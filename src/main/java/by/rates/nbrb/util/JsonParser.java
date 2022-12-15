package by.rates.nbrb.util;

import by.rates.nbrb.api.response.CurrencyInfo;
import by.rates.nbrb.api.response.CurrencyRateResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashSet;
import java.util.Set;

/**
 * Класс выполняяет парсинг JSON объекта курсов валюты
 *
 */
public class JsonParser {

    private static final String CUR_ID = "Cur_ID";
    private static final String DATE = "Date";
    private static final String CUR_ABBREVIATION = "Cur_Abbreviation";
    private static final String CUR_SCALE = "Cur_Scale";
    private static final String CUR_NAME = "Cur_Name";
    private static final String CUR_OFFICIAL_RATE = "Cur_OfficialRate";
    public static Set<CurrencyInfo> currencyInfoSet = new HashSet<>();

    public static Set<CurrencyInfo> parseListOfCurrencyInfo(String rates) {
        Object parse = null;
        try {
            parse = new JSONParser().parse(rates);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        JSONArray jsonArray = (JSONArray) parse;

        for (Object item : jsonArray) {
            CurrencyInfo currencyInfo = new CurrencyInfo();
            JSONObject jsonObject = (JSONObject) item;

            currencyInfo.setCurId((Long) jsonObject.get(CUR_ID));
            currencyInfo.setDate((String) jsonObject.get(DATE));
            currencyInfo.setCurAbbreviation((String) jsonObject.get(CUR_ABBREVIATION));
            currencyInfo.setCurScale((Long) jsonObject.get(CUR_SCALE));
            currencyInfo.setCurName((String) jsonObject.get(CUR_NAME));
            currencyInfo.setCurOfficialRate((Double) jsonObject.get(CUR_OFFICIAL_RATE));

            currencyInfoSet.add(currencyInfo);

        }

        return currencyInfoSet;
    }

    public static CurrencyRateResponse parseCurrencyRate(String rate) {
        Object parse = null;
        try {
            parse = new JSONParser().parse(rate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        CurrencyRateResponse currencyRate = new CurrencyRateResponse();
        JSONObject jsonObject = (JSONObject) parse;

        currencyRate.setCurId((Long) jsonObject.get(CUR_ID));
        currencyRate.setDate((String) jsonObject.get(DATE));
        currencyRate.setCurAbbreviation((String) jsonObject.get(CUR_ABBREVIATION));
        currencyRate.setCurScale((Long) jsonObject.get(CUR_SCALE));
        currencyRate.setCurName((String) jsonObject.get(CUR_NAME));
        currencyRate.setCurOfficialRate((Double) jsonObject.get(CUR_OFFICIAL_RATE));

        return currencyRate;
    }
}
