package com.example.springmvc.model;

import lombok.*;

import javax.persistence.*;
import java.time.*;

@Entity
@Table
public class Booking {

	@Id
	@SequenceGenerator(name = "booking_sequence",
		sequenceName = "booking_sequence",
		allocationSize = 1)
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "booking_sequence"
	)
	@Getter
	@Setter
	private Long id;

	private String clientName;

	@Transient
	@Setter
	private Integer age;

	@Getter
	@Setter
	private LocalDate dateOfBirth;

	private String email;

	public Booking() {
	}

	public Booking(Long id, String clientName, LocalDate dateOfBirth, String email) {
		this.id = id;
		this.clientName = clientName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
	}

	// DataBase will generate the id
	public Booking(String clientName, LocalDate dateOfBirth, String email) {
		this.clientName = clientName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return Period.between(dateOfBirth, LocalDate.now()).getYears();
	}

	@Override
	public String toString() {
		return "Booking{" +
			"id=" + id +
			", clientName='" + clientName + '\'' +
			", age=" + age +
			", dateOfBirth=" + dateOfBirth +
			", email='" + email + '\'' +
			'}';
	}
}
