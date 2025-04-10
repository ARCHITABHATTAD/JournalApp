package com.project.journalApp.repository;

import com.project.journalApp.entity.JournalEntry;
import com.project.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId>{
    User findByUserName(String username);
}
