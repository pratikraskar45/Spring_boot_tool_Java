package com.pr.counsellorapp.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pr.counsellorapp.enums.ClassMode;
import com.pr.counsellorapp.enums.Course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "enquiries")
@Getter
@Setter

public class Enquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eid;

	@NotEmpty
	@Size(min = 3 ,max = 20,message = "Name should be between 3 and 20 charecteres")
	private String name;

	@Column(unique = true)
	private Long phone;

	@Email(message = "Invalid email format")
	@Column(unique = true)
	private String email;

	private Double fees;

	@Enumerated(EnumType.STRING)
	private Course course;

	@Enumerated(EnumType.STRING)
	private ClassMode classMode = ClassMode.OFFLINE;

	@CreationTimestamp
	@Column(updatable = false)
	@JsonIgnore
	private LocalDate createdDate;

	@UpdateTimestamp
	@JsonIgnore
	private LocalDate updatedDate;
	@ManyToOne
	@JoinColumn(name = "counsellor_id")
	@JsonIgnore
	private Counsellor counsellor;
	
	


}
