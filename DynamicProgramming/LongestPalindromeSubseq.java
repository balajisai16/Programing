/* 
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
*/
class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s.length() == 0)
            return 0;
       int temp[][] = new int[s.length()][s.length()];
       for(int l=0;l<s.length();l++) {
           for(int i=0;i<s.length()-l;i++) {
               int j = i+l;
               if(i==j) {
                   temp[i][j] = 1;
               } 
               else {
                       if(s.charAt(i) == s.charAt(j)) {
                            temp[i][j] = temp[i+1][j-1] + 2;
                        }
                       else {
                           temp[i][j] = Math.max(temp[i][j-1],temp[i+1][j]);
                       }
               }     
           }
       }
       return temp[0][s.length()-1];
    }
}