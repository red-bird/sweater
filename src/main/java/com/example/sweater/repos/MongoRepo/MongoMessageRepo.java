package com.example.sweater.repos.MongoRepo;

import com.example.sweater.domain.MongoEntities.MongoMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoMessageRepo extends MongoRepository<MongoMessage, String> {
    List<MongoMessage> findByTag(String tag);
}
