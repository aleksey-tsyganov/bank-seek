package application.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppUtilsTest {

    @Test
    public void generateVkey() {
        String actual = AppUtils.generateVkey();
        assertEquals(actual.length(), 8);
    }
}