Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

 

Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).

  
Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessairly unique.
 

Constraints:

1 <= nums.length <= 5 * 10^4
-5 * 10^4 <= nums[i] <= 5 * 10^4

class Solution 
{
    public int[] sortArray(int[] nums) 
    {    
        mergeSort(nums);
        return nums;
    }

     // Divide the array into two halves. Keep dividing the halves in half until only 1 element is left in the array
     public static void mergeSort(int[] arr)
     {
        int arrLength = arr.length;

        if(arrLength < 2)
        {
            return;
        }

        int midIndex = arrLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[arrLength - midIndex];

        for(int i = 0; i < midIndex; i++)
        {
            leftHalf[i] = arr[i];
        }
        for(int i = midIndex; i < arrLength; i++)
        {
            rightHalf[i - midIndex] = arr[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(arr, leftHalf, rightHalf);           
    }

    // Sort the left half first, then the right half then sort both halves together
    private static void merge(int[] arr, int[] leftHalf, int[] rightHalf)
    {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int left = 0;
        int right = 0;
        int arrSize = 0;

        while(left < leftSize && right < rightSize)
        {
            if(leftHalf[left] <= rightHalf[right])
            {
                arr[arrSize] = leftHalf[left];
                left++;
            }
            else
            {
                arr[arrSize] = rightHalf[right];
                right++;
            }
            arrSize++;
        }

        while(left < leftSize)
        {
            arr[arrSize] = leftHalf[left];
            left++;
            arrSize++;
        }

        while(right < rightSize)
        {
            arr[arrSize] = rightHalf[right];
            right++;
            arrSize++;
        }
    }
}
