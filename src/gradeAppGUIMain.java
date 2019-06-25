import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;

public class gradeAppGUIMain {

	private JFrame frame;
	private JTextField textFieldAddGrade;
	private JTextField textFieldGradeA;
	private JTextField textFieldGradeC;
	private JTextField textFieldGradeB;
	private JTextField textFieldGradeD;
	private JTextField textFieldGradeF;
	private JTextField txtEnterMinimum;
	private JTextField txtEnterMaximum;
	private JTextField textFieldPercentile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gradeAppGUIMain window = new gradeAppGUIMain();
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
	public gradeAppGUIMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 250, 205));
		frame.setBounds(100, 100, 1009, 735);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnOpenFile = new JButton("Open File");
		btnOpenFile.setBackground(new Color(128, 0, 128));
		btnOpenFile.setForeground(Color.WHITE);
		btnOpenFile.setFont(new Font("Dialog", Font.BOLD, 16));
		btnOpenFile.setBounds(12, 60, 190, 45);
		frame.getContentPane().add(btnOpenFile);
		
		JButton btnSaveFile = new JButton("Save File");
		btnSaveFile.setForeground(Color.WHITE);
		btnSaveFile.setBackground(new Color(128, 0, 128));
		btnSaveFile.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSaveFile.setBounds(12, 110, 190, 45);
		frame.getContentPane().add(btnSaveFile);
		
		JButton btnAddGrade = new JButton("Add Grade");
		btnAddGrade.setBackground(new Color(128, 0, 128));
		btnAddGrade.setForeground(Color.WHITE);
		btnAddGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAddGrade.setBounds(468, 60, 180, 45);
		frame.getContentPane().add(btnAddGrade);
		
		textFieldAddGrade = new JTextField();
		textFieldAddGrade.setText("Enter Grade");
		textFieldAddGrade.setBounds(336, 61, 120, 45);
		frame.getContentPane().add(textFieldAddGrade);
		textFieldAddGrade.setColumns(10);
		
		JList listGradeList = new JList();
		listGradeList.setBackground(Color.WHITE);
		listGradeList.setBounds(663, 59, 327, 628);
		frame.getContentPane().add(listGradeList);
		
		JLabel lblGradeJList = new JLabel("Grades");
		lblGradeJList.setFont(new Font("Dialog", Font.BOLD, 16));
		lblGradeJList.setHorizontalAlignment(SwingConstants.CENTER);
		lblGradeJList.setBounds(703, 15, 90, 45);
		frame.getContentPane().add(lblGradeJList);
		
		JLabel lblLetterGrade = new JLabel("Letter Grade");
		lblLetterGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		lblLetterGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblLetterGrade.setBounds(823, 15, 130, 45);
		frame.getContentPane().add(lblLetterGrade);
		
		JButton btnRemoveGrade = new JButton("Remove Grade");
		btnRemoveGrade.setBackground(new Color(128, 0, 128));
		btnRemoveGrade.setForeground(Color.WHITE);
		btnRemoveGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		btnRemoveGrade.setBounds(468, 110, 180, 45);
		frame.getContentPane().add(btnRemoveGrade);
		
		JButton btnAmendGrade = new JButton("Amend Grade");
		btnAmendGrade.setBackground(new Color(128, 0, 128));
		btnAmendGrade.setForeground(Color.WHITE);
		btnAmendGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAmendGrade.setBounds(468, 160, 180, 45);
		frame.getContentPane().add(btnAmendGrade);
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setForeground(new Color(255, 255, 255));
		btnGenerateReport.setFont(new Font("Dialog", Font.BOLD, 16));
		btnGenerateReport.setBackground(new Color(128, 0, 128));
		btnGenerateReport.setBounds(12, 589, 639, 43);
		frame.getContentPane().add(btnGenerateReport);
		
		JLabel lblGradeScaling = new JLabel("Grade Scale");
		lblGradeScaling.setHorizontalAlignment(SwingConstants.CENTER);
		lblGradeScaling.setFont(new Font("Dialog", Font.BOLD, 16));
		lblGradeScaling.setBounds(458, 237, 190, 41);
		frame.getContentPane().add(lblGradeScaling);
		
		JLabel labelA = new JLabel("A >=");
		labelA.setFont(new Font("Dialog", Font.BOLD, 16));
		labelA.setBounds(468, 290, 50, 45);
		frame.getContentPane().add(labelA);
		
		textFieldGradeA = new JTextField();
		textFieldGradeA.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGradeA.setText("90");
		textFieldGradeA.setBackground(Color.GREEN);
		textFieldGradeA.setFont(new Font("Dialog", Font.BOLD, 18));
		textFieldGradeA.setColumns(10);
		textFieldGradeA.setBounds(528, 290, 120, 45);
		frame.getContentPane().add(textFieldGradeA);
		
		textFieldGradeC = new JTextField();
		textFieldGradeC.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGradeC.setText("70");
		textFieldGradeC.setBackground(Color.YELLOW);
		textFieldGradeC.setFont(new Font("Dialog", Font.BOLD, 18));
		textFieldGradeC.setColumns(10);
		textFieldGradeC.setBounds(528, 390, 120, 45);
		frame.getContentPane().add(textFieldGradeC);
		
		textFieldGradeB = new JTextField();
		textFieldGradeB.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGradeB.setText("80");
		textFieldGradeB.setBackground(new Color(204, 255, 51));
		textFieldGradeB.setFont(new Font("Dialog", Font.BOLD, 18));
		textFieldGradeB.setColumns(10);
		textFieldGradeB.setBounds(528, 340, 120, 45);
		frame.getContentPane().add(textFieldGradeB);
		
		textFieldGradeD = new JTextField();
		textFieldGradeD.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGradeD.setText("60");
		textFieldGradeD.setBackground(new Color(255, 102, 51));
		textFieldGradeD.setFont(new Font("Dialog", Font.BOLD, 18));
		textFieldGradeD.setColumns(10);
		textFieldGradeD.setBounds(528, 440, 120, 45);
		frame.getContentPane().add(textFieldGradeD);
		
		textFieldGradeF = new JTextField();
		textFieldGradeF.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGradeF.setText("60");
		textFieldGradeF.setBackground(Color.RED);
		textFieldGradeF.setFont(new Font("Dialog", Font.BOLD, 18));
		textFieldGradeF.setColumns(10);
		textFieldGradeF.setBounds(528, 490, 120, 45);
		frame.getContentPane().add(textFieldGradeF);
		
		JLabel labelB = new JLabel("B >=");
		labelB.setFont(new Font("Dialog", Font.BOLD, 16));
		labelB.setBounds(468, 340, 50, 45);
		frame.getContentPane().add(labelB);
		
		JLabel lblC = new JLabel("C =>");
		lblC.setFont(new Font("Dialog", Font.BOLD, 16));
		lblC.setBounds(468, 390, 50, 45);
		frame.getContentPane().add(lblC);
		
		JLabel lblD = new JLabel("D >=");
		lblD.setFont(new Font("Dialog", Font.BOLD, 16));
		lblD.setBounds(468, 440, 50, 45);
		frame.getContentPane().add(lblD);
		
		JLabel lblF = new JLabel("F   <");
		lblF.setFont(new Font("Dialog", Font.BOLD, 16));
		lblF.setBounds(468, 490, 50, 45);
		frame.getContentPane().add(lblF);
		
		JLabel labelGradeAnalytics = new JLabel("Grade Analytics");
		labelGradeAnalytics.setHorizontalAlignment(SwingConstants.CENTER);
		labelGradeAnalytics.setFont(new Font("Dialog", Font.BOLD, 16));
		labelGradeAnalytics.setBounds(12, 237, 190, 41);
		frame.getContentPane().add(labelGradeAnalytics);
		
		JLabel lblLowestGrade = new JLabel("Lowest Grade: ");
		lblLowestGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblLowestGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		lblLowestGrade.setBounds(22, 400, 190, 30);
		frame.getContentPane().add(lblLowestGrade);
		
		txtEnterMinimum = new JTextField();
		txtEnterMinimum.setText("Enter Minimum");
		txtEnterMinimum.setColumns(10);
		txtEnterMinimum.setBounds(210, 291, 120, 45);
		frame.getContentPane().add(txtEnterMinimum);
		
		txtEnterMaximum = new JTextField();
		txtEnterMaximum.setText("Enter Maximum");
		txtEnterMaximum.setColumns(10);
		txtEnterMaximum.setBounds(210, 341, 120, 45);
		frame.getContentPane().add(txtEnterMaximum);
		
		JButton buttonSetMin = new JButton("Set Min Grade");
		buttonSetMin.setForeground(Color.WHITE);
		buttonSetMin.setFont(new Font("Dialog", Font.BOLD, 16));
		buttonSetMin.setBackground(new Color(128, 0, 128));
		buttonSetMin.setBounds(12, 290, 190, 45);
		frame.getContentPane().add(buttonSetMin);
		
		JButton btnSetMaxGrade = new JButton("Set Max Grade");
		btnSetMaxGrade.setForeground(Color.WHITE);
		btnSetMaxGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSetMaxGrade.setBackground(new Color(128, 0, 128));
		btnSetMaxGrade.setBounds(12, 340, 190, 45);
		frame.getContentPane().add(btnSetMaxGrade);
		
		JLabel labelHighestGrade = new JLabel("Highest Grade: ");
		labelHighestGrade.setHorizontalAlignment(SwingConstants.CENTER);
		labelHighestGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		labelHighestGrade.setBounds(22, 430, 190, 30);
		frame.getContentPane().add(labelHighestGrade);
		
		JLabel labelMedianGrade = new JLabel("Median Grade: ");
		labelMedianGrade.setHorizontalAlignment(SwingConstants.CENTER);
		labelMedianGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		labelMedianGrade.setBounds(22, 460, 190, 30);
		frame.getContentPane().add(labelMedianGrade);
		
		JLabel labelAverageGrade = new JLabel("Average Grade: ");
		labelAverageGrade.setHorizontalAlignment(SwingConstants.CENTER);
		labelAverageGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		labelAverageGrade.setBounds(22, 490, 190, 30);
		frame.getContentPane().add(labelAverageGrade);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setBounds(211, 430, 120, 30);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Dialog", Font.BOLD, 16));
		label_1.setBounds(211, 460, 120, 30);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Dialog", Font.BOLD, 16));
		label_2.setBounds(211, 490, 120, 30);
		frame.getContentPane().add(label_2);
		
		JLabel labelLowestGradeOutput = new JLabel("");
		labelLowestGradeOutput.setHorizontalAlignment(SwingConstants.CENTER);
		labelLowestGradeOutput.setFont(new Font("Dialog", Font.BOLD, 16));
		labelLowestGradeOutput.setBounds(210, 400, 120, 30);
		frame.getContentPane().add(labelLowestGradeOutput);
		
		JLabel lblTitle = new JLabel("Grade Helper v23");
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTitle.setBounds(12, 12, 636, 36);
		frame.getContentPane().add(lblTitle);
		
		JButton buttonPercentile = new JButton("Percentile Rank");
		buttonPercentile.setForeground(Color.WHITE);
		buttonPercentile.setFont(new Font("Dialog", Font.BOLD, 16));
		buttonPercentile.setBackground(new Color(128, 0, 128));
		buttonPercentile.setBounds(12, 532, 190, 45);
		frame.getContentPane().add(buttonPercentile);
		
		textFieldPercentile = new JTextField();
		textFieldPercentile.setText("Enter Percentile");
		textFieldPercentile.setColumns(10);
		textFieldPercentile.setBounds(210, 532, 120, 45);
		frame.getContentPane().add(textFieldPercentile);
		
		JButton buttonExit = new JButton("Exit Program");
		buttonExit.setForeground(Color.WHITE);
		buttonExit.setFont(new Font("Dialog", Font.BOLD, 16));
		buttonExit.setBackground(new Color(128, 0, 128));
		buttonExit.setBounds(12, 644, 190, 45);
		frame.getContentPane().add(buttonExit);
		
		JButton buttonClearEverything = new JButton("Clear Everything");
		buttonClearEverything.setForeground(Color.WHITE);
		buttonClearEverything.setFont(new Font("Dialog", Font.BOLD, 16));
		buttonClearEverything.setBackground(new Color(128, 0, 128));
		buttonClearEverything.setBounds(458, 644, 190, 45);
		frame.getContentPane().add(buttonClearEverything);
		
		JLabel labelACount = new JLabel("0");
		labelACount.setFont(new Font("Dialog", Font.BOLD, 16));
		labelACount.setBounds(391, 290, 50, 45);
		frame.getContentPane().add(labelACount);
		
		JLabel lblGradeCount = new JLabel("Grade Count");
		lblGradeCount.setFont(new Font("Dialog", Font.BOLD, 16));
		lblGradeCount.setBounds(355, 233, 120, 45);
		frame.getContentPane().add(lblGradeCount);
		
		JLabel labelBCount = new JLabel("0");
		labelBCount.setFont(new Font("Dialog", Font.BOLD, 16));
		labelBCount.setBounds(391, 340, 50, 45);
		frame.getContentPane().add(labelBCount);
		
		JLabel labelCCount = new JLabel("0");
		labelCCount.setFont(new Font("Dialog", Font.BOLD, 16));
		labelCCount.setBounds(391, 390, 50, 45);
		frame.getContentPane().add(labelCCount);
		
		JLabel labelDCount = new JLabel("0");
		labelDCount.setFont(new Font("Dialog", Font.BOLD, 16));
		labelDCount.setBounds(391, 440, 50, 45);
		frame.getContentPane().add(labelDCount);
		
		JLabel labelFCount = new JLabel("0");
		labelFCount.setFont(new Font("Dialog", Font.BOLD, 16));
		labelFCount.setBounds(391, 490, 50, 45);
		frame.getContentPane().add(labelFCount);
	}
}
