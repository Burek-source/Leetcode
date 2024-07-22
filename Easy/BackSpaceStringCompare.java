Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

 

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".

  
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".

  
Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
 

Constraints:

1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.
 

Follow up: Can you solve it in O(n) time and O(1) space?

class Solution 
{
    public boolean backspaceCompare(String s, String t) 
    {
        String sWithoutHash = "";
        String tWithoutHash = "";
        int hashesLeft = 0;

        boolean hashFound = false;

        // Check what is left of the string s after backspaces
        for(int i = s.length()-1; i > -1; i--)
        {
            // Keep count of backspaces pressed
            if(s.charAt(i) == '#')
            {
                hashFound = true;
                hashesLeft++;
            }

            // If no backspaces are pressed, add the letter to the string
            else if(hashFound == false && hashesLeft == 0)
            {
                sWithoutHash = s.charAt(i) + sWithoutHash;
            }

            // Check if the current letter is backspaced or not
            else if(s.charAt(i) != '#' && hashFound == true)
            {
                hashesLeft--;

                if(hashesLeft == 0)
                {
                    hashFound = false;
                }
                
            }
            
        }

        hashFound = false;
        hashesLeft = 0;
    
        // Check what is left of the string t after backspaces
        for(int i = t.length()-1; i > -1; i--)
        {
            // Keep count of backspaces pressed
            if(t.charAt(i) == '#')
            {
                hashFound = true;
                hashesLeft++;
            }
             // If no backspaces are pressed, add the letter to the string
            else if(hashFound == false && hashesLeft == 0)
            {
                tWithoutHash = t.charAt(i) + tWithoutHash;
            }

            // Check if the current letter is backspaced or not
            else if(t.charAt(i) != '#' && hashFound == true)
            {
                hashesLeft--;

                if(hashesLeft == 0)
                {
                    hashFound = false;
                }
                
            }
            
        }
        if(sWithoutHash.equals(tWithoutHash))
        {
            return true;
        }
        return false;

    }
}

