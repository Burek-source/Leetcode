Given two positive integers a and b, return the number of common factors of a and b.
An integer x is a common factor of a and b if x divides both a and b.

 

Example 1:

Input: a = 12, b = 6
Output: 4
Explanation: The common factors of 12 and 6 are 1, 2, 3, 6.

  
Example 2:

Input: a = 25, b = 30
Output: 2
Explanation: The common factors of 25 and 30 are 1, 5.
 

Constraints:

1 <= a, b <= 1000

class Solution 
{
    public int commonFactors(int a, int b) 
    {
        int numberOfCommonFactors = 1; // There is always going to be at least one common factor
        int lower = Math.min(a, b); // Common factor numbers depend on the min value

        // If min value is 1, there is only one common factor
        if(lower == 1)
        {
            return numberOfCommonFactors;
        }

        // Check if min value is the common factor
        if(a % lower == 0 && b % lower == 0)
        {
            numberOfCommonFactors++;
        }

        lower = lower / 2; // Common factors can only be numbers up to half of the min value, with the exception of the min value itself

        // Check the rest of possible common factors, starting at number 2
        for(int i = 2; i <= lower; i++)
        {
            if(a % i == 0 && b % i == 0)
            {
                numberOfCommonFactors++;
            }
        }

        return numberOfCommonFactors;

    }
}
