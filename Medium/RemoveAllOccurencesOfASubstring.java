Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:

Find the leftmost occurrence of the substring part and remove it from s.
Return s after removing all occurrences of part.

A substring is a contiguous sequence of characters in a string.

 

Example 1:

Input: s = "daabcbaabcbc", part = "abc"
Output: "dab"
Explanation: The following operations are done:
- s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
- s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
- s = "dababc", remove "abc" starting at index 3, so s = "dab".
Now s has no occurrences of "abc".

  
Example 2:

Input: s = "axxxxyyyyb", part = "xy"
Output: "ab"
Explanation: The following operations are done:
- s = "axxxxyyyyb", remove "xy" starting at index 4 so s = "axxxyyyb".
- s = "axxxyyyb", remove "xy" starting at index 3 so s = "axxyyb".
- s = "axxyyb", remove "xy" starting at index 2 so s = "axyb".
- s = "axyb", remove "xy" starting at index 1 so s = "ab".
Now s has no occurrences of "xy".
 

Constraints:

1 <= s.length <= 1000
1 <= part.length <= 1000
s​​​​​​ and part consists of lowercase English letters.

class Solution 
{
    public String removeOccurrences(String s, String part) 
    {
        

        for(int i = 0; i < s.length(); i++)
        {
            // When s is lower than part or i + part is higher than s
            if(s.length() < part.length() || i + part.length() > s.length())
            {
                break;
            }
            // If s.length == part.length
            if(s.length() == part.length())
            {
                if(s.contains(part))
                {
                    s = "";
                }
                break;
            }
           
           // If s contains substring, remove it from the string and go again from the start
            if(s.substring(i, i+ part.length()).contains(part))
            {
                s = s.substring(0, i) + s.substring(i+ part.length());
                i = -1;
                
             
            }
           // System.out.println(s);
        }

        return s;
    }
}
