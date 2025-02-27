You are given a 0-indexed string num of length n consisting of digits.

Return true if for every index i in the range 0 <= i < n, the digit i occurs num[i] times in num, otherwise return false.

 

Example 1:

Input: num = "1210"
Output: true
Explanation:
num[0] = '1'. The digit 0 occurs once in num.
num[1] = '2'. The digit 1 occurs twice in num.
num[2] = '1'. The digit 2 occurs once in num.
num[3] = '0'. The digit 3 occurs zero times in num.
The condition holds true for every index in "1210", so return true.

  
Example 2:

Input: num = "030"
Output: false
Explanation:
num[0] = '0'. The digit 0 should occur zero times, but actually occurs twice in num.
num[1] = '3'. The digit 1 should occur three times, but actually occurs zero times in num.
num[2] = '0'. The digit 2 occurs zero times in num.
The indices 0 and 1 both violate the condition, so return false.
 

Constraints:

n == num.length
1 <= n <= 10
num consists of digits.


class Solution 
{
    public boolean digitCount(String num) 
    { 
        boolean valid = true;
        Map<Integer, Integer> map = new HashMap<>();

        // Map the occurence of each digit in the string
        for(int i = 0; i < num.length(); i++)
        {
            int n = (int)(num.charAt(i)-48);
            map.merge(n, 1, Integer::sum);
        }

        // Check if index value is represented the number of times of the char at the index
        for(int i = 0; i < num.length(); i++)
        {
            int n = (int)(num.charAt(i)-48);

            // The number is invalid if it exists in a hashmap but their occurence is not the same as indicated by the value at currently checked index
            if(map.containsKey(i) && map.get(i) != n)
            {
                valid = false;
                break;
            }

            // The number is invalid if it doesn't exist in a hashmap and the value at the currently checked index is not 0
            else if(!map.containsKey(i) && num.charAt(i) != '0')
            {
                valid = false;
                break;
            }     
        }
        return valid;
    }
}
