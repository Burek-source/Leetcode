Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
A string is represented by an array if the array elements concatenated in order forms the string.

 

Example 1:

Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true
Explanation:
word1 represents string "ab" + "c" -> "abc"
word2 represents string "a" + "bc" -> "abc"
The strings are the same, so return true.

  
Example 2:

Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
Output: false

  
Example 3:

Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
Output: true
 

Constraints:

1 <= word1.length, word2.length <= 10^3
1 <= word1[i].length, word2[i].length <= 10^3
1 <= sum(word1[i].length), sum(word2[i].length) <= 10^3
word1[i] and word2[i] consist of lowercase letters.

class Solution 
{
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) 
    {
        String s1 = "";
        String s2 = "";

        // Create a word from the first array
        for(int i = 0; i < word1.length; i++)
        {
            s1 += word1[i];
        }

        // Create a word from the second array
        for(int i = 0; i < word2.length; i++)
        {
            s2 += word2[i];
        }

        // Check if two strings are the same
        if(s2.contains(s1) && s2.length() == s1.length())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
