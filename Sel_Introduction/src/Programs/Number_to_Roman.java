package Programs;

import java.util.HashMap;

public class Number_to_Roman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				String val1 = "MCMXCIV";
				int val = Convert(val1);
				System.out.println(val);
				
			}

			public static int Convert(String s) {
				
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
