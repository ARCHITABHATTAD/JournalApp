package com.project.JournalApp.Repository;

import com.project.JournalApp.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId>{
    User findByUserName(String username);

    void deleteByUserName(String username);
}
