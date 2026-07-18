package com.pr.counsellorapp.dto;

import com.pr.counsellorapp.enums.ClassMode;
import com.pr.counsellorapp.enums.Course;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class FilterDto {
	private ClassMode classMode;

	private Course course;

}
