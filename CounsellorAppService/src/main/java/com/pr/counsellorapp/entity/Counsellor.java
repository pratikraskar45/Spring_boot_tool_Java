package com.pr.counsellorapp.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pr.counsellorapp.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "counsellor_info")
@Setter
@Getter
public class Counsellor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;

	@NotEmpty
	@Size(min = 3 ,max = 15,message = "Name should be between 3 and 15 charecteres")
	private String name;

	@Email(message = "invalid email format")
	@Column(unique = true)
	private String email;
	@JsonIgnore
	private String password;
	@Column(unique = true)
	private Long phone;

	@Enumerated(EnumType.STRING)
	private Status status = Status.ACTIVE;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate createdDate;

	@UpdateTimestamp
	private LocalDate updatedDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "counsellor")
	private List<Enquiry> enquiries;

}
