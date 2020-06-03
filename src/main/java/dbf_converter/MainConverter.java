package dbf_converter;

import java.io.File;


/**
 * Класс Main
 * */
public class MainConverter {

    public static void main(String[] args) {
        DBFReader dbfReader = new DBFReader();
        for (File file : ConverterUtils.getFilesList()) {
            dbfReader.readDBF(file.getAbsolutePath());
        }
    }
}
