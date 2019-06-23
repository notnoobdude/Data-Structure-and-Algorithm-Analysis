package fabro;

import java.io.IOException;
import java.util.Scanner;

/*
 * FABRO, DAN NINO I.				BSCpE2a_c1					#12 Lab Exercise/Assignment
 */


public class Fabro_Main {
	static Scanner s = new Scanner(System.in);												//Built-in java class Scanner instantiated b for input.
	static char option;
	
	public static void main(String[] args) throws IOException {
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\t    This program outputs the value of the root or the value of the input mathematical expression.");
		userInput();
	}
	
	public static void userInput(){
		Fabro_ET et = new Fabro_ET();																								
		float result;								
		String equation;
		try{
		do{
		System.out.println("");																					
		System.out.println("");
		System.out.println("Input a string for an arithmetic expression: ");
		equation = s.nextLine();											//User inputs here.
		et.createTree(Fabro_Prefix.convert(equation));
		result = et.evaluate();
		System.out.println("");																					
		System.out.println("");																			
		System.out.println("Result: " + result);												
		}
		while(ask());
		} catch(EmptyStackException e){
			e.printStackTrace();
		}
	  }
	
	public static boolean ask() {
	try{	
		while(true) {
			System.out.println("------------------------------------------------------------------------------------------------------------------------");
			System.out.print("\n\nRetry? (y/n): ");
			option = s.next().charAt(0);
			switch(option) {
			case 'Y':
				return true;
			case 'y':
				return true;
			case 'N':
				return false;
			case 'n':
				return false;
			default:
				System.out.println("Invalid input.");
				break;
	  }
	}
	}catch (EmptyStackException e){
		e.printStackTrace();
	}
	return false;
  }
}
