package dbf_converter;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Вспомогательный класс
 * */
public class ConverterUtils {

    private ConverterUtils (){}

    static final String[] keyList = new String[] { "CB_DATE", "CE_DATE", "DT_IZM", "DATE_IN", "DATE_CH", "DT_IZMR"};

    /**
     * Метод для создания SQL запроса
     * @param fileName наименование файла .dbf
     * @param mapData данные из файла .dbf
     * @return SQL запрос
     * */
    public static String getStatement (Map<String, Object> mapData, String fileName) {
        String dbName = fileName.toLowerCase().substring(0, fileName.length() - 4);
        StringBuilder stringBuilder = new StringBuilder("(?");
        for (int i = 1; i < mapData.size(); i++){
            stringBuilder.append(", ?");
        }
        stringBuilder.append(")");
        return String.format("INSERT INTO %s values %s", dbName, stringBuilder.toString());
    }

    /**
     * Метод для получения списка файлов в директории
     * @return список файлов
     * */
    public static File[] getFilesList(){
        String path = "src/main/webapp/WEB-INF/dbf_source";
        File sourceDir = new File(path);
        return sourceDir.listFiles();
    }

    /**
     * Метод для конвертации строки с датой в LocalDate
     * @param date дата
     * @return LocalDate
     * */
    public static LocalDate convertData(String date) {
        String stringDate =  LocalDate.parse(date, DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH))
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH));
        return LocalDate.parse(stringDate, DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH));
    }

    /**
     * Метод проверки наличия ключа в списке
     * @param key ключ из LinkedHashMap, которая содержит данные из .dbf
     * @return true если ключ в списке
     * */
    public static boolean checkKey(String key) {
        return Arrays.asList(keyList).contains(key);
    }
}
