package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JPasswordField;

public class view_login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_usuario;
	public JButton btn_next;
	public JPasswordField txt_psw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_login frame = new view_login();
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
	public view_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 353, 144);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "INICIO SESI\u00D3N", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(10, 11, 324, 94);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(72, 21, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(51, 46, 67, 14);
		panel.add(lblContrasea);
		
		txt_usuario = new JTextField();
		txt_usuario.setBounds(118, 18, 152, 20);
		panel.add(txt_usuario);
		txt_usuario.setColumns(10);
		
		btn_next = new JButton("Log in");
		btn_next.setBounds(197, 69, 73, 14);
		panel.add(btn_next);
		
		txt_psw = new JPasswordField();
		txt_psw.setBounds(118, 43, 152, 20);
		panel.add(txt_psw);
	}
}
