/*
    Morris Inorder Traversal
    Time Complexity: O(n)
    Space Complexity:O(1)
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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        TreeNode current = root;
        while(current!=null) {
            if(current.left == null) {
                res.add(current.val);
                current = current.right;
            }
            else {
                TreeNode predecssor = findPredecessor(current);
                if(predecssor.right == null) {
                    predecssor.right = current;
                    current = current.left;
                }
                else {
                    predecssor.right = null;
                    res.add(current.val);
                    current = current.right;
                }
            }
        }
        return res;
    }
    
    public TreeNode findPredecessor(TreeNode current) {
        TreeNode pre = current.left;
        while(pre.right != null && pre.right != current)
            pre = pre.right;
        return pre;
    }
}