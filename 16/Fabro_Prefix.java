package fabro;


/*
 * 				FABRO, DAN NINO I.								BSCpE2A_C1					COE20						Lab Assignment #12
 */


public class Fabro_Prefix {									//Class for infix to prefix process.
	
    public Fabro_Prefix() {
    	//Constructor has nothing to instantiate.
    }			

    public static String convert(String arith) {
    	Fabro_Stack<Character> operator = new Fabro_Stack<>();				//Instantiation of Stack class' object type Character as instance operator.
    	Fabro_Stack<String> operand = new Fabro_Stack<>();					//Instantiation of Stack class' object type String as instance operator.
        char subOp;
        operator.push('\0');									
        String str = "";
        String leftOprnd, rightOprnd;
        String result;
        int x;
        for(x=0;x<arith.length();x++) {								//x serves as an index of the infix input passed into this class which is initialized at zero, having a 
            switch(arith.charAt(x))											//condition limiting it to the length of the given input, and is then post-incremented.
            {
                	case '(':
                	case '{':
                	case '[':												//Open parentheses, brackets, and/or curly braces are primarily pushed into the stack.
                				operator.push(arith.charAt(x));
                				break;
              
                	case ')':												//All the scanned str strings are pushed into the operand stack and then, the operators
                	case ']':												//will be popped out of the stack until a close parenthesis, close bracket, or close curly-brace is detected.
                	case '}':
                				if(!str.equals(""))
                				{
                						operand.push(str);
                						str = "";
                				}
                				
                	while(operator.peek() != '{' && operator.peek() != '[' && operator.peek() != '(') 
                	{
                		subOp = operator.pop();
                		rightOprnd = operand.pop();
                        leftOprnd = operand.pop();
                        operand.push(Character.toString(subOp)+" "+leftOprnd+" "+rightOprnd);
                    }
                	
                    operator.pop(); 					//The open parentheses, brackets, and/or curly braces will then be popped.
                    break;
               
                    
                case '+':								//The str string will then be pushed into the operand stack and will then undergo comparison with the precedence
                case '-':								//of operators. 
                case '*':
                case '/':
                    if(!str.equals(""))
                    {																												
                    	operand.push(str);
                        str = "";
                    }
                    
                    while(precedence(arith.charAt(x)) <= precedence(operator.peek()))					//If the operator at the top of the stack has a higher precedence value than the
                    {																					//current operator itself, then the while loop is executed until the acquired operator
                    	if(operator.peek() != '(' && operator.peek() != '[' && operator.peek() != '{')	//has a higher precedence value than the operator at the top of the stack.
                    		{
                    			subOp = operator.pop();							
                    			rightOprnd = operand.pop();
                    			leftOprnd = operand.pop();
                    			operand.push(Character.toString(subOp)+" "+leftOprnd+" "+rightOprnd);
                        	}
                        
                        else 												//The loop is stopped once parentheses are actually found.
                        	{ 
                        		break;
                        	}
                    }
                    operator.push(arith.charAt(x));
                    break;
                /*
                 * All operands are appended to this string. When an operator is
                 * found the string is pushed to the operand stack.
                 */
                default:
                    str = str + Character.toString(arith.charAt(x));			//Operands will then be sub-joined to this particular string and it will be pushed
                    break;														//to the operand stack if an operator is detected.
            }
        }
        
        if(!str.equals(""))
        {
        	operand.push(str);
        }
        
        while(operator.peek() != '\0') 
        {
        	subOp = operator.pop();
        	rightOprnd = operand.pop();
        	leftOprnd = operand.pop();
        	operand.push(Character.toString(subOp)+" "+leftOprnd+" "+rightOprnd);
        }
        
        result = operand.pop();							//The remaining operands and operators will then be popped from the stack and is returned as a prefix result with spaces between.
        return result;
    }
    
    
    private static int precedence(char input) {			//This method is used to determine the comparison of precedence on operators. Returning value is as observed.
        switch(input)
        {
            case '\0':
                return 0;
                
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

