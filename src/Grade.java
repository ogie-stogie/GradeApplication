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
	
vvadodar_edit
	/*	Method name: setAdjustedGrade
	 * 	@param adjustedInput : external value for <adjustedGrade>
	 * 	Description: 	Sets the value of <adjustedGrade> in a Grade object as the 
	 * 					parameter value
	 */
master
	public void setAdjustedGrade(float adjustedInput) {
		this.adjustedGrade = adjustedInput;
	}
vvadodar_edit
	/*	Method name: getGrade()
	 * 	@return this.grade : Returns the value of <grade>
	 * 	Description: Returns the <grade> value of a Grade object
   */
master
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
	
vvadodar_edit
	/*	Method name: getAdjustedGrade()
	 * 	@return this.adjustedGrade : Returns the value of <adjustedGrade>
	 * 	
	 */
 master
	public float getAdjustedGrade() {
		return this.adjustedGrade;
	}
	
vvadodar_edit
	/*	Method name: toString
	 * 	@return strOutput :  returns <grade> and <letterGrade> values
	 * 						 in a specific format for display
	 * 	Description:   Converts the <grade> and <letterGrade> value in a Grade
	 * 				   object to a specific display format
	 */
 master
	public String toString() {
		String strGrade = Float.toString(this.getGrade());
		String strAdjGrade = Float.toString(this.getAdjustedGrade());
		char[] output = new char[44];
		int i = 0;
		for(int j = 0; j < strGrade.length(); j++) {
			output[i] = strGrade.charAt(i);		
			i++;
		}
		while (i < 10) {
			output[i] = '0';
			i++;
		}
		output[11] = ' ';
		output[12] = ' ';
		i += 2;
		
		for(int j = 0; j < strAdjGrade.length(); j++) {
			output[i] = strAdjGrade.charAt(j);
			i++;
		}
		while (i < 22) {
			output[i] = '0';
			i++;
		}
		
		output[23] = ' ';
		output[24] = ' ';
		
		i += 2;
		
		output[25] = this.getLetterGrade().charAt(0);
		System.out.println(i);
		String strOutput = new String(output);
		return strOutput;
		
	}
}
