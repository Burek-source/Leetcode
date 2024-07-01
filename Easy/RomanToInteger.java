Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
  
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].


class Solution 
{
    public int romanToInt(String s) 
    {
        String romanNumerals = "IVXLCDM";
        int[] nums = {1, 5, 10, 50, 100, 500, 1000};
    
        int romanToInteger = 0;
        String sb = new String("");
        char c = s.charAt(0);

        // If the string s consists of only 1 character, return the value of the character
        if(s.length() == 1)
        {
            return nums[romanNumerals.indexOf(c)];
        }

        // Convert a roman numeral to an integer
        for(int i = 1; i < s.length(); i++)
        {
            char temp = s.charAt(i);

            // If the last element of the string stands alone, add its corresponding value to the final result
            if(i == s.length()-1 && romanNumerals.indexOf(c) >= romanNumerals.indexOf(temp))
            {
                romanToInteger += nums[romanNumerals.indexOf(temp)];
            }

            // If the previous char represents numerically larger number, add it to the final result
            if(romanNumerals.indexOf(c) >= romanNumerals.indexOf(temp) )
            {
                romanToInteger += nums[romanNumerals.indexOf(c)];
                c = temp;     
            }

            // Otherwise, add the next char to the string and add its correpsonding value to the final result
            else
            {
               
                sb += c;
                sb += temp;
                
                if(sb.equals("IV"))
                {
                    romanToInteger += 4;
                }
                else if(sb.equals("IX"))
                {
                    romanToInteger += 9;
                }
                else if(sb.equals("XL"))
                {
                    romanToInteger += 40;
                }
                else if(sb.equals("XC"))
                {
                    romanToInteger += 90;
                }
                else if(sb.equals("CD"))
                {
                    romanToInteger += 400;
                }
                else if(sb.equals("CM"))
                {
                    romanToInteger += 900;
                }
     
                sb = "";
                i++;

                if(i <= s.length()-1)
                {
                    c = s.charAt(i);
                    
                    
                    // If increasing i by 1 leads to the final char, add its corresponding value to the final result
                    if(i == s.length()-1)
                    {
                  
                        romanToInteger += nums[romanNumerals.indexOf(s.charAt(i))];

                    }

                }
                
            }    
        }
        return romanToInteger;
    }
}
