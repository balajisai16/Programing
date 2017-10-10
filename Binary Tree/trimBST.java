/*
    Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

        Example 1:
        Input: 
            1
           / \
          0   2

          L = 1
          R = 2

        Output: 
            1
              \
               2
        Example 2:
        Input: 
            3
           / \
          0   4
           \
            2
           /
          1

          L = 1
          R = 3

        Output: 
              3
             / 
           2   
          /
         1
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
    TreeNode newRoot = null;
    
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null)
            return null;
        if(L <= root.val && R >= root.val) {
            newRoot = helperUtil(newRoot, root.val);
        }
        trimBST(root.left,L,R);
        trimBST(root.right,L,R);
        return newRoot;
    }
    
    public TreeNode helperUtil(TreeNode newRoot, int data) {
        if(newRoot == null) {
            newRoot = new TreeNode(data);
            newRoot.left = null;
            newRoot.right = null;
        }
        else {
            if(data <= newRoot.val){
                newRoot.left = helperUtil(newRoot.left,data);
            }
            else {
                newRoot.right = helperUtil(newRoot.right,data);
            }
        }
        return newRoot;
    }
}


class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        
        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);
        
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        
        return root;
    }
}