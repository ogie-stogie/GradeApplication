/*	Names: Taylor Bart, Vipul Vadodaria, Benjamin Veach
 * 	Class ID: 41792
 * 	Grading Analytics System
 * 	Description:	Contains the entire GUI framework for the Grading Analytics
 * 					system and all input, output, analysis, report making, 
 * 					and file opening and saving is done through this class
 * 
 * 					Contains two JFrames for the main GUI and the percentile table
 * 
 * 					Contains five JTextfields for use in editing the grade cutoffs
 * 					
 * 					Contains eighteen JLabels to label all portions of input and output
 * 
 * 					Contains three lists: one for holding Grade objects, the other two 
 * 										for holding float variables
 * 
 * 					Contains ten private float variables for storing results of analysis
 * 				
 * 					Contains five private int variables for holding the amount of grades
 * 					in each cutoff
 * 
 * 					Contains twenty three methods for implementation of all functionality
 * 					of the system
 * 
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
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

/*	This main class contains two JFrames, five JTextfields, eighteen JLabels,
 * 	three lists, ten private float variables, five private int variables, and 
 * 	twenty-three methods
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
 * 	<List<Grade> grades>
 * 	List for holding a series of Grade type objects
 * 
 * 	<List<Float> tempGrades>
 * 	List for holding a series of Float type variables representing grades to perform analysis on
 * 
 * 	<List<Float> originalGrades>
 * 	List for holding a series of Float type variables representing unanalyzed grades
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
 *  Method to allow percentile table window to be closed by the "close" button
 *  
 *  <actionPerformed(ActionEvent openFileEvent)>
 *  Method to open File Chooser via the "Open File" button to open a file
 *  
 *  <actionPerformed(ActionEvent saveFileEvent)>
 *  Method to open File Chooser via the "Save File" button to save a file
 *  
 *  <actionPerformed(ActionEvent addGradeEvent)>
 *  Method to allow a grade to be added by clicking the "Add Grade" button
 *  
 *  <actionPerformed(ActionEvent removeGradeEvent)>
 *  Method to allow a grade to be removed by clicking the "Remove Grade" button
 *  
 *  <actionPerformed(ActionEvent ammendGradeEvent)>
 *  Method to allow a grade to be changed by clicking the "Amend Grade" button
 *  
 *  <actionPerformed(ActionEvent e)>
 *  Method to allow the minimum grade to be set by clicking the "Set Min Grade"
 *  button
 *  
 *  <actionPerformed(ActionEvent e)>
 *  Method to allow the maximum grade to be set by clicking the "Set Max Grade"
 *  button
 *  
 *  <actionPerformed(ActionEvent event)>
 *  Method to allow the percentile table to appear by clicking the 
 *  "Percentile Rank" button
 *  
 *  <actionPerformed(ActionEvent e)>
 *  Method to allow a report to be generated by clicking the "Generate Report"
 *  button
 *  
 *  <actionPerformed(ActionEvent e)>
 *  Method to allow the program to be exited by clicking the "Exit Program"
 *  button
 *  
 *  <actionPerformed(ActionEvent e)>
 *  Method to allow all input and calculated data to be reset to default values
 *  and positions by clicking the "Clear Everything" button
 *  
 *  <updateGradeData()>
 *  Copies Grade objects that fall between min and max values from <originalGrades>
 *  to <tempGrades>, then performs analysis on Grade objects in <tempGrades>
 *  
 *  <generateReport()>
 *  Retrieves the necessary data and formats all of it into a nice looking report
 *  
 */




public class GradeAppGUIMain {

	/* Global Variables */
	private JFrame frame, frmTableOfPercentile;
	private JTextField tfGradeA, tfGradeB, tfGradeC, tfGradeD, tfGradeF;
	private JLabel lblLowestGradeOutput, lblHighestGradeOutput;
	private JLabel lblMedianGradeOutput, lblAverageGradeOutput;
	private JLabel lblACount, lblBCount, lblCCount;
	private JLabel lblDCount, lblFCount;
	private JLabel lblTenthPercentileOutput, lblTwentiethPercentileOutput, lblThirtiethPercentileOutput;
	private JLabel lblFourtiethPercentileOutput, lblFiftiethPercentileOutput, lblSixtiethPercentileOutput;
	private JLabel lblSeventiethPercentileOutput, lblEightiethPercentileOutput, lblNinetiethPercentileOutput;
	DefaultListModel gradeListModel;
	
	private List<Grade> grades = new ArrayList<Grade>();
	private List<Float> tempGrades, originalGrades;

