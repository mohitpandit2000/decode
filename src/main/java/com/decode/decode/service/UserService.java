package com.decode.decode.service;


import com.decode.decode.entity.JournalEntry;
import com.decode.decode.entity.User;
import com.decode.decode.repository.JournalEntryRepository;
import com.decode.decode.repository.repository.UserEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserEntryRepository userEntryRepository;

    public void add(User user) {
        try{
            userEntryRepository.save(user);
        }
        catch (Exception e){
            log.error("Exception"+ e);
        }
    }

    public List<User> getAll() {
        return userEntryRepository.findAll();
    }

    public User  findByUserName(String username){
        return userEntryRepository.findByUserName(username);
    }
}
