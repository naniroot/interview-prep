// Peeking iterator over a tree, basically implement and peek(), next() and hasNext()
/* Mirror image of a Tree 


				16
			3		25
		  2   7	  19
		1

*/
import java.util.*;

class PeekingTree{
	public static void main(String[] args){
		Node root = new Node(16);
		root.left = new Node(3);
		root.right = new Node(25);

		root.left.left = new Node(2);
		root.left.right = new Node(7);
		root.left.left = new Node(1);

		root.right.left = new Node(19);

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
}

class Node{
	int val;
	Node left;
	Node right;

	Node(int val){
		this.val = val;
	}
}

class TreeIterator implements Iterator<Node>{
	Node root;

	TreeIterator(Node root){
		this.root = root;
	}

	@Override
	public boolean hasNext(){

	}

	@Override
	public Node next(){

	}

	@Override
	public void remove(){

	}

	public Node peek(){

	}

}