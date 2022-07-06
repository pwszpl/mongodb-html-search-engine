package io.github.pwszpl.mongo.repositories;


import io.github.pwszpl.mongo.collections.TestCollection;
import mongo.parser.MongoSearchEngineParser;
import mongo.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class TestCollectionCustomImpl implements TestCollectionCustom {
    @Autowired
    MongoTemplate template;

    public List<TestCollection> executeSearchQuery(String queryString){
        MongoSearchEngineParser parser = new MongoSearchEngineParser(new StringReader(queryString));
        parser.setCriteraMode();
        try {
            Criteria c = (Criteria) parser.parse();
            Query query = new Query().addCriteria(c);
            return template.find(query,TestCollection.class);
        } catch (ParseException e) {
            return new ArrayList<>();
        }
    }
}
