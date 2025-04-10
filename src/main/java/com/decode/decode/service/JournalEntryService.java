package com.decode.decode.service;


import com.decode.decode.entity.JournalEntry;
import com.decode.decode.entity.User;
import com.decode.decode.repository.JournalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
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

    public void saveEntry(JournalEntry journalEntry) {
            journalEntryRepository.save(journalEntry);
    }


    public void saveEntry(JournalEntry journalEntry,String userName) {
        try{
            User user = userService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry savedJournalEntry = journalEntryRepository.save(journalEntry);
            user.getJournalEntryList().add(savedJournalEntry);
            userService.add(user);
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
        User user = userService.findByUserName(userName);
        user.getJournalEntryList().removeIf(x->x.getId().equals(myid));
        userService.add(user);
        journalEntryRepository.deleteById(myid);
    }

}
