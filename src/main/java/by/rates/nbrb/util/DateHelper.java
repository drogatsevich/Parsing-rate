package by.rates.nbrb.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Класс выполняет оперции с датой
 *
 */
public class DateHelper {

    private static final String DATE_PATTERN = "YYYY-MM-dd";

    public static String getPreviousDay(String date)
    {
        LocalDate localDate = LocalDate.parse(date).minusDays(1);

        return localDate.format(DateTimeFormatter.ofPattern(DATE_PATTERN));
    }
}
