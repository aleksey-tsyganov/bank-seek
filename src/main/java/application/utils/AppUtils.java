package application.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class AppUtils {

    private AppUtils(){}

    public static String dateToString(Date date) {
        try {
            String pattern = "yyyy-MM-dd";
            DateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        catch (Exception err) {
            return "";
        }
    }

    public static String generateVkey() {
        int leftLimit = 33;
        int rightLimit = 126;
        int targetStringLength = 8;
        Random random = new Random();
        String result = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return result;
    }
}
