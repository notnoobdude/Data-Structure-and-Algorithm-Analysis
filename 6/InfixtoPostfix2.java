package stacks;

/*
 * 				FABRO, DAN NINO I.							BSCpE2A_C1						COE20						Lab Assignment #6
 */

import java.util.Stack;

public class InfixtoPostfix2 {
	
	Stack<Character> b = new Stack<Character>();					   //This is a built-in Java Stack Class. Methods such as pop(), push(), and peek() are applicable.
																												//To avoid redundancy and efficiency is maximized, I used this class instead. And obviously, I instantiated
																												//it with an instance b so that the available methods can then be called upon.
	    public String convert(String expr) {											//This method scans the input infix expression and converts it into a postfix one.
		String result = "";																			//The entered string will be passed here.
		int i;																								
		b.push('\0');																					
		for(i=0;i<expr.length();i++) 														//The loop will depend upon the length of the entered string characters. Index i is initialized at zero having
		{																										//a condition depending on the number of string characters which is then post-incremented.
			switch(expr.charAt(i)) 
			{
			
				case '(':																						//Once the method scans an opening character within the string input along with the operators, they will be pushed
																													//into the stack. However, if in the process it arrives a closing character, the stack is peeked if it has the pair open character
				case '[':																						//and if it has, it is popped and the preceding operator will be passed into the result. On the other hand, operands are directly
																													//passed into the result.
				case '{':
						b.push(expr.charAt(i));
						break;
			
				case ')':
				
				case ']':																														
																																				
				case '}':																														
						while(b.peek() != '(' && b.peek() != '[' && b.peek() != '{')
						{
								result += " " + Character.toString(b.pop());								
						}
						
						b.pop();
						
						break;
																														//It may be observed that some cases doesn't have any implementations inside. Basically, this is because these 
				case '+':																							//cases have similar implementations which then falls into the next and into the next case and into the next case
																														//up until it arrive the case where implementations/statements are available and is having a break statement.
				case '-':
				
				case '*':
				
				case '/':
						result += " ";
						if(precedence(expr.charAt(i)) <= precedence(b.peek()))
						{
								if(result.charAt(result.length() - 1) != ' ')
								{
										result += " ";
								}
					
								if(b.peek() != '(' && b.peek() != '[' && b.peek() != '{')
								{
										result += Character.toString(b.pop()) + " ";
								}
						}
						
						b.push(expr.charAt(i));
						
						break;
						
					default:
							result += Character.toString(expr.charAt(i));
			}
		}
		
		while(b.peek() != '\0')
		{
			result += " " + Character.toString(b.pop());
		}
		
		return result;											//postfix output
	}
	
	private int precedence(char x) {
		switch(x)
		{
			case '\0':																								
					return 0;											//This method is used to determine the comparison of precedence on operators. Returning value is as observed.
																	
			case '+':
			
			case '-':
					return 1;
			
			case '*':
			
			case '/':
					return 2;
			
			default:
					return 3;
		}
	}
}