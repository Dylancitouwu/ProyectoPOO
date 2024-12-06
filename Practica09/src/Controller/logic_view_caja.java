package Controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Model.acount;
import Model.acountDAO;
import view.view_caja;


public class logic_view_caja implements ActionListener {
	private acountDAO adao;
	private acount acount;
	private view_caja vc;
	
	public logic_view_caja(view_caja vc) {
		super();
		this.vc=vc;
		this.vc.btn_search.addActionListener(this);
		loadOptions("Opciones","Cuenta","Cedula");
		adao=new acountDAO();

		
		Thread  hilo1=new Thread(new executeProcess());
		Thread hilo2=new Thread(new proceso_simulacion(vc));
		
		hilo1.start();
		hilo2.start();
	}
			
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		acount=new acount();
		if(e.getSource()==vc.btn_search) {
			optionSelect();
			
		}else if(e.getSource()==vc.btn_depositos) {		    
			try {
	            // Obtenemos el monto del depósito
	            double depositAmount = Double.parseDouble(vc.txt_montoD.getText());
	            if (depositAmount <= 0) {
	                throw new NumberFormatException("El monto debe ser positivo.");
	            }
	            // Obtenemos el número de cuenta
	            long accountNumber = Long.parseLong(vc.txt_acount.getText());
	            
	            // Buscamos la cuenta correspondiente
	            acount = adao.findAcountFile(accountNumber);
	            
	            if (acount != null) {
	                // Crear un hilo para realizar la operación de depósito
	                Thread depositThread = new Thread(new Runnable() {
	                    @Override
	                    public void run() {
	                        try {
	                            // Realizamos el depósito
	                            acount.setMount(acount.getMount() + depositAmount);
	                            
	                            // Actualizamos la cuenta en el archivo
	                            adao.updateAcount(acount);
	                            
	                            // Actualizamos la interfaz con el nuevo monto
	                            SwingUtilities.invokeLater(new Runnable() {
	                                @Override
	                                public void run() {
	                                    vc.txt_mount.setText(String.format("%.2f", acount.getMount()));
	                                    JOptionPane.showMessageDialog(vc, "Depósito realizado con éxito.", "Caja", JOptionPane.INFORMATION_MESSAGE);
	                                }
	                            });
	                        } catch (IOException ex) {
	                            SwingUtilities.invokeLater(new Runnable() {
	                                @Override
	                                public void run() {
	                                    JOptionPane.showMessageDialog(vc, "Error al actualizar la cuenta.", "Caja", JOptionPane.ERROR_MESSAGE);
	                                }
	                            });
	                        }
	                    }
	                });
	                depositThread.start();
	            } else {
	                JOptionPane.showMessageDialog(vc, "Cuenta no encontrada.", "Caja", JOptionPane.INFORMATION_MESSAGE);
	            }
	        } catch (NumberFormatException ex) {
	            // Mostramos un mensaje de error si el monto es incorrecto
	            SwingUtilities.invokeLater(new Runnable() {
	                @Override
	                public void run() {
	                    JOptionPane.showMessageDialog(vc, "Por favor ingrese un monto válido para el depósito.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            });
	        } catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	private void loadOptions(String...options) {
		for(String option:options) {
			vc.cmb_options.addItem(option);
		}
	}
	
	private void optionSelect() {
		switch(vc.cmb_options.getSelectedItem().toString()) {
		case "Cuenta":
			findByAcount();
			break;
		case "Cedula":
			findByDNI();
			break;
		case "Opciones":
			JOptionPane.showMessageDialog(vc,"Elegir una opcion de busqueda","Caja", JOptionPane.ERROR_MESSAGE);
	
		}
		
	}
	private void findByAcount() {
		acount.setNumberAcount(Long.parseLong(vc.txt_search.getText()));
		try {
			acount=adao.findAcountFile(acount.getNumberAcount());
			if(acount!=null) {
				vc.txt_acount.setText(String.valueOf(acount.getNumberAcount()));
				vc.txt_dni.setText(String.valueOf(acount.getDni()));
				vc.txt_mount.setText(String.format("%.2f",acount.getMount()));
				
			}else {
				JOptionPane.showMessageDialog(vc,"Cuenta no existenete","Caja", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(vc,"Error en el archivo","Caja", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void findByDNI() {
	    String input = vc.txt_search.getText().trim(); // Elimina espacios en blanco
	    if (input.isEmpty() || !input.matches("\\d+")) { 
	        JOptionPane.showMessageDialog(vc, "Por favor, ingrese un DNI válido.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    
	    acount.setDni(Long.parseLong(input)); 
	    try {
	        acount = adao.findAcountFileByDni(acount.getDni());
	        if (acount != null) {
	            
	            vc.txt_acount.setText(String.valueOf(acount.getNumberAcount()));
	            vc.txt_dni.setText(String.valueOf(acount.getDni()));
	            vc.txt_mount.setText(String.format("%.2f", acount.getMount()));
	        } else {
	            JOptionPane.showMessageDialog(vc, "DNI no encontrado.", "Caja", JOptionPane.INFORMATION_MESSAGE);
	        }
	    } catch (IOException e1) {
	        JOptionPane.showMessageDialog(vc, "Error al leer el archivo.", "Caja", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
		
	

}
