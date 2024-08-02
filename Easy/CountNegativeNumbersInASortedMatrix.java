Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

 

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.

  
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100
 

Follow up: Could you find an O(n + m) solution?


class Solution 
{
    public int countNegatives(int[][] grid) 
    {
        int numOfNegativeNums = 0;

        // Find the total number of negative numbers
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                // When the first negative number is found, add the remaining length of the grid to the total number of negative numbers
                if(grid[i][j] < 0)
                {
                    numOfNegativeNums += grid[0].length - j;
                    j = grid[0].length;
                }
            }
        }
        return numOfNegativeNums;
    }
}
