package com.example.springmvc.repository;

import com.example.springmvc.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findUsersByFirstNameContains(String firstName);

    List<User> findUsersBySecondNameContains(String secondName);

    List<User> findUsersByThirdNameContains(String thirdName);

    List<User> findUsersByBirthDate(Date birthDate);

    List<User> findUsersByRole(User.Role role);

    List<User> findUsersByAddressContains(String address);

    List<User> findUsersByPhoneNumberContains(String phoneNumber);

    List<User> findUsersByEmailContaining(String email);

    List<User> findUsersByAgeGreaterThan(int age);

    List<User> findUsersByAgeIsLessThan(int age);

    List<User> findAll();

}
