import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LibrarianLogin {

	private JFrame frame;
	private JTextField txtname;
	private JTextField txtpassword;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianLogin window = new LibrarianLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public LibrarianLogin() {
		initialize();
		Connect();
	}
	
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	public void Connect()
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
	    con = DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
		}
	   catch(ClassNotFoundException ex)
	   {
		   
	   }
	   catch(SQLException ex)
		{
		   
		}
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 884, 639);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Librarian login form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(286, 31, 348, 76);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(164, 151, 65, 44);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtname = new JTextField();
		txtname.setBounds(261, 166, 192, 19);
		frame.getContentPane().add(txtname);
		txtname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(164, 230, 81, 44);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtpassword = new JTextField();
		txtpassword.setColumns(10);
		txtpassword.setBounds(261, 245, 192, 19);
		frame.getContentPane().add(txtpassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String n, p;
				n = txtname.getText();
				p = txtpassword.getText();
				
				try
				{
					pst = con.prepareStatement("select * from librarian where name=? and password=?");
					pst.setString(1, n);
					pst.setString(2, p);
					rs = pst.executeQuery();
					while(rs.next()) {
						
					String name =rs.getString("name");
					String password=rs.getString("password");
					
				
				    	if((n.equals(name))&&(p.equals(password)))
				    	{
				    		LibrarianSection.main(new String[] {});
				    		frame.dispose();
				    	}
				    	else
				    	{
				    		JOptionPane.showMessageDialog(null,"please check name or password may be wrong!!");
				    }
					}
				}
				catch(SQLException el)
				{
					el.printStackTrace();
					
				}
				
			}	
				
				
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(338, 314, 92, 31);
		frame.getContentPane().add(btnNewButton);
	}
}
