Given an binary array nums and an integer k, return true if all 1's are at least k places away from each other, otherwise return false.

 

Example 1:


Input: nums = [1,0,0,0,1,0,0,1], k = 2
Output: true
Explanation: Each of the 1s are at least 2 places away from each other.

  
Example 2:


Input: nums = [1,0,0,1,0,1], k = 2
Output: false
Explanation: The second 1 and third 1 are only one apart from each other.
 

Constraints:

1 <= nums.length <= 10^5
0 <= k <= nums.length
nums[i] is 0 or 1


class Solution 
{
    public boolean kLengthApart(int[] nums, int k) 
    {
        int spacesApart = 0;
        int onesFound = 0;

        // Find if all ones are separated by atleast k spaces apart
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 1)
            {
                onesFound++;

                // If two distinct ones are found, check the length of space between them
                if(onesFound == 2 && spacesApart < k)
                {
                    return false;
                }

                // Reset the space counter on every 1 found with the exception of the first 1
                if(onesFound == 2)
                {
                    spacesApart = 0;
                    onesFound--;
                }    
            }

            // Space is counted whenever a 0 is found
            else
            {
                spacesApart++;
            }
        }
        return true;
    }
}
