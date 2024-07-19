No-Zero integer is a positive integer that does not contain any 0 in its decimal representation.

Given an integer n, return a list of two integers [a, b] where:

a and b are No-Zero integers.
a + b = n
The test cases are generated so that there is at least one valid solution. If there are many valid solutions, you can return any of them.

 

Example 1:

Input: n = 2
Output: [1,1]
Explanation: Let a = 1 and b = 1.
Both a and b are no-zero integers, and a + b = 2 = n.

  
Example 2:

Input: n = 11
Output: [2,9]
Explanation: Let a = 2 and b = 9.
Both a and b are no-zero integers, and a + b = 9 = n.
Note that there are other valid answers as [8, 3] that can be accepted.
 

Constraints:

2 <= n <= 10^4

class Solution 
{
    public int[] getNoZeroIntegers(int n) 
    {
        int a = 0;
        int b = 0;

        int[] arr = new int[2];

        boolean aHasZero = true;
        boolean bHasZero = true;

        a = n - 1;
        int aCopy = a;
        int bCopy = 0;

        // Find positive integer a and b such that a + b adds to n and a and b have no zeros in them
        while(aHasZero == true && bHasZero == true)
        {
            // Find an integer a such that it does not have any zeros in it
            while(a > 0)
            {
                if(a % 10 == 0)
                {
                    aCopy--;
                    a = aCopy;
                }
                else
                {
                    a = a / 10;
                }
                
            }

            aHasZero = false;
            b = n - aCopy;
            bCopy = b;

            // Find an integer b such that it does not have any zeros in it. If it does have a zero, new integer a needs to be found.
            while(b > 0)
            {
                if(b % 10 == 0)
                {
                    a = aCopy -1;
                    aCopy = a;
                    aHasZero = true;
                    b = -1;
                }
                else
                {
                    b = b / 10;
                }
            }

            if(b == 0)
            {
                bHasZero = false;
            }      
        }
        arr[0] = aCopy;
        arr[1] = bCopy;

        return arr; 
    }
}
