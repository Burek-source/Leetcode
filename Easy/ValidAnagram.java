Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

  
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 10^4
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

class Solution 
{
    public boolean isAnagram(String s, String t) 
    {
        // Anagram is not possible if strings s and t are of different lengths
        if(s.length() != t.length())
        {
            return false;
        }
      
        boolean isAnagram = true;

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        // For a string t to be an anagram of a string s, in sorted arrays, any two chars in both arrays will have the same index
        for(int i = 0; i < sChar.length; i++)
        {
            if(sChar[i] != tChar[i])
            {
                isAnagram = false;
                break;
            }
        }

        return isAnagram;
    }
}

