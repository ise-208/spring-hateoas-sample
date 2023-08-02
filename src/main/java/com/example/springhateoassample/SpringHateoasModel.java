package com.example.springhateoassample;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;


@Relation(collectionRelation = "actors", itemRelation = "actor")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpringHateoasModel extends RepresentationModel<SpringHateoasModel> {

    private final String content;
    private final String name;


    @JsonCreator
    public SpringHateoasModel(@JsonProperty("content") String content, String name) {
        this.content = content;
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SpringHateoasModel{" +
                "content='" + content + '\'' +
                '}';
    }
}
