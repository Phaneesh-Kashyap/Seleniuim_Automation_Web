package Programs;

public class Add_binary_numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "111", b = "1";
		String sumval = addBinary(a,b);
		String sumval1 = addBinary1(a,b);
		System.out.println(sumval);
		System.out.println(sumval1);
	}

	public static String addBinary(String a, String b) {
		
		int alen = a.length();
		int blen = b.length();
		char aval,bval;
		
		int bigone = Math.max(alen, blen);
		String retval = "";
		boolean charryforward=false;
		
		for(int i=0 ; i<bigone; i++)
		{
				StringBuilder areversed = new StringBuilder(a).reverse();
				StringBuilder breversed = new StringBuilder(b).reverse();
				
				if(i<alen) {
					aval = areversed.charAt(i);
					
				}
				else {
					aval='0';
				}
					
				
				if(i<blen) {
					bval = breversed.charAt(i);
				}
				else {
					bval='0';
				}
					
					
				if(aval=='1' && bval=='1')
				{
					if(charryforward)
					{
						retval = "1" + retval;
						charryforward = true;	
					}
					else
					{
						retval = "0" + retval;
						charryforward = true;	
					}
				}
				else if((aval=='0' && bval=='1')||(aval=='1' && bval=='0'))
				{
					if(charryforward)
					{
						retval = "0" + retval;
						charryforward = true;	
					}
					else
					{
						retval = "1" + retval;
						charryforward = false;	
					}	
				}
				else if(aval=='0' && bval=='0')
				{
					if(charryforward)
					{
						retval = "1" + retval;
						charryforward = false;	
					}
					else
					{
						retval = "0" + retval;
						charryforward = false;	
					}		
				}
			
		}
		
		if(charryforward)
		{
			retval = "1" + retval;
			charryforward = false;	
		}
		
		
		return retval;
        
    }
	
	  public static String addBinary1(String a, String b) {
	        String val = "";
	        int i = a.length() - 1, j = b.length() -1, carry = 0;
	        while (i >= 0 || j >= 0) {
	            int sum = carry;
	            if (j >= 0)
	            {
	            	sum = sum + b.charAt(j--) - '0';
	            }
	            if (i >= 0)
	            {
	            	sum = sum + a.charAt(i--) - '0';
	            }	
	            val = String.valueOf(sum % 2) + val ;
	            carry = sum / 2;
	        }
	        if (carry != 0) 
        	{
	        	val = "1" + val ;;
        	}
	        
	        return val;
	    }
	
	
}