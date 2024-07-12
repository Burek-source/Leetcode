You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.

Return the sum of all the unique elements of nums.

 

Example 1:

Input: nums = [1,2,3,2]
Output: 4
Explanation: The unique elements are [1,3], and the sum is 4.

  
Example 2:

Input: nums = [1,1,1,1,1]
Output: 0
Explanation: There are no unique elements, and the sum is 0.

  
Example 3:

Input: nums = [1,2,3,4,5]
Output: 15
Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100

class Solution 
{
    public int sumOfUnique(int[] nums) 
    {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        // Count the occurrence of each number
        for (int c : nums) 
        {
            map.merge(c, 1, Integer::sum);  
        }

        // Get individual keys and values from a hashmap
        for(int key : map.keySet())
        {
            // Sum up only the numbers that appear once
            if(map.get(key) == 1)
            {
                sum += key;
            }
        }

        return sum;

    }
}
