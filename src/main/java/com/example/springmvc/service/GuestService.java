package com.example.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.springmvc.repository.GuestRepository;
import org.springframework.stereotype.Service;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    //Требование А.а.8
    //private int solvePayment(Date date, int nightAmount){}

    //Требование А.а.5
    private void automaticMailer(){}

    //Требование А.а.4
    private void editGuestInfo(){}

    //Требование А.б.1
    //private Guest.Status checkIn(){}

    //Требование А.б.1
    //private Guest.Status checkOut(){}

    //Требование А.б.3
    private void carRegistration(){}



}
