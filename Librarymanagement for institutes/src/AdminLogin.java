import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminLogin {

	private JFrame frame;
	private JTextField txtadmin;
	private JTextField passwordField;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AdminLogin() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 748, 564);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Admin Login Form");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(250, 71, 254, 47);
		frame.getContentPane().add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBounds(138, 153, 500, 243);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Admin name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(61, 35, 99, 45);
		panel.add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(61, 104, 80, 45);
		panel.add(lblPassword);

		txtadmin = new JTextField();
		txtadmin.setBounds(207, 50, 182, 19);
		panel.add(txtadmin);
		txtadmin.setColumns(10);

		passwordField = new JPasswordField(10);
		passwordField.setBounds(207, 119, 182, 19);
		panel.add(passwordField);
		passwordField.setColumns(10);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String admin, password;
				admin = txtadmin.getText();
				password = passwordField.getText();

				
				  if(admin.equals("admin")&&password.equals("admin123")){ AdminSection.main(new
				  String[]{}); frame.dispose(); }else{ JOptionPane.showMessageDialog(null,
				  "Sorry name or password may be wrong please login again!!!");
				  txtadmin.setText(""); passwordField.setText(""); }
				 
			}	
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(217, 185, 99, 31);
		panel.add(btnNewButton);
	}

}
