package Programs;

public class needle_and_haystack {
	
	 public static void main(String[] args) {
		    
		 	String haystack = "asdfsadbutsad";
		 	String needle = "sad";
		    int ss = strStr(haystack,needle);
		    System.out.println(ss);
		    
		    }
			
	
	
	  public static int strStr(String haystack, String needle)
	    {
		  
		  if (haystack.contains(needle))
		  {
			  return haystack.indexOf(needle);
		  }
		  else
		  {
			  return -1;
		  }
		  
		  
	    }

}
