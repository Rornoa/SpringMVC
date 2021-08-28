package com.example.springmvc.controller;

import com.example.springmvc.exception_handlers.UserNotFoundException;
import com.example.springmvc.model.User;
import com.example.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springmvc.repository.RoomRepository;
import com.example.springmvc.repository.UserRepository;
import java.util.Date;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/hotel-it/users")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RoomRepository roomRepository;


    @PostMapping
    public ResponseEntity<String> createUser(@RequestParam String secondName,@RequestParam String firstName, String thirdName){
        User user = new User(secondName,firstName,thirdName);
        user = userRepository.save(user);
        return ResponseEntity.ok("User "+secondName+" "+firstName+" "+thirdName+" successfully created!");
    }

    // TODO: 25.08.2021 почитать рекомендации REST
    // TODO: 16.07.2021 Requires password confirmation before execute delete command.
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id){
        userRepository.deleteById(id);      
        return ResponseEntity.ok("User "+id+" was deleted!");
    }

    @GetMapping("/all")
    @ResponseBody
    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }

    // TODO: 27.08.2021 Works but not properly. 
    @PutMapping("{id}")
    public void update(String firstName, String secondName, String thirdName, int age, String email, Date birthDate, User.Role role,String address, @PathVariable long id){
                userRepository.findById(id)
                .map(user -> {
                    user.setFirstName(firstName);
                    user.setSecondName(secondName);
                    user.setThirdName(thirdName);
                    user.setAge(age);
                    user.setEmail(email);
                    user.setBirthDate(birthDate);
                    user.setRole(role);
                    user.setAddress(address);
                    userRepository.save(user);
                    return null;
                });
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User getUser(@PathVariable long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
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
