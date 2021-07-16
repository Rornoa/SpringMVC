package com.example.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Класс, описывающий пользователей системы отеля (Administrator, manager, receptionist).
 *
 * @role - параметр определяет роль, уровень доступа .
 *
 * @Author joniker.e@mail.ru
 * @version 0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="USERS")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) long id; // still set automatically
    private String firstName;
    private String secondName;
    private String thirdName;
    private Date birthDate;
    private int age;
    private Role role;
    private String address;
    private String phoneNumber;
    private String email;

    public User(String firstName) {
        this.firstName=firstName;
    }

    public User(String firstName, String secondName) {
        this.firstName=firstName;
        this.secondName=secondName;
    }

    public User(String firstName, String secondName, String thirdName) {
        this.firstName=firstName;
        this.secondName=secondName;
        this.thirdName=thirdName;
    }

    public enum Role{
        ADMINISTRATOR,
        MANAGER,
        RECEPTIONIST
    }
}
