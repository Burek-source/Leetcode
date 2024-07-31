You are given a positive integer n.

Let even denote the number of even indices in the binary representation of n with value 1.

Let odd denote the number of odd indices in the binary representation of n with value 1.

Note that bits are indexed from right to left in the binary representation of a number.

Return the array [even, odd].

 

Example 1:

Input: n = 50

Output: [1,2]

Explanation:

The binary representation of 50 is 110010.

It contains 1 on indices 1, 4, and 5.

  

Example 2:

Input: n = 2

Output: [0,1]

Explanation:

The binary representation of 2 is 10.

It contains 1 only on index 1.

 

Constraints:

1 <= n <= 1000


class Solution 
{
    public int[] evenOddBit(int n) 
    {
        int index = 0; // Keeps track of index position of 1's
        int remainder = 0; // Stores the remainder after dividing the number by 2
        int odd = 0; // Counts odd indices that have the value of 1
        int even = 0; // Counts even indices that have the value of 1

        // Find the number of even and odd indices of 1's
        while(n > 0)
        {
            remainder = n % 2;

            if(remainder == 1 && index % 2 == 0)
            {
                even++;
            }
            else if(remainder == 1 && index % 2 != 0)
            {
                odd++;
            }

            n = n / 2;
            index++;
        }
        int[] arr = {even, odd};
        return arr;
    }
}
