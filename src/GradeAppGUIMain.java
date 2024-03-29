/*	Names: Taylor Bart, Vipul Vadodaria, Benjamin Veach
 * 	Class ID: 41792
 * 	Grading Analytics System
 * 	Description: 
 * Allows a user to add grades by file or individually.
 * Allows user to save a file of the unadjusted grades.
 * Grades can be removed or amended.
 * User can set the min/max possible score.
 * Can determine the lowest, highest, median and average of the grade set.
 * Can display a window of percentiles at 10% intervals.
 * Determines count for each letter grade.
 * Rounds grades correctly.
 * Grade scales can be set by user.
 * User can exit from program at any time.
 * User can clear everything at any time.
 * Generates a thorough report based on all info pertaining to this app.
 * Displays info on grades in scrollable list.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JFileChooser;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import javax.swing.JToggleButton;

/*	This main class contains two JFrames, five JTextfields, eighteen JLabels,
 * 	three lists, ten private float variables, five private int variables, one
 * 	private string variable and twenty-four methods
 * 
 * 	<JFrame frame>
 * 	The main GUI frame
 * 
 * 	<JFrame frmTableOfPercentile>
 * 	The GUI frame for the percentile rank table
 * 
 * 	<JTextField tfGradeA>
 * 	Text field for displaying cutoff for "A" grades
 * 
 * 	<JTextField tfGradeB>
 * 	Text field for displaying cutoff for "B" grades
 * 
 * 	<JTextField tfGradeC>
 * 	Text field for displaying cutoff for "C" grades
 * 
 * 	<JTextField tfGradeD>
 * 	Text field for displaying cutoff for "D" grades
 * 
 * 	<JTextField tfGradeF>
 * 	Text field for displaying cutoff for "F" grades
 * 
 * 	<JLabel lblLowestGradeOutput>
 * 	Label for displaying lowest grade detected
 * 
 * 	<JLabel lblHighestGradeOutput>
 * 	Label for displaying highest grade detected
 * 
 * 	<JLabel lblMedianGradeOutput>
 * 	Label for displaying median grade calculated
 * 
 * 	<JLabel lblAverageGradeOutput>
 * 	Label for displaying average grade calculated
 * 
 * 	<JLabel lblACount>
 * 	Label for displaying amount of "A" grades detected
 * 
 * 	<JLabel lblBCount>
 * 	Label for displaying amount of "B" grades detected
 * 
 * 	<JLabel lblCCount>
 * 	Label for displaying amount of "C" grades detected
 * 
 * 	<JLabel lblDCount>
 * 	Label for displaying amount of "D" grades detected
 * 
 * 	<JLabel lblFCount>
 * 	Label for displaying amount of "F" grades detected
 * 
 * 	<JLabel lblTenthPercentileOutput>
 * 	Label for displaying grade cutoff for tenth percentile of grades
 * 
 * 	<JLabel lblTwentiethPercentileOutput>
 * 	Label for displaying grade cutoff for twentieth percentile of grades
 * 
 * 	<Jlabel lblThirtiethPercentileOutput>
 * 	Label for displaying grade cutoff for thirtieth percentile of grades
 * 
 * 	<JLabel lblFourtiethPercentileOutput>
 * 	Label for displaying grade cutoff for fortieth percentile of grades
 * 
 * 	<JLabel lblFiftiethPercentileOutput>
 * 	Label for displaying grade cutoff for fiftieth percentile of grades
 * 
 * 	<JLabel lblSixtiethPercentileOutput>
 * 	Label for displaying grade cutoff for sixtieth percentile of grades
 * 
 * 	<JLabel lblSeventiethPercentileOutput>
 * 	Label for displaying grade cutoff for seventieth percentile of grades
 * 
 * 	<JLabel lblEightiethPercentileOutput>
 * 	Label for displaying grade cutoff for eightieth percentile of grades
 * 
 * 	<JLabel lblNinetiethPercentileOutput>
 * 	Label for displaying grade cutoff for ninetieth percentile of grades
 * 
 * 	<DefaultListModel gradeListModel>
 * 	Used to update JList containing grades inside scrollpane
 * 
 * 	<List<Grade> grades>
 * 	List for holding a series of Grade type objects
 * 
 * 	<List<Float> tempGrades>
 * 	List for holding a series of Float type variables representing grades to 
 *  perform analysis on
 * 
 * 	<List<Float> originalGrades>
 * 	List for holding a series of Float type variables representing unanalyzed
 *  grades
 * 
 * 	<float minimumGrade>
 * 	Variable holding the minimum grade set
 * 
 * 	<float maximumGrade>
 * 	Variable holding the maximum grade set
 * 
 * 	<float lowestGrade>
 * 	Variable holding the lowest grade detected
 * 
 * 	<float highestGrade>
 * 	Variable holding the highest grade detected
 * 
 * 	<float medianGrade>
 * 	Variable holding the median grade calculated
 * 
 * 	<float averageGrade>
 * 	Variable holding the average grade calculated
 * 
 * 	<float percentA>
 * 	Variable holding the number for the grade cutoff for "A" grades
 * 
 *  <float percentB>
 *  Variable holding the number for the grade cutoff for "B" grades
 *  
 *  <float percentC>
 *  Variable holding the number for the grade cutoff for "C" grades
 *  
 *  <float percentD>
 *  Variable holding the number for the grade cutoff for "D" grades
 *  
 *  <float percentF>
 *  Variable holding the number for the grade cutoff for "F" grades
 *  
 *  <String valueType>
 *  Variable holding the percent symbol for use when displaying grade
 *   percentages
 *  
 *  <int countA>
 *  Variable holding the amount of "A" grades
 *  
 *  <int countB>
 *  Variable holding the amount of "B" grades
 *  
 *  <int countC>
 *  Variable holding the amount of "C" grades
 *  
 *  <int countD>
 *  Variable holding the amount of "D" grades
 *  
 *  <int countF>
 *  Variable holding the amount of "F" grades
 *  
 *  <main(String[] args)>
 *  The main class for running the system
 *  
 *  <run()>
 *  Runs the GUI program
 *  
 *  <GradeAppGUIMain()>
 *  Constructor to call <Initialize()>
 *  
 *  <initialize()>
 *  Initially creates the GUI with default values
 *  
 *  <mouseClicked(MouseEvent changeScale)>
 *  Method to allow click to change "A" cutoff number
 *  
 *  <mouseClicked(MouseEvent changeScale)>
 *  Method to allow click to change "B" cutoff number
 *  
 *  <mouseClicked(MouseEvent changeScale)>
 *  Method to allow click to change "C" cutoff number
 *  
 *  <mouseClicked(MouseEvent changeScale)>
 *  Method to allow click to change "D" cutoff number
 *  
 *  <mouseClicked(MouseEvent changeScale)>
 *  Method to allow click to change "F" cutoff number
 *  
 *  <actionPerformed(ActionEvent event)>
 *  Method to allow percentile table window to be closed by the 
 *  "close" button
 *  
 *  <actionPerformed(ActionEvent openFileEvent)>
 *  Method to open File Chooser via the "Open File" button to open 
 *  a file
 *  
 *  <actionPerformed(ActionEvent saveFileEvent)>
 *  Method to open File Chooser via the "Save File" button to save
 *  a file
 *  
 *  <actionPerformed(ActionEvent addGradeEvent)>
 *  Method to allow a grade to be added by clicking the "Add Grade"
 *  button
 *  
 *  <actionPerformed(ActionEvent removeGradeEvent)>
 *  Method to allow a grade to be removed by clicking the "Remove 
 *  Grade" button
 *  
 *  <actionPerformed(ActionEvent ammendGradeEvent)>
 *  Method to allow a grade to be changed by clicking the "Amend 
 *  Grade" button
 *  
 *  <actionPerformed(ActionEvent e)>
 *  Method to allow the minimum grade to be set by clicking the 
 *  "Set Min Grade" button
 *  
 *  <actionPerformed(ActionEvent e)>
 *  Method to allow the maximum grade to be set by clicking the 
 *  "Set Max Grade" button
 *  
 *  <actionPerformed(ActionEvent event)>
 *  Method to allow the percentile table to appear by clicking the 
 *  "Percentile Rank" button
 *  
 *  <actionPerformed(ActionEvent e)>
 *  Method to allow a report to be generated by clicking the "Generate
 *   Report" button
 *  
 *  <actionPerformed(ActionEvent e)>
 *  Method to allow the program to be exited by clicking the "Exit Program"
 *  button
 *  
 *  <actionPerformed(ActionEvent e)>
 *  Method to allow all input and calculated data to be reset to default values
 *  and positions by clicking the "Clear Everything" button
 *  
 *  <actionPerformed(ActionEvent e)>
 *  Method to allow grades to be converted to percentages by clicking the 
 *  "Absolute Grades" button
 *  
 *  <updateGradeData()>
 *  Copies Grade objects that fall between min and max values from 
 *  <originalGrades> to <tempGrades>, then performs analysis on Grade
 *  objects in <tempGrades>
 *  
 *  <generateReport()>
 *  Retrieves the necessary data and formats all of it into a nice looking
 *  report
 *  
 */

