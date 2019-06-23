package palindrome;

/*
 * 				FABRO, DAN NINO I.								BSCpE2A_C1					COE20						Lab Assignment #8
 * 
 * Note that this class is primarily applicable with the current Eclipse software and an updated Java SE Runtime Environment.
 */


public class ProcPalindrome {

	public ProcPalindrome() {}
	//The entered string by user will be passed here and will undergo a process wherein it'll be tested if it's a palindrome or not.
	public static boolean scan(String pp) {					
		Stack<Character> st = new Stack<>();				//The Stack class' object declare type is a character and is having an instance variable name as st. 
		char pr;									//Field for stack's pop() method							
		int x;										//Field for iteration
		if(pp.length()%2==1)										//If the condition wherein the length of the input has a remainder or 1, then the block of statements will be executed.			
		{
			for(x=0;x<pp.length();x++)				//x is initialized at zero having a condition which is x is limited only to the length of the input and is then post-incremented
			{
				if(x<pp.length()/2)									
				{
					st.push(pp.charAt(x));				//If the index is less than the division of the string input to 2, then the characters in  it will then be pushed into the stack.
				}
				else if(x==pp.length()/2)
				{
					continue;									//However, if the index is equal to the division of the string input to 2, then this current flow proceeds to the next iteration.
				}
				else 
				{
					pr = st.pop();							//Until then, if the above conditions will not be met, this will be executed wherein pr serves as the container of the characters that are popped
					if(pp.charAt(x) != pr)			//And if the characters are not equal to the popped characters, then the return value is false.
					{
						return false;
					}
				}
			}
			return true;								//Returns true if the first characters inside the string input equates to the next characters of the string input right after the middle character.
		}
		else 
		{
			return false;								//Returns false if the conditions above isn't met.
		}
	}
}
