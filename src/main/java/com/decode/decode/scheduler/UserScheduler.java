package com.decode.decode.scheduler;

import com.decode.decode.entity.JournalEntry;
import com.decode.decode.entity.User;
import com.decode.decode.repository.UserRepositoryImpl;
import com.decode.decode.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class UserScheduler {
    @Autowired
    EmailService emailService;
    @Autowired
    UserRepositoryImpl userRepositoryimpl;


    @Scheduled(cron ="0 0 7 * * *")
    public void fetchUserAndSendSAMail(){
        List<User> userForSA = userRepositoryimpl.getUserForSA();
        for(User user:userForSA){
            List<JournalEntry> journalEntryList = user.getJournalEntryList();
            List<String> list = journalEntryList.stream()
                    .filter(x -> x.getDate()
                            .isAfter(LocalDateTime.now().minusDays(7))).map(JournalEntry::getContent).toList();
            String entry=String.join(" ",list);
            emailService.sendSimpleMail(user.getEmail(),"sentiment for the week",entry);
        }
    }
}
