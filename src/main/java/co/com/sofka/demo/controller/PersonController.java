package co.com.sofka.demo.controller;

import co.com.sofka.demo.model.Person;
import co.com.sofka.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping
    public Mono<Void> post (@RequestBody Mono<Person> personMono){
        return personMono.flatMap(service::insert);
    }

    @GetMapping("/{id}")
    public Mono<Person> getPerson(@PathVariable("id") String id){
        return Mono.just(new Person());
    }

    @PutMapping
    public Mono<Void> update(@RequestBody Mono<Person> personMono){
        return Mono.empty();
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") String id){
        return Mono.empty();
    }

    @GetMapping
    public Flux<Person> list(){
        return service.listAll();
    }

}
