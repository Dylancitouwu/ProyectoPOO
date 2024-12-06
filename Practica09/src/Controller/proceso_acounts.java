package Controller;

import Model.configurable;

public class proceso_acounts implements Runnable, configurable{
	
	private Thread hilo;
	private String numberAcount="";
	public proceso_acounts() {
		hilo=new Thread();		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			numberAcount+=String.valueOf(getValue());
		}
	}
	public String getNumberAcount() {
		return numberAcount;
	}

}
