You are given a string s.

Your task is to remove all digits by doing this operation repeatedly:

Delete the first digit and the closest non-digit character to its left.
Return the resulting string after removing all digits.

 

Example 1:


Input: s = "abc"

Output: "abc"

Explanation:

There is no digit in the string.

  

Example 2:

Input: s = "cb34"

Output: ""

Explanation:

First, we apply the operation on s[2], and s becomes "c4".

Then we apply the operation on s[1], and s becomes "".

 

Constraints:

1 <= s.length <= 100
s consists only of lowercase English letters and digits.
The input is generated such that it is possible to delete all digits.

class Solution 
{
    public String clearDigits(String s) 
    {      
        String noDigits = "";
        int count = 0;

        // Remove digits and characters closest to each digit to its left. Return cleared string.
        for(int i = s.length()-1; i > -1; i--)
        {
            if(s.charAt(i) - '0' < 10)
            {
                count++;
            }

            else if(s.charAt(i) - '0' > 10)
            {
                if(count == 0)
                {
                    noDigits = s.charAt(i) + noDigits;
                }
                else if(count > 0)
                {
                    count--;
                }            
            }
        }
        return noDigits;
    }
}
