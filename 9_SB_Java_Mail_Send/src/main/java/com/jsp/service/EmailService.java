package com.jsp.service;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	
	//send simple mail
	public void sendMail(String to,String subject,String body) {
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setTo(to);
		msg.setSubject(subject);
		msg.setText(body);
		javaMailSender.send(msg);
		System.out.println("Simple mail is send to user");
		
	}
	
	// send email with html files and attachments.
	@Autowired
	private TemplateEngine templateEngine;
	public void sendpage(String to,String subject) throws MessagingException {
		MimeMessage mimeMessage= javaMailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mimeMessage, true);//true bcz to send attachments along with email
		
		//forget page line to mail
		String body=templateEngine.process("forgot-password",new Context());
		//resetpage to mail
//		String body=templateEngine.process("reset-password",new Context());
		
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body,true);//pass true if body contains html code else pass false
		//send any file in pdf
		helper.addAttachment("Spring Notes", new File("C:\\Users\\prati\\OneDrive\\Desktop\\Pratik\\My notes Devlopment\\Advanced Java\\Spring_Notes.pdf"));
		
		javaMailSender.send(mimeMessage);
		System.out.println("Sent Html page with pdf to mail");
		
	}

}





