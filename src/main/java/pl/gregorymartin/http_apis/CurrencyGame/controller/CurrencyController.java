package pl.gregorymartin.http_apis.CurrencyGame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gregorymartin.http_apis.CurrencyGame.model.Currency;
import pl.gregorymartin.http_apis.CurrencyGame.service.CurrencyService;

import java.util.Map;

@Controller
@RequestMapping("/currency")
public class CurrencyController {
    private CurrencyService service;
    private Currency currency;

    public CurrencyController(final CurrencyService service) {
        this.service = service;
        currency = service.getCurrency();

    }

    @GetMapping
    String showProjects(Model model) {
        model.addAttribute("base", 1.0);
        model.addAttribute("currency", currency);
        model.addAttribute("rates", service.getRate());
        return "currency";
    }
    @PostMapping
    String checkValue(
            @ModelAttribute("base") Double base,
            Model model) {

        System.out.println(base);
        Double check = currency.getRates().getPLN();
        System.out.println(check);
        if((base - check) > 0){
            model.addAttribute("message","za dużo");
        }
        if((base - check) < 0){
            model.addAttribute("message","za za mało");
        }
        if((base - check) == 0) {
            model.addAttribute("message","Dobrze!");
        }



        model.addAttribute("base", base);
        model.addAttribute("currency", new Currency());
        return "currency";
    }
}
