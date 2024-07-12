We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.

 

Example 1:

Input: word = "USA"
Output: true

  
Example 2:

Input: word = "FlaG"
Output: false
 

Constraints:

1 <= word.length <= 100
word consists of lowercase and uppercase English letters.

class Solution 
{
    public boolean detectCapitalUse(String word) 
    {
        // A word of length 1 is always going to be written properly
        if(word.length() == 1)
        {
            return true;
        }

        char c1 = word.charAt(0);
        char c2 = word.charAt(1);
        int n1 = c1;
        int n2 = c2;
      
        boolean allUpperCase = true;
        boolean allLowerCase = true;
        boolean firstCapitalRestLower = true;

        // Case 1: If the first 2 letters of a word are uppercase, all other letters in the word need to be uppercase
        if(n1 < 91 && n2 < 91)
        {
            allLowerCase = false;
            firstCapitalRestLower = false;
            
            if(word.length() == 2)
            {
                return true;
            }
        }
        // Case 2: If the first 2 letters of a word lowercase, all other letters in the word need to be lowercase
        else if(n1 > 91 && n2 > 91)
        {
            allUpperCase = false;
            firstCapitalRestLower = false;

            if(word.length() == 2)
            {
                return true;
            }
        }
        // Case 3: If the first letter is uppercase and the second letter is lowercase, all other letters in the word need to be lowercase
        else if(n1 < 91 && n2 > 91)
        {
            allLowerCase = false;
            allUpperCase = false;

            if(word.length() == 2)
            {
                return true;
            }
        }
        // If the first letter is lowercase and the second is uppercase, the word is not written properly
        else if(n1 > 91 && n2 < 91)
        {
            return false;
        }

        // If Case 1, check if all letters are uppercase. If not, return false.
        if(allUpperCase == true)
        {
            for(int i = 2; i < word.length(); i++)
            {
                c1 = word.charAt(i);
                n1 = c1;

                if(n1 > 91)
                {
                    return false;
                }
            }
        }

        // If Case 2 or Case 3, check if all letters are lowercase. If not, return false.
        else if(allLowerCase == true || firstCapitalRestLower == true)
        {
            for(int i = 2; i < word.length(); i++)
            {
                c1 = word.charAt(i);
                n1 = c1;

                if(n1 < 91)
                {
                    return false;
                }
            }
        }
        return true;

    }
}
