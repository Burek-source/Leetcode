Given an array arr of integers, check if there exist two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]
 

Example 1:

Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]

  
Example 2:

Input: arr = [3,1,7,11]
Output: false
Explanation: There is no i and j that satisfy the conditions.
 

Constraints:

2 <= arr.length <= 500
-10^3 <= arr[i] <= 10^3

class Solution 
{
    public boolean checkIfExist(int[] arr) 
    {
        boolean nAndItsDouble = false;

        // Find if any number in arr can be calculated by multiplying any number in arr by 2
        for(int i = 0; i < arr.length; i++)
        {
            int indexToSkip = i;

            // Check if the current number checked is even or odd. Odd numbers can never be calculated if multiplied by 2.
            for(int j = 0; j < arr.length; j++)
            {
                if(arr[i] % 2 != 0)
                {
                    j = arr.length;
                }
                else if(j != indexToSkip)
                {
                    if(arr[j]*2 == arr[i])
                    {
                        nAndItsDouble = true;
                        break;
                    }
                }
            }
        }
        return nAndItsDouble;
    }
}
