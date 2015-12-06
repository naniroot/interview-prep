/* Linked List functions */

class LinkedList{
	public static void main(String args[]){
		Node n1 = new Node(1);
		Node n2 = new Node(3);
		Node n3 = new Node(4);
		Node n4 = new Node(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		Node root = n1;
		System.out.println(root);
		root = removeDupicates(root);
		System.out.println(root);

	}
	static Node removeDupicates(Node root){
		if(root == null){
			return null;
		}
		Node temp = root;
		while(temp != null){
			Node prev = temp;
			Node temp2 = temp.next;
			while(temp2 != null){
				if(temp2.val == temp.val){
					prev.next = temp2.next;	
				} else {
					prev = prev.next;
				}
				temp2 = temp2.next;
			}
			temp = temp.next;
		}
		return root;
	}
}
class Node{
	int val;
	Node next;
	Node(int val){
		this.val = val;
	}

	@Override
	public String toString(){

		if(this.next == null){
			return String.format("[%d]->null", this.val);
		}

		return String.format("[%d]->", this.val) + this.next.toString();
	}
}
