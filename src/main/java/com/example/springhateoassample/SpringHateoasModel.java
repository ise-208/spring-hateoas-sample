package com.example.springhateoassample;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

public class SpringHateoasModel extends RepresentationModel<SpringHateoasModel> {

    private final String content;

    @JsonCreator
    public SpringHateoasModel(@JsonProperty("content") String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
