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

    @Column(name="firstName",nullable = false)
    private String firstName;

    @Column(name="secondName",nullable = false)
    private String secondName;

    @Column(name ="thirdName", nullable = true)
    private String thirdName;

    @Column(name = "birthDate",nullable = true)
    private Date birthDate;

    @Column(name ="age", nullable = true)
    private Integer age;

    @Column(name = "role",nullable = true)
    private Role role;

    @Column(name = "address",nullable = true)
    private String address;

    @Column(name = "phoneNumber",nullable = true)
    private String phoneNumber;

    @Column(name = "email",nullable = true)
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

    public User(String firstName, String secondName, String thirdName, Date birthDate, Integer age, Role role, String address, String phoneNumber, String email) {
        this.firstName=firstName;
        this.secondName=secondName;
        this.thirdName=thirdName;
        this.birthDate=birthDate;
        this.age=age;
        this.role=role;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }

    public void setSecondName(String secondName){
        this.secondName=secondName;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public enum Role{
        ADMINISTRATOR,
        MANAGER,
        RECEPTIONIST
    }
}
