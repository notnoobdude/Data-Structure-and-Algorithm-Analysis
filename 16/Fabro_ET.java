package fabro;

/*
 * FABRO, DAN NINO I.				BSCpE2a_c1					#12 Lab Exercise/Assignment
 */


public class Fabro_ET {

	private Fabro_Stack<Fabro_MTNode> n = new Fabro_Stack<>();				//Stack class uses Fabro_MTNode class as a generic object and is then instantiated for this class.
	
	private boolean forDigits(char dig) {						//For digits, returns a numerical character--operand.
		return dig >= '0' && dig <= '9';
	}
	
	private boolean forOperator(char op) {
		return op == '+' || op == '-' || op == '*' || op == '/';			//For operators, returns an operator character.
	}
	
	private void append(char value) {											//This method scans the value returned by methods above and places them into one of these
		try {																	//conditions.
			if(forDigits(value)) {												//If the returned value falls in numerical form condition, then a new node is created for
				Fabro_MTNode newest = new Fabro_MTNode();						//that specific value and is then pushed into the stack.
				newest.value = Float.parseFloat(Character.toString(value));
				n.push(newest);
			}
			else if(forOperator(value)) {										
				Fabro_MTNode newest = new Fabro_MTNode();			//If the returned value falls as an operator character, then a node is created too and that value serves
				newest.label = value; 								//as the operator for both operands pushed into the stack. Afterwards, operands and operators combined
				newest.left = n.pop();							//into the node will then be pushed into the stack.
				newest.right = n.pop();
				n.push(newest);
			}
		}
		catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	public void createTree(String equation) {						//This method accepts the equation and that equation undergoes a for loop.
		for(int i = equation.length() - 1; i >= 0; i--)				
			append(equation.charAt(i));
	}
	
	public float evaluate() {								//This method returns the value returned by the evaluate method with parameter below.
		return evaluate(n.peek());
	}
	
	private float evaluate(Fabro_MTNode node) {
		if(node.left == null && node.right == null){
			return node.value;
		}
		else {
			float output = 0.0f;
			float l = evaluate(node.left);
			float r = evaluate(node.right);
			char operator = node.label;
			
			switch(operator) {							//If the operator is for addition, then the nodes available in the left and right of node operator is added
			case '+':									//and returned. Same flow or process undergoes in the following operators too.
				output=l+r;
				break;
			case '-':
				output=l-r;
				break;
			case '*':
				output=l*r;
				break;
			case '/':
				output=l/r;
				break;
			default:
				output=l+r;
				break;
			}
			return output;
		}
	}
	
	private void postOrder(Fabro_MTNode node) {
		if(node != null) {
			postOrder(node.left);							//This method follows the postorder flow. The left node is placed first, secondary is the right node, and the 
			postOrder(node.right);							//operator is followed.
			if(node.label == '\0')
				System.out.printf("%.0f", node.value);
			else
				System.out.print(node.label);
		}
	}
	
	private void inOrder(Fabro_MTNode node) {
		if(node != null) {
			inOrder(node.left);										//This method follows the certain inorder flow. The left node will be upholded first, followed by the
			if(node.label == '\0')										//operator residing with it, and the right node is next.
				System.out.printf("%.0f", node.value);
			else
				System.out.print(node.label);
			inOrder(node.right);
		}
	}
	
	private void preOrder(Fabro_MTNode node) {
		if(node != null) {										//This method follows the preorder flow. The operator node will be placed first, next is the left node, and
			if(node.label == '\0')									//the right node will be followed.
				System.out.printf("%.0f", node.value);
			else
				System.out.print(node.label);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public void postfix() {
		postOrder(n.peek());
	}
	
	public void infix() {
		inOrder(n.peek());
	}
	
	public void prefix() {
		preOrder(n.peek());
	}
}
