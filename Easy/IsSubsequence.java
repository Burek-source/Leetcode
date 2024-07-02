Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions 
of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true

  
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 

Constraints:

0 <= s.length <= 100
0 <= t.length <= 10^4
s and t consist only of lowercase English letters.
 

Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 10^9, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?

class Solution 
{
    public boolean isSubsequence(String s, String t) 
    {
        char[] sString = new char[s.length()];
        char[] tString = new char[t.length()];
        ArrayList<Integer> positions = new ArrayList<>();

        boolean valid = true;

        // Edge case 1
        if(s.length() == 0 && t.length() != 0)
        {
            return true;
        }

        // Edge case 2
        if(s.length() == 0 && t.length() == 0)
        {
            return true;
        }

        // Make arrays from s and t strings
        for(int i = 0; i < s.length(); i++)
        {
            sString[i] = s.charAt(i);
        }

        for(int i = 0; i < t.length(); i++)
        {
            tString[i] = t.charAt(i);
        }

        // Get an index position of the first char
        char c = sString[0];
        int indexPosition = t.indexOf(c);

        if(indexPosition == -1)
        {
            return false;
        }

        // Get index positions of other chars
        for(int i = 1; i < sString.length; i++)
        {
            char lookUp = sString[i];

            for(int j = 0; j < tString.length;j++)
            {
                if(lookUp == tString[j])
                {
                    positions.add(j);
                }
            }

            if(positions.size() == 0)
            {  
                valid = false;
                i = sString.length;
            }

            // Check if any of indices are higher then the index of the previous letter
            // if so, subsequence is valid so far; otherwise it is false
            else
            {
            
                for(int k = 0; k < positions.size(); k++)
                {
                    if(positions.get(k) > indexPosition)
                    {
                        indexPosition = positions.get(k);
                        k = positions.size();
                        valid = true;
                        positions.clear();

                    }
                    else
                    {
                        valid = false;
                    }
                }
            }
           

            // if not valid, exit
           if(valid == false)
            {
                valid = false;
                i = sString.length;
            }
        }

        return valid;
    }
}
