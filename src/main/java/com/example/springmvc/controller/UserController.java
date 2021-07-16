package com.example.springmvc.controller;

import com.example.springmvc.model.User;
import com.example.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springmvc.repository.RoomRepository;
import com.example.springmvc.repository.UserRepository;

import java.util.List;

@RequestMapping(value = "/api/user")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RoomRepository roomRepository;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestParam String secondName, String firstName){
        User user = new User(secondName,firstName);
        user = userRepository.save(user);
        return ResponseEntity.ok("User "+secondName+" "+firstName+" successfully created!");
    }

    @PostMapping("/create ")
    public ResponseEntity<String> createWithThird(@RequestParam String secondName,String firstName, String thirdName){
        User user = new User(secondName,firstName,thirdName);
        user = userRepository.save(user);
        return ResponseEntity.ok("User "+secondName+" "+firstName+" "+thirdName+" successfully created!");
    }

    // TODO: 16.07.2021 Requires password confirmation before execute delete command.
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam long id){
        userRepository.deleteById(id);      
        return ResponseEntity.ok("User "+id+" was deleted!");
    }

    @RequestMapping(value="all",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }

    //May be helpful with calculating room price and mailing
    @RequestMapping(value="greater",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findGreaterAge(int age){
        List<User> users = userRepository.findUsersByAgeGreaterThan(age);
        return users;
    }

    @RequestMapping(value="less",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findLessAge(int age){
        List<User> users = userRepository.findUsersByAgeIsLessThan(age);
        return users;
    }



}
