Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.

 

Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.

  
Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.

  
Example 3:

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]
 

Constraints:

1 <= nums.length <= 100
-100 <= nums[i] <= 100


class Solution 
{
    public int[] frequencySort(int[] nums) 
    {
       
        int occurenceCount = 0;
        int size = 0;
        int sharedFrequencyCount = 0;
        int index = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> sortedList = new ArrayList<>();
        ArrayList<Integer> uniqueElements = new ArrayList<>();
        ArrayList<Integer> sortedArray = new ArrayList<>();
        int[] result = new int[nums.length];

        
        // Map the elements in nums with their frequency
        for (int c : nums) 
        {
            map.merge(c, 1, Integer::sum);  
        }

        int[] occurence = new int[map.size()];
        size = occurence.length;

        // Get all distinct occurences 
        for(int key : map.keySet())
        {
            if(!uniqueElements.contains(map.get(key)))
            {
                occurence[occurenceCount] = map.get(key);
                occurenceCount++;
            }

            uniqueElements.add(map.get(key));   
        }
        
        Arrays.sort(occurence); // Sort in increasing order
        
        // Add all elements with the same frequency to a list
        while(size > 0)
        {
            for(int key : map.keySet())
            {
                if(map.get(key) == occurence[index])
                {
                    sharedFrequencyCount++;
                    for(int i = 0; i < occurence[index]; i++)
                    {
                        sortedList.add(key);
                    }
                    
                }
            }
           
            // If more than one element has the same frequency, sort the elements in decreasing order
            if(sharedFrequencyCount > 1 )
            {
                Collections.sort(sortedList);
                Collections.reverse(sortedList);
            }

            sortedArray.addAll(sortedList); // Add to the end of the list
            sortedList.clear();
           
            index++;
            size--;
            sharedFrequencyCount = 0;
        }
        for(int i = 0; i < nums.length; i++)
        {
            result[i] = sortedArray.get(i);
        }
        return result;
    }
}
