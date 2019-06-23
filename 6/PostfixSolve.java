package stacks;

/*
 * 				FABRO, DAN NINO I.							BSCpE2A_C1						COE20						Lab Assignment #6
 */

import java.util.Stack;

public class PostfixSolve {
	
	Stack<Double> b = new Stack<Double>();																//This is a built-in Java Stack Class. Methods such as pop(), push(), and peek() are applicable.
																																			//To avoid redundancy and efficiency is maximized, I used this class instead. And obviously, I instantiated
	public double solve(String passedExpr) {																	//it with an instance b so that the available methods can then be called upon.
																																			//This method scans the passed postfix expression and solves it into a numerical value.
		double valContainer, leftOperand, rightOperand;				
		String strContainer = "";																										
		for(int x=0; x<passedExpr.length();x++)
		{																																	//The passed postfix expression is scanned and every operator will fall into one of these cases
			switch(passedExpr.charAt(x))																				//which the left and right operands will eventually be popped and that the only pushed is the
			{																																//result of both operands.
				case '+':																													
						rightOperand = b.pop();
						leftOperand = b.pop();
						b.push(leftOperand+rightOperand);
						break;
						
				case '-':
						rightOperand = b.pop();
						leftOperand = b.pop();
						b.push(leftOperand-rightOperand);
						break;
				
				case '*':
						rightOperand = b.pop();
						leftOperand = b.pop();
						b.push(leftOperand*rightOperand);
						break;
				
				case '/':																									
						rightOperand = b.pop();																	
						leftOperand = b.pop();																		
						b.push(leftOperand/rightOperand);
						break;
				
				default:
						if(passedExpr.charAt(x) != ' ')
							{
								strContainer += Character.toString(passedExpr.charAt(x));								
							}
						
						else																																				//The operand is converted as a string stored into strContainer. Since the passed expression here
							{				 																																//contains a space, it will be the indicator that the operand will be pushed into the stack and that
									try																																	//the converted string operand will then be converted again as a double stored into valContainer
									{																																		//wherein what's stored in valContainer is pushed into the stack, hence, making strContainer empty
											valContainer = Double.parseDouble(strContainer);										//and is set for the upcoming operand.
											strContainer = "";
											b.push(valContainer);
									}
									
					catch(NumberFormatException e) 
									{																			
																						//No implementations inside, hence, nothing is done.
									}
						}
				  }
			}
		return b.pop();
	}
}
