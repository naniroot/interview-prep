import java.util.*;

class LevelOrderTraversal{
	public static void main(String args[]){
		TreeNode root = new TreeNode(5);
		root.left= new TreeNode(4);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(0);
		root.right.right.right = new TreeNode(17);
		/*
		  5
		4   3
		      0
		*/
		levelOrderTraversal(root);
		//recursiveLevelOrderTraversal(root);
	}
	public static void levelOrderTraversal(TreeNode root){
		if(root == null){
			return;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty()){
			int levelNodes = q.size();
			while(levelNodes>0){
				TreeNode node = q.remove();
				if(node.left!=null){
					q.add(node.left);
				}
				if(node.right!=null){
					q.add(node.right);
				}
				System.out.print(node.val + " ");
				levelNodes--;
			}
			System.out.println("");
		}

	}

	public static void recursiveLevelOrderTraversal(TreeNode curr){

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		levelOrderTraversalHelper(curr, 0, map);

		for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){

			System.out.print(String.format("[%d]", entry.getKey()));

			for(Integer i : entry.getValue()){
				System.out.print(i + " ");
			}

			System.out.println("");
		}


	}

	public static void levelOrderTraversalHelper(TreeNode curr, int level, Map<Integer, List<Integer>> map){

		if(curr == null){
			return;
		}

		if(!map.containsKey(level)){
			map.put(level, new ArrayList<Integer>());
		}
		List<Integer> list = map.get(level);
		list.add(curr.val);
		map.put(level, list);

		levelOrderTraversalHelper(curr.left, level + 1, map);
		levelOrderTraversalHelper(curr.right, level + 1, map);

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



