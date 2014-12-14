package com.hifi.thattukada.variety.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admn.tbl_user")
public class UserEntity {
	@Id
	@Column(name="pki_user_id")
	private int id;
	@Column(name="uvc_user_name")
	private String usr_name;
	@Column(name="uvc_email")
	private String usr_email;
	@Column(name="vc_passwd")
	private String usr_passwd;
	
	public UserEntity(){		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsr_name() {
		return usr_name;
	}
	public void setUsr_name(String usr_name) {
		this.usr_name = usr_name;
	}
	public String getUsr_email() {
		return usr_email;
	}
	public void setUsr_email(String usr_email) {
		this.usr_email = usr_email;
	}
	public String getUsr_passwd() {
		return usr_passwd;
	}
	public void setUsr_passwd(String usr_passwd) {
		this.usr_passwd = usr_passwd;
	}
			
}
