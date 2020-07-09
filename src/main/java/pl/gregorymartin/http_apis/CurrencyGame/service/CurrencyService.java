package pl.gregorymartin.http_apis.CurrencyGame.service;

import org.springframework.stereotype.Service;
import pl.gregorymartin.http_apis.CurrencyGame.api.CurrencyClient;
import pl.gregorymartin.http_apis.CurrencyGame.model.Currency;

import java.lang.reflect.Field;
import java.util.*;

@Service
public class CurrencyService {

    private CurrencyClient client;
    List<String> rate;
    private Currency currency;

    public CurrencyService(final CurrencyClient client) {
        rate = new ArrayList<>();
        this.client = client;
        currency = getCurrency("PLN");
    }

    public Currency getCurrency(String base){
        base = base.toUpperCase();
        Currency currency = client.importData(base);
        Arrays.stream(
                currency.getRates().getClass()
                        .getDeclaredFields())
                .forEach(x -> rate.add(x.getName().toUpperCase()));

        rate.remove(base);


        System.out.println(currency);

        return currency;
    }

/*    public Integer check(String currencyFrom, String currencyTo){

        getCurrency(currencyFrom).getRates()
        return
    }*/

    public List<String> getRate() {
        return rate;
    }

    public void setRate(final List<String> rate) {
        this.rate = rate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(final Currency currency) {
        this.currency = currency;
    }
}
