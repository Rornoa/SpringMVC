package com.example.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.springmvc.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService{

    @Autowired
    private RoomRepository roomRepository;

    //Требование А.а.7
    //public int changePrice(Date date){}





}