/**
 * Configures the grade app GUI
 * @author Taylor Bart, Vipul Vadodaria, Benjamin Veach
 * @version 100
 */
public class GradeAppGUIMain {

	/* Global Variables */
	private JFrame frame, frmTableOfPercentile;
	private JLabel lblMinGrade, lblMaxGrade;
	private JTextField tfGradeA, tfGradeB, tfGradeC, tfGradeD, tfGradeF;
	private JLabel lblLowestGradeOutput, lblHighestGradeOutput;
	private JLabel lblMedianGradeOutput, lblAverageGradeOutput;
	private JLabel lblACount, lblBCount, lblCCount;
	private JLabel lblDCount, lblFCount;
	private JLabel lblTenthPercentileOutput, lblTwentiethPercentileOutput;
	private JLabel lblThirtiethPercentileOutput;
	private JLabel lblFourtiethPercentileOutput, lblFiftiethPercentileOutput;
	private JLabel lblSixtiethPercentileOutput;
	private JLabel lblSeventiethPercentileOutput, lblEightiethPercentileOutput;
	private JLabel lblNinetiethPercentileOutput;
	private JToggleButton tglbtnAbsoluteGrade;
	DefaultListModel gradeListModel;
	
	private List<Grade> grades = new ArrayList<Grade>();
	private List<Float> tempGrades, originalGrades;

	private float minimumGrade = 0.0f, maximumGrade = Float.MAX_VALUE;
	private float lowestGrade, highestGrade, medianGrade, averageGrade;
	private float percentA = 90.0f, percentB = 80.0f;
	private float percentC = 70.0f, percentD = 60.0f;
	
	private String valueType = "%";

	private int countA = 0;
	private int countB = 0;
	private int countC = 0;
	private int countD = 0;
	private int countF = 0;
	
