import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Librarymanagement {

	private JFrame frame;
	protected Window frnMainPage;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Librarymanagement window = new Librarymanagement();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Librarymanagement() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 735, 597);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Admin Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			AdminLogin.main(new String[] {});
				frame.dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(276, 156, 193, 58);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnLibrarianLogin = new JButton("Librarian Login");
		btnLibrarianLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LibrarianLogin.main(new String[] {});
				frame.dispose();
				
				
				
			}
		});
		btnLibrarianLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLibrarianLogin.setBounds(276, 261, 193, 58);
		frame.getContentPane().add(btnLibrarianLogin);
		
		JLabel lblNewLabel = new JLabel("Libraray Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(143, 38, 456, 36);
		frame.getContentPane().add(lblNewLabel);
	}
}
