package pl.gregorymartin.http_apis.JokesApi.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface JokeRepository extends JpaRepository<Joke,Integer> {
}
