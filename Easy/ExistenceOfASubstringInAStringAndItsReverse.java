Given a string s, find any 
substring
 of length 2 which is also present in the reverse of s.

Return true if such a substring exists, and false otherwise.

 

Example 1:

Input: s = "leetcode"

Output: true

Explanation: Substring "ee" is of length 2 which is also present in reverse(s) == "edocteel".

  

Example 2:

Input: s = "abcba"

Output: true

Explanation: All of the substrings of length 2 "ab", "bc", "cb", "ba" are also present in reverse(s) == "abcba".

  

Example 3:

Input: s = "abcd"

Output: false

Explanation: There is no substring of length 2 in s, which is also present in the reverse of s.

Constraints:

1 <= s.length <= 100
s consists only of lowercase English letters.

class Solution {
    public boolean isSubstringPresent(String s) 
    { 
        boolean substringExists = false;
        String temp = "";

        // Check if any substring of length 2 starting from the end of the string s exists in the string s
        for(int i = s.length()-1; i > -1; i--)
        {
            temp += s.charAt(i);
          
            // Check if the reverse substring of length 2 is present in the string itself
            if(temp.length() == 2 && s.contains(temp))
            {
                substringExists = true;
                break;
            }
            else if(temp.length() == 2 && !s.contains(temp))
            {
                temp = "";
                temp += s.charAt(i);
            }  
        }
        return substringExists;
    }
}
