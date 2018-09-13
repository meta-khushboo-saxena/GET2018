package com.metacube.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.metacube.training.dto.EmailDetail;

/**
 * Email service to get Mail on id
 */
@Service
public class EmailServiceImplement {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(EmailDetail emailDetail, String subject) {

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(emailDetail.getEmailAddress());
		mail.setSubject(subject);
		mail.setText("Hello " + emailDetail.getFirstName() + " "
				+ emailDetail.getLastname() + " your Password is : "
				+ emailDetail.getPassword());
		javaMailSender.send(mail);
	}
}