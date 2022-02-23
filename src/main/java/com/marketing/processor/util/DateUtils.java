package com.marketing.processor.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static boolean areDateValueAndFormatValid(
            String dateToValidate,
            String datePattern) {
        final SimpleDateFormat simpleDateFormat;
        try {
            simpleDateFormat = new SimpleDateFormat(datePattern);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.parse(dateToValidate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static Date convertStringToDateWithPattern(
            String dateAsString,
            String datePattern) {
        try {
            return new SimpleDateFormat(datePattern)
                    .parse(dateAsString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String convertDateToStringWithPattern(
            Date date,
            String datePattern) {
        return new SimpleDateFormat(datePattern)
                .format(date);
    }
}
