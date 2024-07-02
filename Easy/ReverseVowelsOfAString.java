Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

Example 1:

Input: s = "hello"
Output: "holle"

  
Example 2:

Input: s = "leetcode"
Output: "leotcede"
 

Constraints:

1 <= s.length <= 3 * 10^5
s consist of printable ASCII characters.

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String reverseVowels(String s) 
    {

        ArrayList<Character> vowels = new ArrayList<>();
        ArrayList<Integer> positions = new ArrayList<>();

        char[] chars = new char[s.length()];
        char temp = ' ';
        String result = "";

        // Create an array of chars from the string s
        for(int i = 0; i < s.length(); i++)
        {
            chars[i] = s.charAt(i);
        }

        // Get vowels and their positions in a string
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'A'  || s.charAt(i) == 'E' 
            || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U' )
            {
                vowels.add(s.charAt(i));
                positions.add(i);
            }
        }


        int first = 0;
        int last = positions.size()-1;

        // Reverse the string
        for(int i = 0; i < positions.size()/2; i++)
        {
            temp = vowels.get(first);  
            chars[positions.get(first)] = vowels.get(last);
            chars[positions.get(last)] = temp;

            first++;
            last--;
        }

        for(int i = 0; i < chars.length; i++)
        {
            result = result + chars[i];
        }
        return result;
    }
}
