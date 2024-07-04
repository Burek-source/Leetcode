Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.

 

Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

  
Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 

Constraints:

1 <= arr.length <= 1000
1 <= arr[i] <= 1000
1 <= k <= 1000
arr[i] < arr[j] for 1 <= i < j <= arr.length
 

Follow up:

Could you solve this problem in less than O(n) complexity?

class Solution 
{
    public int findKthPositive(int[] arr, int k) 
    {
        
        int copyK = k; // Used if the first number meets the k condition
        int missingNumber = 0;
        
        // Check if the first number is NOT 1
        if(arr[0] != 1)
        {
            missingNumber = arr[0] - 1;
            k -= missingNumber;
            
        }

        // If the difference between the number 1 and the first element is k-1, return the first element - 1
        if(k == 0)
        {
          missingNumber = arr[0] -1;
          return missingNumber;
        }

        // If the difference between the number 1 and the first element is more than k, return k
        else if(k < 0)
        {
          missingNumber = copyK;
          return missingNumber;
        }

        // Find the missing element
        for(int i = 1; i < arr.length; i++)
        {
              // If the difference between the two adjacent elements is not 1, there is at least one missing elements in between
              if(arr[i] - arr[i-1] != 1 )
              {
                  // If subtracting k from the difference of the two adjacent elements -1 is higher than 0, new k value is k - (arr[i] - arr[i-1]-1)
                  if(k - (arr[i] - arr[i-1]-1) > 0)
                  {
                      k -= arr[i] - arr[i-1] -1;
                      missingNumber = k;
                  }

                  // If subtracting k from the difference of the two adjacent elements -1 is equal to 0 and k is not 1, the missing number must be the current element -1
                  else if(k - (arr[i] - arr[i-1]-1) == 0 && k != 1)
                  {
                      missingNumber = arr[i] - 1;    
                      k =0; 
                      break;
                  }

                  // If subtracting k from the difference of the two adjacent elements -1 is lower than 0, the missing number must be in between the range of previous and current element
                  else if(k - (arr[i] - arr[i-1]) < 0)
                  {   
                      missingNumber = arr[i-1];
                    
                      for(int j = k; j > 0; j--)
                      { 
                          missingNumber++;          
                      }
                      k = 0;
                      break;
                 }  
                
              }             
        }

        // In the case that there are no more missing elements in the array, the missing number is found by adding k to the last element
        if(k > 0)
        {
          missingNumber = arr[arr.length-1] + k;
        }
        return missingNumber;
    }
}

