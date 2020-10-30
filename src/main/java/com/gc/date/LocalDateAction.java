package com.gc.date;


import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author 6c6763
 * @date 2020/10/28
 */
public class LocalDateAction {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final ZoneId CHINA_ZONE_ID = ZoneId.systemDefault();

    public static void main(String[] args) {
        date();
        simpleDate();
        localDate();
        canlendar();
    }
    static void instant(){

    }
    static void date(){
        Date date = new Date();
        Instant instant = date.toInstant();
        System.out.println(date);
        System.out.println(instant);
    }
    static void canlendar(){
        Calendar curDate = Calendar.getInstance();
        Calendar nextDayDate = new GregorianCalendar(curDate.get(Calendar.YEAR), curDate.get(Calendar.MONTH), curDate.get(Calendar.DATE)+1, 0, 0, 0);
        Long remainTime =  ((nextDayDate.getTimeInMillis() - curDate.getTimeInMillis())/1000);
        System.out.println(curDate);
        System.out.println(nextDayDate);
        System.out.println(remainTime);
    }
    static void simpleDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        System.out.println(format);
    }

    static void localDate() {
        LocalDate now = LocalDate.now();

        Date date = new Date();
        LocalDateTime dateTime = date.toInstant().atZone(CHINA_ZONE_ID).toLocalDateTime();
        System.out.println(dateTime);
        String format = dateTime.format(DATE_TIME_FORMATTER);
        String format1 = DATE_TIME_FORMATTER.format(dateTime);
        System.out.println(Date.from(Instant.now()));
    }
}
