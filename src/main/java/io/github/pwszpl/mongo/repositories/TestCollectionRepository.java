package io.github.pwszpl.mongo.repositories;

import io.github.pwszpl.mongo.collections.TestCollection;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestCollectionRepository extends MongoRepository<TestCollection,Long>, TestCollectionCustom {
}
