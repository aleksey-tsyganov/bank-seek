package dbf_converter;

import connection.ConnectionManager;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.sql.*;
import java.time.LocalDate;
import java.util.Map;

/**
 * Класс для конвертации в MySQL
 * */
@Slf4j
public class DBF2MySQL {

    ConnectionManager connectionManager = new ConnectionManager();

    /**
     * Метод подготовки данных для конвертации
     * @param mapData LinkedHashMap
     * @param filePath путь к файлу .dbf
     * */
    public void prepareData(Map <String, Object> mapData, String filePath) {
        File file = new File(filePath);
        String fileName = file.getName().toLowerCase();
        String query = ConverterUtils.getStatement(mapData, fileName);
        putDataToDB(mapData, query);
    }

    /**
     * Метод для сохранения данных в БД
     * @param query SQL запрос
     * @param mapData LinkedHashMap с данными из .dbf файла
     * */
    public void putDataToDB(Map <String, Object> mapData, String query) {
        System.out.println("Start to convert: " + mapData);

        try (PreparedStatement statement = connectionManager.getPreparedStatement(query)){
            int index = 0;
            for (Object key: mapData.keySet()) {
                try {
                    index ++;
                    String value = mapData.get(key).toString();
                    if (ConverterUtils.checkKey(key.toString())) {
                        LocalDate date = ConverterUtils.convertData(value);
                        statement.setDate(index, Date.valueOf(date));
                    }
                    else {
                        statement.setString(index, value);
                    }
                }
                catch (NullPointerException err) {
                    statement.setNull(index, Types.VARCHAR);
                }
            }
            statement.executeUpdate();
        }
        catch (Exception err) {
            log.error("Ошибка при добавлении данных в БД " + err);
        }
        finally {
            connectionManager.closeConnection();
        }
    }
}
