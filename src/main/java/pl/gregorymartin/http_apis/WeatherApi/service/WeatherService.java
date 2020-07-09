package pl.gregorymartin.http_apis.WeatherApi.service;

import org.springframework.stereotype.Service;
import pl.gregorymartin.http_apis.WeatherApi.api.WeatherClient;
import pl.gregorymartin.http_apis.WeatherApi.model.Weather;
import pl.gregorymartin.http_apis.WeatherApi.model.WeatherViewModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {

    private WeatherClient client;

    public WeatherService(final WeatherClient client) {
        this.client = client;
        getWeather("Warszawa");
    }

    public WeatherViewModel getWeather(String cityName){
        WeatherViewModel weatherModel
                = new WeatherViewModel(client.importData(cityName));
        System.out.println(weatherModel);
        return weatherModel;
    }
}
