Given an integer array nums, return the most frequent even element.

If there is a tie, return the smallest one. If there is no such element, return -1.

 

Example 1:

Input: nums = [0,1,2,2,4,4,1]
Output: 2
Explanation:
The even elements are 0, 2, and 4. Of these, 2 and 4 appear the most.
We return the smallest one, which is 2.

  
Example 2:

Input: nums = [4,4,4,9,2,4]
Output: 4
Explanation: 4 is the even element appears the most.

  
Example 3:

Input: nums = [29,47,21,41,13,37,25,7]
Output: -1
Explanation: There is no even element.
 

Constraints:

1 <= nums.length <= 2000
0 <= nums[i] <= 10^5

class Solution 
{
    public int mostFrequentEven(int[] nums) 
    {
        int mostFrequentEvenInt = -1;
        int max = 0;

        Map<Integer, Integer> evenIntmap = new HashMap<>();

        // Map the frequency of all even integers
        for (int c : nums) 
        {
            if(c % 2 == 0)
            {
                evenIntmap.merge(c, 1, Integer::sum);
            }
              
        }

        // Will throw an error if hashmap no elements
        if(evenIntmap.size() > 0)
        {
            max = Collections.max(evenIntmap.values());
        }

        
        // Checks how many elements in the hashmap have the max frequency. Returns the smallest integer.
        for(int key : evenIntmap.keySet())
        {
            if(evenIntmap.get(key) == max && mostFrequentEvenInt == -1)
            {
                mostFrequentEvenInt = key;
            }
            else if(evenIntmap.get(key) == max && key < mostFrequentEvenInt)
            {
                mostFrequentEvenInt = key;
            }
        }
        return mostFrequentEvenInt;

    }
}
