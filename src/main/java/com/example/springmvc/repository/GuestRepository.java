package com.example.springmvc.repository;

import com.example.springmvc.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long>{

    List<Guest> findGuestsByFirstNameContaining(String firstName);

    List<Guest> findGuestsBySecondNameContaining(String secondName);

    List<Guest> findGuestsByFirstNameAndSecondNameContaining(String firstName,String secondName);

    List<Guest> findGuestsByThirdNameContaining(String thirdName);

    List<Guest> findGuestsByBirthDate(Date birthDate);

    List<Guest> findGuestsByStatus(Guest.Status status);

    List<Guest> findGuestsByRoomNumber(int roomNumber);

    List<Guest> findGuestsByStartStatusDate(Date startStatusDate);

    List<Guest> findGuestsByEndStatusDate(Date endStatusDate);

    List<Guest> findGuestsByAddressContains(String address);

    List<Guest> findGuestsByPhoneNumberContains(String phoneNumber);

    List<Guest> findGuestsByEmailContaining(String email);

    //?


}
