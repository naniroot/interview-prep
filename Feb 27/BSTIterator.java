//Leetcode BST iterator next() and hasNext()
/* Mirror image of a Tree 


				16
			3		25
		  2   7	  19
		1

*/
import java.util.*;

class BSTIterator{
	public static void main(String[] args){
		Node root = new Node(16);
		root.left = new Node(3);
		root.right = new Node(25);

		root.left.left = new Node(2);
		root.left.right = new Node(7);
		root.left.left.left = new Node(1);

		root.right.left = new Node(19);

		printTree(root);

		BinarySearchTreeIterator bst = new BinarySearchTreeIterator(root);
		while(bst.hasNext()){
			System.out.print(bst.peek().getVal() + " " + bst.next().getVal() + " ");
		}


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
	Node left;
	Node right;
	int val;
	Node(int val){
		this.val = val;
	}

	public int getVal(){
		return this.val;
	}
}

class BinarySearchTreeIterator{
	private Node curr;
	private Stack<Node> depth;

	BinarySearchTreeIterator(Node root){
		depth = new Stack<Node>();
		Node tes = root;
		while(tes.left != null){
			depth.push(tes);
			tes = tes.left;
		}
		this.curr = tes;
		System.out.println("curr " + this.curr.val);
	}

	public boolean hasNext(){
		return this.curr!=null;

	}

	public Node next(){
		Node temp = this.curr;
		if(this.curr.right != null){
			this.curr = getMinValue(curr.right);
			return temp;
		}
		while(!depth.isEmpty()){
			Node parent = this.depth.pop();
			if(this.curr != parent.right){
				this.curr = parent;
				return temp;
			}
		}
		this.curr = null;
		return temp;
	}

	public Node peek(){
		return this.curr;
	}
	private Node getMinValue(Node root){
		while(root.left != null){
			depth.push(root);
			root = root.left;
		}
		return root;	
	}
}