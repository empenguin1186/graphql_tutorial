package jp.co.penguin.graphql.apps;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import jp.co.penguin.graphql.apps.config.MongoDbConfig;
import jp.co.penguin.graphql.apps.entity.User;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@SpringBootApplication
public class AppsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppsApplication.class, args);
	}

	@Autowired
	MongoDbConfig config;

	@Bean
	MongoCollection<User> collection() {
			CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
					fromProviders(PojoCodecProvider.builder().automatic(true).build()));
			MongoClient mongoClient = new MongoClient(config.getHost(), MongoClientOptions
					.builder()
					.codecRegistry(pojoCodecRegistry)
					.build());
			MongoDatabase database = mongoClient.getDatabase(config.getDb());
			database = database.withCodecRegistry(pojoCodecRegistry);
			return database.getCollection(config.getCollection(), User.class);
	}

}
