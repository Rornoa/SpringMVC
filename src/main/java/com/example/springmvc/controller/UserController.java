package com.example.springmvc.controller;

import com.example.springmvc.model.User;
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
    private RoomRepository roomRepository;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestParam String firstName){
        User user = new User(firstName);
        user = userRepository.save(user);
        return ResponseEntity.ok("User "+firstName+" successfully created!");
    }

    @RequestMapping(value="task",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers(){
        List<User> dtoList = userRepository.findAll();
        return dtoList;
    }


}
