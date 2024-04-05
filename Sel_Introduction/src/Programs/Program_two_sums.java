package Programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Program_two_sums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] nums1 = {3,2,4};
		 int target1 = 6;
		 int[] val = twoSum2(nums1,target1);
		 System.out.println(val[0] + " , " + val[1]);
		 
		
	}
		
		public static int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];
        int  k;
        boolean flag = false;
          
        for (int i = 0; i < nums.length ; i++)
        {
        	int search = target - nums[i];
        	
        	for (k = 0; k < nums.length ; k++)
        	{
        		if (nums[k] == search && i != k)
        		{
        			flag = true;
        			break;
        		}
        	}
        	
        	if (flag)
        	{
        		//System.out.println("[" + i + "," + k + "]");
        		res[0] = i;
        		res[1] = k;
        		
        		return res;
        		
        	}
        	
        	
        }
		return res;

	}

		
		
		public static int[] twoSum1(int[] nums, int target) {

			//{3,2,4};6;
	          
	        HashMap<Integer, Integer> map = new HashMap<>();

	        // Iterate through the array
	        for (int i = 0; i < nums.length; i++) 
	        {
	            int complement = target - nums[i];
	            
	            // Check if the complement exists in the hashmap
	            if (map.containsKey(complement)) 
	            {
	                // If found, return the indices of the two numbers
	                return new int[] {map.get(complement), i};
	            }
	            
	            // Otherwise, put the current element and its index into the hashmap
	            map.put(nums[i], i);
	        }
	        
	        // If no solution is found, return an empty array
	        return new int[0];
		}

		
		public static int[] twoSum2(int[] nums, int target) {

			//{3,2,4};6;
	          
			int[][] numsIndex = new int[nums.length][2];
		    for (int i = 0; i < nums.length; i++) {
		    	numsIndex[i][0] = nums[i];
		    	numsIndex[i][1] = i;
		    }


		    Arrays.sort(numsIndex, Comparator.comparingInt(arr -> arr[0]));
		    int left = 0, right = nums.length - 1;
		    while (left < right) {
		        int sum = numsIndex[left][0] + numsIndex[right][0];
		        if (sum == target) {
		            return new int[] {numsIndex[left][1], numsIndex[right][1]};
		        } else if (sum < target) {
		            left++;
		        } else {
		            right--;
		        }
		    }
		    return new int[]{}; // No solution found!
		}

		
		
}
