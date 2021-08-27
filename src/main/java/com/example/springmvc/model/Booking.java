package com.example.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
    private String firstName;
    private String secondName;
    private String thirdName;

    private String phoneNumber;
    private String email;

    private final SimpleDateFormat formatterForArrival = new SimpleDateFormat("dd/MM/yyyy");
    private Date arrival;
    private String strArrival;

    private final SimpleDateFormat formatterForDepartment = new SimpleDateFormat("dd/MM/yyyy");
    private Date department;
    private String strDepartment;

    Long wholePeriodPrice;

    int peopleAmount;

    String additionalInfo;

    public Booking(String firstName, String secondName, String thirdName, String phoneNumber, String email, String arrival, String department, Long wholePeriodPrice, int peopleAmount, String additionalInfo) throws ParseException {
        this.firstName=firstName;
        this.secondName=secondName;
        this.thirdName=thirdName;
        this.phoneNumber=phoneNumber;
        this.email=email;

        this.arrival =formatterForArrival.parse(arrival);
        this.strArrival=this.arrival.toString();

        this.department =formatterForDepartment.parse(department);
        this.strDepartment=this.department.toString();

        this.wholePeriodPrice=wholePeriodPrice;
        this.peopleAmount=peopleAmount;
        this.additionalInfo=additionalInfo;
    }
}
