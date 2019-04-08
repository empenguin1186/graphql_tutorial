package jp.co.penguin.graphql.apps.dao;

import jp.co.penguin.graphql.apps.entity.Author;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorDao {

    private static List<Author> data = Arrays.asList(
            new Author(1, "taka"),
            new Author(2, "susan")
    );

    public Author getAuthorById(int id) {
        for (Author datum : data) {
            if (id == datum.getId()) {
                return datum;
            }
        }

        return data.stream()
                .filter(e -> id == e.getId())
                .collect(Collectors.toList()).get(0);
    }
}
