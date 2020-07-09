package pl.gregorymartin.http_apis.JokesApi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gregorymartin.http_apis.JokesApi.model.Joke;
import pl.gregorymartin.http_apis.JokesApi.service.JokeService;

@Controller
@RequestMapping("/jokes")
public class JokesController {
    private JokeService service;

    public JokesController(final JokeService service) {
        this.service = service;

    }

    @GetMapping
    String showProjects(Model model) {
        model.addAttribute("joke", new Joke());
        model.addAttribute("allJokes", service.getAll());
        return "jokes";
    }
    @PostMapping
    String RandomJoke(Model model) {
        service.getJoke();
        model.addAttribute("joke", new Joke());
        model.addAttribute("allJokes", service.getAll());
        model.addAttribute("message", "Damn");
        return "jokes";
    }
}
