package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.logic_view_caja;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import java.awt.Color;

public class view_caja extends JFrame {
	public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField txt_search;
	public JTextField txt_acount;
	public JTextField txt_dni;
	public JTextField txt_mount;
	public JComboBox cmb_options;
	public JButton btn_search;
	public JProgressBar prbr_load;
	public JLabel lbl_load;
	public JButton btn_depositos;
	public JButton btn_Retiros;
	public JLabel lblNewLabel_3;
	public JLabel lblNewLabel_4;
	public JTextField txt_montoR;
	public JTextField txt_montoD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_caja frame = new view_caja();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public view_caja() {
		setTitle("Caja");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 289);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn_caja = new JPanel();
		pn_caja.setBackground(Color.WHITE);
		pn_caja.setBounds(10, 0, 428, 254);
		contentPane.add(pn_caja);
		pn_caja.setLayout(null);
		
		cmb_options = new JComboBox();
		cmb_options.setBounds(10, 11, 105, 22);
		pn_caja.add(cmb_options);
		
		txt_search = new JTextField();
		txt_search.setBounds(153, 12, 158, 20);
		pn_caja.add(txt_search);
		txt_search.setColumns(10);
		
		btn_search = new JButton("Buscar");
		btn_search.setBounds(328, 11, 89, 23);
		pn_caja.add(btn_search);
		
		txt_acount = new JTextField();
		txt_acount.setColumns(10);
		txt_acount.setBounds(153, 51, 158, 20);
		pn_caja.add(txt_acount);
		
		txt_dni = new JTextField();
		txt_dni.setColumns(10);
		txt_dni.setBounds(153, 94, 158, 20);
		pn_caja.add(txt_dni);
		
		txt_mount = new JTextField();
		txt_mount.setColumns(10);
		txt_mount.setBounds(153, 139, 158, 20);
		pn_caja.add(txt_mount);
		
		JLabel lblNewLabel = new JLabel("Cuenta:");
		lblNewLabel.setBounds(47, 54, 48, 14);
		pn_caja.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cedula:");
		lblNewLabel_1.setBounds(47, 97, 48, 14);
		pn_caja.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Saldo:");
		lblNewLabel_2.setBounds(47, 145, 48, 14);
		pn_caja.add(lblNewLabel_2);
		
		prbr_load = new JProgressBar();
		prbr_load.setBounds(10, 213, 390, 30);
		pn_caja.add(prbr_load);
		
		lbl_load = new JLabel("");
		lbl_load.setBounds(10, 195, 390, 14);
		pn_caja.add(lbl_load);
		
		btn_depositos = new JButton("Depositos");
		btn_depositos.setBounds(138, 182, 77, 21);
		pn_caja.add(btn_depositos);
		
		btn_Retiros = new JButton("Retiros");
		btn_Retiros.setBounds(335, 182, 65, 21);
		pn_caja.add(btn_Retiros);
		
		lblNewLabel_3 = new JLabel("Depositar:");
		lblNewLabel_3.setBounds(47, 171, 48, 14);
		pn_caja.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Retirar:");
		lblNewLabel_4.setBounds(243, 169, 48, 14);
		pn_caja.add(lblNewLabel_4);
		
		txt_montoD = new JTextField();
		txt_montoD.setBounds(34, 188, 96, 14);
		pn_caja.add(txt_montoD);
		txt_montoD.setColumns(10);
		
		txt_montoR = new JTextField();
		txt_montoR.setColumns(10);
		txt_montoR.setBounds(229, 185, 96, 14);
		pn_caja.add(txt_montoR);
		logic_view_caja lvc=new logic_view_caja(this);
	}
}
