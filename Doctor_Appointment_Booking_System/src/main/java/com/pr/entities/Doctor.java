package com.pr.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pr.enums.Department;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "doctor_info")
@Getter
@Setter
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dr_id;

	@NotBlank(message = "Doctor name is required")
	@Size(min = 3, max = 100, message = "Doctor name must be between 3 and 100 characters")
	private String dr_name;

	@NotBlank(message = "Qualification is required")
	private String dr_qualification;

	@NotBlank(message = "Experience must be provided")
	private String dr_experience;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;

	@NotBlank(message = "Password is required")
	@JsonIgnore
	private String password;

	@Min(value = 1000000000L, message = "Contact number should be at least 10 digits")
	@Max(value = 9999999999L, message = "Contact number should not exceed 10 digits")
	private long dr_contactNumber;

	@NotNull(message = "Department is required")
	@Enumerated(EnumType.STRING)
	private Department department;

	@NotBlank(message = "Availability must be specified")
	private String dr_availability; // e.g., "Mon-Fri 10:00 AM - 2:00 PM"
	@JsonIgnore
	private String dr_photo_url; // to store a profile image path or URL
	@JsonIgnore
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createDateTime;
	@JsonIgnore
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	@JsonIgnore
	@OneToMany(mappedBy = "doctor")
	private List<Appointment> appointments;

}
