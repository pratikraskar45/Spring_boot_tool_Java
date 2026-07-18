package com.pr.counsellorapp.dto;

import com.pr.counsellorapp.enums.Course;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class EnquiryDto {
	private String name;
	private Long phone;
	private String email;
	private Double fees;
	private Course course;

}
