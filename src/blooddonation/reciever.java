package blooddonation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class reciever {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reciever window = new reciever();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public reciever() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 524, 349);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		
		JLabel lblNewLabel = new JLabel("DONOR PAGE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(36, 24, 178, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\devi\\Pictures\\donar.jpeg"));
		lblNewLabel_1.setBounds(262, 46, 329, 221);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setBounds(10, 86, 85, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("BLOOD GROUP");
		lblNewLabel_2_1.setBounds(10, 122, 85, 25);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("PLACE");
		lblNewLabel_2_2.setBounds(10, 155, 85, 25);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("CONTACT");
		lblNewLabel_2_3.setBounds(10, 190, 85, 25);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("EMAIL");
		lblNewLabel_2_4.setBounds(10, 226, 85, 25);
		frame.getContentPane().add(lblNewLabel_2_4);
		
		JButton btnNewButton = new JButton("DONATE");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    try {
			        insertIntoDatabase();
			    } catch (ClassNotFoundException ex) {
			        ex.printStackTrace();
			    }
			}

		});
		btnNewButton.setBounds(70, 262, 117, 37);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(101, 88, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(101, 124, 86, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(101, 158, 86, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(101, 192, 86, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(101, 223, 86, 20);
		frame.getContentPane().add(textField_4);
		
		JLabel lblNewLabel_3 = new JLabel("x");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_3.setForeground(new Color(178, 34, 34));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_3.setBounds(492, 0, 46, 25);
		frame.getContentPane().add(lblNewLabel_3);
		frame.setVisible(true);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	public void insertIntoDatabase() throws ClassNotFoundException  {
				  
        try {
        	  String name = textField.getText();
        	    String bloodGroup = textField_1.getText();
        	    String place = textField_2.getText();
        	    String contact = textField_3.getText();
        	    String email = textField_4.getText();
   		 
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","msc","msc");
        	String sql = "INSERT INTO donor (NAME, BLOOD, PLACE, CONTACT, EMAIL) VALUES (?, ?, ?, ?, ?)";
               PreparedStatement stmt = conn.prepareStatement(sql);

            // Setting the values for the parameters in the query
            stmt.setString(1, name);
            stmt.setString(2, bloodGroup);
            stmt.setString(3, place);
            stmt.setString(4, contact);
            stmt.setString(5, email);

            // Executing the query
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(frame, "Data inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Failed to insert data!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        }
    }


