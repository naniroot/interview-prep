/* Reverse a linked list recursively */

class RecursiveLinkedListReversal{
	public static void main(String[] args){
		Node root = new Node(5);
		root.next = new Node(4, new Node(3, new Node(2, new Node(1))));

		System.out.println(root);
		root = reverseLinkedList(root);
		System.out.println(root);
	}

	public static Node reverseLinkedList(Node curr){

		if(curr == null){
			return curr;
		}

		if(curr.next == null){
			return curr;
		}


		Node nextNode = curr.next;
		Node reverseRest = reverseLinkedList(nextNode);
		
		nextNode.next = curr;
		curr.next = null;
		return reverseRest;
	}
}


class Node{
	int val;
	Node next;

	Node(int x){
		this.val = x;
	}

	Node(int x, Node next){
		this.val = x;
		this.next = next;
	}

	public String toString(){
		if(this.next == null){
			return String.format("[%d]", this.val);
		}
		return String.format("[%d] -> %s", this.val, this.next.toString());
	}
}