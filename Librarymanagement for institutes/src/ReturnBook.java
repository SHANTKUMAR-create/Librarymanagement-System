import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ReturnBook {

	private JFrame frame;
	private JTextField txtbno;
	private JTextField txtsid;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook window = new ReturnBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ReturnBook() {
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
		frame.setBounds(100, 100, 763, 649);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Return Book");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(307, 31, 259, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book No");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(51, 136, 115, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Student Id");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(51, 212, 90, 30);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		txtbno = new JTextField();
		txtbno.setBounds(194, 144, 185, 22);
		frame.getContentPane().add(txtbno);
		txtbno.setColumns(10);
		
		txtsid = new JTextField();
		txtsid.setColumns(10);
		txtsid.setBounds(194, 220, 185, 22);
		frame.getContentPane().add(txtsid);
		
		JButton btnNewButton = new JButton("Return Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bno;
				
				bno = txtbno.getText();
				
				try
				{
				pst = con.prepareStatement("delete from issuebook where bookno=?");
				pst.setString(1,bno);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"Book Returned!!!");
				}
				catch(SQLException el)
				{
					el.printStackTrace();
				}
					
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(233, 283, 130, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LibrarianSection.main(new String[] {});
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(481, 386, 123, 36);
		frame.getContentPane().add(btnNewButton_1);
	}

}
