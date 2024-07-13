Given two integer arrays nums1 and nums2, return an array of their intersection. 
Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000

class Solution 
{
    public int[] intersection(int[] nums1, int[] nums2) 
    {
        Map<Integer, Integer> nums1Map = new HashMap<>();
        Map<Integer, Integer> nums2Map = new HashMap<>();

        // Get frequency of each number in nums1
        for (int c : nums1) 
        {
            nums1Map.merge(c, 1, Integer::sum);  
        }

        // Get frequency of each number in nums2
        for (int c : nums2) 
        {
            nums2Map.merge(c, 1, Integer::sum);  
        }

        Set<Integer> s1 = nums1Map.keySet();
        Set<Integer> s2 = nums2Map.keySet();
        s1.retainAll(s2); // Get intersection of nums1 and nums2
        
        int[] intersection = new int[s1.size()];
        List<Integer> result = new ArrayList<>();
        result.addAll(s1);

        for(int i = 0; i < result.size(); i++)
        {
            intersection[i] = result.get(i);
        }

        return intersection;
    }
}
