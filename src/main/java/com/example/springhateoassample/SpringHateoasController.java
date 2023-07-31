package com.example.springhateoassample;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringHateoasController {

    @GetMapping("/hello")
    public HttpEntity<SpringHateoasModel> hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        SpringHateoasModel model = new SpringHateoasModel(String.format(name));
        model.add(linkTo(methodOn(SpringHateoasController.class).hello(name)).withSelfRel());

        return new ResponseEntity<>(model, HttpStatus.OK);
    }
}
