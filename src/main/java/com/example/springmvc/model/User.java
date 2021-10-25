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

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="last_name",nullable = false)
    private String lastName;

    @Column(name ="middle_name", nullable = true)
    private String middleName;

    @Column(name = "birth_date",nullable = true)
    private Date date;

    @Column(name ="age", nullable = true)
    private Integer age;

    @Column(name = "role",nullable = true)
    private Role role;

    @Column(name = "address",nullable = true)
    private String address;

    @Column(name = "phone",nullable = true)
    private String phone;

    @Column(name = "email",nullable = true)
    private String email;

    public User(String name) {
        this.name = name;
    }

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public User(String name, String lastName, String middleName) {
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public User(String name, String lastName, String middleName, Date date, Integer age, Role role, String address, String phone, String email) {
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
        this.date = date;
        this.age=age;
        this.role=role;
        this.address=address;
        this.phone = phone;
        this.email=email;
    }

    public void setLastName(String lastName){
        this.lastName =lastName;
    }

    public void setName(String name){
        this.name =name;
    }

    public enum Role{
        ADMINISTRATOR,
        MANAGER,
        RECEPTIONIST
    }
}
