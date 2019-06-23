package coe20_LabExer;


/*
 * FABRO, DAN NINO I.					BSCpE2A_C1					COE20 Lab Exercise 9
 */


public class Fabro_LinkedList{
		Fabro_Node first;
	    
	    Fabro_LinkedList()
	    {
	        first=null;			//Initialized a node as null.
	    }
	    
	    
	    public void insertFirst(int x,int y, int z)		//In this method, a node is created and is marked as the first node itself.
	    {
	    	Fabro_Node newNode=new Fabro_Node(x,y,z);				//Coefficient, exponent x, and exponent y are stored as a new node.
	        newNode.proceed=first;
	        first=newNode;
	    }
	    
		//Method called in class Polynomials inside method insert(x,y,z)
	    public void insertPosition(int x,int y,int z,int pos)	
	    {									
	    	Fabro_Node term = first;							//A term is marked as first node
	    	Fabro_Node newNode = new Fabro_Node(x,y,z);				//A node is created.
	        for(int i=pos;i>1;i--){				//Index i is initialized at position having a condition wherein index is greater than 1 and is decremented.
	            term = term.proceed;			//term then proceeds inside this scope of loop
	        }
	        newNode.proceed = term.proceed;		
	        term.proceed = newNode;
	    }
	    
	    
	    public void insertLast(int x,int y,int z)				//This method inserts a node containing the values of coefficient and exponential values of x and y
	    {														//but no node is added once implemented.
	    	Fabro_Node newNode=new Fabro_Node(x,y,z);
	        newNode.proceed=null;
	        if(isEmpty())									//If a node is null, a node is created.
	            first=newNode;
	        else
	        {
	        	Fabro_Node currentTerm = first;						//If condition above is not met, the node is set as null which undergoes a while loop and if the condition
	            while(currentTerm.proceed!=null)				//is not met, the scope of code beneath is not executed. And the created next node equates to the next term
	                currentTerm = currentTerm.proceed;			//and that term will be stored into a whole new node.
	            newNode.proceed = currentTerm.proceed;
	            currentTerm.proceed = newNode;
	        }
	    }
	    
	   public boolean isEmpty()						//Method in insertLast(x,y,z)'s if statement for condition purposes.
	   {
	      return(first==null);
	   }
}
