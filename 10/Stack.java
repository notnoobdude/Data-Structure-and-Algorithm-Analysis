package stacks3;

/*
 * 				FABRO, DAN NINO I.								BSCpE2A_C1					COE20						Lab Assignment #6
 */


import stacks3.EmptyStackException;
import stacks3.FullStackException;

public class Stack<D> {											//Before accessing the implementations in this stack class by using instantiation, the object's declare type must be observed
																					//first before putting it into the stack. In some of the cases, for example, Stack<Character> s = new Stack<Character>(); and 
	private final int maxSize;											//Stack<Double> s = new Stack<Double>(); can be particularly defining which objects in character and double declaration
	public int top;														//types. D serves as a generic of class Stack.
	private D[] arr;
	
	public Stack() {														//Constructor
		this(20);
	}
	
	public Stack(int s) {														//Parametered constructor for initializations.
		maxSize = s > 0 ? s : 20;											//Shorthand if-else. If s is greater than zero, set to s otherwise, set to 10.
		top = -1;
		arr = (D[]) new Object[maxSize];
	}
	
	public D push(D item) {
		if(top == maxSize)
		{
			throw new FullStackException();
		}
		return arr[++top] = item;
	}
	
	public D pop() {
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		return arr[top--];
	}
	
	public D peek() {
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		return arr[top];
	}
	
	public boolean isEmpty() {
		return top < 0;
	}
	
}

class EmptyStackException extends RuntimeException {								//Applied inheritance for EmptyStackException from built-in RuntimeException class
	
	public EmptyStackException()
		{																			
			this("Stack is empty");
		}																															//An 'EmptyStackException' is thrown once an empty stack is popped.
	
	public EmptyStackException(String exception) {
	    super(exception);
	}
}

class FullStackException extends RuntimeException {								//Applied inheritance for FullStackException from built-in RuntimeException class
		
	public FullStackException()
		{
			this("Stack is full");
		}																														//A 'FullStackException' is thrown once a full stack is pushed.

	public FullStackException(String exception) {
	    super(exception);
	 }
}

