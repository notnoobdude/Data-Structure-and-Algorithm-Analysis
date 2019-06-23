package prefix;

/*
 * 				FABRO, DAN NINO I.							BSCpE2A_C1						COE20						Lab Assignment #7
 */


import java.io.IOException;
import java.util.Scanner;

public class MainPrefix {
	
	static Scanner s = new Scanner(System.in);												//Built-in java class Scanner instantiated b for input.
	
	static char option;

	public static void main(String[] args) throws IOException {
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("This program converts an infix arithmetic expression into a prefix expression.");
		System.out.println("Continue? (y/n): ");
		option = s.next().charAt(0);	
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

	
	public static void userInput() throws IOException {
		String arithExp;																								//If the string infix input of the user here has a '.', it should be followed by a number. If not
		String pf;																										//preceded, the generated output is incorrect.
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("Input a string for an arithmetic expression: ");
		arithExp = s.next();																						//User enters string input of arithmetic expression here. The string input will then be passed into
		pf = ProcPrefix.convert(arithExp);															   	//the static-defined ProcPrefix class' convert() method. The returned result will be passed back here
		System.out.println("");																					//and is displayed. The result, however, may have spaces in between the operators and operands.
		System.out.println("");																					//Hence, operands having two digits or more are not confused along the process.
		System.out.println("Prefix result: " + pf);												
		
		ask();																												//Calls out method ask()
	}
	
	public static void ask() throws IOException {
		char yesNo;
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.print("\n\nRetry? (y/n): ");
		yesNo = s.next().charAt(0);																			//User inputs here.
    		if ( yesNo == 'y'|| yesNo == 'Y') {                      
    			userInput();																							//This method is simply tasked for the user if he or she still wants to continue or not.
    		}																													//If input is y or Y, user is directed back to userInput() method. However, if n or N, 
    		else if (yesNo == 'n'|| yesNo == 'N') {                 									//terminates the program.
    			System.exit(0);									
    		}
    		else {                                            
    			System.out.println("Invalid input");
    		}
	  }
}