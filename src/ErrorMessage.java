// Error message test file 

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;

public class ErrorMessage {

	private JFrame frmCriticalFailure;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErrorMessage window = new ErrorMessage();
					window.frmCriticalFailure.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ErrorMessage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCriticalFailure = new JFrame();
		frmCriticalFailure.setTitle("Error");
		frmCriticalFailure.setBounds(100, 100, 450, 300);
		frmCriticalFailure.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCriticalFailure.getContentPane().setLayout(null);
		
		JButton btnErrorExit = new JButton("OK");
		btnErrorExit.setFont(new Font("Dialog", Font.BOLD, 16));
		btnErrorExit.setBounds(148, 204, 152, 51);
		frmCriticalFailure.getContentPane().add(btnErrorExit);
		
		JLabel lblE1 = new JLabel("Error... Invalid file name.  Name can only contain");
		lblE1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblE1.setBounds(12, 12, 418, 33);
		frmCriticalFailure.getContentPane().add(lblE1);
		
		JLabel lblE2 = new JLabel("letters, numbers, dashes, and underscores");
		lblE2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblE2.setBounds(12, 57, 418, 33);
		frmCriticalFailure.getContentPane().add(lblE2);
		
		JLabel lblE3 = new JLabel("");
		lblE3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblE3.setBounds(12, 102, 418, 33);
		frmCriticalFailure.getContentPane().add(lblE3);
	}
}
