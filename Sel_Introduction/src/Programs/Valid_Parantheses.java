package Programs;

import java.util.Stack;

public class Valid_Parantheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String val1 = "{{}{}}";
		boolean val = isValid(val1);
		System.out.println("Is the string valid? --- " +  val);

	}
	
	public static boolean isValid(String s) {
		
		Stack<Character> stack = new Stack<>();
		char topch;
        // Iterate through the characters of the string
		if (s.length() < 2)
		{
			return false;
		}
		
        for (char ch : s.toCharArray()) 
        {
        	if (ch == '(' || ch == '{' || ch == '[') 
        	{
                stack.push(ch);
        	}
        	else
        	{
        		if (stack.isEmpty()){
        			return false;
        		}
        		else
        		{
        			topch = stack.peek();
        		}
        		if (ch == ')' && topch == '(' || ch == '}' && topch == '{' || ch == ']' && topch == '[')
        		{
        			stack.pop();
        		}
        		else
        		{
        			return false;
        		}
        	}
        }
        
        if (stack.isEmpty()){
			return true;
		}
        
		return false;
		

}
}