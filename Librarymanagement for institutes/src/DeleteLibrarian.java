import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteLibrarian {

	private JFrame frame;
	private JTextField txtid;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteLibrarian window = new DeleteLibrarian();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public DeleteLibrarian() {
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
		frame.setBounds(100, 100, 892, 666);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Entet ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(103, 97, 118, 48);
		frame.getContentPane().add(lblNewLabel);
		
		txtid = new JTextField();
		txtid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try
				{
					String id = txtid.getText();
					
					pst = con.prepareStatement("select name,password,email,address,city,contactno from librarin where id = ?");
					pst.setString(1,id);
					rs = pst.executeQuery();
					
					if(rs.next() ==true)
					{
						
						String name = rs.getString(1);
						String password = rs.getString(2); 
						String email = rs.getString(3);
						String address = rs.getString(4);
						String city = rs.getString(5);
						String contactno = rs.getString(6);
						
						
					}
					
				}
				
				catch(SQLException ex)
				{
					
				}
				
			}	
				
		});
		txtid.setBounds(203, 114, 162, 19);
		frame.getContentPane().add(txtid);
		txtid.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id;
				
				id = txtid.getText();
				
				try
				{
				pst = con.prepareStatement("delete from librarian where id=?");
				pst.setString(1, id);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"Record deleted!!!");
				
				}
				
				
				catch(SQLException el)
				{
					el.printStackTrace();
				}
				
				}
				
				
	
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(246, 179, 104, 34);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminSection.main(new String[] {});
			     frame.dispose();
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(450, 283, 125, 39);
		frame.getContentPane().add(btnNewButton_1);
	}

}
