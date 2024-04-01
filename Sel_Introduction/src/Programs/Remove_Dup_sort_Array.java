package Programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Remove_Dup_sort_Array {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] nums = {0,0,1,1,1,2,2,3,3,4};

		int val = removeDuplicates1(nums);
		System.out.println(val);
		
		System.out.println("Array: " + Arrays.toString(nums));

	}
		
		
		 public static int removeDuplicates1(int[] nums) {
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
	