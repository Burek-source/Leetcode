Given a binary array nums, return the maximum number of consecutive 1's in the array.

 

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

  
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2
 

Constraints:

1 <= nums.length <= 10^5
nums[i] is either 0 or 1.

class Solution 
{
    public int findMaxConsecutiveOnes(int[] nums) 
    {   
        int count = 0;
        int tempCount = 0;

        if(nums[0] == 1)
        {
            count = 1;
            tempCount = 1;
        }

        // Find the max number of consecutive ones
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                if(tempCount > count)
                {
                    count = tempCount;
                }
                tempCount = 0;
            }
            else
            {
                tempCount++;
            }

            if(i == nums.length-1 && tempCount > count)
            {
                count = tempCount;
            }
        }
        return count;
    }
}
