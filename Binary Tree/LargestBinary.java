package dataStructure;

import dataStructure.BinaryTree.Node;

public class LargestBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		tree.build123c();
		Node root = tree.getRoot();
		tree.printTree();
		LargestBST largestBst = new LargestBST();
		Data result = largestBst.findLargestBST(root);
		System.out.println(result.count + " " + result.max + " " + result.min);
	}
	
	class Data {
		Node temp;
		boolean isBst;
		int count,min,max;
		public Data(Node temp, boolean isBst, int count, int min, int max) {
			super();
			this.temp = temp;
			this.isBst = isBst;
			this.count = count;
			this.min = min;
			this.max = max;
		}
	}

	private  Data findLargestBST(Node root) {
		if(root == null)
			return null;
		Data left = findLargestBST(root.left);
		Data right = findLargestBST(root.right);
		if(left == null && right == null)
			return new Data(root,true,1,root.data,root.data);
		if(left == null && right != null)
		{
			if(root.data < right.min)
				return new Data(root,true,right.count+1,right.min,right.max);
			else
				return new Data(root,false,right.count,0,0);
		}
		else if(right == null && left != null) {
			if(root.data > left.max)
				return new Data(root,true,left.count +1, left.min,left.max);
			else
				return new Data(root,false,left.count,0,0);
		}
		else {
			if(root.data > left.max && root.data < right.min)
				return new Data(root,true,left.count+right.count + 1,left.min,right.max);
			else
				return new Data(root,false,Math.max(left.count, right.count),0,0);
		}	
	}

}
