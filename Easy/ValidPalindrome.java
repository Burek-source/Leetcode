A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. 
Alphanumeric characters include letters and numbers. Given a string s, return true if it is a palindrome, or false otherwise.

 
Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

  
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 10^5
s consists only of printable ASCII characters.

class Solution {
    public boolean isPalindrome(String s) 
    {
        s = s.toLowerCase();
  
        String forward = new String("");
        String backWard = new String("");

        // Extract all alpha-numeric characters from a string and append each char forward and backwards
        for(int i = 0; i < s.length(); i++)
        {
            if(s.substring(i, i+1).matches("[a-z]") || s.substring(i, i+1).matches("[0-9]") )
            {
                forward += s.charAt(i);
                backWard = s.charAt(i) + backWard;
            }
        }

        // Check if two strings match. If they match, the given string is a palindrome
        if(forward.contains(backWard))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
