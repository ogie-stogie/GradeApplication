
public class Grade {
	
	private float grade;
	private String letterGrade;
	
	public Grade(float gradeInput, String letterGradeInput) {
		this.grade = gradeInput;
		this.letterGrade = letterGradeInput;
	}
	
	public void setGrade(float gradeInput) {
		this.grade = gradeInput;
	}
	
	public void setLetterGrade(String letterGradeInput) {
		this.letterGrade = letterGradeInput;
	}
	
	public float getGrade() {
		return this.grade;
	}
	
	public String getLetterGrade() {
		return this.letterGrade;
	}
	
	public String toString() {
		return String.format("%16.1s%27s", this.getLetterGrade(),
				this.getGrade());
	}
}
