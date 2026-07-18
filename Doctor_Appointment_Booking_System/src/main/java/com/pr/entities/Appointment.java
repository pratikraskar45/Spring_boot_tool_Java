package com.pr.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.pr.enums.Department;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "appointment_info")
@Getter
@Setter
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appointment_Id;

	@NotNull(message = "Department must be selected")
	@Enumerated(EnumType.STRING)
	private Department department;

	@NotNull(message = "Doctor must be selected")
	private Integer doctorId; // OR use @ManyToOne if you want full relation with Doctor

	@NotBlank(message = "Patient name is required")
	private String patientName;

	@NotBlank(message = "Phone number is required")
	@Pattern(regexp = "^\\+?\\d{10,15}$", message = "Invalid phone number")
	private String phone;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;

	@NotNull(message = "Appointment date is required")
	private LocalDate appointmentDate; // Format: dd-MM-yyyy

	@NotNull(message = "Appointment time is required")
	private LocalTime appointmentTime;

	@Size(max = 500, message = "Note can't exceed 500 characters")
	private String note;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdDateTime;

	@ManyToOne
	@JoinColumn(name = "dr_id")
	private Doctor doctor;
}
