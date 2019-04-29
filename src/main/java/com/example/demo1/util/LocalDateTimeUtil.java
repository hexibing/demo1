package com.example.demo1.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateTimeUtil {

    public static void main(String[] args) {
        String s = toString(LocalDateTime.now());
        System.out.println(s);

        LocalDateTime time = toDefaultLocalDateTime("2018-01-16 15:35:54");
        System.out.println(toString(time));
    }

    public static final ZoneOffset ZoneOffset8 = ZoneOffset.of("+8");
    public static DateTimeFormatter YYYYMMDDHHmmss = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    public static DateTimeFormatter defaultFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public static String toCustomDateFormatString(LocalDateTime dt, String format) {
        DateTimeFormatter customDateFormat = DateTimeFormatter.ofPattern(format);
        return dt.format(customDateFormat);
    }

    public static String toString(LocalDateTime dt) {
        return dt.format(YYYYMMDDHHmmss);
    }

    public static String toDefaultString(LocalDateTime dt) {
        return dt.format(defaultFormatter);
    }

    public static String toDefaultString(LocalTime dt) {
        return dt.format(timeFormatter);
    }

    public static LocalDateTime toDefaultLocalDateTime(String s){
        return toLocalDateTime(s, defaultFormatter);
    }

    public static LocalDateTime toLocalDateTime(String s, DateTimeFormatter f){
        LocalDateTime dt = LocalDateTime.parse(s, f);
        return dt;
    }

    public static long seconds(LocalDateTime ldt) {
        long seconds = ldt.toEpochSecond(ZoneOffset8);
        return seconds;
    }

    public static long milliseconds(LocalDateTime ldt) {
        long milli = ldt.toInstant(ZoneOffset8).toEpochMilli();
        return milli;
    }

    public static LocalDateTime DateToLocalDateTime(Date date) {
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return  localDateTime;
    }





}
