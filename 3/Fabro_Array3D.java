package LabExercises;

/*
 * 			FABRO, DAN NINO I.				BSCPE2A_C1				CoE20
 */


import java.io.IOException;
import java.util.Scanner;

public class Fabro_Array3D
   {
	 Scanner num = new Scanner(System.in);
	 private int i, j, k; 							//For the indices. i for rows, j for columns, and k for thickness.
     public static int rows;					 //Field for user's row input. 							//Rows, columns, and thickness are in public so that other classes can gain access to this variable.
     public static int columns;  		//Field for user's column input.
     public static int thickness; 		//Field for user's thickness input.
     
     
     public void ijkList() throws IOException { 																			   //This method is set to public so that other classes can gain access to it.
    	 Fabro_Array3DMain arr = new Fabro_Array3DMain();
    	 int loc=1;																																	//loc is initialized to one.
    	 System.out.printf("\n%-15s%-15s\n","Location","Position");											//To be able to display an array in 3D, thickness should be looped inside the column loop
    	 for (i=0; i<rows; i++) 																												//While columns, on the other hand, is looped also inside row loop. First, for the row part,
    		 for (j=0; j<columns; j++) 																									//the for loop is initialized with the index i of rows set to zero having a condition of i less
    			 for (k=0; k<thickness; k++, loc++) 																				//than the row input and index i is incremented. The same process goes with columns, j is
    				 System.out.printf("%-15d%c[%d][%d][%d]\n", loc, 'a' , i, j, k);							//initialized at zero having a condition of j less than the input columns and index j is incremented.
    	 																																					//Like the rows and columns, same process also but already with variable loc, index k for 
    	 switch(arr.cont())																													//thickness is initialized at zero, then having a condition of k less than the user input's
    	 {																																					//thickness, and then index k is together with loc is incremented to loop.
         case 1:																																		
        	 	arr.mainMenu();
        	 break;
        	 																																				
         case 2: 																																		//The switch statement enables the user to go back to main menu or instead continue by
        	 	seek(1);																																//searching the location of a 3D array's element position. In case 2, it is observed that the
        	 break;																																	//seek() method has an integer inside. This integer will be the indicator passed towards 
        	 																																				//seek method unique to identify in the switch statement in it defining which case will be
         default:																																		//next to be executed. In this method, case 1 will then be executed. Each 3D array pattern form
        	 	System.out.println("Invalid. Try again.");			//For wrong input.						   //list method has a unique integer in each seek() method for it to identify which case is next
    	 }																																					//to be executed found in seek() method's switch statement.
     }
    			 
     public int ijkLoc(int i, int j, int k)
     {  																																				 //This method is for searching the location of the input position by the users. Variable
    	 int loc=0;																																//loc must be first initialized at zero and then the addressing formula is followed. Every addressing
    	 	loc=1+(i-0)*columns*thickness+(j-0)*thickness+(k-0);												//formula of each 'location-searching' method is unique, different from others. Hence, this addressing
    	 		return loc;																														//formula is only exclusive to this method and 3D array pattern form. The value stored in the memory
     }																																					//address as variable loc is then passed into the the method that calls this method.
     
     
     public void jikList() throws IOException {
    	 Fabro_Array3DMain arr = new Fabro_Array3DMain();
    	 int loc=1;
    	 System.out.printf("\n%-15s%-15s\n","Location","Position");
    	 for (j=0; j<columns; j++) 
    		 for (i=0; i<rows; i++) 
    			 for (k=0; k<thickness; k++, loc++) 
    				 System.out.printf("%-15d%c[%d][%d][%d]\n", loc, 'a' , i, j, k);
    	 
    	 switch(arr.cont())
    	 {
         case 1:
        	 	arr.mainMenu();
        	 break;
        	 
         case 2:
        	 	seek(2);
        	 break;
        	 
         default:
        	 System.out.println("Invalid. Try again.");
    	 }
     }
     
     public int jikLoc(int i, int j, int k)
     { 
    	 int loc=0;
    	 	loc=1+(j-0)*rows*thickness+(i-0)*thickness+(k-0);										//Addressing formula for jik 3D pattern form.
    	 		return loc;
     }       
     
     
     public void jkiList() throws IOException {
    	 Fabro_Array3DMain arr = new Fabro_Array3DMain();
    	 int loc=1;
    	 System.out.printf("\n%-15s%-15s\n","Location","Position");
    	 for (j=0; j<columns; j++) 
    		 for (k=0; k<thickness; k++)  
    			 for (i=0; i<rows; i++, loc++)
    				 System.out.printf("%-15d%c[%d][%d][%d]\n", loc, 'a' , i, j, k);
    	 
    	 switch(arr.cont()) 
    	 {
         case 1: 
        	 	arr.mainMenu();
        	 break;
        	 
         case 2: 
        	 	seek(5);
        	break;
        	
         default:
        	 	System.out.println("Invalid. Try again.");
    	 }
     }     
     
     public int jkiLoc(int i,int j,int k) 
     { 
    	 int loc=0;
    	 	loc=1+(j-0)*thickness*rows+(k-0)*rows+(i-0);												//Addressing formula for jki 3D pattern form.
    	 		return loc;
     }
     
     
     public void ikjList() throws IOException {
    	 Fabro_Array3DMain arr = new Fabro_Array3DMain();
    	 int loc=1;
    	 System.out.printf("\n%-15s%-15s\n","Location","Position");
    	 for (i=0; i<rows; i++) 
    		 for (k=0; k<thickness; k++)  
    			 for (j=0; j<columns; j++, loc++)
    				 System.out.printf("%-15d%c[%d][%d][%d]\n", loc, 'a' , i, j, k);
    	 
    	 switch(arr.cont())
    	 {
         case 1: 
        	 	arr.mainMenu();
        	break;
        	
         case 2: 
        	 	seek(4);
        	 break;
        	 
         default: 
        	 	System.out.println("Invalid. Try again.");
    	 }
     }
     
     public int ikjLoc(int i,int j,int k)
     { 
    	 int loc=0;
    	 	loc=1+(i-0)*thickness*columns+(k-0)*columns+(j-0);									//Addressing formula for ikj 3D pattern form.
    	 		return loc;
     }
     
     
     public void kjiList() throws IOException { 
    	 Fabro_Array3DMain arr = new Fabro_Array3DMain();
    	 int loc=1;
    	 System.out.printf("\n%-15s%-15s\n","Location","Position");
    	 for (k=0; k<thickness; k++)
    		 for (j=0; j<columns; j++)
    			 for (i=0; i<rows; i++, loc++)
    				 System.out.printf("%-15d%c[%d][%d][%d]\n", loc, 'a' , i, j, k);
    	 
    	 switch(arr.cont())
    	 {
         case 1: 
        	 	arr.mainMenu();
        	 break;
        	 
         case 2: 
        	 	seek(6);
        	 break;
        	 
         default: 
        	 	System.out.println("Invalid. Try again.");	
    	 }
     }
     
     public int kjiLoc(int i,int j,int k)
     { 
    	 int loc=0;
    	 	loc=1+(k-0)*columns*rows+(j-0)*rows+(i-0);														//Addressing formula for kji 3D pattern form.
    	 		return loc;
     }     
     
     
     public void kijList() throws IOException { 
    	 Fabro_Array3DMain arr = new Fabro_Array3DMain();
    	 int loc=1;
    	 System.out.printf("\n%-15s%-15s\n","Location","Position");
    	 for (k=0; k<thickness; k++) 
    		 for (i=0; i<rows; i++)
    			 for (j=0; j<columns; j++, loc++)  
    				 System.out.printf("%-15d%c[%d][%d][%d]\n", loc, 'a' , i, j, k);
    	 
    	 switch(arr.cont())
    	 {
         case 1: 
        	 	arr.mainMenu();
        	 break;
        	 
         case 2: 
        	 	seek(3);
        	 break;
        	 
         default: 
        	 System.out.println("Invalid. Try again.");
    	 }
     }
   
     public int kijLoc(int i, int j, int k)
     {
    	 int loc=0;
    	 	loc=1+(k-0)*rows*columns+(i-0)*columns+(j-0);												//Addressing formula for kij 3D pattern form.
    	 		return loc;
     }     
   

     
     private void seek(int z) throws IOException {
    	 Fabro_Array3DMain arr = new Fabro_Array3DMain();
    	 System.out.println("-------------------------------------------------------------------------------------------");
    	 System.out.print("Input row position: ");
    	 	i = num.nextInt();															//User's row input position is stored as variable index i -- memory address
    	 System.out.print("Input column position: ");
    	 	j = num.nextInt();															//User's column position is stored as variable index j		-- memory address
    	 System.out.print("Input thickness position: ");
    	 	k = num.nextInt();															//User's thickness position is stored as variable index k -- memory address
    	 	
    	 if((i>rows-1||i<0)||(j>columns-1||j<0)||(k>thickness||k<0)) 
    	 {
    		 System.out.println("Invalid. Input shows exceeding number of rows, columns, or thickness. Please try again.");
	 		 System.out.println("");												//I've set this condition so that whenever the user's row/column input minus 1 except thickness less than its index or if zero
	 		 	seek(z);																		//is greater than the index, then it is invalid. However, if the condition is not met, this method will proceed towards the
    	 }																							//switch statement below.
    	 
    	 switch(z)
    	 {
    	 case 1: 
    		 System.out.println("Location of position is at: " + ijkLoc(i, j, k));							//Here, the location of the position input by the user will be displayed depending of course on the
    		 		arr.redo(1);																												//3D array pattern form he or she chooses in order for the location-searching methods to put to use.
    		 	break;																															//The stored value allocated in the memory address of variable loc will then be passed here. Hence,
    		 																																		//an output of location is displayed, completing the searching process.
    		 																																		//It is also observed in this method the methods available inside the Fabro_Array3DMain which was
    	 case 2: 																																///put to use via instance arr.
    		 System.out.println("Location of position is at: " + jikLoc(i, j, k));
    		 		arr.redo(2);
    		 	break;
    		 		
    	 case 3: 
    		 System.out.println("Location of position is at: " + kijLoc(i, j, k));
    		 		arr.redo(3);
    		 	break;
    		 	
    	 case 4: 
    		 System.out.println("Location of position is at: " + ikjLoc(i, j, k));
    		 		arr.redo(4);
    		 	break;
    		 
    	 case 5: 
    		 System.out.println("Location of position is at: " + jkiLoc(i, j, k));
    		 		arr.redo(5);
    		 	break;
    		 		
    	 case 6: 
    		 System.out.println("Location of position is at: " + kjiLoc(i, j, k));
    		 		arr.redo(6);
    		 	break;
    		 		
    	 default: 
    		 System.out.println("Invalid. Try again."); 														//For wrong input.
       }
    }
 }

