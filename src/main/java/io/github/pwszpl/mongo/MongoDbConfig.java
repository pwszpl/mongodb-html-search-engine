package io.github.pwszpl.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import io.github.pwszpl.Application;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;


@Configuration
@AutoConfigureBefore(MongoAutoConfiguration.class)
public class MongoDbConfig  {
    @Bean
    public MongoTemplate mongoTemplate() {
        MongoClient mongo = MongoClients.create(Application.getMongoConnectionString());
        return new MongoTemplate(mongo,"testDb");
    }

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(Application.getMongoConnectionString());
    }
}
