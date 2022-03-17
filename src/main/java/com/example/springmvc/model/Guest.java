package com.example.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


/**
 * Класс, описывающий гостей отеля.
 *
 * @loyaltyDate - дата с какого периода клиент является постоянным.
 * @tripAmount - количество поездок, совершенных клиентом в Ваш отель.
 * @status - состояния клиента (Забронировал номер, прошел регистрацию в отеле, въехал в номер, выехал из номера).
 * @startStatusDate - дата начала состояния клиента (Забронировал, прошел регистрацию, въехал, проживает с  01.01.2000, 00:01).
 * @endStatusdate - дата конца состояния клиента (дата выезда из номера).
 * @roomNumber - номер номера в который вселился/забронировал/вьехал/выехал гость.
 * @passportNumber - серия и номер паспорта гося. (вводится слитно).
 * @address - адрес места прописки.
 *
 * @Author joniker.e@mail.ru
 * @version 0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="guests")
public class Guest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
    private String firstName;
    private String secondName;
    private String thirdName;
    private Date birthDate;
    private String address;
    private String phoneNumber;
    private String email;

    private boolean hasCar;
    private String carNumber;

    private int tripAmount;
    private Status status;
    private Date loyaltyDate;
    private Date startStatusDate;
    private Date endStatusDate;
    private int roomNumber;
    private long passportNumber;

    public Guest(String firstName, String secondName) {
        this.firstName=firstName;
        this.secondName=secondName;
    }

    public enum Status{
        BOOKED,
        REGISTERED,
        ENTERED,
        LEFT,
    }
}
