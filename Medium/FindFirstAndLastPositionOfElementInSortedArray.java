Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

  
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

  
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums is a non-decreasing array.
-10^9 <= target <= 10^9

class Solution 
{
    public int[] searchRange(int[] nums, int target) 
    {
        int[] targetArr = {-1, -1};

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        int tempIndex = 0;

        // If the array is empty
        if(nums.length == 0)
        {
          return targetArr;
        }

        // Find the index of the target number
        while(true)
        {
            // If left index is higher than the right, the target number is not present in the array
            if(left > right)
            {
                break;
            }
            else
            {
                mid = (left + right) / 2;

                // Index of the target number found
                if(nums[mid] == target)
                {
                    tempIndex = mid; 
                    break;
                }
                // If the target number is lower than the current half, the target number is in the lower half. Set the right half to current mid - 1
                else if(target < nums[mid])
                {
                    right = mid - 1;
                }
                // If the target number is higher than the current half, the target number is in the upper half. Set the left half to current mid + 1
                else if(target > nums[mid])
                {
                    left = mid + 1;
                }
            }   
                
        }
      
        //Find the first index of the target number
        for(int i = tempIndex; i > -1; i--)
        {
            // Look through the lower portion of the array for the index position of the first occurence of the target number. 
            if(nums[i] == target)
            {
                left = i;
                targetArr[0] = left;
            }
            else
            {
                break;
            }
        }

        // Find the last index of the target number
        for(int i = tempIndex; i < nums.length; i++)
        {
            // Look through the upper portion of the array for the index position of the last occurence of the target number. 
            if(nums[i] == target)
            {
                right = i;
                targetArr[1] = right;
            }
            else
            {
                break;
            }
        }     
        return targetArr;   
    }
}
