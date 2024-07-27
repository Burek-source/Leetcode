You are given an alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).

You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. That is, no two adjacent characters have the same type.

Return the reformatted string or return an empty string if it is impossible to reformat the string.

 

Example 1:

Input: s = "a0b1c2"
Output: "0a1b2c"
Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.

  
Example 2:

Input: s = "leetcode"
Output: ""
Explanation: "leetcode" has only characters so we cannot separate them by digits.

  
Example 3:

Input: s = "1229857369"
Output: ""
Explanation: "1229857369" has only digits so we cannot separate them by characters.
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters and/or digits.

class Solution 
{
    public String reformat(String s) 
    {
        String reformatedString = "";

        ArrayList<Character> letters = new ArrayList<>();
        ArrayList<Character> numbers = new ArrayList<>();

        // Separate letters from numbers
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) - 48 < 10)
            {
                numbers.add(s.charAt(i));
            }
            else
            {
                letters.add(s.charAt(i));
            }
        }

        // Case 1: if the difference between two lists is > 1
        if(Math.abs(letters.size() - numbers.size()) > 1)
        {
            return "";
        }

        // Case 2: if the letters list > numbers list
        if(letters.size() > numbers.size())
        {
            for(int i = 0; i < numbers.size(); i++)
            {
                reformatedString += letters.get(i);
                reformatedString += numbers.get(i);
            }

            reformatedString += letters.get(letters.size()-1);
        }

        // Case 3: if the letters list < numbers list
        if(letters.size() < numbers.size())
        {
            for(int i = 0; i < letters.size(); i++)
            {
                reformatedString += numbers.get(i);
                reformatedString += letters.get(i);
            }

            reformatedString += numbers.get(numbers.size()-1);
        }

        // Case 4: if the letters list == numbers list
        if(letters.size() == numbers.size())
        {
            for(int i = 0; i < numbers.size(); i++)
            {
                reformatedString += letters.get(i);
                reformatedString += numbers.get(i);
            }
        }
        return reformatedString;
    }
}
