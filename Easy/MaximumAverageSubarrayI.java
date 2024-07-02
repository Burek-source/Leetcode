You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

 

Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

  
Example 2:

Input: nums = [5], k = 1
Output: 5.00000
 

Constraints:

n == nums.length
1 <= k <= n <= 105
-10^4 <= nums[i] <= 10^4

class Solution 
{
    public double findMaxAverage(int[] nums, int k) 
    {
        int moves = k-1;

        double highest = 0;
        double tempSum = 0;

        int totalToCheck = nums.length - k;

        // Check the first subArray sum
        for(int i = 0; i < k; i++)
        {
            highest += nums[i];
        }

        tempSum = highest;

        // Check the sums of all other possible subarrays and compare with the highest score
        for(int i = 1; i <= totalToCheck; i++)
        {
            moves++;
            tempSum = tempSum - nums[i-1] + nums[moves];

            System.out.println(tempSum);

            if(tempSum > highest)
            {
                highest = tempSum;
            }
        }

        double average = highest / k;
        return average;
    }
}
