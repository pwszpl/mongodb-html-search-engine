package io.github.pwszpl;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import io.github.pwszpl.mongo.collections.TestCollection;
import org.springframework.boot.SpringApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;


public class Application {
    static final MongoDBContainer mongo = new MongoDBContainer(DockerImageName.parse("mongo:4.4"));

    public static void main(String[] args){
        mongo.start();
        populateDBWithDefaultData();
        SpringApplication.run(SpringApp.class,args);
    }

    private static void populateDBWithDefaultData() {
        MongoClient client = MongoClients.create(mongo.getConnectionString());
        MongoTemplate template = new MongoTemplate(client,"testDb");
        template.insert(getTestDocument("critic1","Nice app, but you need to add some more features!",5),"TestCollection");
        template.insert(getTestDocument("Perfect","Awsome!! I can't wait to start using it :)",10),"TestCollection");
        template.insert(getTestDocument("critic2","Who would need this anyway?",1),"TestCollection");
    }

    private static TestCollection getTestDocument(String author, String comment, Integer rating){
        TestCollection document = new TestCollection();
        document.authorName = author;
        document.comment = comment;
        document.rating = rating;
        return document;
    }

    public static String getMongoConnectionString(){
        return mongo.getConnectionString();
    }
}
