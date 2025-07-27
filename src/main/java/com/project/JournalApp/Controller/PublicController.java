package com.project.JournalApp.Controller;

import com.project.JournalApp.Entity.User;
import com.project.JournalApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    private final UserService userService;


    @Autowired
    PublicController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/health-check")
    public String healthCheck(){
        return  "ok";
    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody User user){
        userService.saveNewUser(user);
    }
}
