package stacks3;

/*
 * 				FABRO, DAN NINO I.							BSCpE2A_C1						COE20						Lab Assignment #6
 */


import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolvePostMain {
	
		static Scanner s = new Scanner(System.in);													
		static BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
		static char option;
		
		public static void main(String[] args) throws IOException {
			System.out.println("---------------------------------------------------------------------------------------------------");
			System.out.println("This program shows the numerical value output of the entered postfix expression.");
			System.out.println("Continue? (y/n): ");
			option = s.next().charAt(0);	
				if (option == 'y'||option == 'Y')
				{
					userInput();												//Calls out static method userInput() so that implementations inside it will be executed.
				}
				
				else if (option == 'n'||option == 'N')
				{
					System.exit(0);
				}
				
				else
				{
					System.out.println("Wrong input. Try again.");
				}
		}
		
		public static void userInput() throws IOException {
			String pf;
			PostfixSolve b = new PostfixSolve();
			System.out.println("---------------------------------------------------------------------------------------------------");
			System.out.println("NOTE: Input must have spaces in between.");
			System.out.println("Enter a string for an arithmetic expression: ");
			pf = c.readLine();																												
			System.out.println("");																												
			System.out.println("");																																																			
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
