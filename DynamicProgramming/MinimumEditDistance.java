/* 
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/


class Solution {
    public int minDistance(String word1, String word2) {
        int minDist[][] = new int[word1.length()+1][word2.length()+1];
        for(int i=0; i<word1.length()+1; i++) {
            minDist[i][0] = i;
        }
        for(int i=0; i<word2.length()+1; i++) {
            minDist[0][i] = i;
        }
        for(int i=1;i<word1.length() + 1;i++) {
            for(int j=1;j<word2.length() + 1;j++) {
                if(word1.charAt(i-1) == (word2.charAt(j-1)))
                {
                        minDist[i][j] = minDist[i-1][j-1];
                }
                    else
                    {
                        int min = Math.min(minDist[i-1][j],minDist[i][j-1]);
                         minDist[i][j] = Math.min(minDist[i-1][j-1],min) + 1;
                    }
            }
        }
        return minDist[word1.length()][word2.length()];
    }
}