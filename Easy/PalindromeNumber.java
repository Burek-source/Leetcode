Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
  
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 
Constraints:

-2^31 <= x <= 2^31 - 1


class Solution 
{
    public boolean isPalindrome(int x) 
    {
            String numberString = Integer.toString(x);
            boolean isPalindrome = false;

            // Negative numbers can't be palindromes due to the negative sign
            if(x < 0)
            {
                return false;
            }

            int start = 0;
            int end = numberString.length()-1;
      
            // Check if the first and last char of the string are the same. Move inwards if they are the same. Otherwise, exit the loop
            for (int i = 0; i < numberString.length() ; i++)
            {
                // If chars don't match, the number is not a palindrome
                if(numberString.charAt(start) != numberString.charAt(end))
                {
                    break;
                }

                // If the middle of the string is crossed, palindrome found
                if(start >= end)
                {
                    isPalindrome = true;
                    break;
                }

                start++;
                end--;
            }
            
           
            return isPalindrome;
        
    }
}
