package palindrome;

/*
 * 				FABRO, DAN NINO I.								BSCpE2A_C1					COE20						Lab Assignment #8
 * 
 * Note that this class is primarily applicable with the current Eclipse software and an updated Java SE Runtime Environment.
 */



import palindrome.EmptyStackException;
import palindrome.FullStackException;

public class Stack<D> {											//Before accessing the implementations in this stack class by using instantiation, the object's declare type must be observed
																					//first before putting it into the stack. In some of the cases, for example, Stack<Character> s = new Stack<Character>(); and 
	private final int maxSize;									//Stack<Double> s = new Stack<Double>(); can be particularly defining which objects in character and double declaration
	public int top;														//types. D serves as a generic of class Stack.
	private D[] arr;
	
	public Stack() {														//Constructor
		this(20);
	}
	
	public Stack(int s) {																	//Constructor with parameter for initializations.
		maxSize = s > 0 ? s : 20;											//Shorthand if-else. If s is greater than zero, set to s, otherwise, set to 10.
		top = -1;
		arr = (D[]) new Object[maxSize];				//It can be observed that there is a warning. Using @SuppressWarnings("unchecked") would potentially create an error towards the given field,
	}																			//hence, the warning can then be ignored.
	
	public D push(D item) {											//This basically adds a new element into the stack itself.
		if(top == maxSize)
		{
			throw new FullStackException();
		}
		return arr[++top] = item;
	}
	
	public D pop() {															//The available item at the top of the stack is basically deleted and is then to be returned.
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		return arr[top--];
	}
	
	public D peek() {														//The available item at the top of the stack is basically returned without even deleting it.
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		return arr[top];
	}
	
	public boolean isEmpty() {										  //This method tests if the stack is empty. Which returns true, if the stack is empty. If not, false.
		return top < 0;
	}
	
}
@SuppressWarnings("serial")										//Placed this annotation to disable serial compilation warnings.
class EmptyStackException extends RuntimeException {								//Applied inheritance for EmptyStackException from built-in RuntimeException class
	
	public EmptyStackException()
		{																			
			this("Stack is empty");
		}																															//An 'EmptyStackException' is thrown once an empty stack is popped.
	
	public EmptyStackException(String exception) {
	    super(exception);
	}
}
@SuppressWarnings("serial")										//Placed this annotation to disable serial compilation warnings.
class FullStackException extends RuntimeException {								//Applied inheritance for FullStackException from built-in RuntimeException class
		
	public FullStackException()
		{
			this("Stack is full");
		}																														//A 'FullStackException' is thrown once a full stack is pushed.

	public FullStackException(String exception) {
	    super(exception);
	 }
}
