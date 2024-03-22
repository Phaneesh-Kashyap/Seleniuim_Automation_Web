
public class Number_To_String 
{

	static String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	static String[] teens = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	static String[] tens = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    
    
    
    public static void main(String[] args) {
    
    int num = 2457983;	
    String ss = Convert_to_String(num);
    System.out.println(num + " = " + ss);
    
    }
	
    
    
    public static String Convert_to_String(int val)
    {
    	String word = "";
    	
    	if ((val/100000) > 0)
    	{
    		word += Convert_to_String(val/100000) + " Lakh ";
    		val %= 100000;
    	}
    	
    	if ((val/1000) > 0)
    	{
    		word += Convert_to_String(val/1000) + " Thousand ";
    		val %= 1000;
    	}
    	
    	if ((val/100) > 0)
    	{
    		word += Convert_to_String(val/100) + " Hundred ";
    		val %= 100;
    	}
    	
    	if (val > 0)
    	{
    		if (val < 10)
    		{
    			word += units[val];
    		}
    		else if (val < 20)
    		{
    			word += teens[val-10];
    		}
    		else
    		{
    			word += tens[val/10] + " " + units[val%10];
    		}
    		
    		
    	}
    	
    	
    	return word.trim();
    }
    
    
	
}
