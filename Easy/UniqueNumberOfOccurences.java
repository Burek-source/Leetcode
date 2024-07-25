Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

 

Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.

  
Example 2:

Input: arr = [1,2]
Output: false

  
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
 

Constraints:

1 <= arr.length <= 1000
-1000 <= arr[i] <= 1000
  

class Solution 
{
    public boolean uniqueOccurrences(int[] arr) 
    {   
        Map<Integer, Integer> map = new HashMap<>();
        boolean isUnique = true;
        int count = 1;

        // If the array only has one element, it is always going to have unique number of occurences
        if(arr.length == 1)
        {
            return true;
        }

        Arrays.sort(arr);

        // Find if occurences of all distinct numbers are unique  
        for(int i = 1; i < arr.length; i++)
        {

            // In a sorted array, when the current number is different from the previous number, check if its occurence exists in a hashmap. If it does, it is no longer unique.
            if(arr[i] != arr[i-1])
            {
                if(!map.containsKey(count))
                {
                    map.merge(count, 1, Integer::sum);
                    count = 1;
                }
                else
                {
                    isUnique = false;
                    break;
                }
            }
            // As long as the current and previous number are same, increment the count
            else
            {
                count++;
            }

            // End of the array - posibility 1: If the last element is the same as previous, check if its occurence occurs in the hashmap.
            if(i == arr.length - 1 && arr[i] == arr[i-1])
            {
                if(!map.containsKey(count))
                {
                    map.merge(count, 1, Integer::sum);
                    count = 1;
                }
                else
                {
                    isUnique = false;
                }
            }
            // End of the array - possiblity 2: If the last element is different from the previous element, check if 1 occurs in the hashmap.
            else if(i == arr.length - 1 && arr[i] != arr[i-1])
            {
                if(!map.containsKey(count))
                {
                    map.merge(count, 1, Integer::sum);
                    count = 1;
                }
                else
                {
                    isUnique = false;
                }
            }    
        }
        return isUnique;
    }
}
