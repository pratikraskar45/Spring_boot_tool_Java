package com.jsp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jsp.service.EmailService;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws MessagingException {

		ConfigurableApplicationContext cac= SpringApplication.run(Application.class, args);
		EmailService bean= cac.getBean(EmailService.class);
		//to send simple mail
//		bean.sendMail("raskarpratik44@gmail.com", "Testing The mail", "hello, "+ "I am testing the mail sending to User....");

		
		
		

		
		//to html to mail reset page
//		bean.sendpage("raskarpratik44@gmail.com", "Requsting to reset-password ");
		
		//to html to mail forgot page
		bean.sendpage("raskarpratik44@gmail.com", "Requsting to forgot-password ");
		
		
		
	}

}