import java.util.*;

class BSTIterator{
	public static void main(String v[]){
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode();
		TreeNode n4 = new TreeNode();
		TreeNode n = new TreeNode();
		TreeNode n3 = new TreeNode();

		
	}	

	private static class Tree{
		TreeNode root;

		public static void insert(int val){
			if(root == null){
				TreeNode n = new TreeNode(val);
				root = n;
				return;
			}			
		}

		private static void insertHelper(root, val){
			if(val > root.val){
				if(root.right == null){
					TreeNode n = new TreeNode(val);
					
				}
			}
		}
	}

	private static class TreeNode{
		TreeNode parent;
		TreeNode left;
		TreeNode right;

		int val;

		TreeNode(int val){
			this.val = val;
		}
	}
}
