package pl.gregorymartin.http_apis.JokesApi.service;

import org.springframework.stereotype.Service;
import pl.gregorymartin.http_apis.JokesApi.api.JokesApiImpl;
import pl.gregorymartin.http_apis.JokesApi.model.Joke;
import pl.gregorymartin.http_apis.JokesApi.model.JokeRepository;

import java.util.List;

@Service
public class JokeService {

    private JokesApiImpl api;
    private JokeRepository repository;

    public JokeService(final JokesApiImpl api, final JokeRepository repository) {
        this.api = api;
        this.repository = repository;
        getJoke();
    }

    public Joke getJoke(){
        Joke newJoke = api.importData();
        repository.save(newJoke);
        return newJoke;
    }
    public List<Joke> getAll(){
        return repository.findAll();
    }
}
