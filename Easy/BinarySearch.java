class Solution 
{
    public int search(int[] nums, int target) 
    {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        int tempIndex = -1;
      
        // Find the index of the target number
        while(true)
        {
            // If left index is higher than the right, the target number is not present in the array
            if(left > right)
            {
                break;
            }
            else
            {
                mid = (left + right) / 2;

                // Index of the target number found
                if(nums[mid] == target)
                {
                    tempIndex = mid; 
                    break;
                }
                // If the target number is lower than the current half, the target number is in the lower half. Set the right half to current mid - 1
                else if(target < nums[mid])
                {
                    right = mid - 1;
                }
                // If the target number is higher than the current half, the target number is in the upper half. Set the left half to current mid + 1
                else if(target > nums[mid])
                {
                    left = mid + 1;
                }
            }   

        }
        return tempIndex;
    }
}
