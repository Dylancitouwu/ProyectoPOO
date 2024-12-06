package Controller;

import java.io.File;
import java.io.IOException;

import Model.acount;
import Model.acountDAO;
import Model.configurable;

public class proceso_loadAcount extends Thread implements configurable{
	////////////////////////////
	private String dni="";
	
	////////////////////////////
	
	public proceso_loadAcount(String msg) {
		super(msg);
	}
	
	public double getMount() {
		return Math.random()*2000;
	}
	
	public void run() {
		for(int i=0;i<10;i++) {
			dni+=String.valueOf(getValue());
		}
		
		try {
			sleep(1000);
			acountDAO adao=new acountDAO(new acount(Long.parseLong(getName()),Long.parseLong(dni),getMount()));
			adao.createAcountFile();
			adao.writeAcount();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getDni() {
		return dni;
	}

	
	
};
