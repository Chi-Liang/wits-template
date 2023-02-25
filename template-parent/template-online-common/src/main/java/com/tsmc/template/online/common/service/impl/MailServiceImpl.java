package com.tsmc.template.online.common.service.impl;

import org.springframework.stereotype.Service;
import com.tsmc.template.online.common.service.MailService;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;
import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailServiceImpl implements MailService {
	
	private final JavaMailSender mailSender;
	
	@Override
	public boolean sendMail(String mailTo, String startTime, String endTime) {
		
		boolean result = false;
		
		MimeMessagePreparator messagePreparator = mimeMessage -> {

			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
			String[] to = new String[1];
			to[0] = mailTo;
			messageHelper.setTo(to);
			mimeMessage.setSubject("寄送會議通知");
			
			String utcStartTime = getUtc(startTime);
		
			String utcEndTime = getUtc(endTime);
			StringBuffer buffer = new StringBuffer();
			buffer.append("BEGIN:VCALENDAR\n" + "PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN\n"
					+ "VERSION:2.0\n" + "METHOD:REQUEST\n" + "BEGIN:VEVENT\n"
					+ "ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=FALSE:MAILTO:"+ mailTo + "\n"
			 + "ORGANIZER:MAILTO:"+ mailTo + "\n"
					+ "DTSTART:" + utcStartTime + "\n" + "DTEND:" + utcEndTime + "\n"
					+ "LOCATION:會議室01\n"
					+ "UID:" + UUID.randomUUID().toString() + "\n" + "CATEGORIES:\n"
					+ "TRIGGER:-PT10M\n" + "ACTION:DISPLAY\n" + "DESCRIPTION:Reminder\n" + "END:VALARM\n"
					+ "END:VEVENT\n" + "END:VCALENDAR");
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setDataHandler(new DataHandler(
					new ByteArrayDataSource(buffer.toString(), "text/calendar;method=REQUEST;charset=\"UTF-8\"")));
			MimeMultipart multipart = new MimeMultipart();
			
			MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
			mimeBodyPart2.setText("系統自動寄送會議通知");
			multipart.addBodyPart(mimeBodyPart2);
			multipart.addBodyPart(messageBodyPart);
			mimeMessage.setContent(multipart);
			
		};
		try {
			mailSender.send(messagePreparator);
			result = true;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return result;
	}
	
	private static String getUtc(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		long millionSeconds = 0;
		try {
			millionSeconds = sdf.parse(str).getTime();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		
		long currentTime = millionSeconds - 8 * 60 * 60 * 1000;
		Date date = new Date(currentTime);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = "";
		nowTime = df.format(date);
		String utcTime = nowTime.replace("-", "").replace(" ", "T").replace(":", "");
		return utcTime;
	}

}
