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

public class Grade {
	
	private float grade, adjustedGrade;
	private String letterGrade;
	
	/*	Method name: Grade
	 * 	@param gradeInput: new grade value to change <grade> to
	 * 	@param letterGradeInput: new letter grade value to change <letterGrade> to
	 * 	Description:	Sets the <grade> and <letterGrade> values of a Grade object
	 * 					to the parameter values
	 */
	public Grade(float gradeInput, String letterGradeInput) {
		this.grade = gradeInput;
		this.letterGrade = letterGradeInput;
		this.adjustedGrade = gradeInput;
	}
	
	/*	Method name: setGrade
	 * 	@param gradeInput : External value for <grade>
	 * 	Description: 	Sets the value of <grade> in a Grade object as the parameter
	 * 				 	value
	 */
	public void setGrade(float gradeInput) {
		this.grade = gradeInput;
	}
	
	/*	Method name: setLetterGrade
	 * 	@param letterGradeInput : External value for <letterGrade>
	 * 	Description:	Sets the value of <letterGrade> in a Grade object as the 
	 * 					parameter value
	 */
	public void setLetterGrade(String letterGradeInput) {
		this.letterGrade = letterGradeInput;
	}
	
	/*	Method name: setAdjustedGrade
	 * 	@param adjustedInput : external value for <adjustedGrade>
	 * 	Description: 	Sets the value of <adjustedGrade> in a Grade object as the 
	 * 					parameter value
	 */
	public void setAdjustedGrade(float adjustedInput) {
		this.adjustedGrade = adjustedInput;
	}
	
	/*	Method name: getGrade()
	 * 	@return this.grade : Returns the value of <grade>
	 * 	Description: Returns the <grade> value of a Grade object
   */
	public float getGrade() {
		return this.grade;
	}
	
	/*	Method name: getLetterGrade()
	 * 	@return this.letterGrade : Returns the value of <letterGrade>
	 * 	Description: Returns the <letterGrade> value of a Grade object
	 */
	public String getLetterGrade() {
		return this.letterGrade;
	}
	
	/*	Method name: getAdjustedGrade()
	 * 	@return this.adjustedGrade : Returns the value of <adjustedGrade>
	 * 	
	 */
	public float getAdjustedGrade() {
		return this.adjustedGrade;
	}
	
	/*	Method name: toString
	 * 	@return strOutput :  returns <grade> and <letterGrade> values
	 * 						 in a specific format for display
	 * 	Description:   Converts the <grade> and <letterGrade> value in a Grade
	 * 				   object to a specific display format
	 */
	public String toString() {
		String output = String.format("%-10.2f%10.2f%10s",this.getGrade(),
				this.getAdjustedGrade(),this.getLetterGrade());	
		return output;
	}
}
