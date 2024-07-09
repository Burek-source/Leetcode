There are n friends that are playing a game. The friends are sitting in a circle and are numbered from 1 to n in clockwise order. More formally,
moving clockwise from the ith friend brings you to the (i+1)th friend for 1 <= i < n, and moving clockwise from the nth friend brings you to the 1st friend.

The rules of the game are as follows:

Start at the 1st friend.
Count the next k friends in the clockwise direction including the friend you started at. The counting wraps around the circle and may count some friends more than once.
The last friend you counted leaves the circle and loses the game.
If there is still more than one friend in the circle, go back to step 2 starting from the friend immediately clockwise of the friend who just lost and repeat.
Else, the last friend in the circle wins the game.
Given the number of friends, n, and an integer k, return the winner of the game.

 

Example 1:


Input: n = 5, k = 2
Output: 3
Explanation: Here are the steps of the game:
1) Start at friend 1.
2) Count 2 friends clockwise, which are friends 1 and 2.
3) Friend 2 leaves the circle. Next start is friend 3.
4) Count 2 friends clockwise, which are friends 3 and 4.
5) Friend 4 leaves the circle. Next start is friend 5.
6) Count 2 friends clockwise, which are friends 5 and 1.
7) Friend 1 leaves the circle. Next start is friend 3.
8) Count 2 friends clockwise, which are friends 3 and 5.
9) Friend 5 leaves the circle. Only friend 3 is left, so they are the winner.

  
Example 2:

Input: n = 6, k = 5
Output: 1
Explanation: The friends leave in this order: 5, 4, 6, 2, 3. The winner is friend 1.
 

Constraints:

1 <= k <= n <= 500
 

Follow up:

Could you solve this problem in linear time with constant space?

class Solution 
{
    public int findTheWinner(int n, int k) 
    {
        
        int moves = k -1; // The number of moves is always going to be one less than k since you have to count the current position as one move
        int tempMoves = 0;
        int startPosition = 0; // Game always starts from the first player
        int indexToRemove = 0;
      
        ArrayList<Integer> list = new ArrayList<>();
        
        // Create a list of non-decreasing integers up until and including n
        for(int i = 0; i < n; i++)
        {
            list.add(i+1);
        }

        // Keep removing players every k moves until only one player is left. The last player standing is the winner.
        while(list.size() > 1)
        {
            indexToRemove = startPosition + moves;

            // If the end of the list is reached, go back to start.
            if(indexToRemove >= list.size())
            {
                // Since the game is circular, keep reducing the index until is lower than the list size
                while(indexToRemove >= list.size())
                {
                    indexToRemove = indexToRemove - list.size();
                }
                
                // Remove the player from the game
                list.remove(indexToRemove);

                // If upon removal, index is out of bound, start at position 0
                if(indexToRemove > list.size())
                {
                    startPosition = 0;
                }

                // Otherwise, start at the index where the last player was removed
                else
                {
                    startPosition = indexToRemove;
                }
            }

            // If the removal index is lower than the list size, remove the player at the index
            else
            {
                list.remove(indexToRemove);

                // If upon removal, index is out of bound, start at position 0
                if(indexToRemove > list.size())
                {
                    startPosition = 0;
                }
                // Otherwise, start at the index where last player was removed
                else
                {
                    startPosition = indexToRemove;
                }
            }
            
        }
        int winner = list.get(0);
        return winner;

    }
}

