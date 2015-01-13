package com.hifi.thattukada.variety.pojo;

public class UserDetailsPojo {
	private int pki_user_id;
	private String uvc_user_name;
	private String uvc_email;
	private String vc_passwd;	
	private boolean b_send_updates;
	
	public UserDetailsPojo(){
		System.out.println("\n\n UserDetailsPojo Activated \n \n");
	}

	public int getPki_user_id() {
		return pki_user_id;
	}

	public void setPki_user_id(int pki_user_id) {
		this.pki_user_id = pki_user_id;
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

	public boolean isB_send_updates() {
		return b_send_updates;
	}

	public void setB_send_updates(boolean b_send_updates) {
		this.b_send_updates = b_send_updates;
	}
	
	
}
