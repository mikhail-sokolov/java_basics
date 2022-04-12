package com.luxoft.demo.datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Based around java.util.Date, java.util.Calendar and java.text.DateFormat
 */
public class Legacy {
    public static void main(String[] args) {
        //date();
        //calendar();
        format();
    }

    /**
     * java.util.Date represents a specific instant in time,
     * with millisecond precision (the milliseconds since January 1, 1970, 00:00:00 GMT.).
     *  It also allows:
     *  - the interpretation of dates as year, month, day, hour, minute, and second values
     *  - the formatting and parsing of date strings
     *
     *  But it's recommended to use java.util.Calendar instead.
     *
     *  In all methods of class Date that accept or return year, month, date, hours, minutes, and seconds values,
     *  the following representations are used:
     * - A year y is represented by the integer y - 1900.
     * - A month is represented by an integer from 0 to 11; 0 is January, 1 is February, and so forth; thus 11 is December.
     * - A date (day of month) is represented by an integer from 1 to 31 in the usual manner.
     * - An hour is represented by an integer from 0 to 23. Thus, the hour from midnight to 1 a.m. is hour 0, and the hour from noon to 1 p.m. is hour 12.
     * - A minute is represented by an integer from 0 to 59 in the usual manner.
     * - A second is represented by an integer from 0 to 61;
     */
    public static void date() {
        Date now = new Date();
        System.out.println(now);
        Date happyNewYear = new Date(2022, Calendar.JANUARY, 1);
        System.out.println(happyNewYear);
        Date oddDate = new Date(2022, 1, 30);
        System.out.println(oddDate);

        Date firstDay = new Date(122, 0, 1);
        System.out.println(firstDay);
    }


    /**
     *
     * Main implementations provided by Java:
     * - BuddhistCalendar
     * - JapaneseImperialCalendar
     * - GregorianCalendar
     *
     * But you don't need to create them directly. Calendar.getInstance() returns appropriate calendar based on your
     * time zone and locale.
     *
     * Calendar provides methods for
     *  - converting between a specific instant in time and a set of calendar fields
     * such as YEAR, MONTH, DAY_OF_MONTH, HOUR, and so on,
     *  - manipulating the calendar fields, such as getting the date of the next week.
     *
     *  Field types are defined by int constants such as MONTH, YEAR etc.
     *
     *  The calendar fields can be changed using three methods: set(), add(), and roll().
     *  - set(f, value) changes calendar internal calendar field f to value. It's like marking the specific date
     *  in the calendar.
     *  - add(f, delta) adds delta to field f. This is equivalent to calling set(f, get(f) + delta) with two adjustments
     *  Add rule 1. The value of field f after the call minus the value of field f before the call is delta,
     *  modulo any overflow that has occurred in field f. Overflow occurs when a field value exceeds its range and,
     *  as a result, the next larger field is incremented or decremented and the field value is adjusted back into its range.
     *
     *  Add rule 2. If a smaller field is expected to be invariant, but it is impossible for it to be equal to its prior
     *  value because of changes in its minimum or maximum after field f is changed or other constraints, such as time
     *  zone offset changes, then its value is adjusted to be as close as possible to its expected value.
     *  A smaller field represents a smaller unit of time. HOUR is a smaller field than DAY_OF_MONTH.
     *  No adjustment is made to smaller fields that are not expected to be invariant.
     *  The calendar system determines what fields are expected to be invariant.
     *
     *  roll(f, delta) adds delta to field f without changing larger fields.
     *  This is equivalent to calling add(f, delta) with the following adjustment:
     *  Roll rule. Larger fields are unchanged after the call. A larger field represents a larger unit
     *  of time. DAY_OF_MONTH is a larger field than HOUR.
     */
    public static void calendar() {
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = DateFormat.getInstance(); // getDateTimeInstance(SHORT, SHORT);
        System.out.println("-----------------set------------------");
        calendar.set(2021, 11, 31); // 31 december 2021
        //calendar.set(2021, Calendar.DECEMBER, 31); // 31 december 2021

        for (int i = 0; i < 3; i++) {
            calendar.set(Calendar.MONTH, i);
            System.out.println(dateFormat.format(calendar.getTime()));
        }
        System.out.println("-----------------add------------------");
        calendar.set(2021, 11, 31); // 31 december 2021

        for (int i = 0; i < 3; i++) {
            calendar.add(Calendar.MONTH, 1);
            System.out.println(dateFormat.format(calendar.getTime()));
        }
        System.out.println("-----------------roll------------------");
        calendar.set(2021, 11, 31); // 31 december 2021

        for (int i = 0; i < 3; i++) {
            calendar.roll(Calendar.MONTH, 1);
            System.out.println(dateFormat.format(calendar.getTime()));
        }
    }

    /**
     *  DateFormat is a class which formats (i.e., date → text) and parses dates or time (text → date)
     *  in a language-independent manner.
     *  The date is represented as a Date object or as the milliseconds since January 1, 1970, 00:00:00 GMT.
     *
     *  Use SimpleDateFormat for user defined patterns.
     */
    public static void format() {
        Date now = new Date();
        System.out.println(DateFormat.getDateInstance(DateFormat.FULL).format(now));
        System.out.println(DateFormat.getDateInstance(DateFormat.SHORT).format(now));
        System.out.println(DateFormat.getTimeInstance(DateFormat.FULL).format(now));
        System.out.println(DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL).format(now));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm a");
        System.out.println(simpleDateFormat.format(now));

        try {
            Date date = simpleDateFormat.parse("8:35 AM");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

