import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Window.Type;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

//Created by Taylor Bart

public class PercentileTableGUI {

	private JFrame frmTableOfPercentile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PercentileTableGUI window = new PercentileTableGUI();
					window.frmTableOfPercentile.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PercentileTableGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTableOfPercentile = new JFrame();
		frmTableOfPercentile.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 16));
		frmTableOfPercentile.getContentPane().setBackground(Color.CYAN);
		frmTableOfPercentile.setTitle("Table of Percentile Ranks");
		frmTableOfPercentile.setBounds(100, 100, 817, 144);
		frmTableOfPercentile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTableOfPercentile.getContentPane().setLayout(null);
		
		JLabel lblTenthPercentile = new JLabel("10th");
		lblTenthPercentile.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTenthPercentile.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenthPercentile.setBounds(12, 13, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblTenthPercentile);
		
		JLabel lblTwentiethPercentile = new JLabel("20th");
		lblTwentiethPercentile.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTwentiethPercentile.setHorizontalAlignment(SwingConstants.CENTER);
		lblTwentiethPercentile.setBounds(99, 13, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblTwentiethPercentile);
		
		JLabel lblThirtiethPercentile = new JLabel("30th");
		lblThirtiethPercentile.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThirtiethPercentile.setHorizontalAlignment(SwingConstants.CENTER);
		lblThirtiethPercentile.setBounds(186, 13, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblThirtiethPercentile);
		
		JLabel lblFourtiethPercentile = new JLabel("40th");
		lblFourtiethPercentile.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFourtiethPercentile.setHorizontalAlignment(SwingConstants.CENTER);
		lblFourtiethPercentile.setBounds(273, 13, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblFourtiethPercentile);
		
		JLabel lblFiftiethPercentile = new JLabel("50th");
		lblFiftiethPercentile.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFiftiethPercentile.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiftiethPercentile.setBounds(360, 13, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblFiftiethPercentile);
		
		JLabel lblSixtiethPercentile = new JLabel("60th");
		lblSixtiethPercentile.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSixtiethPercentile.setHorizontalAlignment(SwingConstants.CENTER);
		lblSixtiethPercentile.setBounds(447, 13, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblSixtiethPercentile);
		
		JLabel lblSeventiethPercentile = new JLabel("70th");
		lblSeventiethPercentile.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSeventiethPercentile.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeventiethPercentile.setBounds(534, 13, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblSeventiethPercentile);
		
		JLabel lblEightiethPercentile = new JLabel("80th");
		lblEightiethPercentile.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEightiethPercentile.setHorizontalAlignment(SwingConstants.CENTER);
		lblEightiethPercentile.setBounds(621, 13, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblEightiethPercentile);
		
		JLabel lblNinetiethPercentile = new JLabel("90th");
		lblNinetiethPercentile.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNinetiethPercentile.setHorizontalAlignment(SwingConstants.CENTER);
		lblNinetiethPercentile.setBounds(708, 13, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblNinetiethPercentile);
		
		JLabel lblTenthPercentileOutput = new JLabel("10");
		lblTenthPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTenthPercentileOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenthPercentileOutput.setBounds(12, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblTenthPercentileOutput);
		
		JLabel lblTwentiethPercentileOutput = new JLabel("20");
		lblTwentiethPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTwentiethPercentileOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblTwentiethPercentileOutput.setBounds(99, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblTwentiethPercentileOutput);
		
		JLabel lblThirtiethPercentileOutput = new JLabel("30");
		lblThirtiethPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThirtiethPercentileOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblThirtiethPercentileOutput.setBounds(186, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblThirtiethPercentileOutput);
		
		JLabel lblFourtiethPercentileOutput = new JLabel("40");
		lblFourtiethPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFourtiethPercentileOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblFourtiethPercentileOutput.setBounds(273, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblFourtiethPercentileOutput);
		
		JLabel lblFiftiethPercentileOutput = new JLabel("50");
		lblFiftiethPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFiftiethPercentileOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiftiethPercentileOutput.setBounds(360, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblFiftiethPercentileOutput);
		
		JLabel lblSixtiethPercentileOutput = new JLabel("60");
		lblSixtiethPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSixtiethPercentileOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblSixtiethPercentileOutput.setBounds(447, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblSixtiethPercentileOutput);
		
		JLabel lblSeventiethPercentileOutput = new JLabel("70");
		lblSeventiethPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSeventiethPercentileOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeventiethPercentileOutput.setBounds(534, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblSeventiethPercentileOutput);
		
		JLabel lblEightiethPercentileOutput = new JLabel("80");
		lblEightiethPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEightiethPercentileOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblEightiethPercentileOutput.setBounds(621, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblEightiethPercentileOutput);
		
		JLabel lblNinetiethPercentileOutput = new JLabel("90");
		lblNinetiethPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNinetiethPercentileOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblNinetiethPercentileOutput.setBounds(708, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblNinetiethPercentileOutput);
	}
}
