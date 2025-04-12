package com.decode.decode.service;


import com.decode.decode.entity.JournalEntry;
import com.decode.decode.entity.User;
import com.decode.decode.repository.JournalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    private static final Logger logger= LoggerFactory.getLogger(JournalEntryService.class);

    public void saveEntry(JournalEntry journalEntry,String userName) {
        try{
            User user = userService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry savedJournalEntry = journalEntryRepository.save(journalEntry);
            user.getJournalEntryList().add(savedJournalEntry);
            userService.saveNewUser(user);
        }
        catch (Exception e){
            log.error("Exception"+ e);
            throw new RuntimeException("an error occured while adding an entry");
        }
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> getById(ObjectId myId) {
        return journalEntryRepository.findById(myId);
    }

    public void deleteById(ObjectId myid, String userName) {
        try{
            User user = userService.findByUserName(userName);
            boolean removed = user.getJournalEntryList().removeIf(x -> x.getId().equals(myid));
            if(removed) {
                userService.saveUser(user);
                journalEntryRepository.deleteById(myid);
            }
        }
        catch(Exception e){
            System.out.println(e);
            throw new RuntimeException("An error occured while deleting an entry: " + e);
        }
    }
    public List<JournalEntry> findUserName(String userName){
        return null;
    }

}
