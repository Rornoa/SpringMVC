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
    private String name;
    private String lastName;
    private String middleName;

    private String phone;
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

    public Booking(String name, String lastName, String middleName, String phone, String email, String arrival, String department, Long wholePeriodPrice, int peopleAmount, String additionalInfo) throws ParseException {
        this.name=name;
        this.lastName=lastName;
        this.middleName=middleName;
        this.phone=phone;
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
