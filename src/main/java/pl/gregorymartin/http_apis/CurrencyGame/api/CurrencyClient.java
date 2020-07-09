package pl.gregorymartin.http_apis.CurrencyGame.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import pl.gregorymartin.http_apis.CurrencyGame.model.Currency;


@Controller
public
class CurrencyClient {
    Logger logger = LoggerFactory.getLogger(CurrencyClient.class);

    public CurrencyClient() {}

    public Currency importData(String base){
        Currency currency;
        RestTemplate restTemplate = new RestTemplate();
        currency = restTemplate.getForObject("https://api.exchangeratesapi.io/latest?base=" + base , Currency.class);
        return currency;

    }

}
