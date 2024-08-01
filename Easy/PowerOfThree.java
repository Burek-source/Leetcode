Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3x.

 

Example 1:

Input: n = 27
Output: true
Explanation: 27 = 3^3

  
Example 2:

Input: n = 0
Output: false
Explanation: There is no x where 3x = 0.

  
Example 3:

Input: n = -1
Output: false
Explanation: There is no x where 3x = (-1).
 

Constraints:

-2^31 <= n <= 2^31 - 1
 

Follow up: Could you solve it without loops/recursion?


class Solution 
{
    public boolean isPowerOfThree(int n) 
    {  
        int product = 3;
        boolean isPowerOfThree = false;

        // Edge case: if n is 3 or 1
        if(n == 3  || n == 1)
        {
            return true;
        }

        // Find if the number n can be calculated by raising 3 to an x power
        while(true)
        {
            product *= 3;
          
            if(product == n)
            {
                isPowerOfThree = true;
                break;
            }

            // If the number n is negative and the product is lower than n, the number n cannot be calculated by raising 3 to an x power
            else if(product < 0 && product < n)
            {
                break;
            }

            // If the number n is positive and the product is bigger than n, the number n cannot be calculated by raising 3 to an x power
            else if(product > 0 && product > n)
            {
                break;
            }
        }
        return isPowerOfThree;
    }
}
