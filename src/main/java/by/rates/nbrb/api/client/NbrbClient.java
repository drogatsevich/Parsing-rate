package by.rates.nbrb.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "www.nbrb.by", url = "https://www.nbrb.by/api/exrates/rates", configuration = FeignConfig.class)
public interface NbrbClient {
    @GetMapping(value = "?ondate={date}&periodicity=0")
    String getRatesByDate(@PathVariable("date") String date);

    @GetMapping(value = "/{currencyId}?ondate={date}")
    String getRateByDateAndCurrency(@PathVariable("currencyId") String currencyId, @PathVariable("date") String date);
}
