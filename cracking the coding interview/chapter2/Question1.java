package chapter2;

//TODO: write a proper linked list
//TODO: implement merge sort and analyze its space analysis.

// Its Arrays.sort for an array
// Its Collections.sort for a collection
public class Question1 {

	public static void main(String[] args){

		Node n1 = new Node(1);
		Node n2 = new Node(5);
		Node n3 = new Node(7);
		Node n4 = new Node(1);
		Node n5 = new Node(1);
		CustomLinkedList clist = new CustomLinkedList();
		//System.out.println(clist);
		clist.insert(n1);
		clist.insert(n2);
		clist.insert(n3);
		clist.insert(n4);
		clist.insert(n5);
		System.out.println("");
		System.out.println(clist);
		removeDuplicatesBruteForce(clist);
		System.out.println(clist);
		
	}
	public static void removeDuplicatesBruteForce(CustomLinkedList clist){
		Node n = clist.returnHead();
		if(n == null){
			return;
		}
		else if(n.next == null){
			return;
		}
		while(n.next != null){
			Node nn = n;
			while(nn.next!= null){
				if(nn.next.val == n.val){
					nn.next = nn.next.next; // this also moves it forward
				}else{
				nn = nn.next; // moves the pointer forward 
				}
			}
			n = n.next;
		}
	}
}

class Node{
	public int val;
	public Node next;
	
	Node(int val)
	{
		this.val = val;
		this.next = null;
	}
}

class CustomLinkedList{
	public Node head= null;
	
	public void insert(Node node){
		node.next = head;
		head = node;
	}
	public Node returnHead(){
		return head;
	}
	
   public String toString(){
	   String retString = "";
	   if(head == null){
		   return "Empty";
	   }
	   else{
		   Node temp = head;
		   while(temp != null){
			   System.out.println(temp.val);
			   temp = temp.next;
		   }
	   }
	   return retString;
   }
}