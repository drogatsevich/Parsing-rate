package by.rates.nbrb.controller;

import by.rates.nbrb.api.response.CurrencyRateResponse;
import by.rates.nbrb.service.CurrencyRateService;
import by.rates.nbrb.util.CrcHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExchangeRatesController {

    private final CurrencyRateService currencyRateService;

    @GetMapping("/uploadRates/{date}")
    public ResponseEntity uploadRatesByDate(@PathVariable String date) {
        try {
            Boolean isCurrencyRatesByDatesUpload =  currencyRateService.getCurrencyRatesByDate(date);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("CRC32", CrcHelper.getCRC32Value(isCurrencyRatesByDatesUpload.toString()))
                    .body(isCurrencyRatesByDatesUpload);
        }
        catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Not found data by params: Date = "+date);
        }
    }

    @GetMapping("/getRate/{date}/{currencyCode}")
    public ResponseEntity getRatesByDateAndCurrencyCode(@PathVariable String date, @PathVariable String currencyCode) {
        try {
            CurrencyRateResponse currencyRateResponse = currencyRateService.getCurrencyRatesByDateAndCurrency(currencyCode, date);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("CRC32", CrcHelper.getCRC32Value(currencyRateResponse.toString()))
                    .body(currencyRateResponse);
        }
        catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Not found data by params: Currency code = "+currencyCode+" Date = "+date);
        }
    }

}
