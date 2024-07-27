You are given a positive integer n. Each digit of n has a sign according to the following rules:

The most significant digit is assigned a positive sign.
Each other digit has an opposite sign to its adjacent digits.
Return the sum of all digits with their corresponding sign.

 

Example 1:

Input: n = 521
Output: 4
Explanation: (+5) + (-2) + (+1) = 4.

  
Example 2:

Input: n = 111
Output: 1
Explanation: (+1) + (-1) + (+1) = 1.

  
Example 3:

Input: n = 886996
Output: 0
Explanation: (+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0.
 

Constraints:

1 <= n <= 10^9

class Solution 
{
    public int alternateDigitSum(int n) 
    {
        
        int count = 0;
        int leftMostNegativeSum = 0;
        int leftMostPositiveSum = 0;

        int leftNegative = -1;
        int leftPositive = 1;

        // Find two sums. One if the first digit is positive and the second one where the first digit is negative.
        while(n > 0)
        {
            leftMostNegativeSum = leftMostNegativeSum + ((n % 10) * leftNegative);
            leftMostPositiveSum = leftMostPositiveSum + ((n % 10) * leftPositive);

            count++;
            leftNegative = leftNegative * (-1);
            leftPositive = leftPositive * (-1);

            n = n / 10;
        }

        // If the integer is of odd length, return the sum where the first digit is positive
        if(count % 2 != 0)
        {
            return leftMostPositiveSum;
        }
        return leftMostNegativeSum;  
        
    }
}
 
