Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

  
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 

Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

import java.util.ArrayList;

class Solution 
{
    public int[] intersect(int[] nums1, int[] nums2) 
    {
        ArrayList<Integer> intersection = new ArrayList<Integer>(); 

        // Check which array is smaller
        if(nums1.length < nums2.length)
        {
            for(int i = 0; i < nums1.length; i++)
            {
                for(int j = 0; j < nums2.length; j++)
                {
                    if(nums1[i] == nums2[j])
                    {
                        intersection.add(nums1[i]);
                        nums2[j] = 1001; // If element found, replace it with 1001 as it is out of the constraint
                        break;
                    }
                }
            }
        }
        
        // If arr2 is smaller or equal to arr1, compare its elements to arr1 elements
        else
        {
            for(int i = 0; i < nums2.length; i++)
            {
                for(int j = 0; j < nums1.length; j++)
                {
                    if(nums2[i] == nums1[j])
                    {
                        intersection.add(nums2[i]);
                        nums1[j] = 1001; // If element found, replace it with 1001 as it is out of the constraint
                        break;
                    }
                }
            }
        }
        
        int[] intersectionArr = new int[intersection.size()];

        // Convert ArrayList to Array
        for(int i = 0; i < intersection.size(); i++)
        {
            intersectionArr[i] = intersection.get(i);
        }

        return intersectionArr;
    }
}
