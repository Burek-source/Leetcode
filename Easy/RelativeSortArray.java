Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.

 

Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]

  
Example 2:

Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
Output: [22,28,8,6,17,44]
 

Constraints:

1 <= arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
All the elements of arr2 are distinct.
Each arr2[i] is in arr1.

import java.util.ArrayList;
import java.util.Arrays;

class Solution 
{
    public int[] relativeSortArray(int[] arr1, int[] arr2) 
    {
        ArrayList<Integer> inArray = new ArrayList<>();
        int placeholder = arr2[0];
        int count = arr1.length;
        int temp = 0;

        // Find all elements that appear in both arrays and append them to the list
        for(int i = 0; i < arr2.length; i++)
        {

            for(int j = 0; j < arr1.length; j++)
            {
                if(arr2[i] == arr1[j])
                {
                    inArray.add(arr2[i]);
                    arr1[j] = placeholder; // replace found elements with the first element of the arr2
                    count--;
                }
            }
        }

        // Create an array for missing elements
        int[] onlyInFirst = new int[count];
        count = 0;

        // Get the elements that only appear in the first array
        for(int i = 0; i < arr1.length; i++)
        {
            if(arr1[i] != placeholder)
            {
               onlyInFirst[count] = arr1[i];
               count++;
            }
        }

        // Sort the array in ascending order
        for(int pass = 1; pass < onlyInFirst.length; pass++)
        {
            for(int i = 0; i < onlyInFirst.length-1; i++)
            {
                if(onlyInFirst[i] > onlyInFirst[i+1])
                {
                    temp = onlyInFirst[i];
                    onlyInFirst[i] = onlyInFirst[i+1];
                    onlyInFirst[i+1] = temp;

                }
            }
        }

        // Add the unique elements of the first array to the list of shared elements
        for(int i = 0; i < onlyInFirst.length; i++)
        {
            inArray.add(onlyInFirst[i]);
        }

        // Create an array from the list
        int[] arrayToReturn = new int[inArray.size()];

        for(int i = 0; i < arrayToReturn.length; i++)
        {
            arrayToReturn[i] = inArray.get(i);
        }

        return arrayToReturn;
    }
}
