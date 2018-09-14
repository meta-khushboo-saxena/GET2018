package com.metacube.training.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.metacube.training.dto.EmailDetail;
import com.metacube.training.model.Employee;

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
				+ emailDetail.getLastname()
				+ "\nplease click below link to reset your password:\n\n"
				+ emailDetail.getUrl());
		javaMailSender.send(mail);
	}

	public void emailDetails(Employee employee) {
		EmailDetail emailDetail = new EmailDetail();
		emailDetail.setFirstName(employee.getFirstName());
		emailDetail.setLastname(employee.getLastName());
		emailDetail.setEmailAddress(employee.getEmailId());
		emailDetail.setPassword(employee.getPassword());

		sendEmail(emailDetail, "LOGIN DETAIL");
	}
}