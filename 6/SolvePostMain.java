package stacks;

/*
 * 				FABRO, DAN NINO I.							BSCpE2A_C1						COE20						Lab Assignment #6
 */


import java.util.Scanner;
import java.io.IOException;

public class SolvePostMain {
	
		static Scanner s = new Scanner(System.in);													//Built-in java class Scanner instantiated b for input.
		
		public static void main(String[] args) throws IOException {
			System.out.println("---------------------------------------------------------------------------------------------------");
			System.out.println("This program shows the numerical value output of the entered postfix expression.");
			userInput();																									//Calls out static method userInput() so that implementations inside it will be executed.
		}
		
		public static void userInput() throws IOException {
			String arithExp;
			String pf;
			 InfixtoPostfix2 a = new InfixtoPostfix2();
			PostfixSolve b = new PostfixSolve();
			System.out.println("---------------------------------------------------------------------------------------------------");
			System.out.println("NOTE: Input must be in infix form. It will automatically be converted to postfix.");
			System.out.println("Enter a string for an arithmetic expression: ");
			arithExp = s.next();																												
			System.out.println("");																												
			System.out.println("");																												//The postfix result will eventually be passed into the instantiated PostfixSolve class for it to be
			pf = a.convert(arithExp);																											//identified and solved into a numerical value and that numerical value will then be passed back
			System.out.println("Postfix result: " + pf);																			//here for display.
			System.out.println("Numerical value result: " + b.solve(pf));											
			
			ask();																																			//Calls out method ask()
		}

		public static void ask() throws IOException {
			char yesNo;
			System.out.println("---------------------------------------------------------------------------------------------------");
			System.out.print("\n\nRetry? (y/n): ");
			yesNo = s.next().charAt(0);																										//User inputs here.
	    		if ( yesNo == 'y'|| yesNo == 'Y') {                      
	    			userInput();																														//This method is simply tasked for the user if he or she still wants to continue or not.
	    		}																																				//If input is y or Y, user is directed back to userInput() method. However, if n or N, 
	    		else if (yesNo == 'n'|| yesNo == 'N') {                 																//terminates the program.
	    			System.exit(0);									
	    		}
	    		else {                                            
	    			System.out.println("Invalid input");
	    		}
		  }
		
}
