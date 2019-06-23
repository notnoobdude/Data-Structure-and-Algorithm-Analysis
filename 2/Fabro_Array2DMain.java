package LabExercises;

/*
 * 			FABRO, DAN NINO I.				BSCPE2A_C1				CoE20
 */



import java.io.IOException;
import java.util.Scanner;

public class Fabro_Array2DMain {
	
	Scanner num = new Scanner(System.in); //For input.
	public int option; //Field for the switch statement inside main menu.
	Fabro_Array2D array = new Fabro_Array2D(); //Instantiated Fabro_Array2D as array so that I can have access with the fields and methods 
								  //available inside the class Fabro_Array2D itself.
	public static void main(String[] args) throws IOException {
		Main2D arr = new Main2D();
		System.out.println("A program that can show how the RAM stores array elements depending on the chosen pattern form.");
			arr.userInput(); //Here, method userInput is called to execute the implementations/statements available in it.
	}
	
	public void userInput() throws IOException {
		System.out.println("");
		System.out.println("");
		System.out.println("----------------------------------------ARRAY INPUT----------------------------------------");
		System.out.print("INPUT NUMBER OF ROWS: ");
			Fabro_Array2D.rows = num.nextInt(); //To access the row field with no error or warnings, I declared in a static way.
		System.out.print("INPUT NUMBER OF COLUMNS: ");
			Fabro_Array2D.columns = num.nextInt(); //The same with rows, I declared the column field in a static way.
		mainMenu(); //Here, mainMenu method's statements/implementations are called upon  for execution.
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("");
	}
	
	public void mainMenu() throws IOException {
		System.out.println("--------------------------------------------MENU-------------------------------------------");
		System.out.println("[1] SHOW ROW-MAJOR FORM");
		System.out.println("[2] SHOW COLUMN-MAJOR FORM"); //Options of user.
		System.out.println("[3] NEW INPUT");
 		System.out.println("[4] exit");
 		System.out.println("");
 		System.out.println("CHOOSE: ");
 			option = num.nextInt();
 		System.out.println("-------------------------------------------------------------------------------------------");
 		switch(option)
 		{
 			case 1: 
 					array.rmList(); //Executes the row-major elements and the 'continue-or-not' option found in rmList() 
 				break;				//instantiated via the instance 'array' accessing it from class Fabro_Array2D.
 				
 			case 2: 
 					array.cmList(); //Executes the column-major elements and the 'continue-or-not' option found in cmList()
 				break;				//instantiated via the instance 'array' accessing it from class Fabro_Array2D.
 				
 			case 3: 
 					userInput(); 	//Enables the user to retry the input once this option is chosen.
 				break;
 				
 			case 4: 
 					System.exit(0);		//Terminates the program.
 				break;
 				
 		default: 
 					System.out.println("Invalid. Try again.");
 					
 		  mainMenu();
 		}
 	}
	

	
	public void redo(int z) throws IOException {
		char l; //local variable					
		System.out.println("");					 
		System.out.print("Continue? (y/n): ");	  
		l = num.nextLine().charAt(0);
		System.out.println("-------------------------------------------------------------------------------------------");
		if (l == 'Y'||l == 'y')
			{
			switch(z)
				{
				case 1: 
						array.rmList();		//Executes the method rmList() via instantiation.
				  break;
				
				case 2: 
						array.cmList();	    //Executes the method cmList() via instantiation.
			      break;
			    
				default: 
						System.out.println("Invalid. Try again.");   //Warns the user's error.
				}
			}
		else if (l == 'N'||l == 'n')
			{
				mainMenu();						//Directs the user back to the main menu.
			}
			
		else 
			{
				System.out.println("Invalid. Try again.");		//For wrong input.
					redo(z);
			}
		
		}
	
	
	public int cont() throws IOException {	  
		System.out.println("");				   
		System.out.println("[1] BACK TO MAIN MENU");
		System.out.println("[2] SEARCH FOR LOCATION");
		option = num.nextInt();
		
		switch(option) 				//This method serves as a bridge between main menu and 'Search location 
		{							//of a given position' task. If the user chooses to go back to main menu for another option,
			case 1: 				//then, he or she is obliged since his or her option returns a value of 1. However, if the
					return 1;		//user wishes to seek a location by entering a given position, then, he is obliged too--the
			case 2: 				//process starts by returning 2, calling out the method seek(), executing its implementations.
					return 2;
			default: 
					System.out.println("Invalid. Try again.");
					
		cont();
		}
		return 0;
	}
	
}

