//Leetcode balanced binary tree

class BalancedBinary{
	public static boolean isBalanced(Node root){
		return (isBalancedhelper(root) != -1);
	}

	public static int isBalancedhelper(Node curr){
		if(curr == null){
			return 0;
		}

		int leftHeight = isBalancedhelper(curr.left);
		int rightHeight = isBalancedhelper(curr.right);

		if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight- rightHeight) > 1){
			return -1;
		}

		return Math.max(leftHeight, rightHeight) + 1;
	}
}