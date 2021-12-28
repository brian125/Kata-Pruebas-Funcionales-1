package co.com.sofka.demo.service;

import co.com.sofka.demo.model.Person;
import co.com.sofka.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Flux<Person> listAll() {
        return  repository.findAll();
    }

    public Mono<Void> insert(Person capture) {
        return validateBeforeInsert.apply(repository, capture)
                .switchIfEmpty(Mono.defer(() -> repository.save(capture)))
                .then();
    }

    private final BiFunction<PersonRepository, Person, Mono<Person>> validateBeforeInsert
            = (repo, person) -> repo.findByName(person.getName());

}
