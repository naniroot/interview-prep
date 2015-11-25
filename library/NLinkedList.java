package library;

public class NLinkedList<T> {

	private Node<T> root;
	public void insert(T data){
		if(root == null){
			this.root = new Node<T>(data);
		}else{
			Node<T> n = new Node<T>(data);
			n.next = root;
			this.root = n;
		}
	}
	public String toString(){
		StringBuilder builder = new StringBuilder();
		Node<T> node = root;
		while(node!=null){
			builder.append(node.value.toString());
			builder.append(" ");
			node = node.next;
		}
		return builder.toString();
	}
}

class Node<T>{
	Node<T> next;
	T value;
	Node(T data){
		this.value = data;
		this.next = null;
	}
}
