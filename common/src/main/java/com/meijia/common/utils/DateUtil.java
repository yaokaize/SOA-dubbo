package com.meijia.common.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author kaiser
 *
 * Java8日期处理  线程安全
 */
public class DateUtil {

    /**
     * 获取今天的日期
     * @return LocalDate
     */
    public static LocalDate getTodayDate() {
        return LocalDate.now();
    }

    /**
     * 获取今天 年 信息
     * @return int
     */
    public static int getYear() {
        return LocalDate.now().getYear();
    }

    /**
     * 获取今天 月 信息
     * @return int
     */
    public static int getMonth() {
        return LocalDate.now().getMonthValue();
    }

    /**
     * 获取今天 日 信息
     * @return int
     */
    public static int getDay() {
        return LocalDate.now().getDayOfMonth();
    }

    /**
     * 处理特定日期
     * @param year 年
     * @param month 月
     * @param day 日
     * @return LocalDate
     */
    public static LocalDate getDate(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }

    /**
     * 判断两个日期是否相等
     * @param d1 日期1
     * @param d2 日期2
     * @return boolean
     */
    public static boolean equals(LocalDate d1, LocalDate d2) {
        return d1.equals(d2);
    }

    /**
     * 判断指定日期 月 日
     * 可以判断生日等周期性时间
     * @param d1 指定日期
     * @return boolean
     */
    public static boolean check(LocalDate d1) {
        MonthDay d1MonthDay = MonthDay.of(d1.getMonth(), d1.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(LocalDate.now());
        return currentMonthDay.equals(d1MonthDay);
    }

    /**
     * 获取当前时间
     * @return LocalTime
     */
    public static LocalTime getTodayTime(){
        return LocalTime.now();
    }

    /**
     * 获取指定时间间隔的时间 小时 plus + minus -
     *
     * @return LocalTime
     */
    public static LocalTime getTimeHours(int hours){
        LocalTime now = LocalTime.now();
        return now.plusHours(hours);
    }

    /**
     * 获取指定时间间隔的时间 周 plus + minus -
     *
     * @return LocalTime
     */
    public static LocalDate getTimeWeeks(int weeks){
        LocalDate now = LocalDate.now();
        return now.plus(weeks, ChronoUnit.WEEKS);
    }

    /**
     * 获取默认时区的时间戳
     *
     * @return long
     */
    public static long getTimeMillis() {
        // Clock.systemDefaultZone().millis() 效果等价于 Clock.systemUTC().millis()
        return Clock.systemUTC().millis();
    }

    /**
     * 当前时间是否在指定时间之前 isBefore 之后 isAfter
     *
     * @return boolean
     */
    public static boolean isBefore(LocalDate d1) {
        return LocalDate.now().isBefore(d1);
    }

    /**
     * 获取指定时区的时间
     *
     * @param zoneId 时区
     * @return ZonedDateTime
     */
    public static ZonedDateTime getZoneDateTime(String zoneId) {
        return ZonedDateTime.of(LocalDateTime.now(), ZoneId.of(zoneId));
    }

    /**
     * @return 当前月份最大天数
     */
    public static int getLengthOfMonth() {
        YearMonth currentYearMonth = YearMonth.now();
        return currentYearMonth.lengthOfMonth();
    }

    /**
     * 获取信用卡到期日
     * @param year 年
     * @param month  Month 中的日期
     * @return YearMonth
     */
    public static YearMonth creditCardExpiry(int year, Month month) {
        return YearMonth.of(year, month);
    }

    /**
     * 日期是否是闰年
     * @param d1 指定日期
     * @return boolean
     */
    public static boolean isLeapYear(LocalDate d1) {
        return d1.isLeapYear();
    }

    /**
     * 获取和当前时间相差月份
     * @param d1 指定日期
     * @return int
     */
    public static int checkMonth(LocalDate d1) {
        return Period.between(d1, LocalDate.now()).getMonths();
    }

    /**
     * 获取时间戳
     * @return long
     */
    public static long getNowMills() {
        return Instant.now().toEpochMilli();
    }

    /**
     * 把指定字符串专换成时间
     *
     * @param d1str 时间字符串
     * @param formatter DateTimeFormatter 指定字符串格式
     * @return LocalDate
     */
    public static LocalDate parse(String d1str, DateTimeFormatter formatter) {
        return LocalDate.parse(d1str, formatter);
    }

    /**
     * 把指定时间专换成字符串
     *
     * @param d1 时间
     * @param formatter DateTimeFormatter 指定字符串格式
     * @return String
     */
    public static String format(LocalDate d1, DateTimeFormatter formatter) {
        return d1.format(formatter);
    }

    public static void main(String[] args) {
        LocalDate today = getTodayDate();
        System.out.println(today);

        System.out.println(getYear());
        System.out.println(getMonth());
        System.out.println(getDay());

        System.out.println(getDate(2020, 2, 2));

        System.out.println(equals(LocalDate.now(), getDate(2021, 2, 24)));

        System.out.println(check(getDate(2020, 2, 24)));

        System.out.println(getTodayTime());

        System.out.println(getTimeHours(-3));

        System.out.println(getTimeWeeks(-1));

        System.out.println(Clock.systemUTC().millis());
        System.out.println(Clock.systemDefaultZone().millis());

        System.out.println(getTimeMillis());

        System.out.println(isBefore(getDate(2022, 2, 24)));

        System.out.println(getZoneDateTime("America/New_York"));

        System.out.println(getLengthOfMonth());

        System.out.println(creditCardExpiry(2019, Month.APRIL));

        System.out.println(isLeapYear(LocalDate.now()));

        System.out.println(checkMonth(getDate(2022, 2, 24)));

        System.out.println(getNowMills());

        System.out.println(parse("20200202", DateTimeFormatter.BASIC_ISO_DATE));

        System.out.println(format(LocalDate.now(), DateTimeFormatter.BASIC_ISO_DATE));

    }
}
