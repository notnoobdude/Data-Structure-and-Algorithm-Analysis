package coe20_LabExercises;

/*
 * FABRO, DAN NINO I.			BSCpE2A_C1				#11 Laboratory Exercise
 */

public class FreshmanApplicant {
	public String applicantNo, name, highSchool;
	public int science_Score, math_Score, english_Score;
	public static int science_Total, math_Total, english_Total; 		//Fields for specific subjects' total score
	public static double science_Percent = 0.30, math_Percent = 0.40, english_Percent = 0.30; //Percentages equating to 1.00 
	public double science_Grade, math_Grade, english_Grade, overall_Grade;		//Fields for grades of the student applicant on major subjects after computation
	
	public FreshmanApplicant(String no, String n, String hs, int sciS, int sciTotal, int matS, int mathTotal, int engS, int engTotal) {
		applicantNo = no;
		name = n;
		highSchool = hs;
		science_Score = sciS;
		science_Total = sciTotal;
		math_Score = matS;
		math_Total = mathTotal;
		english_Score = engS;
		english_Total = engTotal;
		setGrades();
	}
	
	private void setGrades() {				//Method calculating the specific subjects' grades, multiplies with the given percentages, and sums it all up for the overall grade.
		science_Grade = 23.0/3.0 - ((20.0 * science_Score) / (3.0 * science_Total)); //this is the 70 percent passing formula
		math_Grade    = 23.0/3.0 - ((20.0 * math_Score) / (3.0 * math_Total)); //this is the 70 percent passing formula
		english_Grade = 23.0/3.0 - ((20.0 * english_Score) / (3.0 * english_Total)); //this is the 70 percent passing formula
		overall_Grade = science_Percent * science_Grade + math_Percent * math_Grade + english_Percent * english_Grade;
	}
}
