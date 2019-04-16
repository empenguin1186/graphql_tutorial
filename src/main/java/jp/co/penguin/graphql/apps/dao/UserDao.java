package jp.co.penguin.graphql.apps.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import jp.co.penguin.graphql.apps.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.mongodb.client.model.Filters.eq;

@Component
public class UserDao {

    private static String USER_ID = "userId";

    @Autowired
    private MongoCollection<User> collection;

    public Boolean insert(User user) {
        collection.insertOne(user);
        return collection.find(eq(USER_ID, user.getUserId())).first().equals(user);
    }

    public boolean update(User user) {
        UpdateResult result = collection.replaceOne(eq(USER_ID, user.getUserId()), user);
        return result.wasAcknowledged();
    }

    public User find(String id) {
        return collection.find(eq(USER_ID, id)).first();
    }

    public Boolean delete(String id) {
        DeleteResult result = collection.deleteOne(eq(USER_ID, id));
        return result.wasAcknowledged();
    }
}
