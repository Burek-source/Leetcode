You are given a string s formed by digits and '#'. We want to map s to English lowercase characters as follows:

Characters ('a' to 'i') are represented by ('1' to '9') respectively.
Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
Return the string formed after mapping.

The test cases are generated so that a unique mapping will always exist.

 

Example 1:

Input: s = "10#11#12"
Output: "jkab"
Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".

  
Example 2:

Input: s = "1326#"
Output: "acz"
 

Constraints:

1 <= s.length <= 1000
s consists of digits and the '#' letter.
s will be a valid string such that mapping is always possible.


class Solution 
{
    public String freqAlphabets(String s) 
    {
        String alphabet = "!abcdefghijklmnopqrstuvwxyz";
        String temp = "";
        String decrypted = "";
        int n = 0;

        // Decrypt the given string
        for(int i = 0; i < s.length(); i++)
        {
            // When # is encountered convert last two digits into a letter, and convert the rest - if any - into letters.
            if(s.charAt(i) == '#')
            {
                for(int j = 0; j < temp.length()-2; j++)
                {
                    n = temp.charAt(j) - '0';
                    decrypted += alphabet.charAt(n);
                }

                n = Integer.parseInt(temp.substring(temp.length()-2)); // Convert last two digits into a letter
                decrypted += alphabet.charAt(n);

                temp = "";
            }
           
            // Add letters into a temporary string until # or the end of the string is reached
            if(s.charAt(i) != '#')
            {
                temp += s.charAt(i);

                // When the end of the string is reached, convert all leftover digits into individual characters
                if(i == s.length()-1)
                {
                    for(int k = 0; k < temp.length(); k++)
                    {
                        n = temp.charAt(k) - '0';
                        decrypted += alphabet.charAt(n);
                    }
                }
            }      
        }
        return decrypted;
    }
}
