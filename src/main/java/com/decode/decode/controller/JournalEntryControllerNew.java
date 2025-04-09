package com.decode.decode.controller;

import com.decode.decode.entity.JournalEntry;
import com.decode.decode.entity.User;
import com.decode.decode.service.JournalEntryService;
import com.decode.decode.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerNew {

    @Autowired
    JournalEntryService journalEntryService;

    @Autowired
    UserService userService;

    @PostMapping("{userName}")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry journalEntry,
                                                    @PathVariable String userName){
        try{
            journalEntryService.add(journalEntry,userName);
            return new ResponseEntity<>(journalEntry,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{userName}")
    public ResponseEntity<List<JournalEntry>> getAllJournalEntriesOfUser(@PathVariable String userName){
        User user = userService.findByUserName(userName);
        List<JournalEntry> all = user.getJournalEntryList();
        if(all!=null && !all.isEmpty()){
            return  new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/id/{myId}")
    public ResponseEntity<JournalEntry> getJournalByid(@PathVariable ObjectId myId){
        Optional<JournalEntry> journalEntry = journalEntryService.getById(myId);
        if(journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id/{myId}")
    public ResponseEntity<?> deleteJournalEntityById(@PathVariable ObjectId myId){
        journalEntryService.deleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PutMapping("/id/{myId}")
//    public ResponseEntity<JournalEntry> pathcJournalEntry(@PathVariable ObjectId myId,@RequestBody JournalEntry newEntry){
//        JournalEntry old = journalEntryService.getById(myId).orElse(null);
//        if(old!=null){
//            if(newEntry.getTitle()!=null){
//                old.setTitle(old.getTitle()!=null && newEntry.getTitle().equals(old.getTitle())? old.getTitle() : newEntry.getTitle());
//            }
//            if(newEntry.getContent()!=null){
//                old.setContent((old.getContent()!=null && newEntry.getContent().equals(old.getContent()))? old.getContent() : newEntry.getContent());
//            }
//            journalEntryService.add(old);
//            return new ResponseEntity<>(old,HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
}
