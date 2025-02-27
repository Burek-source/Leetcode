You are playing a solitaire game with three piles of stones of sizes a​​​​​​, b,​​​​​​ and c​​​​​​ respectively. Each turn you choose two different non-empty piles, take one stone from each, and add 1 point to your score. 
The game stops when there are fewer than two non-empty piles (meaning there are no more available moves).

Given three integers a​​​​​, b,​​​​​ and c​​​​​, return the maximum score you can get.

 

Example 1:

Input: a = 2, b = 4, c = 6
Output: 6
Explanation: The starting state is (2, 4, 6). One optimal set of moves is:
- Take from 1st and 3rd piles, state is now (1, 4, 5)
- Take from 1st and 3rd piles, state is now (0, 4, 4)
- Take from 2nd and 3rd piles, state is now (0, 3, 3)
- Take from 2nd and 3rd piles, state is now (0, 2, 2)
- Take from 2nd and 3rd piles, state is now (0, 1, 1)
- Take from 2nd and 3rd piles, state is now (0, 0, 0)
There are fewer than two non-empty piles, so the game ends. Total: 6 points.

  
Example 2:

Input: a = 4, b = 4, c = 6
Output: 7
Explanation: The starting state is (4, 4, 6). One optimal set of moves is:
- Take from 1st and 2nd piles, state is now (3, 3, 6)
- Take from 1st and 3rd piles, state is now (2, 3, 5)
- Take from 1st and 3rd piles, state is now (1, 3, 4)
- Take from 1st and 3rd piles, state is now (0, 3, 3)
- Take from 2nd and 3rd piles, state is now (0, 2, 2)
- Take from 2nd and 3rd piles, state is now (0, 1, 1)
- Take from 2nd and 3rd piles, state is now (0, 0, 0)
There are fewer than two non-empty piles, so the game ends. Total: 7 points.

  
Example 3:

Input: a = 1, b = 8, c = 8
Output: 8
Explanation: One optimal set of moves is to take from the 2nd and 3rd piles for 8 turns until they are empty.
After that, there are fewer than two non-empty piles, so the game ends.
 

Constraints:

1 <= a, b, c <= 10^5

class Solution 
{
    public int maximumScore(int a, int b, int c) 
    {
        int max = -1;
        int secondMax = -1;

        int count = 0;
        boolean valid = true;

        // As long as any two piles are higher than 0
        while(valid)
        {
            // Check if a is the highest
            if(a >= b && a >= c)
            {
                max = a;

                // Check the second highest
                if(b >= c)
                {
                    secondMax = b;

                    // Update a and b
                    max--;
                    a = max;

                    secondMax--;
                    b = secondMax;

                    count++;
                }
                else
                {
                    secondMax = c;

                    // Update a and c
                    max--;
                    a = max;

                    secondMax--;
                    c = secondMax;

                    count++;
                }
            }

            // Check if b is the highest
            else if(b >= a && b >= c)
            {
                max = b;

                // Check the second highest
                if(a >= c)
                {
                    secondMax = a;

                    // Update a and b
                    max--;
                    b = max;

                    secondMax--;
                    a = secondMax;

                    count++;
                }
                else
                {
                    secondMax = c;

                    // Update b and c
                    max--;
                    b = max;

                    secondMax--;
                    c = secondMax;

                    count++;
                }
            }

            // Check if c is the highest
            else if(c >= a && c >= b)
            {
                max = c;

                // Check the second highest
                if(a >= b)
                {
                    secondMax = a;

                    // Update a and c
                    max--;
                    c = max;

                    secondMax--;
                    a = secondMax;

                    count++;
                }
                else
                {
                    secondMax = b;

                    // Update b and c
                    max--;
                    c = max;

                    secondMax--;
                    b = secondMax;

                    count++;
                }
            }

            // Check if any two piles are 0
            if(a == 0 && b == 0)
            {
                valid = false;
            }
            else if(a == 0 && c == 0)
            {
                valid = false;
            }
            else if(b == 0 && c == 0)
            {
                valid = false;
            }

        }
        return count;

    }
}
