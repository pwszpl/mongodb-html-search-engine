package io.github.pwszpl.mongo.repositories;

import io.github.pwszpl.mongo.collections.TestCollection;

import java.util.List;

public interface TestCollectionCustom {
    public List<TestCollection> executeSearchQuery(String queryString);
}
