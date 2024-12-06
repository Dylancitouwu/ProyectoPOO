package Model;

import lib_genericP65v0.generic;

public class user {
	private generic<String, String> dt_p1; 
	public user() {
		dt_p1= new generic<>("","");
	}
	public user(String nameuser, String password) {
		dt_p1= new generic<>(nameuser,password);
	}
	
	public String getNameuser() {
        return dt_p1.getAttribute1();
    }
	public void setNameuser(String nameuser) {
        dt_p1.setAttribute1(nameuser);
    }
	 public String getPassword() {
	    return dt_p1.getAttribute2();
	}
	public void setPassword(String password) {
	    dt_p1.setAttribute2(password);
	}
	 public String toString() {
	        return String.format("%s,%s", 
	                getNameuser(), getPassword());
	    }
}
