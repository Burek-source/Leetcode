Given an integer n, return true if n has exactly three positive divisors. Otherwise, return false.

An integer m is a divisor of n if there exists an integer k such that n = k * m.

 

Example 1:

Input: n = 2
Output: false
Explantion: 2 has only two divisors: 1 and 2.

  
Example 2:

Input: n = 4
Output: true
Explantion: 4 has three divisors: 1, 2, and 4.
 

Constraints:

1 <= n <= 10^4

class Solution 
{
    public boolean isThree(int n) 
    {
        int numberOfDivisors = 1;
       
        // If n == 1, 2, 3, 5, 7, return false
        if(n == 1 || n == 2 || n == 3 || n == 5 || n == 7)
        {
            return false;
        }   

        //  Find how many divisors a number has. Return true if it only has 3.
        for(int i = 1; i <= n / 2; i++)
        {
            if(n % i == 0)
            {
                numberOfDivisors++;
            }

            if(numberOfDivisors > 3)
            {
                return false;
            }
        }

        // If a number has only 2 divisors, return true
        if(numberOfDivisors < 3)
        {
            return false;
        }
        return true; // A number has ONLY three divisors. Return true.
    }
}
