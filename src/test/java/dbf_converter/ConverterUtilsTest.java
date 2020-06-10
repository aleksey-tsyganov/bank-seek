package dbf_converter;

import org.junit.Test;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ConverterUtilsTest {

    @Test
    public void testGetStatement() {
        Map<String, Object> testMap = new LinkedHashMap<>();
        testMap.put("testKey", "testValue");
        String testFileName = "test.dbf";
        String expected = "INSERT INTO test values (?)";
        String actual = ConverterUtils.getStatement(testMap, testFileName);
        assertEquals(expected, actual);
    }

    @Test
    public void testConvertData() {
        String testDate = "Tue Jan 19 00:00:00 MSK 2016";
        String expected = "2016-01-19";
        String actual = ConverterUtils.convertData(testDate).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckKey() {
        String trueKey = "CB_DATE";
        String falseKey = "qwe";
        assertTrue(ConverterUtils.checkKey(trueKey));
        assertFalse(ConverterUtils.checkKey(falseKey));
    }
}