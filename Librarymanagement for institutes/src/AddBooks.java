import java.awt.EventQueue;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBooks {

	private JFrame frame;
	private JTextField txtbno;
	private JTextField txtname;
	private JTextField txtauthor;
	private JTextField txtpublisher;
	private JTextField txtquantity;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBooks window = new AddBooks();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AddBooks() {
		initialize();
		Connect();
	}
	
	
	Connection con;
	PreparedStatement pst;
	private JTextField txtissuedate;
	
	
	
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
		frame.setBounds(100, 100, 764, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Books");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(290, 28, 164, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book No");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(68, 140, 94, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(73, 201, 70, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Author");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(68, 251, 70, 25);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Publisher");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(68, 302, 70, 25);
		frame.getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Quantity");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(68, 360, 70, 25);
		frame.getContentPane().add(lblNewLabel_2_1_1_1);
		
		txtbno = new JTextField();
		txtbno.setBounds(219, 151, 182, 19);
		frame.getContentPane().add(txtbno);
		txtbno.setColumns(10);
		
		txtname = new JTextField();
		txtname.setColumns(10);
		txtname.setBounds(219, 206, 182, 19);
		frame.getContentPane().add(txtname);
		
		txtauthor = new JTextField();
		txtauthor.setColumns(10);
		txtauthor.setBounds(219, 256, 182, 19);
		frame.getContentPane().add(txtauthor);
		
		txtpublisher = new JTextField();
		txtpublisher.setColumns(10);
		txtpublisher.setBounds(219, 307, 182, 19);
		frame.getContentPane().add(txtpublisher);
		
		txtquantity = new JTextField();
		txtquantity.setColumns(10);
		txtquantity.setBounds(219, 365, 182, 19);
		frame.getContentPane().add(txtquantity);
		
		JButton btnNewButton = new JButton("Add Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bookno,name,author,publisher,quantity,issuedate;
				
				bookno = txtbno.getText();
				name = txtname.getText();
				author = txtauthor.getText();		
				publisher = txtpublisher.getText();		
				quantity = txtquantity.getText();
				issuedate = txtissuedate.getText();
				
			
				
				try
				{
					pst = con.prepareStatement("insert into books(bookno,name,author,publisher,quantity,issuedate)values(?,?,?,?,?,?)");
					pst.setString(1,bookno);
					pst.setString(2,name);
					pst.setString(3,author);
					pst.setString(4,publisher);
					pst.setString(5,quantity);
					pst.setString(6,issuedate);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Book Aadded!!!");
					txtbno.setText("");
				    txtname.setText("");
					txtauthor.setText("");		
					txtpublisher.setText("");		
					txtquantity.setText("");
					txtissuedate.setText("");
					txtbno.requestFocus();	
				}	
				catch(SQLException el)	
				{
					el.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(258, 465, 109, 43);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LibrarianSection.main(new String[] {});
				frame.dispose();
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(480, 519, 117, 37);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Issue Date");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(67, 415, 109, 25);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtissuedate = new JTextField();
		txtissuedate.setColumns(10);
		txtissuedate.setBounds(219, 420, 182, 19);
		frame.getContentPane().add(txtissuedate);
	}
}
