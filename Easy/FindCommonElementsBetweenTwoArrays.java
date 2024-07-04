You are given two integer arrays nums1 and nums2 of sizes n and m, respectively. Calculate the following values:

answer1 : the number of indices i such that nums1[i] exists in nums2.
answer2 : the number of indices i such that nums2[i] exists in nums1.
Return [answer1,answer2].

 

Example 1:

Input: nums1 = [2,3,2], nums2 = [1,2]

Output: [2,1]

Explanation:



Example 2:

Input: nums1 = [4,3,2,3,1], nums2 = [2,2,5,2,3,6]

Output: [3,4]

Explanation:

The elements at indices 1, 2, and 3 in nums1 exist in nums2 as well. So answer1 is 3.

The elements at indices 0, 1, 3, and 4 in nums2 exist in nums1. So answer2 is 4.

Example 3:

Input: nums1 = [3,4,2,3], nums2 = [1,5]

Output: [0,0]

Explanation:

No numbers are common between nums1 and nums2, so answer is [0,0].

 

Constraints:

n == nums1.length
m == nums2.length
1 <= n, m <= 100
1 <= nums1[i], nums2[i] <= 100

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution 
{
    public int[] findIntersectionValues(int[] nums1, int[] nums2) 
    {
        int answer1 = 0;
        int answer2 = 0;

        int[] answer = new int[2];

        Map<Integer, Integer> nums1Count = new HashMap<>(); // Keeps track of each number occurence in nums1
        Map<Integer, Integer> nums2Count = new HashMap<>(); // Keeps track of each number occurence in nums2

        
        // Map values from the frist array
        for (int c : nums1) 
        {
            nums1Count.merge(c, 1, Integer::sum);  
        }
        // Map the values from the second array
        for (int c : nums2) 
        {
            nums2Count.merge(c, 1, Integer::sum);  
        }

        Set<Integer> s1 = nums1Count.keySet();
        Set<Integer> s2 = nums2Count.keySet();
        s1.retainAll(s2); // Get the intersection keys between two sets

        List<Integer> result = new ArrayList<>(); // Create the list of all common keys between the two sets
        result.addAll(s1);

        // Check the values for each set key in each hashmap
        for(int i = 0; i < result.size(); i++)
        {
            answer1 += nums1Count.get(result.get(i));
            answer2 += nums2Count.get(result.get(i));
        }

        answer[0] = answer1;
        answer[1] = answer2;

        return answer;
    }
}
