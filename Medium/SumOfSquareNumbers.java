Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

 

Example 1:

Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5

  
Example 2:

Input: c = 3
Output: false
 

Constraints:

0 <= c <= 2^31 - 1

class Solution {
    public boolean judgeSquareSum(int c) 
    {
        long sumOfSquareNumbers = 0;
        long a = 0;

        double d = Math.sqrt(c); // Get the square root of the target number
        long b = (long) d;
        long range = b;
    
        boolean found = false;

        // Check if the sum of any two numbers less than c equals c. Start with 0 and the square root of c
        for(long i = 0; i <= range; i++)
        {
            sumOfSquareNumbers = a * a + b * b;

            // If a^2 + b^2 == c, return true
            if(sumOfSquareNumbers == c)
            {
                found = true;
                i = range+1;
                break;
            }

            // else if a^2 + b^2 < c, incremenet a by 1
            else if(sumOfSquareNumbers < c)
            {
                a++;
            }

            // else if a^2 + b^2 > c, decremenet b by 1
            else if(sumOfSquareNumbers > c)
            {
                b--;
            }
            
        }

        return found;
    }
}
