Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
 
Example 1:

Input: arr = [2,6,4,1]
Output: false
Explanation: There are no three consecutive odds.
Example 2:

Input: arr = [1,2,34,3,4,5,7,23,12]
Output: true
Explanation: [5,7,23] are three consecutive odds.


class Solution 
{
    public boolean threeConsecutiveOdds(int[] arr) 
    {
        int count = 0;
        boolean threeOddsFound = false; // Indicates if three consecutive odd numbers have been found

        // Checks if three consecutive odd numbers appear anywhere in the array
        for (int i = 0; i < arr.length; i++) 
        {
            // Checks if a number is odd 
            if (arr[i] % 2 != 0) 
            {
                count++;
            } 
            // If not odd, reset the counter
            else 
            {
                count = 0;
            }
            // If three consecutive odd numbers have been found, exit the loop and return true
            if (count == 3) 
            {
                threeOddsFound = true;
                i = arr.length;
            }
        }
        return threeOddsFound;
    }
}
