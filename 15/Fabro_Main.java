package coe20_LabExercises;

/*
 * FABRO, DAN NINO I.			BSCpE2A_C1				#11 Laboratory Exercise
 */

import java.io.*;
import java.util.Scanner;

public class Fabro_Main {

	private static BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
	private static Fabro_DLL dll = new Fabro_DLL();
	static char option;	
	static Scanner z = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("This program is primarily for student application management which can be used to evaluate incoming freshman students.");
		System.out.println("Continue? (y/n): ");
		option = z.next().charAt(0);	
			if (option == 'y'||option == 'Y')
			{
				userInput();												//Calls out static method userInput() so that implementations inside it will be executed.
			}
			
			else if (option == 'n'||option == 'N')
			{
				System.exit(0);											//Terminates the program.
			}
			
			else
			{
				System.out.println("Wrong input. Try again.");				//For error
			}
	}
	
	public static void userInput() throws IOException { 		//Called out by the main method
		while(true) {
			System.out.println("");
			System.out.println("								MAIN MENU								");
			System.out.println("[1] ADD AN APPLICANT");
			System.out.println("[2] DELETE AN APPLICANT");
			System.out.println("[3] DISPLAY ALL APPLICANTS");
			System.out.println("[4] DISPLAY HIGHEST OVERALL GRADE");
			System.out.println("[5] DISPLAY LOWEST OVERALL GRADE");
			System.out.println("[6] SHOW THE BEST IN SCIENCE STUDENT");
			System.out.println("[7] SHOW THE BEST IN MATH STUDENT");
			System.out.println("[8] SHOW THE BEST IN MATH STUDENT");
			System.out.println("[0] exit");
			System.out.println("choice: ");
			int option = Integer.parseInt(b.readLine());
			switch(option) {
			case 0:
				System.exit(0);	;
			case 1:
				addApplicant();
				break;
			case 2:
				deleteApplicant();
				break;
			case 3:
				showAllApplicants();
				break;
			case 4:
				showHighestGrade();
				break;
			case 5:
				showLowestGrade();
				break;
			case 6:
				showBestinSci();
				break;
			case 7:
				showBestinMath();
				break;
			case 8:
				showBestinEng();
				break;
			default:
				System.out.println("Error! Please try again.");
			}
		}
	}
	
	
	public static void addApplicant() throws IOException {
		System.out.println("");
		System.out.println("");
		System.out.println("Add an applicant.");
		System.out.print("Applicant No.: ");
		String id = b.readLine();
		System.out.print("Name: ");											//Basically, this method asks the user for info fields and then creates
		String name = b.readLine();											//a new applicant then stores it in the list.
		System.out.print("High School: ");
		String hs = b.readLine();
		System.out.print("Enter acquired Science score: ");
		int sci = Integer.parseInt(b.readLine());
		System.out.print("Enter Science total: ");
		int sciTot = Integer.parseInt(b.readLine());
		System.out.print("Enter acquired Math score: ");
		int mat = Integer.parseInt(b.readLine());
		System.out.print("Enter Math total: ");
		int matTot = Integer.parseInt(b.readLine());
		System.out.print("Enter acquired English score: ");
		int eng = Integer.parseInt(b.readLine());
		System.out.print("Enter English total: ");
		int engTot = Integer.parseInt(b.readLine());
		FreshmanApplicant newest = new FreshmanApplicant(id, name, hs, sci, sciTot, mat, matTot, eng, engTot);
		dll.addLast(newest);
		System.out.println("");
	}
	
	
	public static void deleteApplicant() throws IOException {		//Method that can delete an applicant via applicant no. search
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Delete an applicant.");
		showAllApplicants();								
		System.out.println("");
		System.out.println("Enter applicant no. to be deleted: ");
		String choice = b.readLine();
		int index = searchAppNo(choice);
		if(index == -1) {
			System.out.println("");
			System.out.println("Applicant not found.");
			System.out.println("");
			return;
		}
		dll.removeAt(index);
		System.out.println("");
	}
	
	
	public static void showAllApplicants() {				//Displays all entered applicants.
		System.out.println("");
		sortList();
		System.out.printf("%-10s %-30s %-30s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "Applic. No", "Name", "High School", "Sci score", "Math score", "Eng score", "Sci grade", "Math grade", "Eng grade", "Overall grade");
		for(int i = 0; i < dll.size(); i++) {
			System.out.printf("%-10s %-30s %-30s %-15d %-15d %-15d %-15.2f %-15.2f %-15.2f %-15.2f\n", dll.elementAt(i).applicantNo, dll.elementAt(i).name, dll.elementAt(i).highSchool, dll.elementAt(i).science_Score, dll.elementAt(i).math_Score, dll.elementAt(i).english_Score, dll.elementAt(i).science_Grade, dll.elementAt(i).math_Grade, dll.elementAt(i).english_Grade, dll.elementAt(i).overall_Grade);
		}
		System.out.println("");
	}
	
	
	public static void showHighestGrade() {					//Shows the student with the highest overall grade.
		System.out.println("");
		double highest = getHighest();
		System.out.printf("%-10s %-30s %-30s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "Applic. No", "Name", "High School", "Sci score", "Math score", "Eng score", "Sci grade", "Math grade", "Eng grade", "Overall grade");
		for(int i = 0; i < dll.size(); i++) {
			if(highest == dll.elementAt(i).overall_Grade)
				System.out.printf("%-10s %-30s %-30s %-15d %-15d %-15d %-15.2f %-15.2f %-15.2f %-15.2f\n", dll.elementAt(i).applicantNo, dll.elementAt(i).name, dll.elementAt(i).highSchool, dll.elementAt(i).science_Score, dll.elementAt(i).math_Score, dll.elementAt(i).english_Score, dll.elementAt(i).science_Grade, dll.elementAt(i).math_Grade, dll.elementAt(i).english_Grade, dll.elementAt(i).overall_Grade);
		}
		System.out.println("");
	}
	
	
	public static void showLowestGrade() {					//Shows the student with the lowest overall grade.
		double lowest = getLowest();
		System.out.println("");
		System.out.printf("%-10s %-30s %-30s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "Applic. No", "Name", "High School", "Sci score", "Math score", "Eng score", "Sci grade", "Math grade", "Eng grade", "Overall grade");
		for(int i = 0; i < dll.size(); i++) {
			if(lowest == dll.elementAt(i).overall_Grade)
				System.out.printf("%-10s %-30s %-30s %-15d %-15d %-15d %-15.2f %-15.2f %-15.2f %-15.2f\n", dll.elementAt(i).applicantNo, dll.elementAt(i).name, dll.elementAt(i).highSchool, dll.elementAt(i).science_Score, dll.elementAt(i).math_Score, dll.elementAt(i).english_Score, dll.elementAt(i).science_Grade, dll.elementAt(i).math_Grade, dll.elementAt(i).english_Grade, dll.elementAt(i).overall_Grade);
		}
		System.out.println("");
	}
	
	
	public static void showBestinSci() {					//Shows the students who are best in Science.
		double highest = getHighestSci();
		System.out.println("");
		System.out.printf("%-10s %-30s %-30s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "Applic. No", "Name", "High School", "Sci score", "Math score", "Eng score", "Sci grade", "Math grade", "Eng grade", "Overall grade");
		for(int i = 0; i < dll.size(); i++) {
			if(highest == dll.elementAt(i).science_Grade)
				System.out.printf("%-10s %-30s %-30s %-15d %-15d %-15d %-15.2f %-15.2f %-15.2f %-15.2f\n", dll.elementAt(i).applicantNo, dll.elementAt(i).name, dll.elementAt(i).highSchool, dll.elementAt(i).science_Score, dll.elementAt(i).math_Score, dll.elementAt(i).english_Score, dll.elementAt(i).science_Grade, dll.elementAt(i).math_Grade, dll.elementAt(i).english_Grade, dll.elementAt(i).overall_Grade);
		}
		System.out.println("");
	}
	

	public static void showBestinMath() {					//Shows the students who are best in Math.
		double highest = getHighestMath();
		System.out.println("");
		System.out.printf("%-10s %-30s %-30s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "Applic. No", "Name", "High School", "Sci score", "Math score", "Eng score", "Sci grade", "Math grade", "Eng grade", "Overall grade");
		for(int i = 0; i < dll.size(); i++) {
			if(highest == dll.elementAt(i).math_Grade)
				System.out.printf("%-10s %-30s %-30s %-15d %-15d %-15d %-15.2f %-15.2f %-15.2f %-15.2f\n", dll.elementAt(i).applicantNo, dll.elementAt(i).name, dll.elementAt(i).highSchool, dll.elementAt(i).science_Score, dll.elementAt(i).math_Score, dll.elementAt(i).english_Score, dll.elementAt(i).science_Grade, dll.elementAt(i).math_Grade, dll.elementAt(i).english_Grade, dll.elementAt(i).overall_Grade);
		}
		System.out.println("");
	}
	
	
	public static void showBestinEng() {					//Shows the students who are best in English.
		double highest = getHighestEng();
		System.out.println("");
		System.out.printf("%-10s %-30s %-30s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "Applic. No", "Name", "High School", "Sci score", "Math score", "Eng score", "Sci grade", "Math grade", "Eng grade", "Overall grade");
		for(int i = 0; i < dll.size(); i++) {
			if(highest == dll.elementAt(i).english_Grade)
				System.out.printf("%-10s %-30s %-30s %-15d %-15d %-15d %-15.2f %-15.2f %-15.2f %-15.2f\n", dll.elementAt(i).applicantNo, dll.elementAt(i).name, dll.elementAt(i).highSchool, dll.elementAt(i).science_Score, dll.elementAt(i).math_Score, dll.elementAt(i).english_Score, dll.elementAt(i).science_Grade, dll.elementAt(i).math_Grade, dll.elementAt(i).english_Grade, dll.elementAt(i).overall_Grade);
		}
		System.out.println("");
	}
	
	
	private static void sortList() {							//Sorts the list using Selection sort.
		for(int i = 0; i < dll.size(); i++) {
			int index = i;
			for(int j = i + 1; j < dll.size(); j++) {
				if(Long.parseLong(dll.elementAt(j).applicantNo) < Long.parseLong(dll.elementAt(index).applicantNo))
					index = j;   
			}
			dll.swap(i, index); 
		}
	}
	
	
	private static int searchAppNo(String app) {							//Seeks for the applicant no. indicated by the user and returns its index.
		for(int i = 0; i < dll.size(); i++) {
			if(app.equals(dll.elementAt(i).applicantNo))
				return i;
		}
		return -1;
	}
	
	
	private static double getHighest() {									//Finds the highest overall grade then returns it.
		int index = 0;
		for(int i = 0; i < dll.size();) {
			index = i;
			for(int j = i + 1; j < dll.size(); j++)
				if(dll.elementAt(j).overall_Grade < dll.elementAt(index).overall_Grade)  
					index = j;
			break;
		}
		return dll.elementAt(index).overall_Grade;
	}
	
	
	private static double getLowest() {										//Finds the lowest overall grade then returns it.
		int index = 0;
		for(int i = 0; i < dll.size();) {
			index = i;
			for(int j = i + 1; j < dll.size(); j++)
				if(dll.elementAt(j).overall_Grade > dll.elementAt(index).overall_Grade)
					index = j;
			break;
		}
		return dll.elementAt(index).overall_Grade;
	}
	
	
	private static double getHighestSci() {									//Finds the highest Science grade then returns it.
		int index = 0;
		for(int i = 0; i < dll.size();) {
			index = i;
			for(int j = i + 1; j < dll.size(); j++)
				if(dll.elementAt(j).science_Grade < dll.elementAt(index).science_Grade)
					index = j;
			break;
		}
		return dll.elementAt(index).science_Grade;
	}
	
	
	private static double getHighestMath() {								//Finds the highest Math grade then returns it.
		int index = 0;
		for(int i = 0; i < dll.size();) {
			index = i;
			for(int j = i + 1; j < dll.size(); j++)
				if(dll.elementAt(j).math_Grade < dll.elementAt(index).math_Grade)
					index = j;
			break;
		}
		return dll.elementAt(index).math_Grade;
	}
	
	
	private static double getHighestEng() {									//Finds the highest English grade then returns it.
		int index = 0;
		for(int i = 0; i < dll.size();) {
			index = i;
			for(int j = i + 1; j < dll.size(); j++)
				if(dll.elementAt(j).english_Grade < dll.elementAt(index).english_Grade)
					index = j;
			break;
		}
		return dll.elementAt(index).english_Grade;
	}

}
