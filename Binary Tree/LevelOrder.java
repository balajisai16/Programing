/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> level = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp;
        if(root == null)
            return result;
        level.offer(root);
        while(!level.isEmpty()) {
            int size = level.size();
            temp = new ArrayList<Integer>();
            for(int i=0; i< size; i++) {
                TreeNode t = level.poll();
                if(t.left != null)
                    level.offer(t.left);
                if(t.right != null)
                    level.offer(t.right);
                temp.add(t.val);
            }
            result.add(temp);
        }
        
        return result;
    }
}