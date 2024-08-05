In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, 
then such a trust relationship does not exist.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

 

Example 1:

Input: n = 2, trust = [[1,2]]
Output: 2

  
Example 2:

Input: n = 3, trust = [[1,3],[2,3]]
Output: 3

  
Example 3:

Input: n = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
 

Constraints:

1 <= n <= 1000
0 <= trust.length <= 10^4
trust[i].length == 2
All the pairs of trust are unique.
ai != bi
1 <= ai, bi <= n


class Solution 
{
    public int findJudge(int n, int[][] trust) 
    {
        int townJudge = -1; // -1 indicates that the town judge doesn't exist

        Set<Integer> list = new HashSet<>(); // Creates a set of all people who trust someone
        Set<Integer> peopleWhoTrustTheJudge = new HashSet<>(); // Creates a set of all people who trust the town judge

        // Make a list of all people who trust someone
        for(int i = 0; i < trust.length; i++)
        {
            list.add(trust[i][0]);
        }

        // If the number of people who trust someone is not equal to n - 1, return -1 as not every person potentially trusts the town judge
        if(list.size() != n - 1)
        {
            return -1;
        }

        // Edge case: if the size of the set is 0 and the number of people in town is 1, the said person is the town judge
        if(list.size() == 0 && n - 1 == 0)
        {
            return 1;
        }

        // Find if the town judge potentially exists
        for(int i = 0; i < trust.length; i++)
        {
            if(!list.contains(trust[i][1]))
            {
                townJudge = trust[i][1]; // This is a potentail town judge. Needs to be verified further more.
                break;
            }    
        }

        // If town judge not found, return -1
        if(townJudge == -1)
        {
            return townJudge;
        }

        // Find if every person in the town trusts the town judge
        for(int i = 0; i < trust.length; i++)
        {
            if(trust[i][1] == townJudge)
            {
                peopleWhoTrustTheJudge.add(trust[i][0]);
            }
            
          
        }

        // If there is someone who doesn't trust the town judge, return -1;
        if(peopleWhoTrustTheJudge.size() != n - 1)
        {
            townJudge = -1;
        }
        return townJudge;
    }
}
