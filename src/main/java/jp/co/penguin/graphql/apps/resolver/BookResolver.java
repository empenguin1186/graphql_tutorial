package jp.co.penguin.graphql.apps.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import jp.co.penguin.graphql.apps.dao.BookDao;
import jp.co.penguin.graphql.apps.entity.Author;
import jp.co.penguin.graphql.apps.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookResolver implements GraphQLResolver<Author> {

    @Autowired
    private BookDao bookDao;

    public List<Book> books(Author author) {
        return bookDao.getBooksById(author.getId());
    }
}
