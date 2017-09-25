/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        Stack<TreeNode> st1 = new Stack<TreeNode>();
        Stack<TreeNode> st2 = new Stack<TreeNode>();
        List<Integer> temp = null;
        temp = new ArrayList<Integer>();
        TreeNode current;
        st1.push(root);
        boolean flag= false;
        while(!st1.isEmpty() || !st2.isEmpty())
        {
            while(!st1.isEmpty())
            {
                flag = true;
                current = st1.pop();
                temp.add(current.val);
                if(current.left != null)
                    st2.push(current.left);
                if(current.right != null)
                    st2.push(current.right);
            }
            if(flag)
            {
                result.add(temp);
                temp = new ArrayList<Integer>();
                flag = false;
            }
            while(!st2.isEmpty())
            {
                flag = true;
                current = st2.pop();
                temp.add(current.val);
                if(current.right != null)
                    st1.push(current.right);
                if(current.left != null)
                    st1.push(current.left);
            }
             if(flag)
            {
                result.add(temp);
                temp = new ArrayList<Integer>();
                flag = false;
            }
        }
        return result;
    }
}

/**
     * One deque with delimiter to print tree in spiral order
     */
    public void spiralWithOneDequeDelimiter(Node root)
    {
        if(root == null){
            return;
        }
        Deque<Node> q = new LinkedList<>();
        q.offer(null);
        q.offerFirst(root);
        //if only delimiter(in this case null) is left in queue then break
        while(q.size() > 1){
            root = q.peekFirst();
            while(root != null){
                root = q.pollFirst();
                System.out.print(root.data + " ");
                if(root.left != null){
                    q.offerLast(root.left);
                }
                if(root.right != null){
                    q.offerLast(root.right);
                }
                root = q.peekFirst();
            }
            root = q.peekLast();
            while(root != null){
                System.out.print(root.data + " ");
                root = q.pollLast();
                if(root.right != null){
                    q.offerFirst(root.right);
                }
                if(root.left != null){
                    q.offerFirst(root.left);
                }
                root = q.peekLast();
            }
        }
    }