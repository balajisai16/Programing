/*
Given an unsorted array of integers, find the length of longest increasing subsequence.
For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int temp[] = new int[nums.length];
        int max = 0;
        for(int i=0;i<temp.length;i++)
        {
            temp[i] = 1;
        }
        for(int i=1;i<nums.length;i++) {
            for(int j=0;j<i;j++) {
                if(nums[j]<nums[i])
                    temp[i] = Math.max(temp[i],1+temp[j]);
            }
        }
        for(int i=0;i<temp.length;i++)
        {
            if(temp[i] > max)
                max = temp[i];
        }
        return max;
    }
}