package jp.co.penguin.graphql.apps.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import jp.co.penguin.graphql.apps.dao.UserDao;
import jp.co.penguin.graphql.apps.entity.User;
import jp.co.penguin.graphql.apps.entity.UserInput;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MutationResolver implements GraphQLMutationResolver {

    @Autowired
    UserDao userDao;

    public Boolean createUser(UserInput input) {
        User user = User.builder()
                .userId(input.getUserId())
                .userName(input.getUserName())
                .intro(input.getIntro())
                .place(input.getPlace())
                .birthDay(input.getBirthDay())
                .imgUrl(input.getImgUrl())
                .build();
        return userDao.insert(user);
    }

    public Boolean updateUser(UserInput input) {
        User user = User.builder()
                .userId(input.getUserId())
                .userName(input.getUserName())
                .intro(input.getIntro())
                .place(input.getPlace())
                .birthDay(input.getBirthDay())
                .imgUrl(input.getImgUrl())
                .build();
        return userDao.update(user);
    }

    public Boolean deleteUser(String userId) {
        return userDao.delete(userId);
    }

}
