package jp.co.penguin.graphql.apps.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Author {

    private int id;

    private String name;
}
