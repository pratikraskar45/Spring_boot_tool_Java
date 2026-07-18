package com.jsp.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "student_info")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//use only one for all this
@Data //its from lambok
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;
	@Size(min = 3,max = 6,message = "You have enter name of min 3 or max 6 char")
	@NotEmpty(message = "The name can't be nulllllll")
	private String name;
	@Column(unique = true)
	@Email(message = "Email  isssss not valid")
	private String email;
	@Column(nullable = false)
	private Integer std;
	@CreationTimestamp
	@Column(updatable = false,nullable = false)
	private LocalDateTime createDateTime;
	@UpdateTimestamp
	@Column(nullable = false)
	private LocalDateTime updateDateTime;
	

}
