/*
    Given a binary tree, return the postorder traversal of its nodes' values.
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
    public List<Integer> postorderTraversal(TreeNode root) {
         if(root == null)
            return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> st1 = new Stack<TreeNode>();
        Stack<Integer> st2 = new Stack<Integer>();
        st1.push(root);
        while(!st1.isEmpty())
        {
            int size =  st1.size();
            for(int i=0;i<size;i++) {
                TreeNode t = st1.pop();
                st2.push(t.val);
                if(t.left != null) {
                    st1.push(t.left);
                }
                if(t.right != null) {
                    st1.push(t.right);
                }
            }
        }
       while(!st2.isEmpty())
       {
           res.add(st2.pop());
       }
        
        return res;
    }
}