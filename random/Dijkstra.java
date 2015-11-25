import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;


class Dijkstra{
	
	public static void main(String args[]){
	    Node n1 = new Node('a');
	    Node n2 = new Node('b');
	    Node n3 = new Node('c');
	    Node n4 = new Node('d');
	    Node n5 = new Node('e');
		Node n6 = new Node('f');
	    Node n7 = new Node('g');


	    n1.addNeighbor(n2, 4);
	    n1.addNeighbor(n3, 5);
	    n2.addNeighbor(n4, 10);
	    n2.addNeighbor(n5, 7);
	    n3.addNeighbor(n5, 1);
	    n4.addNeighbor(n6, 2);
	    n5.addNeighbor(n6, 3);
	    n5.addNeighbor(n7, 6);

	    bfs(n1);

	}

	public static void dijkstra(Node n1, Node n2){

	}
	public static void bfs(Node start){
		HashSet<Node> visited = new HashSet<Node>();

		Queue<Node> q = new LinkedList<Node>();
		q.add(start);
		visited.add(start);

		while(!q.isEmpty()){
			Node k = q.remove();
			System.out.println(k.val);
			for(DistanceNode n: k.neighbors){
				if(!visited.contains(n.nd)){
					visited.add(n.nd);
					q.add(n.nd);
				}
			}
		}
	}


}

class Node{
	public char val;
	public ArrayList<DistanceNode> neighbors;

	public Node(char val){
	   this.val = val;
	   neighbors = new ArrayList<DistanceNode>();
	}

	public void addNeighbor(Node n, int distance){

		this.neighbors.add(new DistanceNode(n, distance));

	}
}

class DistanceNode{
	public Node nd;
	public int distance;

	public DistanceNode(Node nd, int distance){
		this.nd = nd;
		this.distance = distance;
	}

}