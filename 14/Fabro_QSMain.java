package coe20;

/*
 * FABRO, DAN NINO I.				BSCpE2A_C1			COE20				Lab Assignment #10
 */

import java.util.Scanner;
import java.io.IOException;

public class Fabro_QSMain {
	
	static char option;
	
	static Scanner b = new Scanner(System.in); 	//Built-in java class Scanner instantiated b for input.

	public static int[] arr;

	public static void main(String[] args) throws IOException {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("This program enables sorting of integer numbers via quick sort.");
		System.out.println("Continue? (y/n): ");
		option = b.next().charAt(0);	
			if (option == 'y'||option == 'Y')
			{
				userInput();												//Calls out static method userInput() so that implementations inside it will be executed.
			}
			
			else if (option == 'n'||option == 'N')
			{
				System.exit(0);												//Terminates the program.
			}
			
			else
			{
				System.out.println("Wrong input. Try again.");				//For error.
			}
			
	}
	
	public static void userInput() throws IOException {
		int num, i;
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Enter number of integer numbers to be sorted: ");
		num = b.nextInt();										//The user enters number of elements and is stored in field num.
		
		int array[] = new int[num];								//An array is made with the num elements.
		
		System.out.println("\nEnter "+num+" integer numbers: ");	//User is asked to input the elements depending on his or her entered number of elements.
		for(i = 0; i<num; i++)				//Index i is initialized at zero having a condition to stop the loop at the number of elements input and is then incremented.	
			array[i] = b.nextInt();			//Each integer element entered will be passed into QuickSort class' sort(array) method.
		Fabro_QuickSort.sort(array);
		
		
		System.out.println("");
		System.out.println("\nSorted elements: ");		//Sorted output will be displayed here.
		for(i = 0;i<num;i++)																//The sorted elements will also be displayed in a looping process which was based out from user's input on the number of elements
			System.out.println(array[i] + " ");
			System.out.println();
		
			
		ask();											//Calls out method ask()							
	}
	
	public static void ask() throws IOException {
		char  yesNo;
		System.out.println("---------------------------------------------------------------------------");
		System.out.print("\n\nRetry? (y/n): ");
		 yesNo = b.next().charAt(0);													//User enters here.
    		if (yesNo == 'y'|| yesNo == 'Y')
    		{                      
    			userInput();															//This method is simply tasked for the user if he or she still wants to continue or not.
    		}																					//If input is y or Y, user is directed back to userInput() method. However, if n or N, 
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
