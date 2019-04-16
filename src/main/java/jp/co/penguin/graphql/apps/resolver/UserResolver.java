package jp.co.penguin.graphql.apps.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import jp.co.penguin.graphql.apps.dao.UserDao;
import jp.co.penguin.graphql.apps.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserResolver implements GraphQLQueryResolver {

    @Autowired
    private UserDao userDao;

    public User getUserById(String userId) {
        User result = userDao.find(userId);
        return result;
    }

}