package Programs;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val1 = 122343221;
		boolean val = isPalindrome(val1);
		System.out.println(val);
	}

	public static boolean isPalindrome(int x) {
		int y=0;
		int z=x;
		
		while (x >0){
				y = y*10 +(x%10);
				x=x/10;
			
		}
		//System.out.println(y);
		if(y==z) 
		{
		return true;
		}
		else
		{
			return false;
		}
    }
	
}