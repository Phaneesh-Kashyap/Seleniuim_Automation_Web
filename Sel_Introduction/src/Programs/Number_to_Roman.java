package Programs;

import java.util.HashMap;

public class Number_to_Roman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				String val1 = "LVIII";
				int val = Convert(val1);
				System.out.println(val);
				
			}
	
	
	public static int Convert(String s) {
		
		int value=0,prev=0;
        for(char ch: s.toCharArray())
        {
            switch(ch)
            {
                case 'I': 
                	value = value + 1;
                	prev=1;
                	break;
                case 'V': 
                	value= value + ((prev==1)?3:5);
                	prev=5;
                	break;
                	
                case 'X': 
                	value= value + ((prev==1)?8:10);
                	prev=10;
                	break;
                case 'L': 
	                value= value + ((prev==10)?30:50);
	            	prev=50;
	            	break;
                case 'C': 
                	value= value + ((prev==10)?80:100);
 	            	prev=100;
 	            	break;
                case 'D': 
                	value= value + ((prev==100)?300:500);
 	            	prev=500;
 	            	break;
                case 'M': 
                	value= value + ((prev==100)?800:1000);
 	            	prev=1000;
 	            	break;
            }
        }
        return value;
    	
	}
	
	
	

			public static int Convert1(String s) {
				
				 HashMap<Character, Integer> map = new HashMap<>();
				 map.put('I', 1);
				 map.put('V', 5);
				 map.put('X', 10);
				 map.put('L', 50);
				 map.put('C', 100);
				 map.put('D', 500);
				 map.put('M', 1000);
				 
				 int val=0;
				
				 
				 for (int i = 0; i < s.length(); i++) 
			        {
					 
					 char ch_before = s.charAt(i);
					 int v_after = 0;
					 
					 if(!(i+1==s.length()))
					 {
						 char ch_after = s.charAt(i+1);
						 v_after  = map.get(ch_after);
					 }
					 
					 
					 int v_before  = map.get(ch_before);
					 
					 
					 if (v_after > v_before)
					 {
						 val = val + v_after - v_before;
						 i++;
					 }
					 else
					 {
						 val = val + v_before;
					 }
			        }
				 
				return val;
				
		    }

}
