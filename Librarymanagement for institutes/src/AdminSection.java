import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminSection {

	private JFrame frame;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSection window = new AdminSection();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AdminSection() {
		initialize();

	}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 739, 598);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Section");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(270, 53, 197, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Librarian");
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				
				AddLibrarian.main(new String[] {});
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(284, 145, 149, 46);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnViewLibrarian = new JButton("View Librarian");
		btnViewLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ViewLibrarian.main(new String[] {});
				frame.dispose();
					
			}
		});
		btnViewLibrarian.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnViewLibrarian.setBounds(284, 228, 149, 46);
		frame.getContentPane().add(btnViewLibrarian);
		
		JButton btnNewButton_1_1 = new JButton("Delete Librarian");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DeleteLibrarian.main(new String[] {});
				frame.dispose();
				
				
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(284, 319, 149, 46);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Logout");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Librarymanagement.main(new String[] {});
				frame.dispose();
				
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1_1.setBounds(284, 413, 149, 46);
		frame.getContentPane().add(btnNewButton_1_1_1);
	}

}
