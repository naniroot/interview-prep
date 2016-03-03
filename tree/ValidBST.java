/* Check if a tree is a valid binary search tree or not */

class ValidBST{
	public static void main(String args[]){
		TreeNode root = new TreeNode(5);
		root.left= new TreeNode(3);
		root.right = new TreeNode(7);
		root.right.right = new TreeNode(12);
		root.right.right.right = new TreeNode(17);

		boolean res = checkValid(root);
		if(res){
			System.out.println("Valid tree");
		} else {
			System.out.println("NOT Valid");
		}
	}
	public static boolean checkValid(TreeNode root){
		return validHelper(root, null, null);
	}
	public static boolean validHelper(TreeNode root, Integer min, Integer max){
		
		if(root == null){
			return true;
		}
		if(min!=null && root.val<min){
			return false;
		}
		if(max!=null && root.val>max){
			return false;
		}
		if(!validHelper(root.left, min, root.val) || !validHelper(root.right, root.val, max)){
			return false;
		}
		return true; 

	}

	private static class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int val){
			this.val = val;
		}
	}
}