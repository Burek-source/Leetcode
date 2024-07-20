Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.

A subarray is defined as a contiguous sequence of numbers in an array.

A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i where l <= i < r, numsi  < numsi+1. Note that a subarray of size 1 is ascending.

 

Example 1:

Input: nums = [10,20,30,5,10,50]
Output: 65
Explanation: [5,10,50] is the ascending subarray with the maximum sum of 65.

  
Example 2:

Input: nums = [10,20,30,40,50]
Output: 150
Explanation: [10,20,30,40,50] is the ascending subarray with the maximum sum of 150.

  
Example 3:

Input: nums = [12,17,15,13,10,11,12]
Output: 33
Explanation: [10,11,12] is the ascending subarray with the maximum sum of 33.
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100


class Solution 
{
    public int maxAscendingSum(int[] nums) 
    {
        int sum = nums[0]; 
        int tempSum = nums[0];

        // Find the largest sum in an anscending subarray
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] > nums[i-1])
            {
                tempSum += nums[i];
                
            }
            // The array is no longer ascending if the current element is lower or equal to the previous element
            else if(nums[i] <= nums[i - 1])
            {
                if(tempSum > sum)
                {
                    sum = tempSum;
                }

                tempSum = nums[i]; // New potential largest sum begins with the current element
            }

            // The last sum can possibly be the largest sum
            if(i == nums.length-1)
            {
                if(tempSum > sum)
                {
                    sum = tempSum;
                }
            }
        }
        return sum;
    }
}
