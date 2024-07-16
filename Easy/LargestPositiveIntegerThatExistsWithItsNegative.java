Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also exists in the array.

Return the positive integer k. If there is no such integer, return -1.

 

Example 1:

Input: nums = [-1,2,-3,3]
Output: 3
Explanation: 3 is the only valid k we can find in the array.


Example 2:

Input: nums = [-1,10,6,7,-7,1]
Output: 7
Explanation: Both 1 and 7 have their corresponding negative values in the array. 7 has a larger value.


Example 3:

Input: nums = [-10,8,6,7,-2,-3]
Output: -1
Explanation: There is no a single valid k, we return -1.
 

Constraints:

1 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
nums[i] != 0

class Solution 
{
    public int findMaxK(int[] nums) 
    {
        Arrays.sort(nums);

        int leftPointer = 0;
        int rightPointer = nums.length-1;
       
        // Find the largest positive number that has its negative counterpart. Start with the largest positive number and move inwards
        for(int i = 0; i < nums.length; i++)
        {

            // If the sum of two numbers is 0, largest positive number that has its negative counterpart has been found
            if(nums[rightPointer] + nums[leftPointer] == 0)
            {
                return nums[rightPointer];
            }

            // If the sum is negative, the smallest negative number is too small. Move towards 0.
            else if(nums[rightPointer] + nums[leftPointer] < 0)
            {
                leftPointer++;
            }

            // If the sum is positive, the highest positive number is too high. Move towards 0.
            else if(nums[rightPointer] + nums[leftPointer] > 0)
            {
                rightPointer--;
            }
        }

        return -1; // If no number found, return -1
 
    }
}
