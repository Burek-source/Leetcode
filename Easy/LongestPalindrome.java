Given a string s which consists of lowercase or uppercase letters, return the length of the longest 
palindrome
 that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.

 

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

  
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.

class Solution 
{
    public int longestPalindrome(String s) 
    {
        int maxPalindromeLength = 0;
        int maxOddOccurence = 0;
        int countOfOdds = 0;

        Map<Character, Integer> map = new HashMap<>();

        // Map each character in the string s with its occurences
        for(int i = 0; i < s.length(); i++)
        {
            map.merge(s.charAt(i), 1, Integer::sum);
        }

        // Found the length of the longest possible palindrome
        for(char key : map.keySet())
        {
            // If a char appears even number of times, add it to the total count
            if(map.get(key) % 2 == 0)
            {
                maxPalindromeLength += map.get(key);
            }

            // If a char appears odd number of times, add it n - 1 times. 
            else 
            {
                maxPalindromeLength += map.get(key) - 1;
                countOfOdds++;        
            }
          
        }

        // If there is more than one char that appears odd number of times, add 1 to the total count
        if(countOfOdds != 0)
        {
            	maxPalindromeLength++;
        }
        return maxPalindromeLength;
    }
}
