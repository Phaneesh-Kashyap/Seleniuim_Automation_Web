package Programs;

import java.util.Arrays;

public class longestCommonPrefix {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				String[] strs = {"flower","flow","flight"};
//				String val = findit(strs);
				String val = findit2(strs);
				System.out.println(val);
				
			}
	
		public static String findit(String[] strs) {

			for (int i = 0; i<strs.length; i++)
			{
				String prefix = strs[i];
				for (int j = 0; j<prefix.length(); j++)
				{
					
					
				}
				
				System.out.println(strs[i]);
			}
			
			
			return "a";
			
		}
		
		
		 public static String findit1(String[] v) {
		        StringBuilder ans = new StringBuilder();
		        Arrays.sort(v);
		        String first = v[0];
		        String last = v[v.length-1];
		        for (int i=0; i<Math.min(first.length(), last.length()); i++) {
		            if (first.charAt(i) != last.charAt(i)) {
		                return ans.toString();
		            }
		            ans.append(first.charAt(i));
		        }
		        return ans.toString();
		    }
		
		 
		 public static String findit2(String[] v) {
		        Arrays.sort(v);
		        String first = v[0];
		        String last = v[v.length-1];
		        int j=0;
		        
		        for (int i=0; i<Math.min(first.length(), last.length()); i++)
		        {
		        	
		        	if (first.charAt(i) == last.charAt(i)) {
		        		j++;
		        	}
		        	else
		        	{
		        		break;
		        	}
		        }
		        
		        String prefix = first.substring(0, j);
		        return prefix;
		    }
		
		 
}
