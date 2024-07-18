Given three integer arrays nums1, nums2, and nums3, return a distinct array containing all the values that are present in at least two out of the three arrays. You may return the values in any order.
 

Example 1:

Input: nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
Output: [3,2]
Explanation: The values that are present in at least two arrays are:
- 3, in all three arrays.
- 2, in nums1 and nums2.

  
Example 2:

Input: nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
Output: [2,3,1]
Explanation: The values that are present in at least two arrays are:
- 2, in nums2 and nums3.
- 3, in nums1 and nums2.
- 1, in nums1 and nums3.

  
Example 3:

Input: nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
Output: []
Explanation: No value is present in at least two arrays.
 

Constraints:

1 <= nums1.length, nums2.length, nums3.length <= 100
1 <= nums1[i], nums2[j], nums3[k] <= 100


class Solution 
{
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) 
    {
        Map<Integer, Integer> nums1Map = new HashMap<>();
        Map<Integer, Integer> nums2Map = new HashMap<>();
        Map<Integer, Integer> nums3Map = new HashMap<>();

        ArrayList<Integer> partialIntersection = new ArrayList<>();

        // Create a map for nums1 array
        for (int c : nums1) 
        {
            nums1Map.merge(c, 1, Integer::sum);  
        }

        // Create a map for nums2 array
        for (int c : nums2) 
        {
            nums2Map.merge(c, 1, Integer::sum);  
        }

        // Create a map for nums3 array
        for (int c : nums3) 
        {
            nums3Map.merge(c, 1, Integer::sum);  
        }

        // Check if keys in the first map are present in either of other two maps
        for(int key : nums1Map.keySet())
        {
            if(nums2Map.containsKey(key) || nums3Map.containsKey(key))
            { 
                partialIntersection.add(key);     
            }
        }

        // Check if keys in second map are present in the third map
        for(int key : nums2Map.keySet())
        {
            if(nums3Map.containsKey(key) && !partialIntersection.contains(key))
            {
                partialIntersection.add(key); 
            }
        }
        return partialIntersection;
    }
}
