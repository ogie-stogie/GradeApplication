import java.awt.EventQueue;
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
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.NumberFormatter;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.EventQueue;





public class GradeAppGUIMain {

	//Global Variables
	private JFrame frame;
	private JTextField tfGradeF;
	private JLabel lblLowestGradeOutput, lblHighestGradeOutput;
	private JLabel lblMedianGradeOutput, lblAverageGradeOutput;
	private JLabel lblACount, lblBCount, lblCCount;
	private JLabel lblDCount, lblFCount;
	
	private float minimumGrade = 0.0f, maximumGrade = 100.0f;
	private List<Grade> grades = new ArrayList<Grade>();
	private float lowestGrade, highestGrade, medianGrade, averageGrade;
	private float percentA = 90.0f, percentB = 80.0f;
	private float percentC = 70.0f, percentD = 60.0f;
	
	private int countA = 0;
	private int countB = 0;
	private int countC = 0;
	private int countD = 0;
	private int countF = 0;
	
	private List<Float> tempGrades;

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
			}
		});
		
		JTextField tfGradeB = new JTextField();
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
			}
		});
		
		JTextField tfGradeC = new JTextField();
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
			}
		});

		JTextField tfGradeD = new JTextField();
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
			}
		});
		
		tfGradeF = new JTextField();
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
		
		JLabel lblMaxGrade = new JLabel(Float.toString(maximumGrade));
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
		DefaultListModel gradeListModel = new DefaultListModel<>();
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
						gradeListModel.addElement(newGrade.toString());
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
				try {
					JFrame frame = new JFrame("Add Grade");
					String addedGrade 
						= JOptionPane.showInputDialog(frame, "Enter grade: ");
					float gradeInput = Float.parseFloat(addedGrade);
					String letterGradeInput = "A";
					if (GradeAppGUIMain.this.grades == null) {
						GradeAppGUIMain.this.grades = new ArrayList<Grade>();
					}
					Grade newGrade = new Grade(gradeInput,letterGradeInput);
					gradeListModel.addElement(
							newGrade.toString());
					GradeAppGUIMain.this.grades.add(newGrade);
					gradeList.clearSelection();
					updateGradeData();
				}
				catch(NumberFormatException incorrectAddEvent) {
					JOptionPane.showMessageDialog(null, "Incorrect input,"
							+ " value not added");
					 System.err.println("NumberFormatException: " 
							+ incorrectAddEvent.getMessage());
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
					if(GradeAppGUIMain.this.grades != null) {
						GradeAppGUIMain.this.grades.remove(
								gradeList.getSelectedIndex());
						gradeListModel.remove(
								gradeList.getSelectedIndex());
						gradeList.clearSelection();
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
						updateGradeData();
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
						updateGradeData();
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
				maximumGrade = 100;
				
				lblMinGrade.setText(Float.toString(minimumGrade));
				lblMaxGrade.setText(Float.toString(maximumGrade));
				
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
		try {
			averageGrade = 0;
			countA = 0;
			countB = 0;
			countC = 0;
			countD = 0;
			countF = 0;
			
			/*for (int gIndex = 0; gIndex < grades.size(); gIndex++) {
				if (grades.get(gIndex) >= minimumGrade 
					&& grades.get(gIndex) <= maximumGrade) {
					
					tempGrades.add(grades.get(gIndex));
					averageGrade = averageGrade + grades.get(gIndex);
				}
			}
			*/

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
			}
			lblACount.setText(Integer.toString(countA));;
			lblBCount.setText(Integer.toString(countB));;
			lblCCount.setText(Integer.toString(countC));;
			lblDCount.setText(Integer.toString(countD));;
			lblFCount.setText(Integer.toString(countF));;
			
			lowestGrade = tempGrades.get(0);
			highestGrade = tempGrades.get(tempGrades.size()-1);
			medianGrade = tempGrades.get(tempGrades.size()/2);
			averageGrade = averageGrade / tempGrades.size();
			
			lblLowestGradeOutput.setText(Float.toString(lowestGrade));
			lblHighestGradeOutput.setText(Float.toString(highestGrade));
			lblMedianGradeOutput.setText(Float.toString(medianGrade));
			lblAverageGradeOutput.setText(String.format("%.1f", averageGrade));
		}
		catch (NullPointerException error) {
			/*
			 *  NullPointerException occurs if there are no elements
			 *	in the grades ArrayList.
			 */
			
		}
	}	
}
