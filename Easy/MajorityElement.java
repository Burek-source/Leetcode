Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3

  
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 10^4
-109 <= nums[i] <= 10^9
 

Follow-up: Could you solve the problem in linear time and in O(1) space?

class Solution 
{
    public int majorityElement(int[] nums) 
    {
        Map<Integer, Integer> map = new HashMap<>();

        // Map each number with how many times it occurs in an array
        for (int c : nums) 
        {
            map.merge(c, 1, Integer::sum);  
        }

        // Get the key with the highest value
        int max = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();

        return max;
    }
}
