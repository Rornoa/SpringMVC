package com.example.springmvc.repository;

import com.example.springmvc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/***
 * @Репозиторий - это несколько интерфейсов которые используют JPA Entity для взаимодействия с репозиторией
 * JPA - java-спецификация определяющая доступ, сохранение и управления данными между Java-объектами (Entity классами) и реляционной базой данных.
 *
 * 1) Помечаем наш интерфейс аннотацией @Repository.
 * 2) Наследуемся от одного из интерфейсов Spring Data
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findUsersByFirstNameContains(String firstName);

    List<User> findUsersBySecondNameContains(String secondName);

    List<User> findUsersByThirdNameContains(String thirdName);

    List<User> findUsersByBirthDate(Date birthDate);

    List<User> findUsersByRole(User.Role role);

    List<User> findUsersByAddressContains(String address);

    List<User> findUsersByPhoneNumberContains(String phoneNumber);

    List<User> findUsersByEmailContaining(String email);

    List<User> findAll();

}
