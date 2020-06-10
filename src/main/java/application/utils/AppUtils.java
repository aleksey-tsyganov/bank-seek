package application.utils;


import lombok.extern.slf4j.Slf4j;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public class AppUtils {

    private AppUtils() {}

    private static Random random;

    static {
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException err) {
            log.error("Алгоритм не найден ", err);
        }
    }

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
        String result = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return result;
    }
}
