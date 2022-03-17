package com.example.springmvc.repository;

import com.example.springmvc.model.Role;
import com.example.springmvc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findUsersByNameContains(String name);

    List<User> findUsersByLastNameContains(String lastName);

    List<User> findUsersByMiddleNameContains(String middleName);

    List<User> findUsersByDate(Date date);

    List<User> findUsersByAddressContains(String address);

    List<User> findUsersByPhoneContains(String phone);

    List<User> findUsersByEmailContaining(String email);

    List<User> findByOrderByNameAsc();

    User findByEmail(String email);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
