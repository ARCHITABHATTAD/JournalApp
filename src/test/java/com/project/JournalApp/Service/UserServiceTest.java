package com.project.JournalApp.Service;

import com.project.JournalApp.Entity.User;
import com.project.JournalApp.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;
    @Test
    public void testFindByUserName(){
        User user = userRepository.findByUserName("ArchitaS");
        assertTrue(!user.getJournalEntries().isEmpty());
        assertNotNull(userRepository.findByUserName("ArchitaS"));
    }
}
