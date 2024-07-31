A password is said to be strong if it satisfies all the following criteria:

It has at least 8 characters.
It contains at least one lowercase letter.
It contains at least one uppercase letter.
It contains at least one digit.
It contains at least one special character. The special characters are the characters in the following string: "!@#$%^&*()-+".
It does not contain 2 of the same character in adjacent positions (i.e., "aab" violates this condition, but "aba" does not).
Given a string password, return true if it is a strong password. Otherwise, return false.

 

Example 1:

Input: password = "IloveLe3tcode!"
Output: true
Explanation: The password meets all the requirements. Therefore, we return true.

  
Example 2:

Input: password = "Me+You--IsMyDream"
Output: false
Explanation: The password does not contain a digit and also contains 2 of the same character in adjacent positions. Therefore, we return false.

  
Example 3:

Input: password = "1aB!"
Output: false
Explanation: The password does not meet the length requirement. Therefore, we return false.
 

Constraints:

1 <= password.length <= 100
password consists of letters, digits, and special characters: "!@#$%^&*()-+".


class Solution 
{
    public boolean strongPasswordCheckerII(String password) 
    {
        int count = 0;

        // Checks if the length of the password is >= 8
        if(password.matches(".{8,}"))
        {
            count++;
        }

        // Checks if the password contains at least one lower case letter
        if(password.matches(".*[a-z]+.*"))
        {
            count++;
        }

        // Checks if the password contains at least one upper case letter
        if(password.matches(".*[A-Z]+.*"))
        {
            count++;
        }

        // Checks if the password contains at least one number
        if(password.matches(".*[0-9]+.*"))
        {
            count++;
        }

        // Checks if the password contains at least one special characters
        if(password.matches(".*[\\-!@#$%^&*()+]+.*"))
        {
            count++;
        }

        // If any of the above fail, return false
        if(count != 5)
        {
            return false;
        }

        // Check if any two adjacent characters are same
        for(int i = 1; i < password.length(); i++)
        {
            if(password.charAt(i) == password.charAt(i-1))
            {
                count++;
                break;
            }
        }

        if(count == 5)
        {
            return true;
        }
        return false;
        
    }
}
