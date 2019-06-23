package coe20_LabExer;


/*
 * FABRO, DAN NINO I.					BSCpE2A_C1					COE20 Lab Exercise 9
 */

public class Fabro_Polynomials{
    private Fabro_LinkedList link;
    
    public Fabro_Polynomials()
    {
        link = new Fabro_LinkedList();			//Initialized link as LinkedList
    }
    
    public boolean insert(int x, int y, int z)
    {
    	Fabro_Node current = link.first;		//Current variable of class Node will be equivalent to what is initialized in Constructor Fabro_LinkedList as variable first.
        int position = 0;				//Position is initialized at zero.
        while(current!=null)			//This while loop will continue until such condition of while loop is not met.
        {
            if(current.exponentX==y&&current.exponentY==z)		//If the current term's exponent of x equates to y and current term's exponent input equates to z
            {													//returned value is false and the user is asked to input again.
                System.out.println("Not a valid term. Insert again");
                return false;
            }
            else if(current.exponentX<y&&current.exponentY<z)	//However, if the user's current term input for exponent x is less than y and exponent y input is		
                break;											//less than z, a break statement is incurred and position will be iterated and would proceed to next term.
            position++;
            current = current.proceed;
        }
        
        if(position==0)
        {
        	link.insertFirst(x,y,z);		//If the position is zero, class linked list's insertFirst() method is incurred to the values assigned here.
        }
            
        else
        	link.insertPosition(x,y,z,position);		//Else, class linked list's insertPosition() method is incurred to the values including new position is assigned here.
        return true;			//And the return value will then be true.
    }
    
    
    public void showPolynomial()
    {
        int position=0;
        Fabro_Node current = link.first;		//Current variable of class Node will be equivalent to what is initialized in Constructor Fabro_LinkedList as variable first.
        while(current!=null)		//This while loop will continue until such condition of while loop is not met.
        {
            if(position!=0&&current.coefficient>0&&current.coefficient!=-1){		//If the position is not zero and the current term coefficient is greater than zero and that the 
            	 System.out.print("+");									//current coefficient is not equal to negative one itself, than a plus sign is printed to connect terms.
            }
            if(current.coefficient!=0)		//And if the current term's coefficient is not zero itself, this block of statements are observed.		
            {
                if((current.coefficient>1||current.coefficient<-1)||(current.exponentX==0&&current.exponentY==0))	
                {										//If the current term's coefficient is greater than 1, is less than -1, or if the current term's exponents of x and y is 0,
                	System.out.print(current.coefficient);	//then the printed output will be current term's coefficient itself.
                }
                else if(current.coefficient==-1)	//If the current term's coefficient is -1, a negative sign is shown.
                {
                	System.out.print("-");
                }
                if((current.exponentX==1)&&(current.exponentY==0))	//If the current term's exponent of x is 1 and current term's exponent is 0, then the shown output is
                {													//an x term.
                	System.out.print("X");
                }
                if((current.exponentX==0)&&(current.exponentY==1))	//If the current term's exponent of x is 0 and current term's exponent is 1, then the shown output is
                {													//a y term.
                	System.out.print("Y");
                }
                else if((current.exponentX>1||current.exponentX<0)||(current.exponentY>1||current.exponentY<0))
                {																		//If the current term's exponent of x and y is greater than 1 or less than 0,
                	System.out.print("X^"+current.exponentX+"Y^"+current.exponentY);	//then what is shown is the x variable together with the current term's exponent of x
                }																		//and y.		
                position=1;
            }
            current = current.proceed;				//Node will then proceed to next node, creating another node for storage of input and output values.
        }
        System.out.println("");
    }
    
    
    public void addition(Fabro_Polynomials poly1,Fabro_Polynomials poly2)		//Method where both polynomials are added 
    {						//conCoeff will be the container of node's coefficient, conX will be the container of term's exponent of x, conY will be the container of term's exponent of y.
        int conCoeff,conX,conY;			
        Fabro_Node currentPol1=poly1.link.first;		//Each current terms represent nodes having values of coefficients, exponents of x and y--assigned to 1st and 2nd polynomials.
        Fabro_Node currentPol2=poly2.link.first;
        while(currentPol1!=null&&currentPol2!=null)	//If such condition will be false, while loop ends.
        {
            if((currentPol1.exponentX==currentPol2.exponentX)&&(currentPol1.exponentY==currentPol2.exponentY))
            {													//If the 1st polynomial's current term of x exponent is equal to the 2nd polynomial's current term of x exponent
            	conCoeff = currentPol1.coefficient + currentPol2.coefficient;	//and if the 1st polynomial's current term of y exponent is equal to the 2nd polynomial's current term of y exponent,
            	conX = currentPol1.exponentX;						//then this block is executed wherein the value stored in polynomial node 1's coefficient will be added to 
            	conY = currentPol1.exponentY;						//polynomial node 2's coefficient and is stored in conCoeff. After such process, next terms of both polynomials are
                conX = currentPol2.exponentX;						//observed.
                conY = currentPol2.exponentY;
                currentPol1 = currentPol1.proceed;
                currentPol2 = currentPol2.proceed;
            }
            else if((currentPol1.exponentX>currentPol2.exponentX)&&(currentPol1.exponentY>currentPol2.exponentY))
            {											//If the 1st polynomial's current term of x exponent is greater than the 2nd polynomial's current term of x exponent
            	conCoeff = currentPol1.coefficient;			//and if the 1st polynomial's current term of y exponent is greater than the 2nd polynomial's current term of y exponent,
            	conX = currentPol1.exponentX;			//then this block is executed wherein the only values stored in conCoeff is 1st polynomial's current term coefficient together
            	conY = currentPol1.exponentY;			//with its exponents of x and y. Then, proceeds to the next node.
            	currentPol1 = currentPol1.proceed;
            }
            else										//Condition falls here once the other conditions above aren't met.
            {											//Container for coefficient will be stored with the 2nd current term's polynomial coefficient.
            	conCoeff = currentPol2.coefficient;			//Same process undergoes with the containers x and y, they will be stored with the values of
            	conX = currentPol2.exponentX;			//2nd current term's polynomial exponent of x and y. And as such, once done with the term,
            	conY = currentPol2.exponentY;			//it will proceed to the next term of the 2nd polynomial and will be linked with the other terms.
            	currentPol2 = currentPol2.proceed;
            }
            link.insertLast(conCoeff,conX,conY);			
        }
        
        while(currentPol1!=null)				//If such condition will be false, while loop ends.
        {										//Container for coefficient will be stored with the 1st current term's polynomial coefficient.
        	conCoeff = currentPol1.coefficient;		//Same process undergoes with the containers x and y, they will be stored with the values of
        	conX = currentPol1.exponentX;		//1st current term's polynomial exponent of x and y. And as such, once done with the term,
        	conY = currentPol1.exponentY;		//it will proceed to the next term of the 2nd polynomial and will be linked with the other terms.
        	currentPol1 = currentPol1.proceed;
            link.insertLast(conCoeff,conX,conY);
        }
        
        while(currentPol2!=null)				//If such condition will be false, while loop ends.
        {										//Container for coefficient will be stored with the 2nd current term's polynomial coefficient.
        	conCoeff = currentPol2.coefficient;		//Same process undergoes with the containers x and y, they will be stored with the values of
        	conX = currentPol2.exponentX;		//2nd current term's polynomial exponent of x and y. And as such, once done with the term,
        	conY = currentPol2.exponentY;		//it will proceed to the next term of the 2nd polynomial and will be linked with the other terms.
        	currentPol2 = currentPol2.proceed;
            link.insertLast(conCoeff,conX,conY);
        }
    }
}
