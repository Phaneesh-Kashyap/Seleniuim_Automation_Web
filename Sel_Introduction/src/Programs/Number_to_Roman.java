package Programs;

import java.util.HashMap;

public class Number_to_Roman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				String val1 = "III";
				int val = Convert(val1);
				System.out.println(val);
			}

			public static int Convert(String num) {
				
				 HashMap<String, Integer> map = new HashMap<>();
				 map.put("I", 1);
				 map.put("V", 5);
				 map.put("X", 10);
				 map.put("L", 50);
				 map.put("C", 100);
				 map.put("D", 500);
				 map.put("M", 1000);
				
				return 100;
				
		    }

}