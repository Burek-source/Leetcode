Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time, return that integer.

 

Example 1:

Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6

  
Example 2:

Input: arr = [1,1]
Output: 1
 

Constraints:

1 <= arr.length <= 10^4
0 <= arr[i] <= 10^5

class Solution 
{
    public int findSpecialInteger(int[] arr) 
    {
        double percent = (arr.length * 0.25) ;
        int num = 0;

        Map<Integer, Double> map = new HashMap<>();

        // Find the number that appears more than 25% in the array
        for (int c : arr) 
        {
            map.merge(c, 1.0, Double::sum);

            if(map.get(c) > percent)
            {
                num = c;
                break;
            }
        }
        return num;
    }
}
