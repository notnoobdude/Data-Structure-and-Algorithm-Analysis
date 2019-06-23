package coe20_LabExer;
/*
 * FABRO, DAN NINO I.					BSCpE2A_C1					COE20 Lab Exercise 9
 */


import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Fabro_PolAdd{
	
	static Scanner s = new Scanner(System.in);	//Built-in Scanner class for input purposes.
	static char option;
    public static void main(String args[])throws IOException
    {
    	System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("This program adds two polynomial inputs.");
		System.out.println("Continue? (y/n): ");
		option = s.next().charAt(0);	
			if (option == 'y'||option == 'Y')
			{
				userInput();							//Calls out static method userInput() so that implementations inside it will be executed.
			}
			
			else if (option == 'n'||option == 'N')
			{
				System.exit(0);						//Terminates the program if the user wanted to.
			}
			
			else
			{
				System.out.println("Wrong input. Try again.");			//For error
			}
	}
    	
    //Workspace compliance should be JRE 5.0 and above	
	@SuppressWarnings("deprecation")			//To suppress available deprecation warnings in this block of code.
	public static void userInput() throws IOException {
        
        DataInputStream inp = new DataInputStream(System.in);
        int num,co,ex,ey;
        	Fabro_Polynomials pol1 = new Fabro_Polynomials();   	//Class Fabro_Polynomials is instantiated as pol1 for polynomial 1.
        	Fabro_Polynomials pol2 = new Fabro_Polynomials();		//Class Fabro_Polynomials is instantiated as pol2 for polynomial 2.
        	Fabro_Polynomials pol3 = new Fabro_Polynomials();		//Class Fabro_Polynomials is instantiated as pol3 for the combination of both polynomials 1 and 2.
            System.out.println("");
            System.out.println("Enter the no. of terms of 1st polynomial: ");
            num=Integer.parseInt(inp.readLine());		//Input will be stored in num
            while(num!=0)		//This block of code will be iterated until the number of inputs marked as the condition for this while loop will be false.
            {
            	System.out.println("---------------------------------------------------------------------------------------------------");
                System.out.println("Enter the coefficent: ");
                co=Integer.parseInt(inp.readLine());
                System.out.println("Enter the exponent x: ");		//The user will input coefficients of each terms depending on the entered number of input for the first polynomial.
                ex=Integer.parseInt(inp.readLine());
                System.out.println("Enter the exponent y: ");
                ey=Integer.parseInt(inp.readLine());
                if(pol1.insert(co, ex, ey)){
                	num--;
                }
                System.out.println("---------------------------------------------------------------------------------------------------");
            }
            
            System.out.println("Enter the no. of terms of 2nd polynomial");		
            num=Integer.parseInt(inp.readLine());		//Input will be stored in num
            while(num!=0)			//This block of code will be iterated until the number of inputs marked as the condition for this while loop will be false.
            {
            	System.out.println("---------------------------------------------------------------------------------------------------");
                System.out.println("Enter the coefficent: ");
                co=Integer.parseInt(inp.readLine());
                System.out.println("Enter the exponent x: ");	//The same process with polynomial 1.	
                ex=Integer.parseInt(inp.readLine());
                System.out.println("Enter the exponent y: ");
                ey=Integer.parseInt(inp.readLine());
                if (pol2.insert(co, ex, ey)){
                	num--;
                }
                System.out.println("---------------------------------------------------------------------------------------------------");
            }
            System.out.println("---------------------------------------------------------------------------------------------------");
            System.out.println("1st Polynomial:  ");		//The 1st polynomial will be displayed here.
            pol1.showPolynomial();					
            System.out.println("2nd Polynomial:  ");		//The 2nd polynomial will be displayed here.
            pol2.showPolynomial();
            pol3.addition(pol1,pol2);
            System.out.println("");
            System.out.println("Result: ");				//The result of both 1st and second polynomials will be displayed here.
            pol3.showPolynomial();
            
            ask();			//Calls method ask();
        }

public static void ask() throws IOException {
	char yesNo;
	System.out.println("---------------------------------------------------------------------------------------------------");
	System.out.print("\n\nRetry? (y/n): ");
	yesNo = s.next().charAt(0);												//User inputs here.
		if (yesNo == 'y'|| yesNo == 'Y') {                      
			userInput();													//This method is simply tasked for the user if he or she still wants to continue or not.
		}																	//If input is y or Y, user is directed back to userInput() method. However, if n or N, 
		else if (yesNo == 'n'|| yesNo == 'N') {                 			//terminates the program.
			System.exit(0);									
		}
		else {                                            
			System.out.println("Invalid input.");
		}
  }
    }
