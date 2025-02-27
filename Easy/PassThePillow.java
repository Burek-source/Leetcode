There are n people standing in a line labeled from 1 to n. The first person in the line is holding a pillow initially. Every second, the person holding the pillow passes it to the next person standing in the line. 
Once the pillow reaches the end of the line, the direction changes, and people continue passing the pillow in the opposite direction.

For example, once the pillow reaches the nth person they pass it to the n - 1th person, then to the n - 2th person and so on.
Given the two positive integers n and time, return the index of the person holding the pillow after time seconds.

 

Example 1:

Input: n = 4, time = 5
Output: 2
Explanation: People pass the pillow in the following way: 1 -> 2 -> 3 -> 4 -> 3 -> 2.
After five seconds, the 2nd person is holding the pillow.

  
Example 2:

Input: n = 3, time = 2
Output: 3
Explanation: People pass the pillow in the following way: 1 -> 2 -> 3.
After two seconds, the 3rd person is holding the pillow.
 

Constraints:

2 <= n <= 1000
1 <= time <= 1000

class Solution 
{
    public int passThePillow(int n, int time) 
    {
        int pillowHolder = 0; // Index position of the pillow holder
        boolean nReached = false;
        boolean zeroReached = true; // We always start at 0

        while(time >= 0)
        {
            // If n not reached, keep increasing index of the pillow holder
            if(pillowHolder < n && nReached == false)
            {
                pillowHolder++;

                // When n is reached, start going back to 0
                if(pillowHolder == n)
                {
                    nReached = true;
                    zeroReached = false;
                }
                
            }

            // When 0 is to be reached, reverse the direction going back to n
            else if(zeroReached == false)
            {
                pillowHolder--;

                if(pillowHolder == 1)
                {
                    nReached = false;
                    zeroReached = true;
                }

            }

            time--; // On every turn reduce the time by 1 second

           
        }

        return pillowHolder;
    }
}
