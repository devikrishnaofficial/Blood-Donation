package blooddonation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;

public class donor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					donor window = new donor();
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
	public donor() {
		initialize();
	}

	private void displayDetails(String bloodGroup) {
	    // JDBC variables
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        // Establish database connection
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "msc", "msc");

	        // Prepare SQL query to select details of people with the selected blood group
	        String sql = "SELECT NAME, PLACE, CONTACT, EMAIL FROM donor WHERE BLOOD = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, bloodGroup);

	        // Execute query
	        rs = pstmt.executeQuery();

	        // Prepare message to display
	        StringBuilder message = new StringBuilder();
	        message.append("<html>");

	        // Append retrieved details to message
	        while (rs.next()) {
	            String name = rs.getString("NAME");
	            String place = rs.getString("PLACE");
	            String contact = rs.getString("CONTACT");
	            String email = rs.getString("EMAIL");

	            message.append("<b>Name:</b> ").append(name).append("<br>");
	            message.append("<b>Place:</b> ").append(place).append("<br>");
	            message.append("<b>Contact:</b> ").append(contact).append("<br>");
	            message.append("<b>Email:</b> ").append(email).append("<br><br>");
	        }

	        message.append("</html>");

	        // Display message in dialog box
	        JOptionPane.showMessageDialog(frame, message.toString(), "Details for Blood Group " + bloodGroup, JOptionPane.INFORMATION_MESSAGE);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        // Close JDBC resources
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		
		JLabel lblNewLabel = new JLabel("x");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel.setForeground(new Color(139, 69, 19));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(491, 0, 46, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Required Blood Group Type");
		lblNewLabel_1.setForeground(new Color(220, 20, 60));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(58, 11, 373, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\devi\\Pictures\\receive.jpeg"));
		lblNewLabel_2.setBounds(301, 72, 210, 255);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("O+");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				displayDetails("O+");
			}
		});
		lblNewLabel_3.setForeground(new Color(178, 34, 34));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(26, 96, 102, 34);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("A+");
		lblNewLabel_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				displayDetails("A+");
			}
		});
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1.setForeground(new Color(178, 34, 34));
		lblNewLabel_3_1.setBounds(26, 150, 102, 34);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("B+");
		lblNewLabel_3_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				displayDetails("B+");
			}
		});
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_2.setForeground(new Color(178, 34, 34));
		lblNewLabel_3_2.setBounds(26, 198, 102, 34);
		frame.getContentPane().add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_4 = new JLabel("O-");
		lblNewLabel_3_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				displayDetails("O-");
			}
		});
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_4.setForeground(new Color(178, 34, 34));
		lblNewLabel_3_4.setBounds(155, 96, 102, 34);
		frame.getContentPane().add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("A-");
		lblNewLabel_3_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				displayDetails("A-");
			}
		});
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_5.setForeground(new Color(178, 34, 34));
		lblNewLabel_3_5.setBounds(155, 150, 102, 34);
		frame.getContentPane().add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_3_6 = new JLabel("B-");
		lblNewLabel_3_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				displayDetails("B-");
			}
		});
		lblNewLabel_3_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_6.setForeground(new Color(178, 34, 34));
		lblNewLabel_3_6.setBounds(155, 198, 102, 34);
		frame.getContentPane().add(lblNewLabel_3_6);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("AB+");
		lblNewLabel_3_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				displayDetails("AB+");
			}
		});
		lblNewLabel_3_1_1.setForeground(new Color(178, 34, 34));
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1_1.setBounds(26, 253, 102, 34);
		frame.getContentPane().add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("AB-");
		lblNewLabel_3_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				displayDetails("AB-");
			}
		});
		lblNewLabel_3_1_2.setForeground(new Color(178, 34, 34));
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1_2.setBounds(155, 253, 102, 34);
		frame.getContentPane().add(lblNewLabel_3_1_2);
		frame.setBounds(100, 100, 521, 338);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
