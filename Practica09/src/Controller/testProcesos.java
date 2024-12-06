package Controller;

public class testProcesos {

	public static void main(String[] args) {
		
		
//		Thread[] hilo_acounts=new Thread[10]; //vector de hilos 
//		String[] acounts=new String[hilo_acounts.length]; // vector de string
//		int index=0;
//		for (Thread hilo: hilo_acounts) {
//			proceso_acounts proceso=new proceso_acounts();
//			hilo=new Thread(proceso);
//			try {
//				hilo.start();
//				hilo.join();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			acounts[index]=proceso.getNumberAcount();
//			System.out.println(acounts[index]);
//			index++;
//		}
//		
//		
//		
//		Thread[] hilo_files=new Thread[acounts.length];
//		index=0;
//		for(Thread hilo:hilo_files) {
//			hilo=new proceso_newFiles(acounts[index]);
//			index++;
//			try {
//				hilo.start();
//				hilo.join();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		
//		Thread[] hilo_writeAcount=new Thread[acounts.length];
//		index=0;
//		for (Thread hilo:hilo_writeAcount) {
//			hilo= new proceso_loadAcount(acounts[index]);
//			hilo.start();
//			try {
//				hilo.join();
//				System.out.println("Cuenta creada: "+ acounts[index]);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			index++;
//		}
		
		Thread hilo= new Thread(new executeProcess());
		hilo.start();
		
		
		
		
		
		
		
		
		

	};

};
