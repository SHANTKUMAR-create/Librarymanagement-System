import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IssueBook {

	private JFrame frame;
	private JTextField txtbno;
	private JTextField txtsid;
	private JTextField txtsname;
	private JTextField txtscontact;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBook window = new IssueBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public IssueBook() {
		initialize();
		Connect();
	
	}
	
	Connection con;
	PreparedStatement pst;
	
	
	
	public void Connect()
	{
	try {
			
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
		frame.setBounds(100, 100, 784, 670);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Issue Book");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(294, 29, 160, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book No");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(74, 145, 97, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Student Id");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(74, 203, 97, 32);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Student Name");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(74, 258, 113, 32);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Student Contact");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(74, 316, 125, 32);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		txtbno = new JTextField();
		txtbno.setBounds(249, 154, 181, 19);
		frame.getContentPane().add(txtbno);
		txtbno.setColumns(10);
		
		txtsid = new JTextField();
		txtsid.setColumns(10);
		txtsid.setBounds(249, 212, 181, 19);
		frame.getContentPane().add(txtsid);
		
		txtsname = new JTextField();
		txtsname.setColumns(10);
		txtsname.setBounds(249, 267, 181, 19);
		frame.getContentPane().add(txtsname);
		
		txtscontact = new JTextField();
		txtscontact.setColumns(10);
		txtscontact.setBounds(249, 325, 181, 19);
		frame.getContentPane().add(txtscontact);
		
		JButton btnNewButton = new JButton("Issue Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bookno,studentid,studentname,studentcontact;
				 
				bookno = txtbno.getText();
				studentid = txtsid.getText();
				studentname = txtsname.getText();
				studentcontact = txtscontact.getText();
				
				
				try
				{
					pst = con.prepareStatement("insert into issuebook(bookno,studentid,studentname,studentcontact)values(?,?,?,?)");
				    pst.setString(1,bookno);
				    pst.setString(2,studentid);
				    pst.setString(3,studentname);
				    pst.setString(4,studentcontact);
				    pst.executeUpdate();
				    JOptionPane.showMessageDialog(null,"Book Issued!!!");
				    txtbno.setText("");
				    txtsid.setText("");
				    txtsname.setText("");
				    txtscontact.setText("");
				    txtbno.requestFocus();
	  
				}
				catch(SQLException el)
				{
					el.printStackTrace();
				}
				
			
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(279, 394, 140, 44);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			LibrarianSection.main(new String[] {});	
			frame.dispose();
	
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(505, 505, 97, 32);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Note: Please check student ID Carefully before issuing book! ");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(33, 580, 421, 32);
		frame.getContentPane().add(lblNewLabel_2);
	}

}
