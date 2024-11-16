package com.performancetest.chanwoong.repository;

import com.performancetest.chanwoong.domain.RoundDataDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDbRepository extends MongoRepository<RoundDataDocument, String> {
}
