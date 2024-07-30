Given an integer n, add a dot (".") as the thousands separator and return it in string format.

 

Example 1:

Input: n = 987
Output: "987"

  
Example 2:

Input: n = 1234
Output: "1.234"
 

Constraints:

0 <= n <= 2^31 - 1

class Solution 
{
    public String thousandSeparator(int n) 
    {
        String number = Integer.toString(n);
        String result = "";
        int count = 0;

        // Add full stops to every thousands place
        for(int i = number.length()-1; i > -1; i--)
        {
            if(count == 3)
            {
                result = "." + result;
                count = 0;
            }

            result = number.charAt(i) + result; 
            count++;
        }
        return result;
    }
}