	// private float minimumGrade = 0.0f, maximumGrade = 100.0f;
	private float minimumGrade = 0.0f, maximumGrade = Float.MAX_VALUE;
	private float lowestGrade, highestGrade, medianGrade, averageGrade;
	private float percentA = 90.0f, percentB = 80.0f;
	private float percentC = 70.0f, percentD = 60.0f;
	
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
		tfGradeA.setEditable(false);
		tfGradeA.setHorizontalAlignment(SwingConstants.CENTER);
		tfGradeA.setText(Float.toString(percentA));
		tfGradeA.setBackground(Color.GREEN);
		tfGradeA.setFont(new Font("Dialog", Font.BOLD, 18));
		tfGradeA.setColumns(10);
		tfGradeA.setBounds(528, 290, 120, 45);
		frame.getContentPane().add(tfGradeA);
		
		tfGradeA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent changeScale) {
				JFrame frame = new JFrame("Grade Scale");
				String gradePercentage = 
					JOptionPane.showInputDialog(frame, "Enter Grade for "
							+ "\"A\": ");
				try {
					percentA = Float.parseFloat(gradePercentage);
					if (percentA <= percentB) {
						JOptionPane.showMessageDialog(frame, "Percentage "
								+ "for an \"A\" cannot be less than or "
								+ "equal to the percentage for a \"B\"");
					}
					else {
						tfGradeA.setText(Float.toString(percentA));
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
					//Do nothing - catches textField edit cancel
				}
			}
		});
		
		tfGradeB = new JTextField();
		tfGradeB.setEditable(false);
		tfGradeB.setHorizontalAlignment(SwingConstants.CENTER);
		tfGradeB.setText(Float.toString(percentB));
		tfGradeB.setBackground(new Color(204, 255, 51));
		tfGradeB.setFont(new Font("Dialog", Font.BOLD, 18));
		tfGradeB.setColumns(10);
		tfGradeB.setBounds(528, 340, 120, 45);
		frame.getContentPane().add(tfGradeB);
		
		tfGradeB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent changeScale) {
				JFrame frame = new JFrame("Grade Scale");
				String gradePercentage = 
					JOptionPane.showInputDialog(frame, "Enter Grade for "
							+ "\"B\": ");
				try {
					percentB = Float.parseFloat(gradePercentage);
					if (percentB <= percentC) {
						JOptionPane.showMessageDialog(frame, "Percentage "
								+ "for \"B\" cannot be less than or equal "
								+ " to the percentage for a \"C\"");
					}
					else if (percentB >= percentA) {
						JOptionPane.showMessageDialog(frame, "Percentage "
								+ "for \"B\" cannot be greater than or "
								+ "equal to the percentage for an \"A\""
								+ "");
					}
					else {
						tfGradeB.setText(Float.toString(percentB));
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
					//Do nothing - catches textField edit cancel
				}
			}
		});
		
		tfGradeC = new JTextField();
		tfGradeC.setEditable(false);
		tfGradeC.setHorizontalAlignment(SwingConstants.CENTER);
		tfGradeC.setText(Float.toString(percentC));
		tfGradeC.setBackground(Color.YELLOW);
		tfGradeC.setFont(new Font("Dialog", Font.BOLD, 18));
		tfGradeC.setColumns(10);
		tfGradeC.setBounds(528, 390, 120, 45);
		frame.getContentPane().add(tfGradeC);
		
		tfGradeC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent changeScale) {
				JFrame frame = new JFrame("Grade Scale");
				String gradePercentage = 
					JOptionPane.showInputDialog(frame, "Enter Grade for "
							+ "\"B\": ");
				try {
					percentC = Float.parseFloat(gradePercentage);
					if (percentC <= percentD) {
						JOptionPane.showMessageDialog(frame, "Percentage "
								+ "for \"C\" cannot be less than or equal "
								+ " to the percentage for a \"D\"");
				}
					else if (percentC >= percentB) {
						JOptionPane.showMessageDialog(frame, "Percentage "
								+ "for \"C\" cannot be greater than or "
								+ "equal to the percentage for an \"B\""
								+ "");
					}
					else {
						tfGradeC.setText(Float.toString(percentC));
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
					//Do nothing - catches textField edit cancel
				}
			}
		});

		tfGradeD = new JTextField();
		tfGradeD.setEditable(false);
		tfGradeD.setHorizontalAlignment(SwingConstants.CENTER);
		tfGradeD.setText(Float.toString(percentD));
		tfGradeD.setBackground(new Color(255, 102, 51));
		tfGradeD.setFont(new Font("Dialog", Font.BOLD, 18));
		tfGradeD.setColumns(10);
		tfGradeD.setBounds(528, 440, 120, 45);
		frame.getContentPane().add(tfGradeD);
		
		tfGradeD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent changeScale) {
				JFrame frame = new JFrame("Grade Scale");
				String gradePercentage = 
					JOptionPane.showInputDialog(frame, "Enter Grade for "
							+ "\"D\": ");
				try {
					percentD = Float.parseFloat(gradePercentage);
					if (percentD >= percentC) {
						JOptionPane.showMessageDialog(frame, "Percentage "
								+ "for \"D\" cannot be greater than or "
								+ "equal to the percentage for an \"C\""
								+ "");
					}
					else {
						tfGradeD.setText(Float.toString(percentD));
						tfGradeF.setText(Float.toString(percentD));
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
					//Do nothing - catches textField edit cancel
				}
			}
		});
		
		tfGradeF = new JTextField();
		tfGradeF.setEditable(false);
		tfGradeF.setHorizontalAlignment(SwingConstants.CENTER);
		tfGradeF.setText(Float.toString(percentD));
		tfGradeF.setBackground(Color.RED);
		tfGradeF.setFont(new Font("Dialog", Font.BOLD, 18));
		tfGradeF.setColumns(10);
		tfGradeF.setBounds(528, 490, 120, 45);
		frame.getContentPane().add(tfGradeF);
		
		tfGradeF.addMouseListener(new MouseAdapter() {
			@Override
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
		frmTableOfPercentile.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 16));
		frmTableOfPercentile.getContentPane().setBackground(Color.CYAN);
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
		lblTwentiethPercentileOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblTwentiethPercentileOutput.setBounds(99, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblTwentiethPercentileOutput);
		
		lblThirtiethPercentileOutput = new JLabel("0");
		lblThirtiethPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThirtiethPercentileOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblThirtiethPercentileOutput.setBounds(186, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblThirtiethPercentileOutput);
		
		lblFourtiethPercentileOutput = new JLabel("0");
		lblFourtiethPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFourtiethPercentileOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblFourtiethPercentileOutput.setBounds(273, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblFourtiethPercentileOutput);
		
		lblFiftiethPercentileOutput = new JLabel("0");
		lblFiftiethPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFiftiethPercentileOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiftiethPercentileOutput.setBounds(360, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblFiftiethPercentileOutput);
		
		lblSixtiethPercentileOutput = new JLabel("0");
		lblSixtiethPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSixtiethPercentileOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblSixtiethPercentileOutput.setBounds(447, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblSixtiethPercentileOutput);
		
		lblSeventiethPercentileOutput = new JLabel("0");
		lblSeventiethPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSeventiethPercentileOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeventiethPercentileOutput.setBounds(534, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblSeventiethPercentileOutput);
		
		lblEightiethPercentileOutput = new JLabel("0");
		lblEightiethPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEightiethPercentileOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblEightiethPercentileOutput.setBounds(621, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblEightiethPercentileOutput);
		
		lblNinetiethPercentileOutput = new JLabel("0");
		lblNinetiethPercentileOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNinetiethPercentileOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblNinetiethPercentileOutput.setBounds(708, 56, 75, 30);
		frmTableOfPercentile.getContentPane().add(lblNinetiethPercentileOutput);
		
		JButton btnClose = new JButton("Close");
		btnClose.setForeground(new Color(255, 255, 255));
		btnClose.setFont(new Font("Dialog", Font.BOLD, 18));
		btnClose.setBackground(new Color(139, 0, 139));
		btnClose.setBounds(99, 110, 597, 50);
		frmTableOfPercentile.getContentPane().add(btnClose);
		
		btnClose.addActionListener(new ActionListener() {
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
		lblLowestGradeOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblLowestGradeOutput.setFont(new Font("Dialog", Font.BOLD, 16));
		lblLowestGradeOutput.setBounds(210, 400, 120, 30);
		frame.getContentPane().add(lblLowestGradeOutput);
		
		lblHighestGradeOutput = new JLabel("");
		lblHighestGradeOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblHighestGradeOutput.setFont(new Font("Dialog", Font.BOLD, 16));
		lblHighestGradeOutput.setBounds(211, 430, 120, 30);
		frame.getContentPane().add(lblHighestGradeOutput);
		
		lblMedianGradeOutput = new JLabel("");
		lblMedianGradeOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedianGradeOutput.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMedianGradeOutput.setBounds(211, 460, 120, 30);
		frame.getContentPane().add(lblMedianGradeOutput);
		
		lblAverageGradeOutput = new JLabel("");
		lblAverageGradeOutput.setHorizontalAlignment(SwingConstants.CENTER);
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
		
		JLabel lblMinGrade = new JLabel(Float.toString(minimumGrade));
		lblMinGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMinGrade.setBounds(210, 290, 50, 45);
		frame.getContentPane().add(lblMinGrade);
		
		JLabel lblMaxGrade = new JLabel("N/A");
		lblMaxGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMaxGrade.setBounds(210, 340, 50, 45);
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
		btnOpenFile.setBackground(new Color(128, 0, 128));
		btnOpenFile.setForeground(Color.WHITE);
		btnOpenFile.setFont(new Font("Dialog", Font.BOLD, 16));
		btnOpenFile.setBounds(12, 60, 190, 45);
		frame.getContentPane().add(btnOpenFile);
		
		btnOpenFile.addActionListener(new ActionListener() {
			@Override
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
						//gradeListModel.addElement(newGrade.toString());
						gradeList.clearSelection();
					}
					bufferedReader.close();
					updateGradeData();
					for(Grade updatedGrades:grades) {
						gradeListModel.addElement(updatedGrades.toString());
					}
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
					//Do Nothing but catch canceled open files
				}
			}
		});
		
		
		JButton btnSaveFile = new JButton("Save File");
		btnSaveFile.setForeground(Color.WHITE);
		btnSaveFile.setBackground(new Color(128, 0, 128));
		btnSaveFile.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSaveFile.setBounds(12, 110, 190, 45);
		frame.getContentPane().add(btnSaveFile);
		
		btnSaveFile.addActionListener(new ActionListener() {
			@Override
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
					//Do Nothing but catch canceled save file
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
					GradeAppGUIMain.this.grades.set(gradeList.getSelectedIndex(), newGrade);
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
					//Do nothing - catches amend grade cancel
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
						lblMinGrade.setText(minGradeInput);
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
					//Do nothing - catches amend grade cancel
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
						lblMaxGrade.setText(Float.toString(maximumGrade));
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
					//Do nothing - catches amend grade cancel
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
			public void actionPerformed(ActionEvent e) {
				try {
					generateReport();
				}
				catch(NullPointerException error ) {
					//Do nothing - catches textField edit cancel
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
			public void actionPerformed(ActionEvent e) {
				System.exit(0);			
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
			public void actionPerformed(ActionEvent e) {
				
				percentA = 90.0f;
				percentB = 80.0f;
				percentC = 70.0f;
				percentD = 60.0f;
				
				tfGradeA.setText(Float.toString(percentA));
				tfGradeB.setText(Float.toString(percentB));
				tfGradeC.setText(Float.toString(percentC));
				tfGradeD.setText(Float.toString(percentD));
				tfGradeF.setText(Float.toString(percentD));
				
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
				
				minimumGrade = 0;
				maximumGrade = Float.MAX_VALUE;
				
				lblMinGrade.setText(Float.toString(minimumGrade));
				lblMaxGrade.setText("N/A");
				
				gradeListModel.clear();
				grades.clear();
				
			}
		});
	}
	
	
	/**
	 * Method Name: updateGradeData
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
				
				//Grade Rounding
				for(Grade gradeInput:grades) {
					
					temp = gradeInput.getGrade();
					float tempFloor = (int)Math.floor(gradeInput.getGrade());
					
					System.out.println(tempFloor);
					
					if (temp % tempFloor > 0.5) {
						roundedTemp = Math.round(temp);
					}
					else {
						roundedTemp = temp;
					}
							
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
				}
				
				Collections.sort(tempGrades);
				
				for (int gIndex = 0; gIndex < tempGrades.size(); gIndex++) {
					if (tempGrades.get(gIndex) >= percentA) {
						countA++;
					}
					else if (tempGrades.get(gIndex) >= percentB) {
						countB++;
					}
					else if (tempGrades.get(gIndex) >= percentC) {
						countC++;
					}
					else if (tempGrades.get(gIndex) >= percentD) {
						countD++;
					}
					else {
						countF++;
					}
					
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
							tempGrades.get( ( tempGrades.size() / 2 ) - 1) ) / 2;
					medianGrade = ((tempGrades.get(tempGrades.size() / 2) + 
							tempGrades.get(tempGrades.size() / 2) - 1 )) / 2;
				}
				else {
					medianGrade = (tempGrades.get(tempGrades.size() / 2));
				}
				
				lblLowestGradeOutput.setText(Float.toString(lowestGrade));
				lblHighestGradeOutput.setText(Float.toString(highestGrade));
				lblMedianGradeOutput.setText(Float.toString(medianGrade));
				lblAverageGradeOutput.setText(String.format("%.1f", averageGrade));
				gradeListModel.clear();
				
				for (Grade updatedGrades : grades) {
					gradeListModel.addElement(updatedGrades.toString());
				}
				for (int rankIndex = tempGrades.size() - 1; rankIndex >= 0;
						rankIndex--) {
					
					double total = tempGrades.size();
					double rank = rankIndex + 1;
					String rankOutput = tempGrades.get(rankIndex).toString();
					
					if(rank / total > 0.10) {
						lblTenthPercentileOutput.setText(rankOutput);
					}
					if(rank / total > 0.20) {
						lblTwentiethPercentileOutput.setText(rankOutput);
					}
					if(rank / total > 0.30) {
						lblThirtiethPercentileOutput.setText(rankOutput);
					}
					if(rank / total > 0.40) {
						lblFourtiethPercentileOutput.setText(rankOutput);
					}
					if(rank / total > 0.50) {
						lblFiftiethPercentileOutput.setText(rankOutput);
					}
					if(rank / total > 0.60) {
						lblSixtiethPercentileOutput.setText(rankOutput);
					}
					if(rank / total > 0.70) {
						lblSeventiethPercentileOutput.setText(rankOutput);
					}
					if(rank / total > 0.80) {
						lblEightiethPercentileOutput.setText(rankOutput);
					}
					if(rank / total > 0.90) {
						lblNinetiethPercentileOutput.setText(rankOutput);
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
				lblTenthPercentileOutput.setText("0");
				lblTwentiethPercentileOutput.setText("0");
				lblThirtiethPercentileOutput.setText("0");
				lblFourtiethPercentileOutput.setText("0");
				lblFiftiethPercentileOutput.setText("0");
				lblSixtiethPercentileOutput.setText("0");
				lblSeventiethPercentileOutput.setText("0");
				lblEightiethPercentileOutput.setText("0");
				lblNinetiethPercentileOutput.setText("0");
				
			}
		JOptionPane.showMessageDialog(null, "Grades Updated");
	}
	
	/*
	 * Method Name: generateReport()
	 * Description: generates a text file to be saved by a user. The report
	 * contains a summary of the grade data in an easy to ready format.
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
					+ "####################"));
			sb.append(String.format("%45s%n", "Grade Report"));
			sb.append(String.format("%-80s%n", "####################"
					+ "########################################"
					+ "####################"));
			
			sb.append(String.format("%n"));
			
			sb.append(String.format("%-20s %-20s%n", "Total Grades:", 
							tempGrades.size()));
			
			sb.append(String.format("%n"));
			
			sb.append(String.format("%-20s %-20s %-20s %-20s%n", 
					"Minimum Grade", "Maximum Grade", "Median Grade",
					"Average Grade"));
			sb.append(String.format("%-20s %-20s %-20s %-20s%n", 
					"-------------", "-------------", "------------",
					"-------------"));
			sb.append(String.format("%-20s %-20s %-20s %-20s%n", 
					minimumGrade, maximumGrade, medianGrade,
					averageGrade));
			
			sb.append(String.format("%n"));
			
			sb.append(String.format("%-8s %-18s %-8s%n", "Grade", 
					"  Percentage", "Total"));
			sb.append(String.format("%-8s %-18s %-8s%n", "-----", 
					"--------------", "-----"));
			sb.append(String.format("%-1s %-6s %-18s %-8s%n", "", "A", 
					percentA + "% - " + maximumGrade + "%", countA));
			sb.append(String.format("%-1s %-6s %-18s %-8s%n", "", "B", 
					percentB + "% -  " + percentA + "%", countB));
			sb.append(String.format("%-1s %-6s %-18s %-8s%n", "", "C",
					percentC + "% -  " + percentB + "%", countC));
			sb.append(String.format("%-1s %-6s %-18s %-8s%n", "", "D",
					percentD + "% -  " + percentD + "%", countD));
			sb.append(String.format("%-1s %-6s %-18s %-8s%n", "", "F",
					" " + minimumGrade + "% -  " + percentD + "%", countF));
			
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
