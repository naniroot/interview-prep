/* Strategies to reverse a linked list */
import java.util.*;

class LinkedListReversal{
	public static void main(String args[]){
		Node root = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));

		// print withour reverising
		System.out.println(root);
		//Reverse iteratively
		root = iterativeReverse(root);
		System.out.println(root);
		//Reverse recursively
		root = recursiveReverse(root);
		System.out.println(root);

		//Reverse linked list using stack
		root = stackReverse(root);
		System.out.println(root);
	}

	public static Node stackReverse(Node root){
		Stack<Node> s = new Stack<Node>();

		Node temp = root;
		while(temp!=null){
			s.push(temp);
			temp = temp.next;
		}
		Node newRoot = s.pop();
		temp = newRoot;
		while(!s.isEmpty()){
			temp.next = s.pop();
			temp = temp.next;
		}
		temp.next = null;
		return newRoot;
	}

	public static Node recursiveReverse(Node root){
		if(root == null || root.next == null){
			return root;
		}
		Node secondElement = root.next;
		root.next = null;

		Node reverseRest = recursiveReverse(secondElement);

		secondElement.next = root;

		return reverseRest;
	}

	public static Node iterativeReverse(Node root){
		if(root == null || root.next == null){
			return root;
		}

		Node temp = root;
		Node next = temp.next;
		Node prev = null;
		while(next != null){
			temp.next = prev;
			prev = temp;
			temp = next;
			next = next.next;
		} 
		temp.next = prev;
		return temp;
	}
}
class Node{
	Node next;
	int val;
	Node(int val, Node next){
		this.val = val;
		this.next = next;
	}
	Node(int val){
		this.val =val;
	}
	@Override
	public String toString(){
		if(this.next == null){
			return String.format("[%d]->null", this.val);
		} else {
			return String.format("[%d]->", this.val) + this.next.toString();
		}
	}
}