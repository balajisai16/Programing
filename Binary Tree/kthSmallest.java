/*
	Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

	Note: 
	You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

	Follow up:
	What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
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
class Solution {
    int val = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;
        ksmall(root,k);
        return val;
    }
    
    public void ksmall(TreeNode root, int k) {
        if(root == null)
            return;
        ksmall(root.left,k);
        if(k == ++count) {
          val = root.val;   
        }
        ksmall(root.right,k);
    }
}