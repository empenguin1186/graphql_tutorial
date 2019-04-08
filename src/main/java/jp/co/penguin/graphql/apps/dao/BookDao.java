package jp.co.penguin.graphql.apps.dao;

import jp.co.penguin.graphql.apps.entity.Book;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookDao {

    private List<Book> data = Arrays.asList(
            new Book(1, "Elixir入門", 1),
            new Book(2, "Erlang入門", 2),
            new Book(3, "python入門", 2),
            new Book(4, "Go入門", 2)
    );

    public List<Book> getBooksById(int id) {
        return data
                .stream()
                .filter(e -> id == e.getId())
                .collect(Collectors.toList());
    }
}