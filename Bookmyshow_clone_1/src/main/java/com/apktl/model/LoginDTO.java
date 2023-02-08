package com.apktl.model;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Component
public class LoginDTO {

	private String logEmail;
	private String logPassword;
	
	public LoginDTO() {
		
	}

	public String getLogEmail() {
		return logEmail;
	}

	public void setLogEmail(String logEmail) {
		this.logEmail = logEmail;
	}

	public String getLogPassword() {
		return logPassword;
	}

	public void setLogPassword(String logPassword) {
		this.logPassword = logPassword;
	}

	@Override
	public String toString() {
		return "LoginDTO [logEmail=" + logEmail + ", logPassword=" + logPassword + "]";
	}

	
	
	
}
