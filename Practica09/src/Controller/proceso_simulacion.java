package Controller;

import view.view_caja;

public class proceso_simulacion implements Runnable{
	///////////
	private view_caja vc;
	private Thread hilo;
	////////////
	
	public proceso_simulacion(view_caja vc) {
		super();
		this.vc = vc;
		hilo= new Thread();
	}
	private void enableField(boolean state) {
		vc.txt_search.setEnabled(state);
		vc.txt_mount.setEnabled(state);
		vc.btn_search.setEnabled(state);
		vc.txt_acount.setEnabled(state);
		vc.txt_dni.setEnabled(state);
		vc.txt_montoD.setEnabled(state);
		vc.txt_montoR.setEnabled(state);
		vc.btn_depositos.setEnabled(state);
		vc.btn_Retiros.setEnabled(state);
	}
	
	@Override
	public void run() {
		enableField(false);
		try {
			for (int i=0;i<100;i++) {
				hilo.sleep(300);
				vc.prbr_load.setValue(i);
				if (i%2==0) {
					vc.lbl_load.setText("Loading");
				}else if (i%3==0){
					vc.lbl_load.setText("Loading");
				}else if (i%5==0){
					vc.lbl_load.setText("Loading");
				}
			}
			vc.lbl_load.setText("Carga completa");
			hilo.sleep(1000);
			enableField(true);
			vc.lbl_load.setVisible(false);
			vc.prbr_load.setVisible(false);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	

}
