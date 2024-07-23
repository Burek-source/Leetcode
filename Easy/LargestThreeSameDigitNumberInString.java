You are given a string num representing a large integer. An integer is good if it meets the following conditions:

It is a substring of num with length 3.
It consists of only one unique digit.
Return the maximum good integer as a string or an empty string "" if no such integer exists.

Note:

A substring is a contiguous sequence of characters within a string.
There may be leading zeroes in num or a good integer.
 

Example 1:

Input: num = "6777133339"
Output: "777"
Explanation: There are two distinct good integers: "777" and "333".
"777" is the largest, so we return "777".

  
Example 2:

Input: num = "2300019"
Output: "000"
Explanation: "000" is the only good integer.

  
Example 3:

Input: num = "42352338"
Output: ""
Explanation: No substring of length 3 consists of only one unique digit. Therefore, there are no good integers.
 

Constraints:

3 <= num.length <= 1000
num only consists of digits.

class Solution 
{
    public String largestGoodInteger(String num) 
    {
        String result = "";
        String temp = num.substring(0, 1);
        char c = num.charAt(0);

        // Check if a string has a substring of length three consisted of the same digit. Return the largest substring.
        for(int i = 1; i < num.length(); i++)
        {
            if(num.charAt(i) == c)
            {
                temp += c;

                if(temp.length() == 3)
                {  
                    // If the substring consists of 9's, no larger substring exists
                    if(temp.charAt(0) == '9')
                    {
                        return temp;
                    }
                    else if(result.length() == 0)
                    {
                        result = temp;
                        temp = "";
                    }
                    else if(temp.charAt(0) > result.charAt(0))
                    {
                        result = temp;
                        temp = "";
                    }
                    
                }
            }
            else
            {
                c = num.charAt(i);
                temp = "";
                temp += c;
            }
        }
        return result;
    }
}
