package com.project.journalApp.service;

import com.project.journalApp.entity.JournalEntry;
import com.project.journalApp.entity.User;
import com.project.journalApp.repository.JournalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(JournalEntryService.class);
    
    //@Transactional //(atomicity achieved here)
    public void saveEntry(JournalEntry journalEntry, String userName){
        try{
            User user = userService.findByUserName(userName);
            if (journalEntry.getDate() == null) {
                journalEntry.setDate(LocalDateTime.now());
            }
            //journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            userService.saveEntry(user);
        } catch (Exception e) {
            log.error("e: ", e);
            throw new RuntimeException("An error occured while saving the entry." ,e);
        }
    }

    public void saveEntry(JournalEntry journalEntry){
//        try{
            journalEntryRepository.save(journalEntry);
//        }catch(Exception e){
//            log.error("Exception ",e);
//        }
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public void deleteById(ObjectId id, String userName){
        User user = userService.findByUserName(userName);
        boolean b = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
        if(b){
            userService.saveEntry(user);
            journalEntryRepository.deleteById(id);
        }
    }
}
