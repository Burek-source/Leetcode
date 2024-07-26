You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.

Return the index of the peak element.

Your task is to solve it in O(log(n)) time complexity.

 

Example 1:

Input: arr = [0,1,0]

Output: 1

  

Example 2:

Input: arr = [0,2,1,0]

Output: 1

  

Example 3:

Input: arr = [0,10,5,2]

Output: 1

 

Constraints:

3 <= arr.length <= 10^5
0 <= arr[i] <= 10^6
arr is guaranteed to be a mountain array.

class Solution 
{
    public int peakIndexInMountainArray(int[] arr) 
    {
        int left = 0;
        int right = arr.length-1;
        int mid = 0;
        int tempIndex = -1;

        

        // Find the index of the peak number
        while(true)
        {
            
            // If left index is higher than the right, the peak number is not present in the array
            if(left > right)
            {
                break;
            }
            else
            {
                mid = (left + right) / 2;

                // Index of the peak number found is found if the number in question is higher than the number before and the number after
                if(arr[mid-1] < arr[mid] && arr[mid+1] < arr[mid])
                {
                    tempIndex = mid; 
                    break;
                }
                // If the current number is higher than the previous number and lower than the next number, the peak number is located in the upper portion of the array
                else if(arr[mid-1] < arr[mid] && arr[mid] < arr[mid+1])
                {
                    left = mid;
                }
                // If the current number is lower than the previous number and higher than the next number, the peak number is located in the lower portion of the array
                else if(arr[mid-1] > arr[mid] && arr[mid] > arr[mid+1])
                {
                    right = mid;
                }
            }   

        }
        return tempIndex;
    }
}
