package blooddonation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class donation {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					donation window = new donation();
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
	public donation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 527, 348);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\devi\\Pictures\\blood.jpeg"));
		lblNewLabel.setBounds(10, 0, 238, 299);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("DONOR");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				reciever rc=new reciever();
				rc.setVisible(true);
				rc.dispose();
			}
		});
		btnNewButton.setForeground(new Color(220, 20, 60));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(282, 130, 143, 39);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDonar = new JButton("RECIEVER");
		btnDonar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				donor d=new donor();
				d.setVisible(true);
				d.dispose();
			}
		});
		btnDonar.setForeground(new Color(220, 20, 60));
		btnDonar.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDonar.setBounds(282, 173, 143, 39);
		frame.getContentPane().add(btnDonar);
		
		JLabel lblNewLabel_1 = new JLabel("You are a");
		lblNewLabel_1.setFont(new Font("Script MT Bold", Font.BOLD, 16));
		lblNewLabel_1.setBounds(258, 103, 87, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("x");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_2.setForeground(new Color(178, 34, 34));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel_2.setBounds(481, 0, 46, 25);
		frame.getContentPane().add(lblNewLabel_2);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	

}
