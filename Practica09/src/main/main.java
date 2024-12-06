package main;

import java.awt.EventQueue;

import Controller.logic_login;


import view.view_login;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                view_login frame = new view_login();
	                new logic_login(frame); // Registrar el controlador
	                frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}

}
