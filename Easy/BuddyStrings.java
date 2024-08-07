Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].

For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 

Example 1:

Input: s = "ab", goal = "ba"
Output: true
Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.

  
Example 2:

Input: s = "ab", goal = "ab"
Output: false
Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.

  
Example 3:

Input: s = "aa", goal = "aa"
Output: true
Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.
 

Constraints:

1 <= s.length, goal.length <= 2 * 10^4
s and goal consist of lowercase letters.

class Solution 
{
    public boolean buddyStrings(String s, String goal) 
    {
        boolean stringSwapPossible = true;

        // Edge case: s and goal are different lengths
        if(s.length() != goal.length())
        {
            return false;
        }

        char firstChar = ' ';  // Records the first mismatched character in s
        char secondChar = ' '; // Records the first mismatched character in goal

        int countOfMisplacedLetters = 0;

        // Find if two strings can be made same with swapping two characters. We assume two strings will have mismatched characters.
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) != goal.charAt(i))
            {
                countOfMisplacedLetters++;

                // If we find two mismatched characters, check if we can swap them around to make two strings equal
                if(countOfMisplacedLetters == 2)
                {
                    if(firstChar != goal.charAt(i) || secondChar != s.charAt(i))
                    {
                        stringSwapPossible = false;
                        break;
                    }        
                }

                // If there are more than 2 mismatched characters, swap is no possible.
                else if(countOfMisplacedLetters > 2)
                {
                    stringSwapPossible = false;
                    break;
                }

                firstChar = s.charAt(i);
                secondChar = goal.charAt(i);
            }      
        }
        // If there is only one mismatched character, swap is not possible.
        if(countOfMisplacedLetters == 1)
        {
            stringSwapPossible = false;
        }

        // If two strings are the same, we check if any character occurs more than once. If all chars appear just once, swap is not possible.
        else if(stringSwapPossible == true && firstChar == ' ')
        {
            // A string that has a length > 26 is guaranteed to be able to swap elements to make two string equal
            if(s.length() > 26)
            {
                return true;
            }
          
            Map<Character, Integer> map = new HashMap<>();

            // Map occurences of each character in the string s. Map is never going to be larger than 26.
            for(int i = 0; i < s.length(); i++)
            {
                map.merge(s.charAt(i), 1, Integer::sum);      
            }

            int max = Collections.max(map.values()); // Find the max value. 

            if(max == 1)
            {
                stringSwapPossible = false;
            }
        }
        return stringSwapPossible;
    }
}
