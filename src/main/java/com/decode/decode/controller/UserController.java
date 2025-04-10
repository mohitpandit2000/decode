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

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

//    @GetMapping
//    public ResponseEntity<List<User>> getAllUser(){
//        List<User> all = userService.getAll();
//        if(all!=null && !all.isEmpty()){
//            return  new ResponseEntity<>(all,HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }


    @PutMapping("/{userName}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable String userName){
        User userInDb = userService.findByUserName(userName);
        if(userInDb!=null){
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.add(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
