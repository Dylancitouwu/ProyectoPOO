package Controller;

import java.io.File;

import Model.acount;
import Model.acountDAO;
import Model.configurable;

public class proceso_newFiles extends Thread implements configurable{
	//////////////////////
	private acountDAO adao;
	
	//////////////////////
	
	public proceso_newFiles(String nameFile) {
		super(nameFile);
		adao = new acountDAO(new acount(Long.parseLong(nameFile),0,0));
	}
	
	
	public void run() {
		try {
			sleep(2000);
			adao.createAcountFile();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
};