	/*
	 * ########################################################################
	 * Launch the application.
	 * ########################################################################
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GradeAppGUIMain window = new GradeAppGUIMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * ########################################################################
	 * Create the application.
	 * ########################################################################
	 */
	/**
	 * Calls the initialize() function for the grade app GUI
	 */
	public GradeAppGUIMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(255, 250, 205));
		frame.setBounds(100, 100, 1009, 735);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tfGradeA = new JTextField();
		tfGradeA.setToolTipText("Click to set the requirement for an A");
		tfGradeA.setEditable(false);
		tfGradeA.setHorizontalAlignment(SwingConstants.CENTER);
		tfGradeA.setText(Float.toString(percentA) + valueType);
		tfGradeA.setBackground(Color.GREEN);
		tfGradeA.setFont(new Font("Dialog", Font.BOLD, 18));
		tfGradeA.setColumns(10);
		tfGradeA.setBounds(528, 290, 120, 45);
		frame.getContentPane().add(tfGradeA);
		
		tfGradeA.addMouseListener(new MouseAdapter() {
			@Override
			
			/*	Method: mouseClicked(MouseEvent changeScale)
			 * 	Description: 	Allows a click of the mouse on the "A"
			 * 					grade cutoff number to create a pop-up
			 * 					in order to change the cutoff number. 
			 */
			public void mouseClicked(MouseEvent changeScale) {
				JFrame frame = new JFrame("Grade Scale");
				String gradePercentage = 
					JOptionPane.showInputDialog(frame, "Enter Grade for "
							+ "\"A\": ");
				try {
					float tempPercentA = Float.parseFloat(gradePercentage);
					if (tempPercentA <= percentB) {
						JOptionPane.showMessageDialog(frame, "Percentage "
								+ "for an \"A\" cannot be less than or "
								+ "equal to the percentage for a \"B\"");
					}
					else {
						percentA = tempPercentA;
						tfGradeA.setText(String.format("%.1f", percentA)
								+ valueType);
						updateGradeData();
					}
				}
				catch(NumberFormatException error) {
					JOptionPane.showMessageDialog(null, "Error! "
							+ "Must enter a number");
					System.err.println("NumberFormatException: "
							+ error.getMessage());
				}
				catch(NullPointerException error ) {
					/* Do nothing - catches textField edit cancel */
				}
			}
		});
		
		tfGradeB = new JTextField();
		tfGradeB.setToolTipText("Click to set the requirement for a B");
		tfGradeB.setEditable(false);
		tfGradeB.setHorizontalAlignment(SwingConstants.CENTER);
		tfGradeB.setText(Float.toString(percentB) + valueType);
		tfGradeB.setBackground(new Color(204, 255, 51));
		tfGradeB.setFont(new Font("Dialog", Font.BOLD, 18));
		tfGradeB.setColumns(10);
		tfGradeB.setBounds(528, 340, 120, 45);
		frame.getContentPane().add(tfGradeB);
		
		tfGradeB.addMouseListener(new MouseAdapter() {
			@Override
			
			/*	Method: mouseClicked(MouseEvent changeScale)
			 * 	Description: 	Allows a click of the mouse on the "B"
			 * 					grade cutoff number to create a pop-up
			 * 					in order to change the cutoff number. 
			 */
			public void mouseClicked(MouseEvent changeScale) {
				JFrame frame = new JFrame("Grade Scale");
				String gradePercentage = 
					JOptionPane.showInputDialog(frame, "Enter Grade for "
							+ "\"B\": ");
				try {
					float tempPercentB = Float.parseFloat(gradePercentage);
					if (tempPercentB <= percentC) {
						JOptionPane.showMessageDialog(frame, "Percentage "
								+ "for \"B\" cannot be less than or equal "
								+ " to the percentage for a \"C\"");
					}
					else if (tempPercentB >= percentA) {
						JOptionPane.showMessageDialog(frame, "Percentage "
								+ "for \"B\" cannot be greater than or "
								+ "equal to the percentage for an \"A\""
								+ "");
					}
					else {
						percentB = tempPercentB;
						tfGradeB.setText(String.format("%.1f", percentB) 
								+ valueType);
						updateGradeData();
					}
				}
				catch(NumberFormatException error) {
					JOptionPane.showMessageDialog(null, "Error! "
							+ "Must enter a number");
					System.err.println("NumberFormatException: "
							+ error.getMessage());
				}
				catch(NullPointerException error ) {
					/* Do nothing - catches textField edit cancel */
				}
			}
		});
		
		tfGradeC = new JTextField();
		tfGradeC.setToolTipText("Click to set the requirement for a C");
		tfGradeC.setEditable(false);
		tfGradeC.setHorizontalAlignment(SwingConstants.CENTER);
		tfGradeC.setText(Float.toString(percentC) + valueType);
		tfGradeC.setBackground(Color.YELLOW);
		tfGradeC.setFont(new Font("Dialog", Font.BOLD, 18));
		tfGradeC.setColumns(10);
		tfGradeC.setBounds(528, 390, 120, 45);
		frame.getContentPane().add(tfGradeC);
		
		tfGradeC.addMouseListener(new MouseAdapter() {
			@Override
			
			/**	Method: mouseClicked(MouseEvent changeScale)
			 * 	Description: 	Allows a click of the mouse on the "C"
			 * 					grade cutoff number to create a pop-up
			 * 					in order to change the cutoff number. 
			 */
			public void mouseClicked(MouseEvent changeScale) {
				JFrame frame = new JFrame("Grade Scale");
				String gradePercentage = 
					JOptionPane.showInputDialog(frame, "Enter Grade for "
							+ "\"C\": ");
				try {
					float tempPercentC = Float.parseFloat(gradePercentage);
					if (tempPercentC <= percentD) {
						JOptionPane.showMessageDialog(frame, "Percentage "
								+ "for \"C\" cannot be less than or equal "
								+ " to the percentage for a \"D\"");
				}
					else if (tempPercentC >= percentB) {
						JOptionPane.showMessageDialog(frame, "Percentage "
								+ "for \"C\" cannot be greater than or "
								+ "equal to the percentage for an \"B\""
								+ "");
					}
					else {
						percentC = tempPercentC;
						tfGradeC.setText(String.format("%.1f", percentC) 
								+ valueType);
						updateGradeData();
					}
				}
				catch(NumberFormatException error) {
					JOptionPane.showMessageDialog(null, "Error! "
							+ "Must enter a number");
					System.err.println("NumberFormatException: "
							+ error.getMessage());
				}
				catch(NullPointerException error ) {
					/* Do nothing - catches textField edit cancel */
				}
			}
		});

		tfGradeD = new JTextField();
		tfGradeD.setToolTipText("Click to set the requirement for a D");
		tfGradeD.setEditable(false);
		tfGradeD.setHorizontalAlignment(SwingConstants.CENTER);
		tfGradeD.setText(Float.toString(percentD) + valueType);
		tfGradeD.setBackground(new Color(255, 102, 51));
		tfGradeD.setFont(new Font("Dialog", Font.BOLD, 18));
		tfGradeD.setColumns(10);
		tfGradeD.setBounds(528, 440, 120, 45);
		frame.getContentPane().add(tfGradeD);
		
		tfGradeD.addMouseListener(new MouseAdapter() {
			@Override
			
			/*	Method: mouseClicked(MouseEvent changeScale)
			 * 	Description: 	Allows a click of the mouse on the "D"
			 * 					grade cutoff number to create a pop-up
			 * 					in order to change the cutoff number. 
			 */
			public void mouseClicked(MouseEvent changeScale) {
				JFrame frame = new JFrame("Grade Scale");
				String gradePercentage = 
					JOptionPane.showInputDialog(frame, "Enter Grade for "
							+ "\"D\": ");
				try {
					float tempPercentD = Float.parseFloat(gradePercentage);
					if (tempPercentD >= percentC) {
						JOptionPane.showMessageDialog(frame, "Percentage "
								+ "for \"D\" cannot be greater than or "
								+ "equal to the percentage for an \"C\""
								+ "");
					}
					else if (tempPercentD < 0) {
						JOptionPane.showMessageDialog(frame, "Percentage "
								+ "for \"D\" cannot be a negative "
								+ "value.");
					}
					else {
						percentD = tempPercentD;
						tfGradeD.setText(String.format("%.1f", percentD) 
								+ valueType);
						tfGradeF.setText(String.format("%.1f", 
								(percentD)) + valueType);
						updateGradeData();
					}
				}
				catch(NumberFormatException error) {
					JOptionPane.showMessageDialog(null, "Error! "
							+ "Must enter a number");
					System.err.println("NumberFormatException: "
							+ error.getMessage());
				}
				catch(NullPointerException error ) {
					/* Do nothing - catches textField edit cancel */
				}
			}
		});
		
		tfGradeF = new JTextField();
		tfGradeF.setEditable(false);
		tfGradeF.setHorizontalAlignment(SwingConstants.CENTER);
		tfGradeF.setText(Float.toString(percentD) + valueType);
		tfGradeF.setBackground(Color.RED);
		tfGradeF.setFont(new Font("Dialog", Font.BOLD, 18));
		tfGradeF.setColumns(10);
		tfGradeF.setBounds(528, 490, 120, 45);
		frame.getContentPane().add(tfGradeF);
		
		tfGradeF.addMouseListener(new MouseAdapter() {
			@Override
			
			/*	Method: mouseClicked(MouseEvent changeScale)
			 * 	Description: 	Allows a click of the mouse on the "F"
			 * 					grade cutoff number to create a pop-up
			 * 					in order to change the cutoff number. 
			 */
			public void mouseClicked(MouseEvent changeScale) {
				JOptionPane.showMessageDialog(frame, "Anything less than a "
						+ "\"D\" is an \"F\"");
			}
		});
				
		
	/*
	 * ########################################################################
	 * JLabel Group
	 * ########################################################################
	 */
		
		frmTableOfPercentile = new JFrame();
		frmTableOfPercentile.getContentPane().setFont(new Font("Tahoma", 
				Font.BOLD, 16));
		frmTableOfPercentile.getContentPane().setBackground(new Color(255,
				250, 205));
		frmTableOfPercentile.setTitle("Table of Percentile Ranks");
		frmTableOfPercentile.setBounds(100, 100, 817, 210);
		frmTableOfPercentile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTableOfPercentile.getContentPane().setLayout(null);
		frmTableOfPercentile.setVisible(false);
		
		
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
		
		lblTenthPercentileOutput = new JLabel("0");
		lblTenthPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTenthPercentileOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenthPercentileOutput.setBounds(12, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblTenthPercentileOutput);
		
		lblTwentiethPercentileOutput = new JLabel("0");
		lblTwentiethPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTwentiethPercentileOutput.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblTwentiethPercentileOutput.setBounds(99, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblTwentiethPercentileOutput);
		
		lblThirtiethPercentileOutput = new JLabel("0");
		lblThirtiethPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThirtiethPercentileOutput.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblThirtiethPercentileOutput.setBounds(186, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblThirtiethPercentileOutput);
		
		lblFourtiethPercentileOutput = new JLabel("0");
		lblFourtiethPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFourtiethPercentileOutput.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblFourtiethPercentileOutput.setBounds(273, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblFourtiethPercentileOutput);
		
		lblFiftiethPercentileOutput = new JLabel("0");
		lblFiftiethPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFiftiethPercentileOutput.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblFiftiethPercentileOutput.setBounds(360, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblFiftiethPercentileOutput);
		
		lblSixtiethPercentileOutput = new JLabel("0");
		lblSixtiethPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSixtiethPercentileOutput.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblSixtiethPercentileOutput.setBounds(447, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblSixtiethPercentileOutput);
		
		lblSeventiethPercentileOutput = new JLabel("0");
		lblSeventiethPercentileOutput.setFont(new Font(
				"Tahoma", Font.BOLD, 16));
		lblSeventiethPercentileOutput.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblSeventiethPercentileOutput.setBounds(534, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(
				lblSeventiethPercentileOutput);
		
		lblEightiethPercentileOutput = new JLabel("0");
		lblEightiethPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEightiethPercentileOutput.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblEightiethPercentileOutput.setBounds(621, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblEightiethPercentileOutput);
		
		lblNinetiethPercentileOutput = new JLabel("0");
		lblNinetiethPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNinetiethPercentileOutput.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblNinetiethPercentileOutput.setBounds(708, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblNinetiethPercentileOutput);
		
		JButton btnClose = new JButton("Close");
		btnClose.setForeground(new Color(255, 255, 255));
		btnClose.setFont(new Font("Dialog", Font.BOLD, 18));
		btnClose.setBackground(new Color(139, 0, 139));
		btnClose.setBounds(99, 110, 597, 50);
		frmTableOfPercentile.getContentPane().add(btnClose);
		
		btnClose.addActionListener(new ActionListener() {
			
			/*	Method name: actionPerformed(ActionEvent event)
			 * 	Description:	Allows a click of the mouse on the "Close"
			 * 					button to close the Percentile Rank Table window
			 */
			public void actionPerformed(ActionEvent event) {
				frmTableOfPercentile.setVisible(false);
			}	
		});
		
		JLabel lblJScroll = new JLabel("Grade     Adjusted     Letter Grade");
		lblJScroll.setFont(new Font("Dialog", Font.BOLD, 16));
		lblJScroll.setHorizontalAlignment(SwingConstants.CENTER);
		lblJScroll.setBounds(661, 9, 330, 45);
		frame.getContentPane().add(lblJScroll);
		
		JLabel lblTitle = new JLabel("Grade Helper v23");
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTitle.setBounds(12, 12, 636, 36);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblGradeScaling = new JLabel("Grade Scale");
		lblGradeScaling.setHorizontalAlignment(SwingConstants.CENTER);
		lblGradeScaling.setFont(new Font("Dialog", Font.BOLD, 16));
		lblGradeScaling.setBounds(458, 237, 190, 41);
		frame.getContentPane().add(lblGradeScaling);
		
		JLabel lblA = new JLabel("A >=");
		lblA.setFont(new Font("Dialog", Font.BOLD, 16));
		lblA.setBounds(468, 290, 50, 45);
		frame.getContentPane().add(lblA);
		
		JLabel lblB = new JLabel("B >=");
		lblB.setFont(new Font("Dialog", Font.BOLD, 16));
		lblB.setBounds(468, 340, 50, 45);
		frame.getContentPane().add(lblB);
		
		JLabel lblC = new JLabel("C >=");
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
			
		JLabel lblGradeAnalytics = new JLabel("Grade Analytics");
		lblGradeAnalytics.setHorizontalAlignment(SwingConstants.CENTER);
		lblGradeAnalytics.setFont(new Font("Dialog", Font.BOLD, 16));
		lblGradeAnalytics.setBounds(12, 237, 190, 41);
		frame.getContentPane().add(lblGradeAnalytics);
		
		JLabel lblLowestGrade = new JLabel("Lowest Grade: ");
		lblLowestGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblLowestGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		lblLowestGrade.setBounds(22, 400, 190, 30);
		frame.getContentPane().add(lblLowestGrade);
		
		JLabel lblHighestGrade = new JLabel("Highest Grade: ");
		lblHighestGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblHighestGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		lblHighestGrade.setBounds(22, 430, 190, 30);
		frame.getContentPane().add(lblHighestGrade);
		
		JLabel lblMedianGrade = new JLabel("Median Grade: ");
		lblMedianGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedianGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMedianGrade.setBounds(22, 460, 190, 30);
		frame.getContentPane().add(lblMedianGrade);
		
		JLabel lblAverageGrade = new JLabel("Average Grade: ");
		lblAverageGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblAverageGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAverageGrade.setBounds(22, 490, 190, 30);
		frame.getContentPane().add(lblAverageGrade);
		
		lblLowestGradeOutput = new JLabel("");
		lblLowestGradeOutput.setHorizontalAlignment(SwingConstants.LEFT);
		lblLowestGradeOutput.setFont(new Font("Dialog", Font.BOLD, 16));
		lblLowestGradeOutput.setBounds(210, 400, 120, 30);
		frame.getContentPane().add(lblLowestGradeOutput);
		
		lblHighestGradeOutput = new JLabel("");
		lblHighestGradeOutput.setHorizontalAlignment(SwingConstants.LEFT);
		lblHighestGradeOutput.setFont(new Font("Dialog", Font.BOLD, 16));
		lblHighestGradeOutput.setBounds(211, 430, 120, 30);
		frame.getContentPane().add(lblHighestGradeOutput);
		
		lblMedianGradeOutput = new JLabel("");
		lblMedianGradeOutput.setHorizontalAlignment(SwingConstants.LEFT);
		lblMedianGradeOutput.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMedianGradeOutput.setBounds(211, 460, 120, 30);
		frame.getContentPane().add(lblMedianGradeOutput);
		
		lblAverageGradeOutput = new JLabel("");
		lblAverageGradeOutput.setHorizontalAlignment(SwingConstants.LEFT);
		lblAverageGradeOutput.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAverageGradeOutput.setBounds(211, 490, 120, 30);
		frame.getContentPane().add(lblAverageGradeOutput);
		
		JLabel lblGradeCount = new JLabel("Grade Count");
		lblGradeCount.setFont(new Font("Dialog", Font.BOLD, 16));
		lblGradeCount.setBounds(355, 233, 120, 45);
		frame.getContentPane().add(lblGradeCount);
		
		lblACount = new JLabel("0");
		lblACount.setFont(new Font("Dialog", Font.BOLD, 16));
		lblACount.setBounds(391, 290, 50, 45);
		frame.getContentPane().add(lblACount);

		lblBCount = new JLabel("0");
		lblBCount.setFont(new Font("Dialog", Font.BOLD, 16));
		lblBCount.setBounds(391, 340, 50, 45);
		frame.getContentPane().add(lblBCount);
		
		lblCCount = new JLabel("0");
		lblCCount.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCCount.setBounds(391, 390, 50, 45);
		frame.getContentPane().add(lblCCount);
		
		lblDCount = new JLabel("0");
		lblDCount.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDCount.setBounds(391, 440, 50, 45);
		frame.getContentPane().add(lblDCount);
		
		lblFCount = new JLabel("0");
		lblFCount.setFont(new Font("Dialog", Font.BOLD, 16));
		lblFCount.setBounds(391, 490, 50, 45);
		frame.getContentPane().add(lblFCount);
		
		lblMinGrade = new JLabel(Float.toString(minimumGrade) + valueType);
		lblMinGrade.setHorizontalAlignment(SwingConstants.LEFT);
		lblMinGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMinGrade.setBounds(210, 290, 120, 45);
		frame.getContentPane().add(lblMinGrade);
		
		lblMaxGrade = new JLabel("N/A");
		lblMaxGrade.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaxGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMaxGrade.setBounds(210, 340, 120, 45);
		frame.getContentPane().add(lblMaxGrade);
		
		/*
		 * List
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(660, 60, 331, 627);
		frame.getContentPane().add(scrollPane);
		gradeListModel = new DefaultListModel<>();
		JList gradeList = new JList(gradeListModel);
		gradeList.setFont(new Font("Tahoma", Font.BOLD, 16));
		gradeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(gradeList);
		
		
	/*
	 * ########################################################################
	 * Buttons Group
	 * ########################################################################
	 */
		JButton btnOpenFile = new JButton("Open File");
		btnOpenFile.setToolTipText("Select .txt file to load grades from");
		btnOpenFile.setBackground(new Color(128, 0, 128));
		btnOpenFile.setForeground(Color.WHITE);
		btnOpenFile.setFont(new Font("Dialog", Font.BOLD, 16));
		btnOpenFile.setBounds(12, 60, 190, 45);
		frame.getContentPane().add(btnOpenFile);
		
		btnOpenFile.addActionListener(new ActionListener() {
			@Override
			
			/*	Method name: actionPerformed(ActionEvent openFileEvent)
			 * 	Description: 	Allows a click of the mouse on the "Open File"
			 * 					button to open the Java File Chooser
			 */
			public void actionPerformed(ActionEvent openFileEvent) {
				JFileChooser chooser = new JFileChooser();
			    int returnVal = chooser.showOpenDialog(null);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	JOptionPane.showMessageDialog(null, 
			    			"You chose to open this file: " +
			            chooser.getSelectedFile().getName());
			    }
			    File fileName = chooser.getSelectedFile();
				String line = null;
				String letterGrade = "A";
				float gradeInput;
				if(GradeAppGUIMain.this.grades == null) {
					GradeAppGUIMain.this.grades = new ArrayList<Grade>();
				}
				try {
					FileReader fileReader = new FileReader(fileName);
					BufferedReader bufferedReader = 
							new BufferedReader(fileReader);
					while( ( line = bufferedReader.readLine() ) != null) {
						gradeInput = Float.parseFloat(line);
						Grade newGrade = new Grade(gradeInput,letterGrade);
						GradeAppGUIMain.this.grades.add(newGrade);
						/* gradeListModel.addElement(newGrade.toString()); */
						gradeList.clearSelection();
					}
					bufferedReader.close();
					updateGradeData();
				}
				catch(FileNotFoundException fileException) {
					JOptionPane.showMessageDialog(null, "Error! File " 
							+ fileName + " not found.");
					System.err.println("FileNotFoundException: " 
							+ fileException.getMessage());
				}
				catch(IOException IOException) {
					JOptionPane.showMessageDialog(null, "Error! File" 
							+ fileName + "contains unreadable characters.");
					System.err.println("IOException: " 
							+ IOException.getMessage());
				}
				catch(NumberFormatException numberFormatException) {
					JOptionPane.showMessageDialog(null, "Error! File" 
							+ fileName + " has incorrect formatting.");
					 System.err.println("NumberFormatException: " 
							+ numberFormatException.getMessage());
				}
				catch(NullPointerException incorrectAddEvent) {
					/* Do Nothing but catch canceled open files */
				}
			}
		});
		
		
		JButton btnSaveFile = new JButton("Save File");
		btnSaveFile.setToolTipText("Save grade data to .txt file");
		btnSaveFile.setForeground(Color.WHITE);
		btnSaveFile.setBackground(new Color(128, 0, 128));
		btnSaveFile.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSaveFile.setBounds(12, 110, 190, 45);
		frame.getContentPane().add(btnSaveFile);
		
		btnSaveFile.addActionListener(new ActionListener() {
			@Override
			
			/*	Method name: actionPerformed(ActionEvent saveFileEvent)
			 * 	Description: 	Allows a click of the mouse on the "Save File"
			 * 					button to open the Java File Chooser
			 */
			public void actionPerformed(ActionEvent saveFileEvent) {
				JFileChooser chooser = new JFileChooser();
			    int returnVal = chooser.showSaveDialog(null);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	JOptionPane.showMessageDialog(null, 
			    			"Attempting to save " +
			            chooser.getSelectedFile().getName());
			    }
			    String fileName = null;
			    try {
			    File file = chooser.getSelectedFile();
			    fileName = file.getAbsolutePath();
					if (!file.exists()) {
						file.createNewFile();
					}
					FileWriter fileWriter =
							new FileWriter(fileName);
					BufferedWriter bufferedWriter =
							new BufferedWriter(fileWriter);
					for(Grade gradeInput : GradeAppGUIMain.this.grades) {
						String formattedGradeInput
							= Float.toString(gradeInput.getGrade());
						bufferedWriter.write(formattedGradeInput);
						bufferedWriter.newLine();
					}
					bufferedWriter.close();
				}
				catch(FileNotFoundException fileException) {
					JOptionPane.showMessageDialog(null, "Error! File " 
							+ fileName + " not found.");
					 System.err.println("FileNotFoundException: " 
							+ fileException.getMessage());
				}
				catch(IOException IOException) {
					JOptionPane.showMessageDialog(null, "Error! File" 
							+ fileName + "contains unreadable characters.");
					 System.err.println("IOException: " 
							+ IOException.getMessage());
				}
				catch(IllegalArgumentException argumentException)
				{
					JOptionPane.showMessageDialog(null, "Error! File "
							+ fileName + "contains invalid characters.");
					System.err.println("ArgumentException: "
							+ argumentException.getMessage());
				}
				catch(NullPointerException incorrectAddEvent) {
					/* Do Nothing but catch canceled save file */
				}
			}
		});
		
		JButton btnAddGrade = new JButton("Add Grade");
		btnAddGrade.setBackground(new Color(128, 0, 128));
		btnAddGrade.setForeground(Color.WHITE);
		btnAddGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAddGrade.setBounds(468, 60, 180, 45);
		frame.getContentPane().add(btnAddGrade);
		
		btnAddGrade.addActionListener(new ActionListener() {
			@Override
			
			/*	Method name: actionPerformed(ActionEvent addGradeEvent)
			 * 	Description: 	Allows a click of the mouse on the "Add Grade"
			 * 					button to open a pop-up to add a grade value
			 */
			public void actionPerformed(ActionEvent addGradeEvent) {
				try {
					JFrame frame = new JFrame("Add Grade");
					String addedGrade 
						= JOptionPane.showInputDialog(frame, "Enter grade: ");
					String letterGradeInput = "A";
					float gradeInput = Float.parseFloat(addedGrade);
					if (gradeInput < 0)
					{
						JOptionPane.showMessageDialog(null, "Cannot enter "
								+ "negative grades.");
					}
					else
					{
						Grade newGrade = new Grade(gradeInput,letterGradeInput);
						gradeListModel.addElement(newGrade.toString());
						GradeAppGUIMain.this.grades.add(newGrade);
						gradeList.clearSelection();
						updateGradeData();
					}
					if (GradeAppGUIMain.this.grades == null) {
						GradeAppGUIMain.this.grades = new ArrayList<Grade>();
					}
					
				}
				catch(NumberFormatException incorrectAddEvent) {
					JOptionPane.showMessageDialog(null, "Incorrect input,"
							+ " value not added");
					 System.err.println("NumberFormatException: " 
							+ incorrectAddEvent.getMessage());
				}
				catch(NullPointerException incorrectAddEvent) {
					
				}
				gradeList.clearSelection();
			}
		});
		
		JButton btnRemoveGrade = new JButton("Remove Grade");
		btnRemoveGrade.setBackground(new Color(128, 0, 128));
		btnRemoveGrade.setForeground(Color.WHITE);
		btnRemoveGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		btnRemoveGrade.setBounds(468, 110, 180, 45);
		frame.getContentPane().add(btnRemoveGrade);
		
		btnRemoveGrade.addActionListener(new ActionListener() {
			@Override
			
			/*	Method name: actionPerformed(ActionEvent removeGradeEvent)
			 * 	Description:	Allows a click of the mouse on the "Remove 
			 * 					Grade" button to remove the grade selected on
			 * 					the scroll pane
			 */
			public void actionPerformed(ActionEvent removeGradeEvent) {
				try {
					if(!GradeAppGUIMain.this.grades.isEmpty()) {
						GradeAppGUIMain.this.grades.remove(
								gradeList.getSelectedIndex());
						gradeListModel.remove(
								gradeList.getSelectedIndex());
						gradeList.clearSelection();
						updateGradeData();
					}
				}
				catch(IndexOutOfBoundsException incorrectSelectionEvent) {
					JOptionPane.showMessageDialog(null, "Make a selection on "
							+ "the list");
					 System.err.println("IOException: " 
							+ incorrectSelectionEvent.getMessage());
				}
			}
		});
		
		
		JButton btnAmendGrade = new JButton("Amend Grade");
		btnAmendGrade.setBackground(new Color(128, 0, 128));
		btnAmendGrade.setForeground(Color.WHITE);
		btnAmendGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAmendGrade.setBounds(468, 160, 180, 45);
		frame.getContentPane().add(btnAmendGrade);
		
		btnAmendGrade.addActionListener(new ActionListener() {
			@Override
			
			/*	Method name: actionPerformed(ActionEvent ammendGradeEvent)
			 * 	Description:	Allows a click of the mouse on the "Amend Grade"
			 * 					button to amend the grade selected on the 
			 * 					scroll pane
			 */
			public void actionPerformed(ActionEvent ammendGradeEvent) {
				try {
					JFrame frame = new JFrame("Amend Grade");
					String ammendedGrade 
						= JOptionPane.showInputDialog(frame, "Change grade: ");
					float gradeInput = Float.parseFloat(ammendedGrade);
					String letterGradeInput = "A";
					Grade newGrade = new Grade(gradeInput,letterGradeInput);
					gradeListModel.setElementAt(newGrade,
							gradeList.getSelectedIndex());
					GradeAppGUIMain.this.grades.set(
							gradeList.getSelectedIndex(), newGrade);
					gradeList.clearSelection();
					updateGradeData();
					}
				
				catch(IndexOutOfBoundsException incorrectSelectionEvent) {
					JOptionPane.showMessageDialog(null, "Make a selection on "
							+ "the list");
					 System.err.println("IOException: " 
							+ incorrectSelectionEvent.getMessage());
				}
				catch(NumberFormatException incorrectInputEvent) {
					JOptionPane.showMessageDialog(null, 
							"Error! Must enter a number");
					System.err.println("NumberFormatException: " 
							+ incorrectInputEvent.getMessage());
				}
				catch(NullPointerException error) {
					/* Do nothing - catches amend grade cancel */
				}
			}
		});
		
		JButton buttonSetMinGrade = new JButton("Set Min Grade");
		buttonSetMinGrade.setForeground(Color.WHITE);
		buttonSetMinGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		buttonSetMinGrade.setBackground(new Color(128, 0, 128));
		buttonSetMinGrade.setBounds(12, 290, 190, 45);
		frame.getContentPane().add(buttonSetMinGrade);
		
		buttonSetMinGrade.addActionListener(new ActionListener() {
			@Override
			
			/*	Method name: actionPerformed(ActionEvent e)
			 * 	Description:	Allows a click of the mouse on the "Set 
			 * 					Min Grade" to open a pop-up to change the set
			 * 					minimum grade
			 */
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Set Minimum Grade");
				String minGradeInput = JOptionPane.showInputDialog(frame,
					"Enter minimum possible grade: ");
				try {
					float newMinGrade = Float.parseFloat(minGradeInput);
					if 
					(newMinGrade > maximumGrade) {
						JOptionPane.showMessageDialog(null, "Minimum Grade "
								+ "cannot be greater than Maximum Grade. "
								+ "Minimum Grade not changed!");
					}
					else if (newMinGrade < 0) {
						JOptionPane.showMessageDialog(
								null, "Minimum Grade cannot be less than 0");
					}
					else {
						minimumGrade = newMinGrade;
						lblMinGrade.setText(Float.toString(minimumGrade) 
								+ valueType);
						updateGradeData();
					}
				}
				catch(NumberFormatException error) {
					JOptionPane.showMessageDialog(null, 
							"Error! Must enter a number");
						System.err.println("NumberFormatException: " 
						+ error.getMessage());
				}
				catch(NullPointerException error) {
					/* Do nothing - catches amend grade cancel */
				}
			}
		});
		
		JButton btnSetMaxGrade = new JButton("Set Max Grade");
		btnSetMaxGrade.setForeground(Color.WHITE);
		btnSetMaxGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSetMaxGrade.setBackground(new Color(128, 0, 128));
		btnSetMaxGrade.setBounds(12, 340, 190, 45);
		frame.getContentPane().add(btnSetMaxGrade);
		
		btnSetMaxGrade.addActionListener(new ActionListener() {
			@Override
			
			/*	Method name: actionPerformed(ActionEvent e)
			 * 	Description:	Allows a click of the mouse on the "Set Max 
			 * 					Grade" button to open a pop-up to change the set
			 * 					max grade
			 */
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Set Maximum Grade");
				String maxGradeInput = JOptionPane.showInputDialog(frame,
					"Enter maximum possible grade: ");
				try {
					float newMaxGrade = Float.parseFloat(maxGradeInput);
					if 
					(newMaxGrade < minimumGrade) {
						JOptionPane.showMessageDialog(null, "Maximum Grade "
								+ "cannot be greater than Minimum Grade. "
								+ "Maximum Grade not changed!");
					}
					else {
						maximumGrade = newMaxGrade;
						lblMaxGrade.setText(Float.toString(maximumGrade) 
								+ valueType);
						updateGradeData();
					}
					
				}
				catch(NumberFormatException error) {
					JOptionPane.showMessageDialog(null, 
							"Error! Must enter a number");
						System.err.println("NumberFormatException: " 
						+ error.getMessage());
				}
				catch(NullPointerException error) {
					/* Do nothing - catches amend grade cancel */
				}
			}
		});
		
		JButton btnPercentile = new JButton("Percentile Rank");
		btnPercentile.setForeground(Color.WHITE);
		btnPercentile.setFont(new Font("Dialog", Font.BOLD, 16));
		btnPercentile.setBackground(new Color(128, 0, 128));
		btnPercentile.setBounds(12, 532, 190, 45);
		frame.getContentPane().add(btnPercentile);
		
		btnPercentile.addActionListener(new ActionListener() {
			
			/*	Method name: actionPerformed(ActionEvent event)
			 * 	Description:	Allows a click of the mouse on the "Percentile 
			 * 					Rank" button to have the Percentile Rank Window
			 * 					appear
			 */
			public void actionPerformed(ActionEvent event) {
				frmTableOfPercentile.setVisible(true);
			}
		});
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setForeground(new Color(255, 255, 255));
		btnGenerateReport.setFont(new Font("Dialog", Font.BOLD, 16));
		btnGenerateReport.setBackground(new Color(128, 0, 128));
		btnGenerateReport.setBounds(12, 589, 636, 43);
		frame.getContentPane().add(btnGenerateReport);
		
		btnGenerateReport.addActionListener(new ActionListener() {
			
			/*	Method name: actionPerformed(ActionEvent e)
			 * 	Description:	Allows a click of the mouse on the "Generate 
			 * 					Report" button to open the Java File Chooser to
			 * 					save the report file to a user designated
			 * 					location
			 */
			public void actionPerformed(ActionEvent e) {
				try {
					generateReport();
				}
				catch(NullPointerException error ) {
					/* Do nothing - catches textField edit cancel */
				}
			}
		});
		
		JButton btnExit = new JButton("Exit Program");
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Dialog", Font.BOLD, 16));
		btnExit.setBackground(new Color(128, 0, 128));
		btnExit.setBounds(12, 644, 190, 45);
		frame.getContentPane().add(btnExit);
		
		btnExit.addActionListener(new ActionListener() {
			@Override
			
			/*	Method name: actionPerformed(ActionEvent e)
			 * 	Description:	Allows a click of the mouse on the "Exit 
			 * 					Program" button to exit the program and close
			 * 					the system window
			 */
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, 
						"Have you saved your grade data?", 
						"Exit Program Check", 0);
				if (option == 0) {
					System.exit(0);
				}
				else {
					// Do not exit the program
				}
			}
		});
		
		JButton btnClearEverything = new JButton("Clear Everything");
		btnClearEverything.setForeground(Color.WHITE);
		btnClearEverything.setFont(new Font("Dialog", Font.BOLD, 16));
		btnClearEverything.setBackground(new Color(128, 0, 128));
		btnClearEverything.setBounds(458, 644, 190, 45);
		frame.getContentPane().add(btnClearEverything);
		
		btnClearEverything.addActionListener(new ActionListener() {
			@Override
			
			/*	Method name: actionPerformed(ActionEvent e)
			 * 	Description:	Allows a click of the mouse on the "Clear 
			 * 					Everything" button to reset all input data in
			 * 					the system to default value
			 */
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(btnExit, 
						"Have you saved your grade data?", 
						"Clear Everything Check", 0);
				if (option == 0) {
					percentA = 90.0f;
					percentB = 80.0f;
					percentC = 70.0f;
					percentD = 60.0f;
					
					tfGradeA.setText(Float.toString(percentA) + valueType);
					tfGradeB.setText(Float.toString(percentB) + valueType);
					tfGradeC.setText(Float.toString(percentC) + valueType);
					tfGradeD.setText(Float.toString(percentD) + valueType);
					tfGradeF.setText(Float.toString(percentD) + valueType);
					
					countA = 0;
					countB = 0;
					countC = 0;
					countD = 0;
					countF = 0;
					
					lblACount.setText(Integer.toString(countA));
					lblBCount.setText(Integer.toString(countB));
					lblCCount.setText(Integer.toString(countC));
					lblDCount.setText(Integer.toString(countD));
					lblFCount.setText(Integer.toString(countF));
					
					lblLowestGradeOutput.setText("");
					lblHighestGradeOutput.setText("");
					lblMedianGradeOutput.setText("");
					lblAverageGradeOutput.setText("");
					
					lblTenthPercentileOutput.setText("0" + valueType);
					lblTwentiethPercentileOutput.setText("0" + valueType);
					lblThirtiethPercentileOutput.setText("0" + valueType);
					lblFourtiethPercentileOutput.setText("0" + valueType);
					lblFiftiethPercentileOutput.setText("0" + valueType);
					lblSixtiethPercentileOutput.setText("0" + valueType);
					lblSeventiethPercentileOutput.setText("0" + valueType);
					lblEightiethPercentileOutput.setText("0" + valueType);
					lblNinetiethPercentileOutput.setText("0" + valueType);
					
					minimumGrade = 0;
					maximumGrade = Float.MAX_VALUE;
					valueType = "%";
					tglbtnAbsoluteGrade.setSelected(false);
					
					lblMinGrade.setText(Float.toString(minimumGrade)
							+ valueType);
					lblMaxGrade.setText("N/A");
					
					gradeListModel.clear();
					grades.clear();
				}
				else {
					/* Do nothing and exit prompt */
				}
			}
		});
		
		tglbtnAbsoluteGrade = new JToggleButton("Absolute Grades");
		tglbtnAbsoluteGrade.setBackground(new Color(139, 0, 139));
		tglbtnAbsoluteGrade.setForeground(Color.WHITE);
		tglbtnAbsoluteGrade.setToolTipText("Select this if grades read in are"
				+ " not percentages");
		tglbtnAbsoluteGrade.setFont(new Font("Tahoma", Font.BOLD, 16));
		tglbtnAbsoluteGrade.setBounds(12, 160, 190, 45);
		frame.getContentPane().add(tglbtnAbsoluteGrade);
		
		tglbtnAbsoluteGrade.addActionListener(new ActionListener() {
			@Override
			
			/*	Method name: 	actionPerformed(ActionEvent e)
			 * 	Description:	Allows a click of the mouse on the "Absolute 
			 * 					Grades" button to allow a pop-up to appear to 
			 * 					change grade values to percentages
			 */
			public void actionPerformed(ActionEvent e) {
				if (tglbtnAbsoluteGrade.isSelected()) {
					try {
						String maxGradeInput = JOptionPane.showInputDialog(
								frame, "Enter maximum possible grade: ");
						maximumGrade = Float.parseFloat(maxGradeInput);
				
						percentA = (float) 0.9 * maximumGrade;
						percentB = (float) 0.8 * maximumGrade;
						percentC = (float) 0.7 * maximumGrade;
						percentD = (float) 0.6 * maximumGrade;
				
						valueType = " pts";
		
						tfGradeA.setText(String.format("%.1f", percentA)
								+ valueType);
						tfGradeB.setText(String.format("%.1f", percentB)
								+ valueType);
						tfGradeC.setText(String.format("%.1f", percentC) 
								+ valueType);
						tfGradeD.setText(String.format("%.1f", percentD) 
								+ valueType);
						tfGradeF.setText(String.format("%.1f", percentD) 
								+ valueType);
						
						minimumGrade = 0;
					
						lblMinGrade.setText(String.format("%.1f",minimumGrade)
								+ valueType);
						lblMaxGrade.setText(String.format("%.1f",maximumGrade)
								+ valueType);
						
						updateGradeData();
					}
					catch(NumberFormatException error) {
						JOptionPane.showMessageDialog(null, 
								"Error! Must enter a number");
							System.err.println("NumberFormatException: " 
							+ error.getMessage());
							tglbtnAbsoluteGrade.setSelected(false);
					}
					catch(NullPointerException error) {
						tglbtnAbsoluteGrade.setSelected(false);
					}
				}
				else {
					percentA = 90.0f;
					percentB = 80.0f;
					percentC = 70.0f;
					percentD = 60.0f;
					
					/* MODIFIEDPOSITION */					
					maximumGrade = 100;
					valueType = "%";
			
					
					tfGradeA.setText(Float.toString(percentA) + valueType);
					tfGradeB.setText(Float.toString(percentB) + valueType);
					tfGradeC.setText(Float.toString(percentC) + valueType);
					tfGradeD.setText(Float.toString(percentD) + valueType);
					tfGradeF.setText(Float.toString(percentD) + valueType);
					
					minimumGrade = 0;
					
					lblMinGrade.setText(Float.toString(minimumGrade) +
							valueType);
					lblMaxGrade.setText("N/A");
					
					updateGradeData();
				}
			}
		});
	}
	
	
	/**
	 * Description: copies grade elements from grades ArrayList that fall
	 * 			within the min and max grade limits and adds those values
	 * 			to a tempGrade ArrayList which is then sorted and used
	 * 			to find the Lowest, Highest, Median, Average Grade and update
	 * 			the appropriate labels.
	 */
	public void updateGradeData() {
		
		GradeAppGUIMain.this.tempGrades = new ArrayList<Float>();
		if (!grades.isEmpty()) {
			try {
				float temp = 0;
				float roundedTemp =  0;
				averageGrade = 0;
				countA = 0;
				countB = 0;
				countC = 0;
				countD = 0;
				countF = 0;
				
				for(Grade gradeInput:grades) {
					//Round grades correctly
					temp = gradeInput.getGrade();
					float tempFloor = (int)Math.floor(gradeInput.getGrade());
					
					if (temp % tempFloor >= 0.5) {
						roundedTemp = Math.round(temp);
					}
					else {
						roundedTemp = temp;
					}
					//Replace scores outside of set range
					if (temp < minimumGrade) {
						tempGrades.add(minimumGrade);
						roundedTemp = Math.round(minimumGrade);
					}
					else if (temp > maximumGrade) {
						tempGrades.add(maximumGrade);
						roundedTemp = Math.round(maximumGrade);
					}
					else {
						tempGrades.add(temp);
					}
					
					gradeInput.setAdjustedGrade(roundedTemp);
					
					/* Set the letter grade for each object Grade */
					if (roundedTemp >= percentA) {
						gradeInput.setLetterGrade("A");
					}
					else if (roundedTemp >= percentB) {
						gradeInput.setLetterGrade("B");
					}
					else if (roundedTemp >= percentC) {
						gradeInput.setLetterGrade("C");
					}
					else if (roundedTemp >= percentD) {
						gradeInput.setLetterGrade("D");
					}
					else {
						gradeInput.setLetterGrade("F");
					}
					
					/* Determine grade count */
					if (roundedTemp >= percentA) {
						countA++;
					}
					else if (roundedTemp >= percentB) {
						countB++;
					}
					else if (roundedTemp >= percentC) {
						countC++;
					}
					else if (roundedTemp >= percentD) {
						countD++;
					}
					else {
						countF++;
					}
				}
				
				Collections.sort(tempGrades);
				
				/* Find sum of grades for later use in average calculation */
				for (int gIndex = 0; gIndex < tempGrades.size(); gIndex++) {
					averageGrade = averageGrade + tempGrades.get(gIndex);
				}
				
				lblACount.setText(Integer.toString(countA));;
				lblBCount.setText(Integer.toString(countB));;
				lblCCount.setText(Integer.toString(countC));;
				lblDCount.setText(Integer.toString(countD));;
				lblFCount.setText(Integer.toString(countF));;
				
				lowestGrade = tempGrades.get(0);
				highestGrade = tempGrades.get(tempGrades.size()-1);
				averageGrade = averageGrade / tempGrades.size();
			
				
				/* Median grade calculation */
				if (tempGrades.size() % 2 == 0) {
					medianGrade = (tempGrades.get( tempGrades.size() / 2 ) + 
							tempGrades.get(( tempGrades.size() / 2 ) - 1)) / 2;
				}
				else {
					medianGrade = (tempGrades.get(tempGrades.size() / 2));
				}

				lblLowestGradeOutput.setText(Float.toString(lowestGrade) +
						valueType);
				lblHighestGradeOutput.setText(Float.toString(highestGrade) +
						valueType);
				lblMedianGradeOutput.setText(Float.toString(medianGrade) + 
						valueType);
				lblAverageGradeOutput.setText(String.format("%.1f", 
						averageGrade) + valueType);
				

				gradeListModel.clear();
				
				for (Grade updatedGrades : grades) {
					gradeListModel.addElement(updatedGrades.toString());
				}
				
				/*	Calculate percentiles
					Percentile nth defined as number that is greater
					or equal to n% of the data set
				*/
				for (int rankIndex = tempGrades.size() - 1; rankIndex >= 0;
						rankIndex--) {
					
					double total = tempGrades.size();
					double rank = rankIndex + 1;
					String rankOutput = tempGrades.get(rankIndex).toString();
					
					if(rank / total >= 0.10) {
						lblTenthPercentileOutput.setText(rankOutput + 
								valueType);
					}
					if(rank / total >= 0.20) {
						lblTwentiethPercentileOutput.setText(rankOutput + 
								valueType);
					}
					if(rank / total >= 0.30) {
						lblThirtiethPercentileOutput.setText(rankOutput + 
								valueType);
					}
					if(rank / total >= 0.40) {
						lblFourtiethPercentileOutput.setText(rankOutput + 
								valueType);
					}
					if(rank / total >= 0.50) {
						lblFiftiethPercentileOutput.setText(rankOutput + 
								valueType);
					}
					if(rank / total >= 0.60) {
						lblSixtiethPercentileOutput.setText(rankOutput + 
								valueType);
					}
					if(rank / total >= 0.70) {
						lblSeventiethPercentileOutput.setText(rankOutput +
								valueType);
					}
					if(rank / total >= 0.80) {
						lblEightiethPercentileOutput.setText(rankOutput + 
								valueType);
					}
					if(rank / total >= 0.90) {
						lblNinetiethPercentileOutput.setText(rankOutput +
								valueType);
					}
				}
			}
			catch (NullPointerException error) {
				/*
				 *  NullPointerException occurs if there are no elements
				 *	in the grades ArrayList.
				 */
			}
		}
			else {
				lblACount.setText("0");
				lblBCount.setText("0");
				lblCCount.setText("0");
				lblDCount.setText("0");
				lblFCount.setText("0");
				lblLowestGradeOutput.setText("");
				lblHighestGradeOutput.setText("");
				lblMedianGradeOutput.setText("");
				lblAverageGradeOutput.setText("");
				lblTenthPercentileOutput.setText("0" + valueType);
				lblTwentiethPercentileOutput.setText("0" + valueType);
				lblThirtiethPercentileOutput.setText("0" + valueType);
				lblFourtiethPercentileOutput.setText("0" + valueType);
				lblFiftiethPercentileOutput.setText("0" + valueType);
				lblSixtiethPercentileOutput.setText("0" + valueType);
				lblSeventiethPercentileOutput.setText("0" + valueType);
				lblEightiethPercentileOutput.setText("0" + valueType);
				lblNinetiethPercentileOutput.setText("0" + valueType);
				
			}
		JOptionPane.showMessageDialog(null, "Grades Updated");
	}
	
	/**
	 * Description: generates a text file to be saved by a user. The report
	 * contains a summary of the grade data in an easy to ready format.
	 * 
	 * Utilizes FileChooser to name file and save directory then saves the
	 * data to that text file formatted using a StringBuilder.
	 */
	public void generateReport() {
		JFileChooser chooser = new JFileChooser();
	    int returnVal = chooser.showSaveDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	JOptionPane.showMessageDialog(null, 
	    			"Saving Report to: " +
	            chooser.getSelectedFile().getName());
	    }
	    File file = chooser.getSelectedFile();
	    String fileName = file.getAbsolutePath();
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWriter =
					new FileWriter(fileName);
			BufferedWriter bufferedWriter =
					new BufferedWriter(fileWriter);
			StringBuilder sb = new StringBuilder();
			
			sb.append(String.format("%-80s%n", "####################"
					+ "########################################"
					+ "###################"));
			sb.append(String.format("%45s%n", "Grade Report"));
			sb.append(String.format("%-80s%n", "####################"
					+ "########################################"
					+ "###################"));
			
			sb.append(String.format("%n"));
			
			sb.append(String.format("%-20s %-20s%n", "Total Grades:", 
							tempGrades.size()));
			
			sb.append(String.format("%n"));
			
			sb.append(String.format("%-30s %-40s%n", 
					"Minimum Grade Possible", "Maximum Grade Possible"));
			sb.append(String.format("%-30s %-30s%n", 
					"----------------------", "----------------------"));
			sb.append(String.format("%-30s %-30s%n", 
					minimumGrade, maximumGrade));
			
			sb.append(String.format("%n"));
			
			sb.append(String.format("%-20s %-20s %-20s %-20s%n", 
					"Lowest Grade", "Highest Grade", "Median Grade",
					"Average Grade"));
			sb.append(String.format("%-20s %-20s %-20s %-20s%n", 
					"-------------", "-------------", "------------",
					"-------------"));
			sb.append(String.format("%-20s %-20s %-20s %-20s%n", 
					lowestGrade, highestGrade, medianGrade,
					averageGrade));
			
			sb.append(String.format("%n"));
			
			sb.append(String.format("%-8s %-18s%n", "Grade", 
					"    Scale"));
			sb.append(String.format("%-8s %-18s%n", "-----", 
					"--------------"));
			sb.append(String.format("%-1s %-6s %-18s%n", "", "A", 
					percentA + " - " + maximumGrade));
			sb.append(String.format("%-1s %-6s %-18s %n", "", "B", 
					percentB + " -  " + percentA));
			sb.append(String.format("%-1s %-6s %-18s%n", "", "C",
					percentC + " -  " + percentB));
			sb.append(String.format("%-1s %-6s %-18s%n", "", "D",
					percentD + " -  " + percentC));
			sb.append(String.format("%-1s %-6s %-18s%n", "", "F",
					" " + minimumGrade + " -  " + percentD));
			
			sb.append(String.format("%n"));
			
			sb.append(String.format("%-8s %-18s%n", "Grade", 
					"    Total"));
			sb.append(String.format("%-8s %-18s%n", "-----", 
					"--------------"));
			sb.append(String.format("%-1s %-6s %7s%n", "", "A", countA));
			sb.append(String.format("%-1s %-6s %7s%n", "", "B", countB));
			sb.append(String.format("%-1s %-6s %7s%n", "", "C", countC));
			sb.append(String.format("%-1s %-6s %7s%n", "", "D", countD));
			sb.append(String.format("%-1s %-6s %7s%n", "", "F", countF));

			sb.append(String.format("%n"));
			
			sb.append(String.format("%47s%n", "Percentile Chart"));
			sb.append(String.format("%-8s %-8s %-8s %-8s %-8s %-8s %-8s %-8s"
					+ "%-8s%n", "10th","20th","30th", "40th", "50th", "60th",
					"70th", "80th", "90th"));
			sb.append(String.format("%-8s %-8s %-8s %-8s %-8s %-8s %-8s %-8s"
					+ "%-8s%n", "----","----","----", "----", "----", "----",
					"----", "----", "----"));
			sb.append(String.format("%-8s %-8s %-8s %-8s %-8s %-8s %-8s %-8s"
					+ "%-8s%n", lblTenthPercentileOutput.getText(),
					lblTwentiethPercentileOutput.getText(),
					lblThirtiethPercentileOutput.getText(),
					lblFourtiethPercentileOutput.getText(),
					lblFiftiethPercentileOutput.getText(),
					lblSixtiethPercentileOutput.getText(),
					lblSeventiethPercentileOutput.getText(),
					lblEightiethPercentileOutput.getText(),
					lblNinetiethPercentileOutput.getText()));
			
			sb.append(String.format("%n%n%2s%n", "Grades read in for report:"));
			sb.append(String.format("%-10s%10s%15s%n", "Grades",
					"Adjusted", "Letter Grade"));
			for(Grade reportedGrades : grades) {
				sb.append(reportedGrades.toString());
				sb.append(String.format("%n"));
			}
			bufferedWriter.write(sb.toString());
			bufferedWriter.close();
		}
		catch(FileNotFoundException fileException) {
			JOptionPane.showMessageDialog(null, "Error! File " 
					+ fileName + " not found.");
			 System.err.println("FileNotFoundException: " 
					+ fileException.getMessage());
		}
		catch(IOException IOException) {
			JOptionPane.showMessageDialog(null, "Error! File" 
					+ fileName + "contains unreadable characters.");
			 System.err.println("IOException: " 
					+ IOException.getMessage());
		}
		catch(NullPointerException nullException) {
			JOptionPane.showConfirmDialog(null, "Error! Cannot generate "
					+ "report with zero entered grades.");
			System.err.println("NullException: "
					+ nullException.getMessage());
		}
	}
}