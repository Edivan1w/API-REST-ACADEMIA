package me.dio.academia.digital.config.jwt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JWTObject {

	private String subject;
	private Date issuedAt;
	private Date expiration;
	private List<String> roles = new ArrayList<String>();
	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getIssuedAt() {
		return issuedAt;
	}
	public void setIssuedAt(Date inssuedAt) {
		this.issuedAt = inssuedAt;
	}
	public Date getExpiration() {
		return expiration;
	}
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
	
}
