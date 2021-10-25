package com.example.springmvc.controller;

import com.example.springmvc.exception_handlers.UserNotFoundException;
import com.example.springmvc.model.User;
import com.example.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springmvc.repository.RoomRepository;
import com.example.springmvc.repository.UserRepository;

import java.util.*;

@RequestMapping(value = "/hotel-it/users")
@CrossOrigin(origins = "*")

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RoomRepository roomRepository;


    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User reqUser){
      //  User user = new User(name, lastname,middleName,date,age,role,address,phone,email);
        reqUser = userRepository.save(reqUser);
        return ResponseEntity.ok("User "+ reqUser.getName() +" "+ reqUser.getLastName() +" "+reqUser.getMiddleName()+" successfully created!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id){
        userRepository.deleteById(id);      
        return ResponseEntity.ok("User "+id+" was deleted!");
    }

    @GetMapping("/all")
    @ResponseBody
    public List<User> getAllUsers(@RequestParam String... sort){
        List<Sort.Order> orders = new ArrayList<>();
        for ( String s: sort) {
            if(s.charAt(0)=='d')
                orders.add(new Sort.Order(Sort.Direction.DESC,s.substring(1)));
            if(s.charAt(0)=='a')
                orders.add(new Sort.Order(Sort.Direction.ASC,s.substring(1)));
        }
        return userRepository.findAll(Sort.by(orders));
    }
    //Sort.by(Sort.Direction.valueOf(order),sort)
    @GetMapping
    @ResponseBody
    public List<User> getAllUsers(@RequestParam String sort, @RequestParam boolean isAsc, @RequestParam int limit, @RequestParam int page){
        List<User> users;
        if (sort!=null)
            users = userRepository.findAll(PageRequest.of(page, limit, Sort.by(isAsc ? Sort.Direction.ASC : Sort.Direction.DESC, sort))).getContent();
        else
            users = userRepository.findAll(PageRequest.of(page, limit)).getContent();
        return  users;
    }

    // TODO: 27.08.2021 Works but not properly. 
    @PutMapping("{id}")
    public void update(String name, String lastName, String middleName, Integer age, String email, Date birthDate, User.Role role,String address, @PathVariable long id,String phone){
                userRepository.findById(id)
                .map(user -> {
                    user.setName(name);
                    user.setLastName(lastName);
                    user.setMiddleName(middleName);
                    user.setAge(age);
                    user.setEmail(email);
                    user.setDate(birthDate);
                    user.setRole(role);
                    user.setAddress(address);
                    user.setPhone(phone);
                    userRepository.save(user);
                    return null;
                });
    }

    /*@GetMapping()
    @ResponseBody
    public User getSortedUsersAsc(){
        return null;
    }*/

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
