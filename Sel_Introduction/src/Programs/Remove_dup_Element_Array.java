package Programs;

import java.util.Arrays;

public class Remove_dup_Element_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {3,2,2,3};
		int val = 3;

		int op = removeDuplicates(nums,val);
		System.out.println(op);
		
		//System.out.println("Array: " + Arrays.toString(nums));

	}
		
		
		private static int removeDuplicates(int[] nums, int val) {
			 int i = 0; 
		        for (int j = 0; j < nums.length; j++) {
		            if (nums[j] != val) {
		                nums[i] = nums[j]; 
		                i++; 
		            }
		        }
		        
		       System.out.println("Array: " + Arrays.toString(nums));
		        return i;
	}


		public int removeElement(int[] nums, int val) {
		        int i = 1; 
		        for (int j = 1; j < nums.length; j++) {
		            if (nums[j] != nums[j - 1]) {
		                nums[i] = nums[j]; 
		                i++; 
		            }
		        }
		        
		        return i; 
		    }
	
}
