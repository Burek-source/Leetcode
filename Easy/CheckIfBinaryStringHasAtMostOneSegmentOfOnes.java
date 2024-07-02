Given a binary string s ​​​​​without leading zeros, return true​​​ if s contains at most one contiguous segment of ones. Otherwise, return false.

 

Example 1:

Input: s = "1001"
Output: false
Explanation: The ones do not form a contiguous segment.

  
Example 2:

Input: s = "110"
Output: true
 

Constraints:

1 <= s.length <= 100
s[i]​​​​ is either '0' or '1'.
s[0] is '1'.

class Solution 
{
    public boolean checkOnesSegment(String s) 
    {

        int oneSegment = 0;
        int count = 0;
        boolean noMoreThanOneSegment = false;

       
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '1')
            {
                count++;
            }
            if(s.charAt(i) == '0' || i == s.length()-1)
            {
                if(count > 0)
                {
                    oneSegment++;
                    noMoreThanOneSegment = true;

                }
                count = 0;
            }

            if(oneSegment > 1)
            {
                noMoreThanOneSegment = false;
                break;
            }
        }

        

        return noMoreThanOneSegment;
    }
}
