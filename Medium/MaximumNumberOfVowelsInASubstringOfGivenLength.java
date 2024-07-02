Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

 

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.

  
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.

  
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
 

Constraints:

1 <= s.length <= 10^5
s consists of lowercase English letters.
1 <= k <= s.length

class Solution 
{
    public int maxVowels(String s, int k) 
    {

        int count = 0;
        int actualHighest = 0;
        int indexOfchar = 0;
       

        // Check how many vowels the first substring has
        for(int i = 0; i < k; i++)
        {

            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')
            {
               actualHighest++;
               count++; 
               
               // If the substring has the same amount of vowels as k, return k
               if(actualHighest == k)
               {
                return k;
               }
                    
            } 
        }

        // Check if there are more vowels in subsequent substrings
        for(int i = k; i < s.length(); i++)
        {
          
            char c = s.charAt(indexOfchar);
            
            // Check if the first char of the substring is a vowel
            if(c== 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            {
                count--;
            }
            
            // Check if the last char of the current substring is a vowel
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')
            {
                count++;
            }

            if(count == k)
            {   
                actualHighest = k;
                break;
            }

            else if(count > actualHighest)
            {
                actualHighest = count;
            }

            indexOfchar++;
                
        }  
            
       return actualHighest;
    }
}
