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
    public void changeInfo(User user, String firstName, String secondName, String thirdName, Date birthDate, String email, String phoneNumber, User.Role role){ // TODO: 04.07.2021 Подавать данные, ?считываемые с html форм?
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setThirdName(thirdName);
        user.setBirthDate(birthDate);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
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
