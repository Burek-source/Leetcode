Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

  
Example 2:

Input: nums = [1,1]
Output: [2]
 

Constraints:

n == nums.length
1 <= n <= 10^5
1 <= nums[i] <= n
 

Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.


class Solution 
{
    public List<Integer> findDisappearedNumbers(int[] nums) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> missinIntegers = new ArrayList<>();
        
        // Create a hashmap of integers from 1 to the length of nums array
        for(int i = 1; i <= nums.length; i++)
        {
            map.put(i, 0);
        }
     
        // Add all values from nums to the hashmap with the same key
        for(int i = 0; i < nums.length; i++)
        {
            map.merge(nums[i], 1, Integer::sum);
        }

        // Find all keys that do not appear in the nums array
        for(int key : map.keySet())
        {
            if(map.get(key) == 0)
            {
                missinIntegers.add(key);
            }
        }
        return missinIntegers;
    }
}
