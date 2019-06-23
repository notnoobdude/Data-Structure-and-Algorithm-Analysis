package LabExercises;

/*
 * 			FABRO, DAN NINO I.				BSCPE2A_C1				CoE20
 */

import java.io.IOException;
import java.util.Scanner;

public class Fabro_Array3DMain {
	Scanner num = new Scanner(System.in);					//Built-in java class Scanner instantiated num for input.
	public int option;															//Field for the switch statement inside main menu.	
	Fabro_Array3D array = new Fabro_Array3D();									 //Instantiated Fabro_Array3D as array so that I can have access with the fields and methods
																							//available inside the class Fabro_Array3D itself.
	
	public static void main(String[] args) throws IOException {
		Fabro_Array3DMain arr = new Fabro_Array3DMain();
		System.out.println("A program that can show how the RAM stores 3D array elements depending on the chosen pattern form.");
		arr.userInput();														 //Here, method userInput is called to execute the implementations/statements available in it.
	}
	
	
	public void userInput() throws IOException {
		System.out.println("--------------------------------------ARRAY INPUT---------------------------------------");
		System.out.print("INPUT NUMBER OF ROWS: ");
		Fabro_Array3D.rows = num.nextInt();						 //To access the row field with no error or warnings, I declared in a static way.
		System.out.print("INPUT NUMBER OF COLUMNS: ");
		Fabro_Array3D.columns = num.nextInt();				//The same with rows, I declared the column field in a static way.
		System.out.print("INPUT NUMBER FOR THICKNESS: ");
		Fabro_Array3D.thickness = num.nextInt();				
			
		mainMenu();															 //Here, mainMenu method's statements/implementations are called upon  for execution.
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("");
	}
	
	
	public void mainMenu() throws IOException {
		System.out.println("------------------------------------------MENU------------------------------------------");
 		System.out.println("[1] SHOW ROW-MAJOR(IJK) FORM");					
 		System.out.println("[2] SHOW COLUMN-MAJOR(JIK) FORM");
 		System.out.println("[3] SHOW IKJ FORM");													//Options of user. Displays after integer input for rows, columns, and thickness.
 		System.out.println("[4] SHOW JKI FORM");
 		System.out.println("[5] SHOW KIJ FORM");
 		System.out.println("[6] SHOW KJI FORM");
 		System.out.println("[7] NEW INPUT");
 		System.out.println("[0] exit");
 		System.out.println("");
 		System.out.println("CHOSEN OPTION: ");
 			option = num.nextInt();							 										
 		System.out.println("-------------------------------------------------------------------------------------------");
 		switch(option) 						//The user's option will determine what 3D array form will be displayed. The input here will be stored in field option to determine
 		{												//which task is selected.
 			case 1: 
 					array.ijkList();				 //Executes the row-major/ijk elements and the 'continue-or-not' option found in method ijkList()
 				break;								//instantiated via the instance 'array' accessing it from class Fabro_Array3D.
	 					
	 		case 2: 								//Executes the column-major/jik elements and the 'continue-or-not' option found in method jikList()
 					array.jikList();				//instantiated via the instance 'array' accessing it from class Fabro_Array3D.
 				break;
 					
 			case 3: 
 					array.ikjList();				//Executes the ikj elements and the 'continue-or-not' option found in method ikjList()
 				break;								//instantiated via the instance 'array' accessing it from class Fabro_Array3D.
 					
 			case 4: 
 					array.jkiList();				//Executes the jki elements and the 'continue-or-not' option found in method jkiList()
 				break;								//instantiated via the instance 'array' accessing it from class Fabro_Array3D.
 					
 			case 5: 
 					array.kijList();				//Executes the kij elements and the 'continue-or-not' option found in method kijList()
 				break;								//instantiated via the instance 'array' accessing it from class Fabro_Array3D.
 					
 			case 6: 
 					array.kjiList();				//Executes the kji elements and the 'continue-or-not' option found in method kjiList()
 				break;								//instantiated via the instance 'array' accessing it from class Fabro_Array3D.
 					
 			case 7: 
 					userInput();				//Enables the user to retry the input for rows, columns, and thickness once this option is chosen.
 				break;
 					
 			case 0: 
 					System.exit(0);			//Terminates the program.
 				break;
 					
 			default: 
 					System.out.println("Invalid. Try again.");				//For wrong input.
 		
 			
 			mainMenu();
 		}
	}
	
	
	public int cont() throws IOException {
		System.out.println("");				   
		System.out.println("[1] BACK TO MAIN MENU");
		System.out.println("[2] SEARCH FOR A LOCATION");
		System.out.println("CHOSEN OPTION: ");	
			option = num.nextInt();
																												//This method serves as a bridge between main menu and 'Search location
		switch(option) 																				//of a given position' task. If the user chooses to go back to the main menu for another option,
		{																										//then, he or she is obliged since his or her option returns a value of 1, the program goes back. However, if the	
			case 1: 																						//user wishes to seek a location by entering a given position, then, he is obliged too, the program proceeds to that UI--the
				return 1;																				//process starts by returning 2, calling out method seek(), executing its implementations.
			case 2: 
				return 2;
		   default: 
			    System.out.println("Invalid. Try again."); 								//For wrong input.
			
			
			cont();
		}
		return 0;
	}
	
	
	public void redo(int z) throws IOException {  //local variable y serves as the memory address for the option
		char l;												//local variable
		System.out.println("");					 
		System.out.print("Continue? (y/n): ");						//Asks the user if he or she still wants to proceed.
			l = num.nextLine().charAt(0);									//The user's input will then be stored into the local variable l and will then proceed under the if-else statement below.
			System.out.println("-------------------------------------------------------------------------------------------");
		if (l == 'Y' || l == 'y')
		{
			switch(z)
			{
				case 1: 
					array.ijkList();											//Here, each method is executed whenever the user chooses to continue. 
						break;													//Since Fabro_Array3D class is called through instantiation which in this case is via the instance: array, I gained access of each method inside
																					//Fabro_Array3D. I used it inside this switch statement so that I can eventually use the implementations/statements available inside the given
				case 2: 														//method. Hence, the user can re-do tasks such as going back to the main menu, and perform the 'search the location of an array' task found
					array.jikList();											//inside in these given methods inside the switch statement.
						
				case 3: 
					array.kijList();
						break;
						
				case 4: 
					array.ikjList();
						break;
						
				case 5: 
					array.jkiList();
						break;
						
				case 6: 
					array.kjiList();
						break;
						
				default: 
					System.out.println("Invalid. Try again.");						//For wrong input.
			}
		}
		else if (l == 'N' || l == 'n')
		{
			mainMenu();																//Directs the user back to the main menu.
		}
		else 
		{
			System.out.println("Invalid. Try again.");				//For wrong input.
		redo(z);
		}
	}
}

/*A program that can show how the RAM stores 3D array elements depending on the chosen pattern form. The program starts asking the user to input the number of rows, columns,
and thickness. The input values will then be stored in the memory addresses with regards to its variables. After the input, The main menu UI will be shown displaying the listed options
of the user if he or she wants to see the output of his input in accordance to his chosen 3D array pattern form. This undergoes a switch statement wherein the chosen option of the user
will direct him or her to that specific output. Once the output is displayed, it is observed that there two options to choose, either if the user wants to go back to the main menu and try out
other options or if the user wishes to search for a location of a particular position of a 3D array element. If the user wants to locate a 3D array element, then he or she is directed to input a
specific row, column, and thickness position. The input values will then be used by the 'location-search' methods returning a value equal to the position of the designated 3D array element
shown in the list. However, a condition is set if the whenever the user inputs an invalid integer of a row, column, and thickness position. Furthermore, the user is can still input again the values
after the error is displayed. Once the location of a position is displayed, the program will then ask the user if he or she still wants to continue on searching for a location of a 3D array element
or not. If he or she does, then the list of the specific 3D array element chosen will be displayed together with the two other options. On the other hand, if he or she doesn't want to, then the user
is directed back to the main menu.*/