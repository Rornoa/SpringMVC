package com.example.springmvc.repository;

import com.example.springmvc.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findAllByArrivalGreaterThan(Date arrival);
    List<Booking> findAllByArrivalLessThan(String arrival);

    List<Booking> findAllByDepartmentGreaterThan(String department);
    List<Booking> findAllByDepartmentLessThan(String department);

    List<Booking> findAll();

}
