package Programs;

public class Search_Insert_Position {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {9,9,9,9};
		
		int target = 7;
		
		//int[] nums1 = plusOne(nums);
		int[] nums2 = plusOne1(nums);
		 for(int i=0; i<nums2.length; i++)
		  {
			 System.out.println(nums2[i]);
			  
		  }
		
		
			String s="Hello World";
		  String[] litrals = s.split(" ");
		  //int len = litrals.length;
		  System.out.println(litrals[litrals.length-1].length());
		  //int len = litrals.length;
		  
		  
		
	 	
	    int ss = searchInsert(nums,target);
	    System.out.println(ss);

	}

	
	  public static int searchInsert(int[] nums, int target) {
		  int i;
		  
		  
		  for (i=0; i<nums.length;i++)
		  {
			  if (nums[i]>=target)
			  {
				  return i;
			  }
		  }
		return i;
		
		
		
		    
	    }
	  
	  
	  public static int[] plusOne(int[] digits) 
	  {
		  long val = 0;
		  for(int i=0; i<digits.length; i++)
		  {
			  val=val*10+digits[i];
		  }
		  val++;
		  String val2 = Long.toString(val);
		  int[] newdigit = new int[val2.length()];
		  for(int i=0; i<val2.length() ;i++)
		  {
			  newdigit[i]=Character.getNumericValue(val2.charAt(i));
			  
		  }
		  
		  return newdigit;

	    }
	  
	  
	  public static int[] plusOne1(int[] digits) 
	  {
		  	
		    for(int i=digits.length-1; i>=0; i--) {
		        if(digits[i] < 9) {
		            digits[i]++;
		            return digits;
		        }
		        
		        digits[i] = 0;
		    }
		    
		    int[] newNumber = new int [digits.length+1];
		    newNumber[0] = 1;
		    
		    return newNumber;

	    }


}