Given a string s containing only lowercase English letters and the '?' character, convert all the '?' characters into lowercase letters such that the final string does not contain any 
consecutive repeating characters. You cannot modify the non '?' characters.

It is guaranteed that there are no consecutive repeating characters in the given string except for '?'.

Return the final string after all the conversions (possibly zero) have been made. If there is more than one solution, return any of them. 
It can be shown that an answer is always possible with the given constraints.

 

Example 1:

Input: s = "?zs"
Output: "azs"
Explanation: There are 25 solutions for this problem. From "azs" to "yzs", all are valid. Only "z" is an invalid modification as the string will consist of consecutive repeating characters in "zzs".

  
Example 2:

Input: s = "ubv?w"
Output: "ubvaw"
Explanation: There are 24 solutions for this problem. Only "v" and "w" are invalid modifications as the strings will consist of consecutive repeating characters in "ubvvw" and "ubvww".
 

Constraints:

1 <= s.length <= 100
s consist of lowercase English letters and '?'.


class Solution 
{
    public String modifyString(String s) 
    {    
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String afterQuestionMarksReplaced = "";

        int indexOfCharBefore = 0;
        int indexOfCharAfter = 0;
        int newIndex = 0;

        Random rand = new Random();
        
        if(s.length() == 1)
        {
            if(s.charAt(0) == '?')
            {
                return "a";
            }
            else
            {
                return s;
            }
        }
      

        if(s.charAt(0) == '?')
        {
            indexOfCharAfter = alphabet.indexOf(s.charAt(1));
            indexOfCharAfter = (indexOfCharAfter+1) % 26;
            
            
            afterQuestionMarksReplaced+=  alphabet.charAt(indexOfCharAfter);
        }
        else
        {
            afterQuestionMarksReplaced += s.charAt(0);
        }

        

        for(int i = 1; i < s.length()-1; i++)
        {
            if(s.charAt(i) == '?')
            {
                indexOfCharBefore = alphabet.indexOf(afterQuestionMarksReplaced.charAt(afterQuestionMarksReplaced.length()-1));
                indexOfCharAfter = alphabet.indexOf(s.charAt(i+1));

               

                newIndex = indexOfCharBefore;

                

               while(newIndex == indexOfCharBefore || newIndex == indexOfCharAfter)
               {
                   newIndex = rand.nextInt(26);
               }
                
               afterQuestionMarksReplaced += alphabet.charAt(newIndex);

              
             
            }
            else
            {
                afterQuestionMarksReplaced += s.charAt(i);
            }

            
        }

        if(s.charAt(s.length()-1) == '?')
        {
            indexOfCharBefore = alphabet.indexOf(afterQuestionMarksReplaced.charAt(afterQuestionMarksReplaced.length()-1));
            indexOfCharBefore = (indexOfCharBefore +1) % 26;
            afterQuestionMarksReplaced += alphabet.charAt(indexOfCharBefore);
        }
        else
        {
            afterQuestionMarksReplaced += s.charAt(s.length()-1);
        }

        return afterQuestionMarksReplaced;
    }
}
