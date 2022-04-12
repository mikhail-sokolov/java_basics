package com.luxoft.demo.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.*;
import java.util.Date;

/**
 * DataTime API was introduced in Java 8 as the main API for dates, times, instants, and durations.
 * All the classes are immutable and thread-safe.
 * Based on the ISO calendar system.
 * Uses enums instead int constants for basic date/time types like Month, Year etc
 * All types have basic parsing and formatting methods.
 *
 * Dates and Times
 * - Instant is a numeric timestamp. Useful for logging and persistence of a point in time.
 * - LocalDate stores a date without a time. This stores a date like '2010-12-03' and could be used to store a birthday.
 * - LocalTime stores a time without a date. This stores a time like '11:30' and could be used to store an opening or closing time.
 * - LocalDateTime stores a date and time. This stores a date-time like '2010-12-03T11:30'.
 * - ZonedDateTime stores a date and time with a time-zone. This is useful if you want to perform accurate calculations
 *   of dates and times taking into account the ZoneId, such as 'Europe/Paris'. Where possible, it is recommended to use
 *   a simpler class without a time-zone. The widespread use of time-zones tends to add considerable complexity to an application.
 * - OffsetTime stores a time and offset from UTC without a date.
 *   This stores a date like '11:30+01:00'. The ZoneOffset is of the form '+01:00'.
 *
 * - OffsetDateTime stores a date and time and offset from UTC.
 *   This stores a date-time like '2010-12-03T11:30+01:00'. This is sometimes found in XML messages and other forms of
 *   persistence, but contains less information than a full time-zone.
 *
 * Duration and Period
 * - Duration is a simple measure of time along the time-line in nanoseconds.
 *      Time between two instants: 1 <--duration---> 2
 * - A Period expresses an amount of time in units meaningful to humans, such as years or days.
 *      Time between two dates: 4/1/22 <--period---> 4/12/22
 *
 * The API is very rich in terms of number of methods.
 * This is made manageable through the use of consistent method prefixes.
 * - of - static factory method
 * - parse - static factory method focussed on parsing
 * - get - gets the value of something
 * - is - checks if something is true
 * - with - the immutable equivalent of a setter
 * - plus - adds an amount to an object
 * - minus - subtracts an amount from an object
 * - to - converts this object to another type
 * - at - combines this object with another, such as date.atTime(time)
 */
public class DateTime {
    public static void main(String[] args) throws InterruptedException {
        //date();
        //operations();
        //durationAndPeriod();
        format();
    }

    public static void date() {
        Instant now = Instant.now();
        System.out.println(now);
        Instant legacy = new Date().toInstant();

        LocalDate happyNewYear = LocalDate.of(2022,  1, 1);
        System.out.println(happyNewYear);
        LocalDate oddDate = LocalDate.of(2022, 2, 30);
        System.out.println(oddDate);

        LocalDate firstDay = LocalDate.ofYearDay(2022,  1);
        System.out.println(firstDay);
    }

    public static void operations() {

        LocalDate lastDay = LocalDate.ofYearDay(2021,  1).with(TemporalAdjusters.lastDayOfYear()); // 31 december 2021
        System.out.println(lastDay);

        System.out.println("-----------------------------------");
        for (int i = 1; i < 4; i++) {
            LocalDate date = lastDay.withMonth(i);
            System.out.println(date);
        }
        System.out.println("-----------------------------------");
        for (int i = 1; i < 4; i++) {
            LocalDate date = lastDay.plusMonths(i);
            System.out.println(date);
        }
    }

    public static void durationAndPeriod() throws InterruptedException {
        System.out.println("Duration");
        Instant start = Instant.now();
        Thread.sleep(1000);
        Duration duration = Duration.between(start, Instant.now());
        System.out.println(duration.toMillis());
        System.out.println(duration.getSeconds());

        System.out.println("Period");
        LocalDate firstDay = LocalDate.ofYearDay(2022,  1);
        Period period = Period.between(firstDay, LocalDate.now());
        System.out.println(period);
    }

    /**
     * Formatter for printing and parsing date-time objects.
     * This class provides the main application entry point for printing and parsing and provides common
     * implementations of DateTimeFormatter:
     *  - Using predefined constants, such as ISO_LOCAL_DATE
     *  - Using pattern letters, such as uuuu-MMM-dd
     *   - Using localized styles, such as long or medium
     * More complex formatters are provided by DateTimeFormatterBuilder.
     */
    public static void format() {
        LocalDate date = LocalDate.now();
        System.out.println(date.format(DateTimeFormatter.ISO_DATE));
        System.out.println(date.format(DateTimeFormatter.ISO_WEEK_DATE));

        DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder()
            .appendLiteral("<-")
            .appendValue(WeekFields.ISO.dayOfWeek())
            .appendLiteral("->")
            .toFormatter();
        System.out.println(date.format(dateTimeFormatter));
    }
}
