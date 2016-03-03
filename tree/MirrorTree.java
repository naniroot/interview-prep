/* Mirror image of a Tree 


				1
			2		3
		  7  16	  9

*/
import java.util.*;

class MirrorTree{
	public static void main(String[] args){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(7);
		root.left.right = new Node(16);

		root.right.left = new Node(9);

		printTree(root);
		mirrorTree(root);
		printTree(root);

	}

	public static void printTree(Node root){

		if(root == null){
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		int counter = q.size();

		while(!q.isEmpty()){
			if(counter == 0){
				counter = q.size();
				System.out.println("");
			}
			Node curr = q.poll();
			System.out.print(curr.val + " ");
			counter --;
			if(curr.left != null){
				q.add(curr.left);
			}

			if(curr.right != null){
				q.add(curr.right);
			}
		}
		System.out.println();
	}

	public static void mirrorTree(Node curr){

		if(curr == null){
			return;
		}

		Node temp = curr.left;
		curr.left = curr.right;
		curr.right = temp;

		mirrorTree(curr.left);
		mirrorTree(curr.right);
	}
}

class Node{
	int val;
	Node left;
	Node right;

	Node(int val){
		this.val = val;
	}
}