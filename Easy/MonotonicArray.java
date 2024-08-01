An array is monotonic if it is either monotone increasing or monotone decreasing.

An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].

Given an integer array nums, return true if the given array is monotonic, or false otherwise.

 

Example 1:

Input: nums = [1,2,2,3]
Output: true

  
Example 2:

Input: nums = [6,5,4,4]
Output: true

  
Example 3:

Input: nums = [1,3,2]
Output: false
 

Constraints:

1 <= nums.length <= 10^5
-10^5 <= nums[i] <= 10^5


class Solution 
{
    public boolean isMonotonic(int[] nums) 
    {   
        int temp = nums[0];
        boolean isDecreasing = false;
        boolean isIncreasing = false;
        

        // Edge case: if the length of nums is 1
        if(nums.length == 1)
        {
            return true;
        }

        // Check that the array is either decreasing or increasing
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] < temp)
            {
                isDecreasing = true;
                temp = nums[i];

                if(isDecreasing == true && isIncreasing == true)
                {
                    return false;
                }
            }
            else if(nums[i] > temp)
            {
                isIncreasing = true;
                temp = nums[i];

                if(isDecreasing == true && isIncreasing == true)
                {    
                    return false;
                }
            }  
        }
        return true;
    }
}
