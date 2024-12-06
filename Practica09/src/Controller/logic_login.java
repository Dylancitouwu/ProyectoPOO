package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import Model.userDAO;
import view.view_caja;
import view.view_login;


public class logic_login implements ActionListener {
	private userDAO D;
	private view_login vlg;
	public logic_login(view_login vlg) {
		if(vlg==null) {
			throw new IllegalArgumentException("La vista no puede ser nula.");
		}
		this.vlg=vlg;
		this.vlg.btn_next.addActionListener(this);
		this.D=new userDAO();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vlg.btn_next) {
			validateCredentials();
		}		
		// TODO Auto-generated method stub		
	}
	private void validateCredentials() {
	    String enteredUsername = vlg.txt_usuario.getText().trim();
	    String enteredPassword = new String(vlg.txt_psw.getPassword()).trim();

	    if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
	        JOptionPane.showMessageDialog(vlg, "Por favor ingresa ambos, usuario y contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    System.out.println("Usuario ingresado: " + enteredUsername);
	    System.out.println("Contraseña ingresada: " + enteredPassword);

	    File file = new File("src/nomina/Userlogin.txt");

	    if (!file.exists()) {
	        JOptionPane.showMessageDialog(vlg, "El archivo de credenciales no existe.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	        String line;
	        boolean isValid = false;

	        while ((line = reader.readLine()) != null) {
	            if (line.trim().isEmpty() || line.startsWith("#")) {
	                continue;
	            }

	            // Dividir la línea por comas
	            String[] columns = line.split(",");

	            // Verificar si la línea tiene al menos dos columnas (usuario y contraseña)
	            if (columns.length >= 2) {
	                String fileUsername = columns[0].trim();
	                String filePassword = columns[1].trim();

	                System.out.println("Usuario en archivo: " + fileUsername);
	                System.out.println("Contraseña en archivo: " + filePassword);

	                if (fileUsername.equals(enteredUsername) && filePassword.equals(enteredPassword)) {
	                    isValid = true;
	                    break;
	                }
	            } else {
	                System.out.println("Línea con formato incorrecto: " + line);
	            }
	        }

	        if (isValid) {
	            JOptionPane.showMessageDialog(vlg, "Inicio de sesión exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	            
             // Abrir la ventana de login para administrador                	
                view_caja MadminView = new  view_caja();
                MadminView.setVisible(true);
                vlg.dispose(); // Cierra la ventana actual si es necesario
	            // Aquí puedes proceder a la siguiente ventana
	        } else {
	            JOptionPane.showMessageDialog(vlg, "Nombre de usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(vlg, "Error al leer el archivo de credenciales", "Error", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace();
	    }
	}



}
