package com.example.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Класс, описывающий пользователей системы отеля (Administrator, manager, receptionist).
 *
 * @role - параметр определяет роль, уровень доступа .
 *
 * @Author Nikita Terekhov
 * @version 0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) long id; // still set automatically

    @Column(name="name",nullable = true)
    private String name;

    @Column(name="last_name",nullable = true)
    private String lastName;

    @Column(name ="middle_name", nullable = true)
    private String middleName;

    @Column(name = "date", columnDefinition = "date",nullable = true)
    private Date date;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "phone",nullable = true)
    private String phone;

    @NotBlank
    @Size(max=20)
    private String username;

    @Column(name = "email",nullable = false)
    @Email
    @Size(max = 50)
    private String email;

    @Column(name = "password",nullable = false)
    @NotBlank
    @Size(max = 120)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
            @JoinTable(name="user_roles",
                    joinColumns = @JoinColumn(name = "user_id"),
                    inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles = new HashSet<>();

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getUsername() {
        return username;
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public User(String name, String lastName, String middleName, Date date, Role role, String address, String phone, String email) {
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
        this.date = date;
        this.address=address;
        this.phone = phone;
        this.email=email;
    }

    public User(String username, String email, String password){
        this.username=username;
        this.email=email;
        this.password=password;
    }

    public void setLastName(String lastName){
        this.lastName =lastName;
    }

    public void setName(String name){
        this.name =name;
    }

}
