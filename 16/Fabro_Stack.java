package fabro;

/*
 * FABRO, DAN NINO I.				BSCpE2a_c1					#12 Lab Exercise/Assignment
 */


public class Fabro_Stack<D> {		//Before accessing the implementations in this stack class by using instantiation, the object's declare type must be observed
							//first before putting it into the stack. In some of the cases, for example, Stack<Character> s = new Stack<Character>(); and 
	private final int maxSize;	//Stack<Double> s = new Stack<Double>(); can be particularly defining which objects in character and double declaration
	private D[] info;		//types. D serves as a generic of class Stack.
	private int top;
	
	public Fabro_Stack() {		//Constructor
		this(20);
	}
	
	@SuppressWarnings("unchecked")	
	public Fabro_Stack(int s) {					//Constructor with parameter for initializations.
		maxSize = s > 0 ? s : 10;				//Shorthand if-else. If s is greater than zero, set to s, otherwise, set to 10.
		info = (D[]) new Object[maxSize];
		top = -1;
	}
	
	public int size() {						
		return top + 1;
	}
	
	public boolean isEmpty() {				//This method tests if the stack is empty. Which returns true, if the stack is empty. If not, false.
		return top < 0;
	}
	
	public void push(D item) {				//This basically adds a new element into the stack itself.
		info[++top] = item;
	}
	
	public D pop(){							//The available item at the top of the stack is basically deleted and is then to be returned.
		if(isEmpty())
			throw new EmptyStackException();
		return info[top--];
	}
	
	public D peek() {						//The available item at the top of the stack is basically returned without even deleting it.
		if(isEmpty())
			throw new EmptyStackException();
		return info[top];
	}
}

@SuppressWarnings("serial")
class EmptyStackException extends RuntimeException {				//Applied inheritance for EmptyStackException from built-in RuntimeException class
	
	public EmptyStackException()
		{																			
			this("Stack is empty");
		}															//An 'EmptyStackException' is thrown once an empty stack is popped.
	
	public EmptyStackException(String exception) {
	    super(exception);
	}
}

@SuppressWarnings("serial")
class FullStackException extends RuntimeException {					//Applied inheritance for FullStackException from built-in RuntimeException class
	
	public FullStackException()
		{
			this("Stack is full");
		}															//A 'FullStackException' is thrown once a full stack is pushed.

	public FullStackException(String exception) {
	    super(exception);
	 }
}

