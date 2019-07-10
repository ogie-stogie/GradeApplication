/*	Names: Taylor Bart, Vipul Vadodaria, Benjamin Veach
 * 	Class ID: 41792
 * 	Grading Analytics System
 * 	Description:	This class is paired with the GradeAppGUIMain.java file
 * 
 * 					This class contains two private float variables, a private string
 * 					variable, and eight methods
 * 
 * 					This class stores and gives input grades for use in the 
 * 					main class
 * 
 *	This class contains a two private float variables, a private string
 * 	variable, and eight methods:
 * 
 * 	<float grade>
 * 	Variable to hold the number of the grade
 * 
 * 	<String letterGrade>
 * 	Variable to hold the alphabetical value of the grade
 * 
 * 	<Grade(float gradeInput, String letterGradeInput)
 * 	Constructor to create a Grade object with <grade> and <letterGrade> values
 * 
 * 	<setGrade(float gradeInput)>
 * 	Sets the grade to the parameter value when called
 * 
 * 	<setLetterGrade(String letterGradeInput)>
 * 	Sets the alphabetical value of the grade to the parameter when called
 * 
 * 	<setAdjustedGrade(float adjustedInput)>
 * 	Sets the adjusted grade value to the parameter when called
 * 
 * 	<getGrade()>
 * 	Obtains the <grade> of the Grade object
 * 
 * 	<getLetterGrade()>
 * 	Obtains the <letterGrade> of the Grade object
 * 
 * 	<getAdjustedGrade()
 * 	Obtains the <adjustedGrade> of the Grade object
 * 
 * 	<toString()>
 * 	Converts Grade data to specific format for display purposes
 */

/**
 * This class is used to define the object Grade.
 * The grade score, letter grade and adjusted grade can be set/get from here.
 * Contains a toString method that returns the grade, adjusted grade and
 * letter grade.
 * @authors Taylor Bart, Vipul Vadodaria, Benjamin Veach 
 * @version 100
 */

public class Grade {
	
	private float grade, adjustedGrade;
	private String letterGrade;
	
	/**Description:	Sets the grade and letterGrade values of a Grade object
	 * 	to the parameter values
	 * 	@param gradeInput new grade value to change grade to
	 * 	@param letterGradeInput new letter grade value to change letterGrade to
	 */
	public Grade(float gradeInput, String letterGradeInput) {
		this.grade = gradeInput;
		this.letterGrade = letterGradeInput;
		this.adjustedGrade = gradeInput;
	}
	
	/**	Description: Sets the value of grade in a Grade object as the parameter
	 * 	value
	 * 	@param gradeInput External value for grade
	 */
	public void setGrade(float gradeInput) {
		this.grade = gradeInput;
	}
	
	/**Description:	Sets the value of letterGrade in a Grade object as the 
	 * 					parameter value
	 * 	@param letterGradeInput External value for letterGrade
	 */
	public void setLetterGrade(String letterGradeInput) {
		this.letterGrade = letterGradeInput;
	}
	
	/**	Description: Sets the value of adjustedGrade in a Grade object as the 
	 * 	parameter value
	 * 	@param adjustedInput external value for adjustedGrade
	 */
	public void setAdjustedGrade(float adjustedInput) {
		this.adjustedGrade = adjustedInput;
	}
	
	/**	Description: Returns the grade value of a Grade object
	 * 	@return grade
	 */
	public float getGrade() {
		return this.grade;
	}
	
	/**	Description: Returns the letterGrade value of a Grade object
	 * 	@return letterGrade
	 * 
	 */
	public String getLetterGrade() {
		return this.letterGrade;
	}
	
	/**	Description: Returns the adjustedGrade value of a Grade object
	 * 	@return adjustedGrade 	
	 */
	public float getAdjustedGrade() {
		return this.adjustedGrade;
	}
	
	/** Description: Converts the grade, adjustedGrade and letterGrade value
	 *  in a Grade object to a specific display format
	 * 	@return output 	
	 */
	public String toString() {
		String output = String.format("%-10.2f%10.2f%10s",this.getGrade(),
				this.getAdjustedGrade(),this.getLetterGrade());	
		return output;
	}
}