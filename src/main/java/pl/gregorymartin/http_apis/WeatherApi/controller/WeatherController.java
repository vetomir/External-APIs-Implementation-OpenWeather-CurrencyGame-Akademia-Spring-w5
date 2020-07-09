package pl.gregorymartin.http_apis.WeatherApi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gregorymartin.http_apis.WeatherApi.model.WeatherViewModel;
import pl.gregorymartin.http_apis.WeatherApi.service.WeatherService;

@Controller
@RequestMapping("/weather")
public class WeatherController {
    private WeatherService service;

    public WeatherController(final WeatherService service) {
        this.service = service;

    }

    @GetMapping
    String showProjects(Model model) {
        model.addAttribute("city", "Wpisz Nazwę Miasta");
        return "weather";
    }
    @PostMapping
    String checkWeather(
            @ModelAttribute("city") String city,
            Model model) {

        WeatherViewModel newForecast = service.getWeather(city);
        model.addAttribute("forecast", newForecast);


        model.addAttribute("message", "Oto pogoda w: " + city);
        return "weather";
    }
}
