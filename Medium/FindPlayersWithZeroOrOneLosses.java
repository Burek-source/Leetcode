You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.

Return a list answer of size 2 where:

answer[0] is a list of all players that have not lost any matches.
answer[1] is a list of all players that have lost exactly one match.
The values in the two lists should be returned in increasing order.

Note:

You should only consider the players that have played at least one match.
The testcases will be generated such that no two matches will have the same outcome.
 

Example 1:

Input: matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
Output: [[1,2,10],[4,5,7,8]]
Explanation:
Players 1, 2, and 10 have not lost any matches.
Players 4, 5, 7, and 8 each have lost one match.
Players 3, 6, and 9 each have lost two matches.
Thus, answer[0] = [1,2,10] and answer[1] = [4,5,7,8].

  
Example 2:

Input: matches = [[2,3],[1,3],[5,4],[6,4]]
Output: [[1,2,5,6],[]]
Explanation:
Players 1, 2, 5, and 6 have not lost any matches.
Players 3 and 4 each have lost two matches.
Thus, answer[0] = [1,2,5,6] and answer[1] = [].
 

Constraints:

1 <= matches.length <= 10^5
matches[i].length == 2
1 <= winneri, loseri <= 10^5
winneri != loseri
All matches[i] are unique.

class Solution 
{
    public List<List<Integer>> findWinners(int[][] matches) 
    {
        Map<Integer, Integer> winners = new HashMap<>();
        Map<Integer, Integer> losers = new HashMap<>();

        // Generate two hasmaps, one for winners and one for losers
        for(int i = 0; i < matches.length; i++)
        {
            winners.merge(matches[i][0], 1, Integer::sum);
            losers.merge(matches[i][1], 1, Integer::sum);
        }

        ArrayList<Integer> playersWithNoLosses = new ArrayList();
        ArrayList<Integer> playersWithOneLoss = new ArrayList();

        // Compare the winners hasmap with losers hasmap and find players with one or no losses
        for(int key : winners.keySet())
        {
            if(!losers.containsKey(key))
            {
                playersWithNoLosses.add(key);
            }
            else if(losers.containsKey(key) && losers.get(key) == 1)
            {
                playersWithOneLoss.add(key);
            }
        }

        // Find the keys that exist in losers hashmap and are not present in the winners hashmap. Check if they only have one loss.
        for(int key : losers.keySet())
        {
            if(!winners.containsKey(key) && losers.get(key) == 1)
            {
                playersWithOneLoss.add(key);
            }
             
        }

        playersWithNoLosses.sort(null);
        playersWithOneLoss.sort(null);

        ArrayList answer = new ArrayList<>();

        answer.add(playersWithNoLosses);
        answer.add(playersWithOneLoss);

        return answer;

    }
}
