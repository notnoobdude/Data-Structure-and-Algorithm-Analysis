package stacks;

/*
 * 				FABRO, DAN NINO I.								BSCpE2A_C1					COE20						Lab Assignment #4
 */


import java.util.Stack;
import java.util.EmptyStackException;

public class ParenthesisCount {

																										//This is a built-in Java Stack Class. Methods such as pop(), push(), and peek() are applicable.
	Stack<Character> b = new Stack<Character>();				//To avoid redundancy and efficiency is maximized, I used this class instead. And obviously, I instantiated
																										//it with an instance b so that the available methods can then be called upon.
	public int scan(String expr) {							//The entered string will be passed here.
		for(int x=0; x<expr.length();x++)				//The loop will depend upon the length of the entered string characters. Index x is initialized at zero having
		{																		//a condition depending on the number of string characters which is then post-incremented.
			if(expr.charAt(x) == '(')
			{
				b.push('(');
			}
			if(expr.charAt(x) == '[')						//If the method scans a character particularly an open parenthesis, open bracket, and an open curly brace, it is directly pushed into the stack.
			{																//Furthermore, if this method scans a close parenthesis, close bracket, and a close curly brace, it is then checked if the closing characters
				b.push('[');											//have its pair inside the stack and if it has, it is popped.
			}																						
			if(expr.charAt(x) == '{')
			{																				//The method returns a value of -1 if the number of the scanned closing characters exceeds the number of open characters.
				b.push('{');															//The method returns a value of 1 if the number of the scanned open characters exceeds the number of closing characters.
			}																				//The method returns a value of 2 if the scanned open and closing characters are not ordered properly.
																							//The method, however, returns a value of 0 if both scanned open and closing characters have been paired and popped--valid.
			
			if(expr.charAt(x) == ')')												
			{
				try
				{
					if(b.peek() == '{' || b.peek() == '[')							
					{
						return 2;
					}

					else 
					{
						b.pop();
					}
				}

				catch(EmptyStackException e) 
				{
					return -1;
				}
			}


			if(expr.charAt(x) == ']')
			{
				try
				{
					if(b.peek() == '{' || b.peek() == '(') 
					{
						return 2;
					}
					else
					{
						b.pop();
					}
				}
				catch(EmptyStackException e) 
				{
					return -1;
				}
			}
			if(expr.charAt(x) == '}')
			{
				try
				{
					if(b.peek() == '(' || b.peek() == '[')
					{
						return 2;
					}
					else
					{
						b.pop();
					}
				}
				catch(EmptyStackException e)
				{
					return -1;
				}
			}
		}

		if(b.isEmpty())
		{
			return 0;
		}

		else
		{
			return 1;
		}

	}
}
