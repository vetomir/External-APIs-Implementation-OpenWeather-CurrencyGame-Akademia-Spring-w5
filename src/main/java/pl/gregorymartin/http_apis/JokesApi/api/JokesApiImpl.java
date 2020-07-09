package pl.gregorymartin.http_apis.JokesApi.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import pl.gregorymartin.http_apis.JokesApi.model.Joke;

@Controller
public
class JokesApiImpl {
    public JokesApiImpl() {}

    public Joke importData(){
        RestTemplate restTemplate = new RestTemplate();
        Joke newJoke = restTemplate.getForObject("https://official-joke-api.appspot.com/random_joke", Joke.class);
        System.out.println(newJoke);
        return newJoke;
    }

}
