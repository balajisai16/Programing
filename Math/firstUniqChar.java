/*
    Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

        Examples:

        s = "leetcode"
        return 0.

        s = "loveleetcode",
        return 2.
*/
class Solution {
    public int firstUniqChar(String s) {
        int frequency[] = new int[26];
        for(int i=0; i<s.length(); i++) {
            frequency[s.charAt(i) - 'a'] ++;
        }
        for(int j=0; j<s.length(); j++) {
            if(frequency[s.charAt(j) - 'a'] == 1)
                return j;
        }
        return -1;
    }
}