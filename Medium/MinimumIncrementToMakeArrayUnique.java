You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.
Return the minimum number of moves to make every value in nums unique. The test cases are generated so that the answer fits in a 32-bit integer.

 

Example 1:

Input: nums = [1,2,2]
Output: 1
Explanation: After 1 move, the array could be [1, 2, 3].

  
Example 2:

Input: nums = [3,2,1,2,1,7]
Output: 6
Explanation: After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 

Constraints:

1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5

import java.util.ArrayList;
import java.util.Arrays;

class Solution 
{
    public int minIncrementForUnique(int[] nums) 
    {
       
        int moves = 0;
        int keepTrackOf = 0;
        boolean found = false;

        ArrayList<Integer> duplicates = new ArrayList<>();
        ArrayList<Integer> missingElemenets = new ArrayList<>();

        Arrays.sort(nums); // Sort the array
        int uniqueElement = nums[0];
        int lastElement = nums[nums.length-1]+1;
    
        // Find duplicates and missing elements
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] == uniqueElement)
            {
                duplicates.add(nums[i]);
            }
            else if(nums[i] - uniqueElement != 1)
            {
                int temp = nums[i];
                for(int j = nums[i]; j >uniqueElement+1; j--)
                {
                    temp--;
                    missingElemenets.add(temp);
                }
            }

            uniqueElement = nums[i];
        }

        missingElemenets.sort(null);

        // Get the minimum number of moves
        for(int i = 0; i < duplicates.size(); i++)
        {
            found = false;
            // As long as there are enough missing elements
            if(keepTrackOf < missingElemenets.size())
            {
                for(int j = keepTrackOf; j < missingElemenets.size(); j++)
                {
                    if(duplicates.get(i) < missingElemenets.get(j))
                    {
                        moves += missingElemenets.get(j) - duplicates.get(i);
                        keepTrackOf = j+1;
                        found = true;
                        j = missingElemenets.size();
                    }
                }
            }

            // If there are no more missing elements
            if(found == false)
            {
                moves += lastElement - duplicates.get(i);
                lastElement++;
            }      
            
        }

        return moves;
    }
    
}
