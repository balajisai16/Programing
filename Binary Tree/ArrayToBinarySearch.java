/*
	Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        TreeNode head = toBST(nums,0,nums.length-1);
        return head;
    }
    
    public TreeNode toBST(int[] nums,int low,int high) {
        if(low > high)
            return null;
        int mid = low + (high - low)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums,low,mid-1);
        root.right = toBST(nums,mid+1,high);
        return root;
    }
    
}
