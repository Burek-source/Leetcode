Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.

 

Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
  
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 5000
0 <= nums[i] <= 5000

class Solution 
{
    public int[] sortArrayByParity(int[] nums) 
    {
        Arrays.sort(nums);

        ArrayList<Integer> evenNums = new ArrayList<>();
        ArrayList<Integer> oddNums = new ArrayList<>();

        // Separate numbers on even/odd basis
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] % 2 == 0)
            {
                evenNums.add(nums[i]);
            }
            else
            {
                oddNums.add(nums[i]);
            }
        }

        int evenLength = evenNums.size();
        int oddNumsIndex = 0;

        // Replace first n numbers in the array with the sorted even numbers
        for(int i = 0; i < nums.length; i++)
        {
            if(i < evenLength)
            {
                nums[i] = evenNums.get(i);
            }

            // After all even number have been added to the array, add all sorted odd numbers
            else
            {
                nums[i] = oddNums.get(oddNumsIndex);
                oddNumsIndex++;
            }
        }

        return nums;

    }
}
