package com.example.springmvc.repository;

import com.example.springmvc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findUsersByNameContains(String name);

    List<User> findUsersByLastNameContains(String lastName);

    List<User> findUsersByMiddleNameContains(String middleName);

    List<User> findUsersByDate(Date date);

    List<User> findUsersByRole(User.Role role);

    List<User> findUsersByAddressContains(String address);

    List<User> findUsersByPhoneContains(String phone);

    List<User> findUsersByEmailContaining(String email);

    List<User> findByOrderByNameAsc();

    List<User> findUsersByAgeGreaterThan(int age);

    List<User> findUsersByAgeIsLessThan(int age);

    List<User> findAll();

}
