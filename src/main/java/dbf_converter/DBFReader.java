package dbf_converter;

import lombok.extern.slf4j.Slf4j;
import net.iryndin.jdbf.core.DbfMetadata;
import net.iryndin.jdbf.core.DbfRecord;
import net.iryndin.jdbf.reader.DbfReader;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.ParseException;

/**
 * Класс для чтения .dbf файлов
 * */
@Slf4j
public class DBFReader {

    /**
     * Метод для чтения .dbf и преобразования данных в LinkedHashMap и передачи на конвертацию
     * @param filePath путь к файлу .dbf
     * */
    public void readDBF(String filePath) {
        Charset stringCharset = Charset.forName("Cp866");
        DBF2MySQL dbf2MySQL = new DBF2MySQL();
        DbfRecord rec;
        try (InputStream dbf = new FileInputStream(filePath); DbfReader reader = new DbfReader(dbf)) {
            DbfMetadata meta = reader.getMetadata();
            System.out.println("Read DBF Metadata: " + meta);
            while ((rec = reader.read()) != null) {
                rec.setStringCharset(stringCharset);
                dbf2MySQL.prepareData(rec.toMap(), filePath);
            }
        }
        catch (IOException | ParseException err) {
            log.error("Ошибка при чтении файла ", err);
        }
    }
}
