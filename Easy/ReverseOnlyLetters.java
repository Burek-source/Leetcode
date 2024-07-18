Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.

 

Example 1:

Input: s = "ab-cd"
Output: "dc-ba"

  
Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"

  
Example 3:

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 

Constraints:

1 <= s.length <= 100
s consists of characters with ASCII values in the range [33, 122].
s does not contain '\"' or '\\'.

class Solution 
{
    public String reverseOnlyLetters(String s) 
    {
      
        String lowerCase = s.toLowerCase();
        String reversed = "";

        char[] letter = s.toCharArray();
       

        int startIndex = 0;
        int endIndex = s.length()-1;
        char temp = ' ';
        

        while(startIndex < endIndex)
        {
            // If the first and last letter are alphabetical characters, swap them and move inwards
            if(lowerCase.charAt(startIndex) > 96 && lowerCase.charAt(startIndex) < 123)
            {
                if(lowerCase.charAt(endIndex) > 96 && lowerCase.charAt(endIndex) < 123)
                {
                    temp = s.charAt(startIndex);
                    letter[startIndex] = s.charAt(endIndex);
                    letter[endIndex] = temp;

                   startIndex++;
                   endIndex--;
                     
                }
            }
            // If the letter is not in the English alphabet, move to the next letter
            if(lowerCase.charAt(startIndex) < 97)
            {
                startIndex++;
            }
          // If the letter is not in the English alphabet, move to the next letter
            if(lowerCase.charAt(endIndex) < 97)
            {
                endIndex--;
            }
        }

        for(int i = 0; i < letter.length; i++)
        {
            reversed += letter[i];
        }

        return reversed;
    }
}
