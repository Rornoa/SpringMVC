package com.example.springmvc.service;

import com.example.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springmvc.repository.UserRepository;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    //Требование А.с.1
    public void changeInfo(User user, String name, String lastName, String middleName, Date birthDate, String email, String phone, User.Role role){
        user.setName(name);
        user.setLastName(lastName);
        user.setMiddleName(middleName);
        user.setDate(birthDate);
        user.setEmail(email);
        user.setPhone(phone);
        user.setRole(role);
    }

    //Requires password confirmation
    public void changeRole(){

    }

    public User changeAge(User user, int age){
        user.setAge(age);
        return userRepository.save(user);
    }

}
