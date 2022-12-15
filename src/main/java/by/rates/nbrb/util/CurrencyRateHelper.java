package by.rates.nbrb.util;

/**
 * Класс выполняет операции с курсом валюты
 *
 */
public class CurrencyRateHelper {

    public static String compareCurrencyRate(Double oldRate, Double newRate) {
        if (Double.compare(oldRate, newRate) == 0) {

            return "Курс валюты не изменился";
        } else if (Double.compare(oldRate, newRate) < 0) {

            return "Курс валюты вырос";
        } else {

            return "Курс валюты уменьшился";
        }
    }
}
