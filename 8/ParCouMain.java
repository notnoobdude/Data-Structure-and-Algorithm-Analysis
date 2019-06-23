package stacks;

/*
 * 				FABRO, DAN NINO I.								BSCpE2A_C1					COE20						Lab Assignment #4
 */

import java.util.Scanner;
import java.io.IOException;

public class ParCouMain {
	
	static char option;
	
	static Scanner b = new Scanner(System.in); //Built-in java class Scanner instantiated b for input.

	public static void main(String[] args) throws IOException {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("This program determines if an arithmetic expression is valid or not.");
		System.out.println("Continue? (y/n): ");
		option = b.next().charAt(0);	
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
		ParenthesisCount a = new ParenthesisCount();					//Instantiated a as an instance for class ParenthesisCount.
		String arithExp;																			//Field for input string.
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Input a string for an arithmetic expression: ");
		arithExp = b.next();																	//User enters input string here.
			if(a.scan(arithExp) == 0)
			{																									//The entered string input will then be passed to ParenthesisCount for a string check.
					System.out.println("");														
					System.out.println("");
					System.out.println("VALID A.E.");									//Output if the returned value by ParenthesisCount is 0, then the arithmetic expression is valid.	
			}																									
			else
			{
					System.out.println("");
					System.out.println("");
						System.out.println("INVALID A.E.");							//If not, arithmetic expression is invalid.
			}
			
		ask();																								//Calls out method ask()							
	}
	
	public static void ask() throws IOException {
		char  yesNo;
		System.out.println("---------------------------------------------------------------------------");
		System.out.print("\n\nRetry? (y/n): ");
		 yesNo = b.next().charAt(0);														//User inputs here.
    		if (yesNo == 'y'|| yesNo == 'Y')
    		{                      
    			userInput();																			//This method is simply tasked for the user if he or she still wants to continue or not.
    		}																									//If input is y or Y, user is directed back to userInput() method. However, if n or N, 
    		else if (yesNo == 'n'|| yesNo == 'N')										//terminates the program.
    		{                 																					
    			System.exit(0);																	   
    		}
    		else
    		{                                            
    			System.out.println("Invalid input");
    		}
	  }
}
