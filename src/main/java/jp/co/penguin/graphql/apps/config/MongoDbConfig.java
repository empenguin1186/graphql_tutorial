package jp.co.penguin.graphql.apps.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "my-mongodb")
public class MongoDbConfig {

    private String host;

    private String db;

    private String collection;
}
