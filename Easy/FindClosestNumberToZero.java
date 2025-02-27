Given an integer array nums of size n, return the number with the value closest to 0 in nums. If there are multiple answers, return the number with the largest value.

 

Example 1:

Input: nums = [-4,-2,1,4,8]
Output: 1
Explanation:
The distance from -4 to 0 is |-4| = 4.
The distance from -2 to 0 is |-2| = 2.
The distance from 1 to 0 is |1| = 1.
The distance from 4 to 0 is |4| = 4.
The distance from 8 to 0 is |8| = 8.
Thus, the closest number to 0 in the array is 1.

  
Example 2:

Input: nums = [2,-1,1]
Output: 1
Explanation: 1 and -1 are both the closest numbers to 0, so 1 being larger is returned.
 

Constraints:

1 <= n <= 1000
-10^5 <= nums[i] <= 10^5

class Solution 
{
    public int findClosestNumber(int[] nums) 
    {
       // Returns the only element in the array as the answer
       if(nums.length == 1)
       {
            return nums[0];
       }

        int minNumberToZero = Integer.MAX_VALUE;
        int tempMinNumberToZero = 0;

        // Find which element is closest to zero
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                return 0;
            }

            // Find if a negative number is closer to 0 than the current min number
            else if(nums[i] < 0)
            {
                tempMinNumberToZero = nums[i] * -1;
               

                if(tempMinNumberToZero < Math.abs(minNumberToZero))
                {
                    minNumberToZero = nums[i];
                }
            }

            // Find if a positive number is closer or equal to 0 than the current min number
            else if(nums[i] > 0)
            {
                tempMinNumberToZero = nums[i];

                if(tempMinNumberToZero <= Math.abs(minNumberToZero))
                {
                    minNumberToZero = tempMinNumberToZero;
                }
            }
        }
        return minNumberToZero;
    }
}
