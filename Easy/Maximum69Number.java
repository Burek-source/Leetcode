You are given a positive integer num consisting only of digits 6 and 9.

Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).

 

Example 1:

Input: num = 9669
Output: 9969
Explanation: 
Changing the first digit results in 6669.
Changing the second digit results in 9969.
Changing the third digit results in 9699.
Changing the fourth digit results in 9666.
The maximum number is 9969.

  
Example 2:

Input: num = 9996
Output: 9999
Explanation: Changing the last digit 6 to 9 results in the maximum number.

  
Example 3:

Input: num = 9999
Output: 9999
Explanation: It is better not to apply any change.
 

Constraints:

1 <= num <= 10^4
num consists of only 6 and 9 digits.

class Solution 
{
    public int maximum69Number (int num) 
    {
        int maxNumber = 0;
        int indexOf6 = number.indexOf('6');

        String number = Integer.toString(num);
        String maxNum = "";
        
        // If '6' is not present in the number, return the number
        if(indexOf6 == -1)
        {
            return num;
        }

        // If '6' is only present at the last index position in the number
        else if(indexOf6 == number.length()-1)
        {
            maxNum = number.substring(0, number.length()-1) + '9';
            maxNumber = Integer.parseInt(maxNum);
        }

        // If the first occurence of 6 is anywhere else but at the last index in the number
        else
        {
            maxNum = number.substring(0, indexOf6) + '9' + number.substring(indexOf6 + 1);
            maxNumber = Integer.parseInt(maxNum);
        }
        return maxNumber;     
    }
}
