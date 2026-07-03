package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtil {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private DateUtil() {
    }

    public static LocalDate today() {

        return LocalDate.now();

    }

    public static String format(LocalDate date) {

        if (date == null)
            return "";

        return date.format(FORMATTER);

    }

    public static LocalDate parse(String date) {

        return LocalDate.parse(date, FORMATTER);

    }

    public static long daysBetween(LocalDate start,
                                   LocalDate end) {

        return ChronoUnit.DAYS.between(start, end);

    }

}