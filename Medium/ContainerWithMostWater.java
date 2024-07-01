You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water. Return the maximum amount of water a container can store.

  Notice that you may not slant the container.

class Solution 
{
    public int maxArea(int[] height) 
    {
        
        int max = 0;
        int actualMax = 0;
        
        int leftPointer = height[0];
        int rightPointer = height[height.length-1];

        int leftLeft = 0;
        int rightRight = height.length-1;

        int counter = height.length-1;

        while(counter != 0)
        {
            for(int i = 0; i < height.length-1;i++)
            {
                // If the left pointer is lower than the right pointer, compute the max height using the left pointer
                // Move the left pointer by 1 index
                if(leftPointer < rightPointer)
                {
                    max = leftPointer * counter;
                    leftLeft++;
                    leftPointer = height[leftLeft];
                    counter--;
                }

                // If the right pointer is lower than the left pointer, compute the max height using the right pointer
                // Move the right pointer by -1 index
                else if(rightPointer < leftPointer)
                {
                    max = rightPointer * counter;
                    rightRight--;
                    rightPointer = height[rightRight];
                    counter--;
                }

                // If the left pointer is equal to the right pointer, compute the max height using the left pointer
                // Move the left pointer by 1 index
                else if(leftPointer == rightPointer)
                {
                    max = leftPointer * counter;
                    leftLeft++;
                    leftPointer = height[leftLeft];
                    counter--;
                }

                // On each iteration check if any product exceedes the actual max capacity
                if(max > actualMax)
                {
                    actualMax = max;
                }
            }
        }
        return actualMax;
    }
}
