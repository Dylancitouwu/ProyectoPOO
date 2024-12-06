package Controller;

public class executeProcess implements Runnable{
	///////////////////////////////////////////////
	private String[] acounts=new String[10]; // vector de string
	private int index=0;
	///////////////////////////////////////////////
	
	private void createNumberAcounts() {
		Thread[] hilo_acounts=new Thread[acounts.length];
		for (Thread hilo: hilo_acounts) {
			proceso_acounts proceso=new proceso_acounts();
			hilo=new Thread(proceso);
			try {
				hilo.start();
				hilo.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			acounts[index]=proceso.getNumberAcount();
			System.out.println(acounts[index]);
			index++;
		}
	}
	private void createFiles() {
		Thread[] hilo_files=new Thread[acounts.length];
		index=0;
		for(Thread hilo:hilo_files) {
			hilo=new proceso_newFiles(acounts[index]);
			index++;
			try {
				hilo.start();
				hilo.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private void loadAcounts() {
		Thread[] hilo_writeAcount=new Thread[acounts.length];
		index=0;
		for (Thread hilo:hilo_writeAcount) {
			hilo= new proceso_loadAcount(acounts[index]);
			hilo.start();
			try {
				hilo.join();
				System.out.println("Cuenta creada: "+ acounts[index]);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			index++;
		}
	}
	@Override
	public void run() {
		createNumberAcounts();
		createFiles();
		loadAcounts();
	}
	
	
	
	
	
	
	
	
	
	
	
	

};
