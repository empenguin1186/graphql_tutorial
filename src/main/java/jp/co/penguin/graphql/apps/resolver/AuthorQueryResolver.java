package jp.co.penguin.graphql.apps.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import jp.co.penguin.graphql.apps.dao.AuthorDao;
import jp.co.penguin.graphql.apps.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private AuthorDao authorDao;

    public Author getAuthor(int id) {
        return authorDao.getAuthorById(id);
    }

}
