import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddLibrarian {

	private JFrame frame;
	private JTextField txtname;
	private JTextField txtpassword;
	private JTextField txtemail;
	private JTextField txtaddress;
	private JTextField txtcity;
	private JTextField txtcontact;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLibrarian window = new AddLibrarian();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AddLibrarian() {
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
		frame.setBounds(100, 100, 743, 609);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Librarian");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(269, 31, 269, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(47, 119, 65, 34);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(47, 163, 76, 34);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(47, 207, 54, 34);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Address");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(47, 262, 65, 34);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("City");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBounds(47, 323, 65, 34);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Contact No.");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1.setBounds(47, 378, 90, 34);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1_1);
		
		txtname = new JTextField();
		txtname.setBounds(172, 129, 217, 19);
		frame.getContentPane().add(txtname);
		txtname.setColumns(10);
		
		txtpassword = new JTextField();
		txtpassword.setColumns(10);
		txtpassword.setBounds(172, 173, 217, 19);
		frame.getContentPane().add(txtpassword);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(172, 217, 217, 19);
		frame.getContentPane().add(txtemail);
		
		txtaddress = new JTextField();
		txtaddress.setColumns(10);
		txtaddress.setBounds(172, 272, 217, 19);
		frame.getContentPane().add(txtaddress);
		
		txtcity = new JTextField();
		txtcity.setColumns(10);
		txtcity.setBounds(172, 333, 217, 19);
		frame.getContentPane().add(txtcity);
		
		txtcontact = new JTextField();
		txtcontact.setColumns(10);
		txtcontact.setBounds(172, 388, 217, 19);
		frame.getContentPane().add(txtcontact);
		
		JButton btnNewButton = new JButton("Add Librarian");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name,password,email,address,city,contactno; 
				name = txtname.getText();
				password = txtpassword.getText();
				email = txtemail.getText();
				address = txtaddress.getText();
				city = txtcity.getText();
				contactno = txtcontact.getText();
				
				try
				{
					pst = con.prepareStatement("insert into librarian(name,password,email,address,city,contactno)values(?,?,?,?,?,?)");
					pst.setString(1,name);
					pst.setString(2,password);
					pst.setString(3,email);
					pst.setString(4,address);
					pst.setString(5,city);
					pst.setString(6, contactno);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Librarian Aadded!!!");
					txtname.setText("");
					txtpassword.setText("");
					txtemail.setText("");
					txtaddress.setText("");
					txtcity.setText("");
					txtcontact.setText("");
					txtname.requestFocus();
				}
				catch(SQLException el)
				{
					el.printStackTrace();
				}
				
				
				
				
				}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(206, 436, 137, 41);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				AdminSection.main(new String[] {});
				frame.dispose();
				
				
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(250, 517, 76, 27);
		frame.getContentPane().add(btnNewButton_1);
	}
}
