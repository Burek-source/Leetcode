The value of an alphanumeric string can be defined as:

The numeric representation of the string in base 10, if it comprises of digits only.
The length of the string, otherwise.
Given an array strs of alphanumeric strings, return the maximum value of any string in strs.

 

Example 1:

Input: strs = ["alic3","bob","3","4","00000"]
Output: 5
Explanation: 
- "alic3" consists of both letters and digits, so its value is its length, i.e. 5.
- "bob" consists only of letters, so its value is also its length, i.e. 3.
- "3" consists only of digits, so its value is its numeric equivalent, i.e. 3.
- "4" also consists only of digits, so its value is 4.
- "00000" consists only of digits, so its value is 0.
Hence, the maximum value is 5, of "alic3".

  
Example 2:

Input: strs = ["1","01","001","0001"]
Output: 1
Explanation: 
Each string in the array has value 1. Hence, we return 1.
 

Constraints:

1 <= strs.length <= 100
1 <= strs[i].length <= 9
strs[i] consists of only lowercase English letters and digits.

class Solution 
{
    public int maximumValue(String[] strs) 
    {
        boolean isLetter = false;
        boolean isDigit = false;

        int maxLength = 0;

        // Find if a given string consists of only letters, only digits, or combinations of both
        for(int i = 0; i < strs.length; i++)
        {
            isLetter = false;
            isDigit = false;

            for(int j = 0; j < strs[i].length(); j++)
            {
                int n = strs[i].charAt(j) - '0';
              
                // If a digit
                if(n < 10)
                {
                    isDigit = true;
                }

                // If a letter
                else if(n > 10)
                {
                    isLetter = true;
                }

                // If a string consists of both a letter and a number, check if the string length is higher than the current max. Exit the inner loop early.
                if(isDigit == true && isLetter == true)
                {
                    if(strs[i].length() > maxLength)
                    {
                        maxLength = strs[i].length();
                    }
                    
                    j = strs[i].length();
                }
            }
            // If the string consists of only digits, check if its value is higher that the current max length
            if(isDigit == true && isLetter == false)
            {
                int n = Integer.parseInt(strs[i]);

                if(n > maxLength)
                {
                    maxLength = n;
                }
            }

            // If the string consists of only letters, check if its length is higher than the current max
            else if(isDigit == false && isLetter == true)
            {
                if(strs[i].length() > maxLength)
                {
                    maxLength = strs[i].length();
                }
            }
        }
        return maxLength;
    }
}
