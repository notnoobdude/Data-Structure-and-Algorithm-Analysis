package LabExercises;

/*
 * 			FABRO, DAN NINO I.				BSCPE2A_C1			CoE20
 */


import java.io.IOException;
import java.util.Scanner;

public class Fabro_Array2D {
	
	Scanner num = new Scanner(System.in);
	private int i,j;  //For the indices. i for rows and j for columns.
    public static int rows; //Field for user's row input.
    public static int columns; //Field for user's column input.
    
    
    
    public void rmList() throws IOException { //Shows a list of all elements in Row-Major ordering.
    	Fabro_Array2DMain arr = new Fabro_Array2DMain();
    	int loc = 1;
    	System.out.printf("\n%-15s%-15s\n","Location","Position");
        for(i=0; i<rows; i++) //Index for row is initialized at zero, having a condition limited 
        {					  //at user input row which will then be incremented.
        	for(j=0; j<columns; j++, loc++) 	//Index for column is initialized at zero, having a condition limited 
        	{									//at user input column which will then be incremented 
        										//together with the location initialized at one.
        		System.out.printf("%-15d%c[%d][%d]\n", loc,'a',i,j); 	//Shows the row-major order of elements.
        	}
        }
        
        switch(arr.cont())					//Executes right after the execution of row-major elements.
        {									//Enabling the user to choose between going back to main menu for other options
        		case 1: 					//or seek for a location of an array element by entering its position.
        				arr.mainMenu();
        		  break;
        		
        		case 2: 
        				seek(1);
        		  break;
        		
        		default: 
        			System.out.println("Invalid. Try again.");
        }
     }
    
    
    public int rmLoc(int x, int y) { //Serves as the addressing method for row-major ordering.
        int loc;
        	loc=1+(x+0)*(columns)+(y); //Addressing formula returning a value as local variable loc.
        		return loc;
     }
    
    
     public void cmList() throws IOException { 		//Shows a list of all elements in Column-Major ordering.
    	 Fabro_Array2DMain m = new Fabro_Array2DMain();					//Instantiated m for class Fabro_Array2DMain
    	 int loc = 1;
    	 System.out.printf("\n%-15s%-15s\n","Location","Position");
         for(j=0; j<columns; j++) 					//Index for column is initialized at zero, having a condition limited 					
         {											//at user input column which will then be incremented.
        	 for(i=0; i<rows; i++,loc++) 						//Index for row is initialized at zero, having a condition limited
        	 {													//at user input row which will then be incremented 
        		 												//together with the location initialized at one.
        		 System.out.printf("%-15d%c[%d][%d]\n", loc,'a',i,j);		//Displays the column-major order of elements.
         	 }
         }
         switch(m.cont())
         {
         		case 1: 
         				m.mainMenu();
         		  break;
         		
         		case 2: 
         				seek(2);
         		  break;
         		
         		default: 
         			System.out.println("Invalid. Try again.");
         }
     }
     
     
     public int cmLoc(int x, int y) { 		//Serves as the addressing method for row-major ordering.
    	int loc;
        	loc=1+(y+0)*(rows)+(x);				//Addressing formula returning a value as local variable loc.
        		return loc;
     }
     
     
     private void seek(int z) throws IOException { //This method is for searching the location of a position in a 2D array.
    	 Fabro_Array2DMain m = new Fabro_Array2DMain();
    	 System.out.println("-------------------------------------------------------------------------------------------");
    	 System.out.print("Input row position: ");
    	 	i = num.nextInt(); 		//Input for row stored for index i
    	 System.out.print("Input column position: ");
    	 	j = num.nextInt();			//Input for column stored for index j
    	 		if((i>rows-1||i<0)||(j>columns-1||j<0)) { 		//Warns the user that his or her input's not found inside the profound elements.
    	 			System.out.println("Invalid. Input shows exceeding number for rows and columns. Please try again.");
    	 			System.out.println("");		
    	 				seek(z);
    	 }
    	 
    	 switch(z)
    	 	{
    	 		case 1: 					//Displays for the search location output on row-major ordering.
    	 			System.out.println("Location of position is at: "+rmLoc(i,j));		
    	 				m.redo(1);								
    	 		  break;
    	 		
    	 		case 2: 					//Displays for the search location output on column-major ordering.
    	 			System.out.println("Location of position is at: "+cmLoc(i,j));
    	 				m.redo(2);
    	 		  break;
    	 		
    	 		default: 
    	 				System.out.println("Invalid. Try again.");
    	 	}
       }
}
