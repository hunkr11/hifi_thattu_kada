package com.hifi.thattukada.variety.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="tbl_user",schema="admn")
public class UserEntity implements java.io.Serializable{

	@Id	
	@GeneratedValue
	//@Column(name="pki_user_id")
	private int pki_user_id;
	
	public int getPki_user_id() {
		return pki_user_id;
	}

	public void setPki_user_id(int pki_user_id) {
		this.pki_user_id = pki_user_id;
	}

	//@Column(name="uvc_user_name")
	private String uvc_user_name;
	
	//@Column(name="uvc_email")
	private String uvc_email;
	
	//@Column(name="vc_passwd")
	private String vc_passwd;
	
	public UserEntity(){		
		System.out.println("\n\n ENTITY ACTIVATED \n\n");
	}

	public String getUvc_user_name() {
		return uvc_user_name;
	}

	public void setUvc_user_name(String uvc_user_name) {
		this.uvc_user_name = uvc_user_name;
	}

	public String getUvc_email() {
		return uvc_email;
	}

	public void setUvc_email(String uvc_email) {
		this.uvc_email = uvc_email;
	}

	public String getVc_passwd() {
		return vc_passwd;
	}

	public void setVc_passwd(String vc_passwd) {
		this.vc_passwd = vc_passwd;
	}
	
	
			
}
