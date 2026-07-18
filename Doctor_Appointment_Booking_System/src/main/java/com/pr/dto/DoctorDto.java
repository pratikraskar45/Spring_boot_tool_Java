package com.pr.dto;


import com.pr.enums.Department;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorDto {	
    private String dr_name;

    private String dr_qualification;

    private String dr_experience; 

    private String email;
	
	private String password;

    private long dr_contactNumber; 
	
	

    private Department department;

    private String dr_availability; // e.g., "Mon-Fri 10:00 AM - 2:00 PM"

    private String dr_photo_url; // to store a profile image path or URL
 

}
