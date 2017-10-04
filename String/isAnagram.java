/*
	Given two strings s and t, write a function to determine if t is an anagram of s.

		For example,
		s = "anagram", t = "nagaram", return true.
		s = "rat", t = "car", return false.

		Note:
		You may assume the string contains only lowercase alphabets.

		Follow up:
		What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] anagram = new int[26];
        for(int i=0;i < s.length(); i++)
            anagram[s.charAt(i) - 'a']++;
        for(int j=0; j < t.length(); j++)
            anagram[t.charAt(j) - 'a']--;
        for(int i: anagram) 
            if(i != 0) 
                return false;
        return true;
    }
}