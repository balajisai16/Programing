/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root == null) {
            root = node;
            return root;
        }
        TreeNode current = root,parent = null;
        while(current != null) {
            parent = current;
            if(parent.val > node.val)
                current = current.left;
                else
                current = current.right;
        }
        if(parent.val > node.val)
            parent.left = node;
            else
            parent.right = node;
        
        
        return root;
    }
}