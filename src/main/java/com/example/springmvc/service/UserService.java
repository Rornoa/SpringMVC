package com.example.springmvc.service;

import com.example.springmvc.exception_handlers.UserNotFoundException;
import com.example.springmvc.model.Role;
import com.example.springmvc.model.User;
import com.example.springmvc.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;
import com.example.springmvc.repository.UserRepository;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User createNewUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    /*
    public List<User> getAllUsersList(String... sort){
        List<Sort.Order> orders = new ArrayList<>();
        for (String s: sort) {
            if (s.charAt(0)=='d')
                orders.add(new Sort.Order(Sort.Direction.DESC,s.substring(1)));
            if(s.charAt(0)=='a')
                orders.add(new Sort.Order(Sort.Direction.ASC,s.substring(1)));
        }
        return userRepository.findAll(Sort.by(orders));
    }*/

    public List<User> getAllUsersForTable(String sort, boolean isAsc, int limit, int page){
        List<User> users;
        if(sort!=null)
            users = userRepository.findAll(PageRequest.of(page, limit, Sort.by(isAsc ? Sort.Direction.ASC : Sort.Direction.DESC, sort))).getContent();
        else
            users = userRepository.findAll(PageRequest.of(page, limit)).getContent();
        return  users;
    }

    public void updateUser(long id, String name, String lastName, String middleName, Date date, String address, String phone, String email){
        userRepository.findById(id)
                .map(user -> {
                    user.setName(name);
                    user.setLastName(lastName);
                    user.setMiddleName(middleName);
                    user.setDate(date);
                    user.setAddress(address);
                    user.setPhone(phone);
                    user.setEmail(email);
                    userRepository.save(user);
                    return null;
                });
    }

    public User getUserById(long id){
        return  userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    //Требование А.с.1
    public void changeInfo(User user, String name, String lastName, String middleName, Date date, String email, String phone, Role role){
        user.setName(name);
        user.setLastName(lastName);
        user.setMiddleName(middleName);
        user.setDate(date);
        user.setEmail(email);
        user.setPhone(phone);
    }

    //Requires password confirmation
    public void changeRole(){

    }


}
