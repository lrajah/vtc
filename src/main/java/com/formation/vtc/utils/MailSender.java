package com.formation.vtc.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

	// Recipient's email ID needs to be mentioned.
	String to;

	// Sender's email ID needs to be mentioned
	String from;

	// Assuming you are sending email from localhost
	String host = "localhost";

	// Get system properties
	Properties properties = System.getProperties();

	// Setup mail server

	public void sendMail(String to, String from, String subject, String msg) {
//		this.getProperties().setProperty("mail.smtp.host", this.host);
//		this.getProperties().put("mail.smtp.port", 8000);
		this.setFrom(from);
		this.setTo(to);

		// Get the default Session object.
		final String username = "";
		final String password = "";

//		this.getProperties().put("mail.smtp.host", "smtp.gmail.com");
//		this.getProperties().put("mail.smtp.socketFactory.port", "465");
//		this.getProperties().put("mail.smtp.socketFactory.class",
//				"javax.net.ssl.SSLSocketFactory");
//		this.getProperties().put("mail.smtp.auth", "true");
//		this.getProperties().put("mail.smtp.port", "465");
//
//		Session session = Session.getDefaultInstance(this.getProperties(),
//			new javax.mail.Authenticator() {
//				protected PasswordAuthentication getPasswordAuthentication() {
//					return new PasswordAuthentication("username","password");
//				}
//			});
		this.getProperties().put("mail.smtp.auth", "true");
		this.getProperties().put("mail.smtp.starttls.enable", "true");
		this.getProperties().put("mail.smtp.host", "smtp.gmail.com");
		this.getProperties().put("mail.smtp.port", "587");

		Session session = Session.getInstance(this.getProperties(), new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
//		Session session = Session.getDefaultInstance(this.getProperties());

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(this.getFrom()));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.getTo()));

			// Set Subject: header field
			message.setSubject(subject);

			// Send the actual HTML message, as big as you like
			message.setContent(msg, "text/html");

			// Send message
			Transport.send(message);
//			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

}
