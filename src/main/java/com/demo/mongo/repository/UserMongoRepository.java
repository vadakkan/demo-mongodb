package com.demo.mongo.repository;

import com.demo.mongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<User, String> {
    User findByName(String name);
}
