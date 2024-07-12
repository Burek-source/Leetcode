Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

 

Example 1:

Input: nums = [2,2,1]
Output: 1

  
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4

  
Example 3:

Input: nums = [1]
Output: 1
 

Constraints:

1 <= nums.length <= 3 * 10^4
-3 * 104 <= nums[i] <= 3 * 10^4
Each element in the array appears twice except for one element which appears only once.

class Solution 
{
    public int singleNumber(int[] nums) 
    {     
        Arrays.sort(nums); 
        int nonRepeating = 0;

        if(nums.length == 1)
        {
            return nums[0];
        }

        // If the first element in a sorted array is not the same as the second element, the first element is the unique one
        if(nums[0] != nums[1])
        {
            return nums[0];
        }

        // If the last element in a sorted array is not the same as the second to last element, the last element is unique
        if(nums[nums.length-1] != nums[nums.length-2])
        {
            return nums[nums.length-1];
        }

        // Find the unique element by checking values left of the current element and right of the current element. If in both cases the current element is different to the compared elements, the current element is unique
        for(int i = 1; i < nums.length-1; i++)
        {
            if(nums[i] != nums[i-1] && nums[i] != nums[i+1])
            {
                nonRepeating = nums[i];
                break;
            }
           
        }

        return nonRepeating;
    }
}
