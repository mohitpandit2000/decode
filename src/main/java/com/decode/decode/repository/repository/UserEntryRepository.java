package com.decode.decode.repository.repository;

import com.decode.decode.entity.JournalEntry;
import com.decode.decode.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserEntryRepository extends MongoRepository<User, ObjectId> {

    User findByUserName(String username);
}
