// Level Order Traversal

import java.util.*;


class LevelOrderTraversal{
	public static void main(String args[]){
		Node root = new Node(5);
		root.left = new Node(4);
		root.right = new Node(3);
		root.right.right = new Node(1);

		traverse(root);
	}

	public static void traverse(Node root){
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		int counter = q.size();

		while(!q.isEmpty()){
			if(counter == 0){
				counter = q.size();
				System.out.println("");
			}
			Node n = q.poll();
			counter -=1;
			System.out.print(n.val + " ");
			if(n.left != null){
				q.add(n.left);	
			}
			if(n.right != null){
				q.add(n.right);				
			}
		}
	}
}

class Node{
	Node left;
	Node right;
	int val;

	Node(int val){
		this.val = val;
	}

}