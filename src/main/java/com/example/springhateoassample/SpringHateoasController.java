package com.example.springhateoassample;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class SpringHateoasController {

    SpringHateoasRepository repository;

    public SpringHateoasController(SpringHateoasRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/hello")
    public HttpEntity<SpringHateoasModel> hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        SpringHateoasModel model = new SpringHateoasModel(String.format(name), name);
        model.add(linkTo(methodOn(SpringHateoasController.class).hello(name)).withSelfRel());
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @GetMapping("/hello/{name}")
    public List<SpringHateoasModel> getSpringHateoasById(@PathVariable("name") String name) {
        return repository.findByName(name);
    }
}
