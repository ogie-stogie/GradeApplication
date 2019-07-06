// This is a gitHub test.. Please help!
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

public class GradeAppGUIMain {

	//Global Variables
	private JFrame frame;
	private DefaultListModel gradeListModel = new DefaultListModel<>();
	private float minimumGrade = 0.0f, maximumGrade = 100.0f;
	private List<Grade> grades = new ArrayList<Grade>();
	private int selectedGrade;
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
		
		JTextField tfGradeA = new JTextField();
		tfGradeA.setHorizontalAlignment(SwingConstants.CENTER);
		tfGradeA.setText("90");
		tfGradeA.setBackground(Color.GREEN);
		tfGradeA.setFont(new Font("Dialog", Font.BOLD, 18));
		tfGradeA.setColumns(10);
		tfGradeA.setBounds(528, 290, 120, 45);
		frame.getContentPane().add(tfGradeA);
		
		JTextField tfGradeB = new JTextField();
		tfGradeB.setHorizontalAlignment(SwingConstants.CENTER);
		tfGradeB.setText("80");
		tfGradeB.setBackground(new Color(204, 255, 51));
		tfGradeB.setFont(new Font("Dialog", Font.BOLD, 18));
		tfGradeB.setColumns(10);
		tfGradeB.setBounds(528, 340, 120, 45);
		frame.getContentPane().add(tfGradeB);
		
		JTextField tfGradeC = new JTextField();
		tfGradeC.setHorizontalAlignment(SwingConstants.CENTER);
		tfGradeC.setText("70");
		tfGradeC.setBackground(Color.YELLOW);
		tfGradeC.setFont(new Font("Dialog", Font.BOLD, 18));
		tfGradeC.setColumns(10);
		tfGradeC.setBounds(528, 390, 120, 45);
		frame.getContentPane().add(tfGradeC);

		JTextField tfGradeD = new JTextField();
		tfGradeD.setHorizontalAlignment(SwingConstants.CENTER);
		tfGradeD.setText("60");
		tfGradeD.setBackground(new Color(255, 102, 51));
		tfGradeD.setFont(new Font("Dialog", Font.BOLD, 18));
		tfGradeD.setColumns(10);
		tfGradeD.setBounds(528, 440, 120, 45);
		frame.getContentPane().add(tfGradeD);
		
		JTextField tfGradeF = new JTextField();
		tfGradeF.setHorizontalAlignment(SwingConstants.CENTER);
		tfGradeF.setText("60");
		tfGradeF.setBackground(Color.RED);
		tfGradeF.setFont(new Font("Dialog", Font.BOLD, 18));
		tfGradeF.setColumns(10);
		tfGradeF.setBounds(528, 490, 120, 45);
		frame.getContentPane().add(tfGradeF);
		
		
	/*
	 * ########################################################################
	 * JLabel Group
	 * ########################################################################
	 */
		JLabel lblTitle = new JLabel("Grade Helper v23");
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTitle.setBounds(12, 12, 636, 36);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblGradeJList = new JLabel("Letter Grade");
		lblGradeJList.setFont(new Font("Dialog", Font.BOLD, 16));
		lblGradeJList.setHorizontalAlignment(SwingConstants.CENTER);
		lblGradeJList.setBounds(683, 15, 128, 45);
		frame.getContentPane().add(lblGradeJList);
		
		JLabel lblLetterGrade = new JLabel("Grade");
		lblLetterGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		lblLetterGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblLetterGrade.setBounds(823, 15, 130, 45);
		frame.getContentPane().add(lblLetterGrade);
		
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
		
		JLabel lblLowestGradeOutput = new JLabel("");
		lblLowestGradeOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblLowestGradeOutput.setFont(new Font("Dialog", Font.BOLD, 16));
		lblLowestGradeOutput.setBounds(210, 400, 120, 30);
		frame.getContentPane().add(lblLowestGradeOutput);
		
		JLabel lblHighestGradeOutput = new JLabel("");
		lblHighestGradeOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblHighestGradeOutput.setFont(new Font("Dialog", Font.BOLD, 16));
		lblHighestGradeOutput.setBounds(211, 430, 120, 30);
		frame.getContentPane().add(lblHighestGradeOutput);
		
		JLabel lblMedianGradeOutput = new JLabel("");
		lblMedianGradeOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedianGradeOutput.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMedianGradeOutput.setBounds(211, 460, 120, 30);
		frame.getContentPane().add(lblMedianGradeOutput);
		
		JLabel lblAverageGradeOutput = new JLabel("");
		lblAverageGradeOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblAverageGradeOutput.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAverageGradeOutput.setBounds(211, 490, 120, 30);
		frame.getContentPane().add(lblAverageGradeOutput);
		
		JLabel lblGradeCount = new JLabel("Grade Count");
		lblGradeCount.setFont(new Font("Dialog", Font.BOLD, 16));
		lblGradeCount.setBounds(355, 233, 120, 45);
		frame.getContentPane().add(lblGradeCount);
		
		JLabel lblACount = new JLabel("0");
		lblACount.setFont(new Font("Dialog", Font.BOLD, 16));
		lblACount.setBounds(391, 290, 50, 45);
		frame.getContentPane().add(lblACount);

		JLabel lblBCount = new JLabel("0");
		lblBCount.setFont(new Font("Dialog", Font.BOLD, 16));
		lblBCount.setBounds(391, 340, 50, 45);
		frame.getContentPane().add(lblBCount);
		
