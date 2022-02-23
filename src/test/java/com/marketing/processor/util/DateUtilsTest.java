package com.marketing.processor.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    @Test
    void areDateValueAndFormatValidTest1() {
        final String dateWithValidFormat = "24-JAN-22 10:27:44";
        final String datePattern = "dd-LLL-dd HH:mm:ss";

        assertTrue(DateUtils.areDateValueAndFormatValid(dateWithValidFormat, datePattern));
    }

    @Test
    void areDateValueInValidAndFormatValidTest2() {
        final String dateWithValidFormat = "24-10-22 10:27:44";
        final String datePattern = "dd-LLL-dd HH:mm:ss";

        assertFalse(DateUtils.areDateValueAndFormatValid(dateWithValidFormat, datePattern));
    }

    @Test
    void areDateValueValidAndFormatInValidTest2() {
        final String dateWithValidFormat = "24-Jan-22 10:27:44";
        final String datePattern = "dd-MM-dd HH:mm:ss";

        assertFalse(DateUtils.areDateValueAndFormatValid(dateWithValidFormat, datePattern));
    }
}