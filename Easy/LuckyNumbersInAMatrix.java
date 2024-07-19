Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

 

Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.

  
Example 2:

Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.

  
Example 3:

Input: matrix = [[7,8],[1,2]]
Output: [7]
Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.
 

Constraints:

m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 10^5.
All elements in the matrix are distinct.

class Solution 
{
    public List<Integer> luckyNumbers (int[][] matrix) 
    {
        ArrayList<Integer> listOfLuckyNumbers = new ArrayList<>();
      
        int min = 0;
        int max = 0;
        int columnTracker = 0; // Tracks columns that need to be checked for max values

        // Finds the value that is min value in its row and max value in its column
        for(int i = 0; i < matrix.length; i++)
        {
            min = matrix[i][0];
            columnTracker = 0;
            
            // Find the min value in the current row
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] < min)
                {
                    min = matrix[i][j];
                    columnTracker = j;
                }
            }
            max = matrix[0][columnTracker]; // Determined by the index position of the min value in the current row

            //Find the max value in the current column
            for(int j = 0; j < matrix.length; j++)
            {
                if(matrix[j][columnTracker] > max)
                {
                    max = matrix[j][columnTracker];
                }
                if(j == matrix.length - 1 && min == max)
                {
                    listOfLuckyNumbers.add(max);
                 
                }
            } 
        }
       return listOfLuckyNumbers;
    }
}
