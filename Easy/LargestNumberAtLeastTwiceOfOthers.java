You are given an integer array nums where the largest integer is unique.

Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.

 

Example 1:

Input: nums = [3,6,1,0]
Output: 1
Explanation: 6 is the largest integer.
For every other number in the array x, 6 is at least twice as big as x.
The index of value 6 is 1, so we return 1.

  
Example 2:

Input: nums = [1,2,3,4]
Output: -1
Explanation: 4 is less than twice the value of 3, so we return -1.
 

Constraints:

2 <= nums.length <= 50
0 <= nums[i] <= 100
The largest element in nums is unique.

class Solution 
{
    public int dominantIndex(int[] nums) 
    {
        int[] copyOfnums = nums.clone();
        int index = -1;

        Arrays.sort(nums);
        int largest = nums[nums.length-1];

        // Check if the second largest number is bigger than largest / 2
        if(largest / 2 < nums[nums.length-2])
        {
            return index;
        }

        // Find the index of the largest number
        for(int i = 0; i < copyOfnums.length; i++)
        {
            if(copyOfnums[i] == largest)
            {
                index = i;
                break;
            }
        }
        return index;
    }
}
