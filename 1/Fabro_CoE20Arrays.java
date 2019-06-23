package LaboratoryAssignment;

/*
 * 		FABRO, DAN NINO I. 			BSCpE2A_C1		COE20
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Fabro_CoE20Arrays {

	static Scanner s = new Scanner(System.in); //s is instantiated for the built-in class Scanner
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //br is instantiated for the built-in class BufferedReader

	public static void main(String[] args) throws IOException {

		

		char l = 0; //variable for yes and no options
		int x, p, option, n, q; //x are the iteration counters. n is the number of strings. option for the switch.
		//p is used as the variable wherein the user chooses which position. q is the indicator for string position.
		String addString, find; //addString is the variable used to store the new string input. 
		//find is for the allocation of searching the strings in the string input.
		String elements[] = new String[99]; //main string input
		int asd[] = new int[99]; //recognizes string position
		
		do //if the user wants to create a new list, he or she is expected to reset the program with this loop method
		{
		System.out.println("-------------------------------1D Array-------------------------------");
		System.out.println("");
		System.out.println("A program that can store up to 99 strings.");
        System.out.println("");
		System.out.println("Kindly enter the number of elements: ");
		n = Integer.parseInt(br.readLine()); //user is asked to input how many strings is needed.
		
		System.out.println("Enter the names of each element: ");
		System.out.println("Each element name must be unique."); //Prompts the user to have a different input for each element name.
		
		for (x=0; x<n; x++) {
	        elements[x] = br.readLine(); //loops and allocates strings until it reaches the the input
	    }
		System.out.println("");
		System.out.println("");
		System.out.println("Your elements are: ");
		
		for (x=0;x<n;x++) {
			System.out.println(elements[x]); //strings are displayed
		}
		do
		{ ///if the user wants to choose another task, he or she will go back here with this loop method
		System.out.println("");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("This program can also insert a new element, delete a new element, and seeks an element if its present.");
		System.out.println("TASKS:");
		System.out.println("[1] To insert a new element, input a valid array position.");
		System.out.println("[2] To delete an existing element, input a valid array position.");
		System.out.println("[3] To find the location of an element, input the value of the element.");
		System.out.println("[4] To terminate the program.");
		System.out.println("CHOOSE A TASK:");
		option=Integer.parseInt(br.readLine()); //user is asked to choose a task
		if (option == 1)
		{
				do //This loop method is helpful if the user wishes to retry his or her current task.
				{	do
					{
						System.out.println("Enter position of new element: ");
						p = Integer.parseInt(br.readLine());
						
						if (p > n+1|| p < 1) { //If the input position isn't in the number of total inputs, this is indicated
		                    System.out.println("Invalid position. Try again."); 
		                    continue;
		                }
						//Hence, user is asked to try again.
						else {
							for (x=n;x>=p-1;x--) {
								elements[x] = elements[x-1];
							}
							x = p-1;
							System.out.println("Input a new element: ");
								addString = br.readLine();
								elements[x] = addString;	//adds strings in accordance to the chosen string position
									n++; //updates the string list including the new one
								System.out.println("Your elements are: "); //Shows strings
					
								for (x=0, q=1;x<n;x++,q++) {
									System.out.println(elements[x]);
								}
						  }
					}while ((n==0) && (n != 0));
					do
					{
						System.out.printf("\n\nAdd another element, choose another option, or create new element list? (y/n/e)");
						l = s.next().charAt(0);								
	                		if (l == 'y'||l == 'Y') {                      
	                			continue;									
	                		}										//After the implementations above, these implementations are shown		
	                		else if (l == 'n'||l == 'N') {          //so that the user is given the chance to retry the chosen task,        
	                			continue;							//go back to the main menu, or create a new element list.			
	                		}
	                		else if (l == 'e' || 1 == 'E') {
	    						continue;
	    					}
	                		else {                                            
	                			System.out.print("Invalid input\n");
	                		}
					}while ((l != 'n') && (l != 'N') && (l != 'y') && (l != 'Y') && (l != 'e') && (l != 'E'));
					}while (l == 'y'||l == 'Y'); //Condition in 'Add another element', once met, loop goes back to the start of the current chosen task.
			}
			
			else if (option == 2)
			{
				do
				{	do
					{	
						System.out.println("Enter position of the element you want to delete: ");
							p = Integer.parseInt(br.readLine());
							
							if (p > n|| p < 1){
								System.out.println("Invalid position. Try again."); //Here, if string position input is less than the total string
								System.out.println("Your elements are: ");			//position input or string input is greater than 1, position's
																					//displayed as invalid and elements are shown again.
								for (x=0, q=1;x<n;x++, q++) {
									System.out.print(q+"\t");
									System.out.println(elements[x]);
								}
							}
							else {
							for (x=p;x<=n+1;x++) {							//However, in here, if the user has an input not meeting the conditions above,
								elements[x-1] = elements[x];				//then, the chosen string position is deleted and the strings below it
							}												//moves moves upward.
								n--; //updates the string list not including the deleted one
							System.out.println("Your elements are: "); //displays strings
				
							for (x=0, q=1;x<n;x++, q++) {
								System.out.print(q+"\t");
								System.out.println(elements[x]);
							}
						}
					}while ((n==0) && (n != 0));
					do
					{
						System.out.printf("\n\nDelete another element, choose another option, or create new element list? (y/n/e)");
						l = s.next().charAt(0);								
                			if (l == 'y'||l == 'Y') {                      
                				continue;									
                			}												
                			else if (l == 'n'||l == 'N') {                 
                				continue;										
                			}
                			else if (l == 'e' || 1 == 'E') {
        						continue;
        					}
                			else {                                            
                				System.out.print("Invalid input\n");
                			}
					}while ((l != 'n') && (l != 'N') && (l != 'y') && (l != 'Y') && (l != 'e') && (l != 'E'));
				}while (l == 'y'||l == 'Y'); //Condition in 'Delete another element', once met, loop goes back to the start of the current chosen task.
			}
				
				
			else if (option == 3)
			{
				do
				{	do
					{
							System.out.println("Your elements are: ");
				
								for (x=0;x<n;x++) {
									System.out.println(elements[x]); //strings are shown so that the user could choose
								}
									System.out.println("Input the element you want to search: ");
									System.out.println("NOTE: Case-sensitive.");
									find = br.readLine();
			
			
									
			
									for (x=0,q=0;x<n;x++) {					//Here, the variable find is equivalent to an element inside the string inputs.
										if (elements[x].equals(find)){		//x and q are initialized at zero having a condition set at x less than y
											asd[q] = x+1;					//where x is incremented first
											System.out.println("\n\nElement is present at position: ");
											System.out.println(asd[q]);
											break;
										}									
										else
											continue;
									}
									if (x >= n) {					//This will be displayed if the conditions above are not met. Hence, the user is
										System.out.println("");		//given the option to retry, go back to menu, or create a new element list.
						            	System.out.println("String not found. Please try again.");
									}
						}while ((n==0) && (n != 0));
					do
					{
						System.out.printf("\n\nSearch another element, choose another option, or create new element list? (y/n/e)");
						l = s.next().charAt(0);								
						if (l == 'y'||l == 'Y') {                       
							continue;									
						}												
						else if (l == 'n'||l == 'N') {                  
							continue;										
						}
						else if (l == 'e' || 1 == 'E') {
							continue;
						}
						else {                                            
							System.out.print("Invalid input\n");
						}
					}while ((l != 'n') && (l != 'N') && (l != 'y') && (l != 'Y') && (l != 'e') && (l != 'E'));
				}while (l == 'y'||l == 'Y'); //Condition in 'Search another element', once met, loop goes back to the start of the current chosen task.
			}
		
			else if (option == 4)
			{
				System.exit(0);			//Option to terminate the program.
			}
		
			}while (l == 'n' || l == 'N'); //Condition for 'choose another option', once met, loop goes back to menu.
		}while (l == 'e' || l == 'E');	   //Condition for 'create new element list', once met, loop goes back to asking user a new set of string elements.
	}
}