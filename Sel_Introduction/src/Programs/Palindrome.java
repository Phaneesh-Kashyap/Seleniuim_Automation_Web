package Programs;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val1 = 0;
		boolean val = isPalindrome(val1);
		System.out.println(isPalindrome(0));
		System.out.println(isPalindrome(9));
		System.out.println(isPalindrome(99));
		System.out.println(isPalindrome(123454321));
		System.out.println(isPalindrome(100));
		System.out.println(isPalindrome(1001));
		System.out.println(isPalindrome(432234));
		
		
	}

	
	public static boolean isPalindrome(int x) {
	        String number = String.valueOf(x);
	        StringBuilder sb = new StringBuilder(number);
	        if(number.equals(sb.reverse().toString())){
	          return true;
	        }else{
	          return false;
	        }
	    }
	
	
	public static boolean isPalindrome2(int x) {
		int y=0;
		int z=x;
		int b=0;
		
		while ((x>0 || z==0) && z!=10 && (z==0 || z%10!=0)){
				y = y*10 +(x%10);
				x=x/10;
				b=x/10;
				
				if (y==b || y==x || z<10) return true;
				
		}
		//System.out.println(y);
		return false;
		
    }
	public boolean isPalindrome1(int x) {
        int y=0;
		int z=x;
		
		while (x >0){
				y = y*10 +(x%10);
				x/=10;
			
		}
		//System.out.println(y);
		if(y==z) return true;
	    return false;
	}
}
