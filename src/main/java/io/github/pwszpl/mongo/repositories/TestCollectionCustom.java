package io.github.pwszpl.mongo.repositories;

import io.github.pwszpl.mongo.collections.TestCollection;
import io.github.pwszpl.mongo.parser.ParseException;

import java.util.List;

public interface TestCollectionCustom {
    public List<TestCollection> executeSearchQuery(String queryString) throws ParseException;
}
