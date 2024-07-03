You are given a string number representing a positive integer and a character digit.

Return the resulting string after removing exactly one occurrence of digit from number such that the value of the resulting string in decimal form is maximized. 
The test cases are generated such that digit occurs at least once in number.

 

Example 1:

Input: number = "123", digit = "3"
Output: "12"
Explanation: There is only one '3' in "123". After removing '3', the result is "12".

  
Example 2:

Input: number = "1231", digit = "1"
Output: "231"
Explanation: We can remove the first '1' to get "231" or remove the second '1' to get "123".
Since 231 > 123, we return "231".

  
Example 3:

Input: number = "551", digit = "5"
Output: "51"
Explanation: We can remove either the first or second '5' from "551".
Both result in the string "51".
 

Constraints:

2 <= number.length <= 100
number consists of digits from '1' to '9'.
digit is a digit from '1' to '9'.
digit occurs at least once in number.

class Solution 
{
    public String removeDigit(String number, char digit) 
    {
        String highestNumber = "";
        String temp = "";  

        // Check all possible numbers when the digit has been removed
        for(int i = 0; i < number.length(); i++)
        {
        
            if(number.charAt(i) == digit)
            {
                // If the digit occurs at the last index position, the substring involves all chars except the last one
                if(i + 1 > number.length() -1)
                {
                    temp = number.substring(0, number.length()-1);
                }

                // If the digit occurs anywhere else in the string, make two substrings, one before the digit and one after the digit and combine them
                else
                {
                    temp = number.substring(0, i) + number.substring(i + 1);
                }

                // Lexicographically compare strings to find the largest one
                if(temp.compareTo(highestNumber) > -1)
                {
                    highestNumber = temp;
                }
                
            }
        }
        
        return highestNumber;

    }
}
