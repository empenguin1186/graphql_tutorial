package jp.co.penguin.graphql.apps.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {

    private int id;

    private String name;

    private int authorId;
}
