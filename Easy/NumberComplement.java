The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.

For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer num, return its complement.

 

Example 1:

Input: num = 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

  
Example 2:

Input: num = 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 

Constraints:

1 <= num < 2^31
 

Note: This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/


class Solution 
{
    public int findComplement(int num) 
    {
        String complement = "";
        int remainder = 0;
        int result = 0;
        int index = 0;

        // Find the binary complement of an integer
        while(num > 0)
        {
            remainder = num % 2;
            char c = (char)(remainder + '0');

            if(c == '0')
            {
                complement = '1' + complement;
            }
            else
            {
                complement = '0' + complement;
            }
            num = num /2;
        }
      
        // Convert the complement into an integer
        for(int i = complement.length()-1; i > -1; i--)
        {
            if(complement.charAt(i) == '1')
            {
                result += Math.pow(2, index);
            }
            index++;
        }
        return result;
    }
}
