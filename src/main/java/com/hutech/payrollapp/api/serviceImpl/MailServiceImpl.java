package com.hutech.payrollapp.api.serviceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.hutech.payrollapp.api.model.Timesheet;
import com.hutech.payrollapp.api.repository.TimesheetRepository;

@Service
public class MailServiceImpl {
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private TimesheetRepository timesheetRepo;

	@Autowired
	public MailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendEmail(String mang, Timesheet timeSheet) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		String subject = "Time Sheet Approval";
		helper.setTo(mang);
		helper.setSubject(subject);
		helper.setText("http://localhost:8045/application/verify?verificationCode=" + timeSheet.getVerificationCode());
		javaMailSender.send(message);
	}

	public boolean verify(String verificationCode) throws MessagingException {
		Timesheet timesheet = timesheetRepo.findByVerificationCode(verificationCode);
		if (timesheet == null || timesheet.isEnabled()) {
			return false;
		} else {
			timesheet.setVerificationCode(null);
			timesheet.setEnabled(true);
			timesheetRepo.save(timesheet);
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setTo(timesheet.getEmployee().getEmpEmail());
			helper.setSubject("Timesheet Approved!");
			String content = "<center><h3> Dear, " + timesheet.getEmployee().getEmpFirstName() + "</h3>"
					+ "<h4>Your Time Sheet has been approved by your Manager.</h4></center>";
			message.setContent(content, "text/html; charset=utf-8");
			javaMailSender.send(message);
			return true;
		}
	}

}
