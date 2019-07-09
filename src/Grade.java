

public class Grade {
	
	private float grade, adjustedGrade;
	private String letterGrade;
	
	public Grade(float gradeInput, String letterGradeInput) {
		this.grade = gradeInput;
		this.letterGrade = letterGradeInput;
		this.adjustedGrade = gradeInput;
	}
	
	public void setGrade(float gradeInput) {
		this.grade = gradeInput;
	}
	
	public void setLetterGrade(String letterGradeInput) {
		this.letterGrade = letterGradeInput;
	}
	
	public void setAdjustedGrade(float adjustedInput) {
		this.adjustedGrade = adjustedInput;
	}
	
	public float getGrade() {
		return this.grade;
	}
	
	public String getLetterGrade() {
		return this.letterGrade;
	}
	
	public float getAdjustedGrade() {
		return this.adjustedGrade;
	}
	
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