		JLabel lblCCount = new JLabel("0");
		lblCCount.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCCount.setBounds(391, 390, 50, 45);
		frame.getContentPane().add(lblCCount);
		
		JLabel lblDCount = new JLabel("0");
		lblDCount.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDCount.setBounds(391, 440, 50, 45);
		frame.getContentPane().add(lblDCount);
		
		JLabel lblFCount = new JLabel("0");
		lblFCount.setFont(new Font("Dialog", Font.BOLD, 16));
		lblFCount.setBounds(391, 490, 50, 45);
		frame.getContentPane().add(lblFCount);
		
		JLabel lblMinGrade = new JLabel("0");
		lblMinGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMinGrade.setBounds(210, 290, 50, 45);
		frame.getContentPane().add(lblMinGrade);
		
		JLabel lblMaxGrade = new JLabel("100");
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
						GradeAppGUIMain.this.gradeListModel.addElement(newGrade.toString());
					}
					bufferedReader.close();
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
							+ fileName + "has incorrect formatting.");
					 System.err.println("NumberFormatException: " 
							+ numberFormatException.getMessage());
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
			    			"You chose to open this file: " +
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
					JFrame frame = new JFrame("Add Grade");
					String addedGrade 
						= JOptionPane.showInputDialog(frame, "Enter grade: ");
					float gradeInput = Float.parseFloat(addedGrade);
					String letterGradeInput = "A";
					if (GradeAppGUIMain.this.grades == null) {
						GradeAppGUIMain.this.grades = new ArrayList<Grade>();
					}
					Grade newGrade = new Grade(gradeInput,letterGradeInput);
					GradeAppGUIMain.this.grades.add(newGrade);
					GradeAppGUIMain.this.gradeListModel.addElement(newGrade.toString());
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
				if(GradeAppGUIMain.this.grades != null) {
					GradeAppGUIMain.this.grades.remove(
							GradeAppGUIMain.this.selectedGrade);
				}
			}
		});
		
		
		JButton btnAmendGrade = new JButton("Amend Grade");
		btnAmendGrade.setBackground(new Color(128, 0, 128));
		btnAmendGrade.setForeground(Color.WHITE);
		btnAmendGrade.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAmendGrade.setBounds(468, 160, 180, 45);
		frame.getContentPane().add(btnAmendGrade);
		
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
				float newMinGrade = Float.parseFloat(minGradeInput);
				try {
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
					}
				}
				catch(NumberFormatException error) {
					JOptionPane.showMessageDialog(null, 
							"Error! Must enter a number");
						System.err.println("NumberFormatException: " 
						+ error.getMessage());
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
				float newMaxGrade = Float.parseFloat(maxGradeInput);
				try {
					if 
					(newMaxGrade < minimumGrade) {
						JOptionPane.showMessageDialog(null, "Maximum Grade "
								+ "cannot be greater than Minimum Grade. "
								+ "Maximum Grade not changed!");
					}
					else {
						maximumGrade = newMaxGrade;
						lblMaxGrade.setText(maxGradeInput);
					}
				}
				catch(NumberFormatException error) {
					JOptionPane.showMessageDialog(null, 
							"Error! Must enter a number");
						System.err.println("NumberFormatException: " 
						+ error.getMessage());
				}				
			}
		});
		
		JButton btnPercentile = new JButton("Percentile Rank");
		btnPercentile.setForeground(Color.WHITE);
		btnPercentile.setFont(new Font("Dialog", Font.BOLD, 16));
		btnPercentile.setBackground(new Color(128, 0, 128));
		btnPercentile.setBounds(12, 532, 190, 45);
		frame.getContentPane().add(btnPercentile);
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setForeground(new Color(255, 255, 255));
		btnGenerateReport.setFont(new Font("Dialog", Font.BOLD, 16));
		btnGenerateReport.setBackground(new Color(128, 0, 128));
		btnGenerateReport.setBounds(12, 589, 636, 43);
		frame.getContentPane().add(btnGenerateReport);
		
		JButton btnExit = new JButton("Exit Program");
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Dialog", Font.BOLD, 16));
		btnExit.setBackground(new Color(128, 0, 128));
		btnExit.setBounds(12, 644, 190, 45);
		frame.getContentPane().add(btnExit);
		
		JButton btnClearEverything = new JButton("Clear Everything");
		btnClearEverything.setForeground(Color.WHITE);
		btnClearEverything.setFont(new Font("Dialog", Font.BOLD, 16));
		btnClearEverything.setBackground(new Color(128, 0, 128));
		btnClearEverything.setBounds(458, 644, 190, 45);
		frame.getContentPane().add(btnClearEverything);
		
		
		gradeList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				GradeAppGUIMain.this.selectedGrade
					= gradeList.getSelectedIndex();
			}
		});
		
		btnClearEverything.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = "You clicked ClearAll";
				JOptionPane.showMessageDialog(null, msg);
				tfGradeA.setText("90");
				tfGradeB.setText("80");
				tfGradeC.setText("70");
				tfGradeD.setText("60");
				tfGradeF.setText("60");
				lblMinGrade.setText(Float.toString(minimumGrade));
				lblMaxGrade.setText(Float.toString(maximumGrade));
				grades.clear();
			}
		});
	}
}
