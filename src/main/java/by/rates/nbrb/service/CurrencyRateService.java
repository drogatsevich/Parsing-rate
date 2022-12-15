package by.rates.nbrb.service;

import by.rates.nbrb.api.client.NbrbClient;
import by.rates.nbrb.api.response.CurrencyRateResponse;
import by.rates.nbrb.util.CurrencyRateHelper;
import by.rates.nbrb.util.DateHelper;
import by.rates.nbrb.util.JsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrencyRateService {

    private final NbrbClient nbrbClient;

    /**
     * Метод получает список курсов валют по дате. Если список курсов валют был добавлен, то возвращвет true.
     * Если по текущей дате ничего не найдено, то вернет false.
     *
     * @param date
     * @return Boolean
     */
    public Boolean getCurrencyRatesByDate(String date) {
        String result = nbrbClient.getRatesByDate(date);
        log.info("Getting rates by date from nbrb.by " + result);
        JsonParser.parseListOfCurrencyInfo(nbrbClient.getRatesByDate(date));
        if (result.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Метод получает курс валюты по дате и валюте.
     *
     * @param currencyId
     * @param date
     * @return CurrencyRateResponse
     */
    public CurrencyRateResponse getCurrencyRatesByDateAndCurrency(String currencyId, String date) {
        String rateByDateAndCurrency = nbrbClient.getRateByDateAndCurrency(currencyId, date);
        CurrencyRateResponse currencyRate = JsonParser.parseCurrencyRate(rateByDateAndCurrency);

        log.info("Getting currency rate by date and currency from nbrb.by " +rateByDateAndCurrency);

        if (rateByDateAndCurrency.isEmpty()){
            return null;
        }
        String rateByDateAndCurrencyForPreviousDay = nbrbClient.getRateByDateAndCurrency(currencyId, DateHelper.getPreviousDay(date));
        CurrencyRateResponse yesterdayCurrencyRate = JsonParser.parseCurrencyRate(rateByDateAndCurrencyForPreviousDay);

        log.info("Getting currency rate by date and currency for previous day from nbrb.by " + rateByDateAndCurrencyForPreviousDay);

        if (rateByDateAndCurrencyForPreviousDay.isEmpty()) {
            return null;
        }
        currencyRate.setCourseChanges(CurrencyRateHelper.compareCurrencyRate(yesterdayCurrencyRate.getCurOfficialRate(),currencyRate.getCurOfficialRate()));

        log.info("CurrentRate Response with rate assessment" + currencyRate);
        return currencyRate;
    }
}
