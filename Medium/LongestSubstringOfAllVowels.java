A string is considered beautiful if it satisfies the following conditions:

Each of the 5 English vowels ('a', 'e', 'i', 'o', 'u') must appear at least once in it.
The letters must be sorted in alphabetical order (i.e. all 'a's before 'e's, all 'e's before 'i's, etc.).
For example, strings "aeiou" and "aaaaaaeiiiioou" are considered beautiful, but "uaeio", "aeoiu", and "aaaeeeooo" are not beautiful.

Given a string word consisting of English vowels, return the length of the longest beautiful substring of word. If no such substring exists, return 0.

A substring is a contiguous sequence of characters in a string.

 

Example 1:

Input: word = "aeiaaioaaaaeiiiiouuuooaauuaeiu"
Output: 13
Explanation: The longest beautiful substring in word is "aaaaeiiiiouuu" of length 13.

  
Example 2:

Input: word = "aeeeiiiioooauuuaeiou"
Output: 5
Explanation: The longest beautiful substring in word is "aeiou" of length 5.

  
Example 3:

Input: word = "a"
Output: 0
Explanation: There is no beautiful substring, so return 0.
 

Constraints:

1 <= word.length <= 5 * 10^5
word consists of characters 'a', 'e', 'i', 'o', and 'u'.

class Solution 
{
    public int longestBeautifulSubstring(String word) 
    {
        int length = 0;
        int tempMaxLength = 0;

        boolean aInOrder = false;
        boolean eInOrder = false;
        boolean iInOrder = false;
        boolean oInOrder = false;
        boolean uInOrder = false;
        
        // Check the length of longest beautiful substring
        for(int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);

            // For the check to trigger, 'a' needs to be found
            if(c == 'a')
            {
                aInOrder = true;

            }

            // If 'a' is found and it is not preceeded by 'eiou', possible beautiful substring found
            if(aInOrder == true && eInOrder == false && iInOrder == false && oInOrder == false && uInOrder == false &&  c == 'a')
            {
                tempMaxLength++;
            }

            // If 'e' is found and it is only preceeded by 'a', possible beautiful substring found
            else if(aInOrder == true && iInOrder == false && oInOrder == false && uInOrder == false &&  c == 'e')
            {
                eInOrder = true;
                tempMaxLength++;
            }

            // If 'i' is found and it is only preceeded by 'ae' substring of length n, possible beautiful substring found
            else if(aInOrder == true && eInOrder == true && oInOrder == false && uInOrder == false && c == 'i')
            {
                iInOrder = true;
                tempMaxLength++;
            }

            // If 'o' is found and it is only preceeded by 'aei' substring of length n, possible beautiful substring found
            else if(aInOrder == true && eInOrder == true && iInOrder == true && uInOrder == false &&  c == 'o')
            {
                oInOrder = true;
                tempMaxLength++;
            }

            // If 'u' is found and it is only preceeded by 'aeio' substring of length n, a beautiful substring is found
            else if(aInOrder == true && eInOrder == true && iInOrder == true && oInOrder == true && c == 'u')
            {
                uInOrder = true;
                tempMaxLength++;
            }

            // As soon as the next character does not fit the 'aeiou' format, check if the length of a temp beautiful substring is the longer than the current length
            else
            {

                if(tempMaxLength > length && aInOrder == true && eInOrder == true && iInOrder == true && oInOrder == true && uInOrder == true)
                {
                    length = tempMaxLength;
                }
              
                aInOrder = false;
                eInOrder = false;
                iInOrder = false;
                oInOrder = false;
                uInOrder = false;
                tempMaxLength = 0;

                // If the char that does not follow the pattern is 'a', a possible start of a beautiful substring is found
                if(c == 'a')
                {
                    aInOrder = true;
                    tempMaxLength++;
                }
            }

            // If the beautiful substring stays as such until the end of the string, check if its length is longer than the currently longest recorded one
            if(i == word.length()-1)
            {
                if(tempMaxLength > length && aInOrder == true && eInOrder == true && iInOrder == true && oInOrder == true && uInOrder == true)
                {
                    length = tempMaxLength;
                }
            }      
        }
        return length;
    }
}
