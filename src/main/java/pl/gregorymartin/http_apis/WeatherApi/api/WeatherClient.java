package pl.gregorymartin.http_apis.WeatherApi.api;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import pl.gregorymartin.http_apis.WeatherApi.model.Weather;


@Controller
public
class WeatherClient {
    @Value("${weather.api.key}")
    private String apikey;
    Logger logger = LoggerFactory.getLogger(WeatherClient.class);

    public WeatherClient() {}

    public Weather importData(String city){
        Weather weather;
        RestTemplate restTemplate = new RestTemplate();
        try {
            weather = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apikey + "&lang=pl", Weather.class);
            return weather;
        }
        catch (Exception e){
            logger.info("Wrong city name");
            weather = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=Warszawa&appid=" + apikey + "&lang=pl", Weather.class);
            return weather;
        }
    }

}
