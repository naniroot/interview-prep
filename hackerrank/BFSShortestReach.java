package hackerrank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSShortestReach {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	int testCases = Integer.parseInt(scanner.nextLine());
    	for(int i=0; i<testCases; i++){
    		String firstLine = scanner.nextLine();
    		String test[] = firstLine.split(" ");
    		int noNodes = Integer.parseInt(test[0]);
    		int noEdges = Integer.parseInt(test[1]);
    		//System.out.println("no nodes " + noNodes + "no edges " + noEdges);
    		ArrayList<Node> nodeList = createNodes(noNodes);
    		for(int j=0;j<noEdges; j++){
    			String edge = scanner.nextLine();
    			addEdge(edge, nodeList);
    		}
    		int start = Integer.parseInt(scanner.nextLine());
    		bfs(start, nodeList);
    		printDistances(nodeList);
    	}
		scanner.close();
    }
    public static void bfs(int s, ArrayList<Node> list ){
    	Node start = list.get(s-1);
    	start.distance = 0;
    	Queue<Node> q = new LinkedList<Node>();
    	q.add(start);
    	while(!q.isEmpty()){
    		Node t = q.remove();
    		for(Node neigh: t.neighbors){
    			if(neigh.distance == -1){
    				neigh.distance = t.distance+6;
    				q.add(neigh);
    			}
    		}
    	}
    }

    public static void printDistances(ArrayList<Node> list){
		//System.out.println("tada\n");
    	for(int i =0; i<list.size(); i++){
    		Node t = list.get(i);
    		if(t.distance!=0){
    			System.out.print(t.distance);
    			System.out.print(" ");
    		}
    	}
		System.out.println("");
    }

    public static void addEdge(String edge, ArrayList<Node> list){
    	String test[] = edge.split(" ");
    	int n1 = Integer.parseInt(test[0]);
    	int n2 = Integer.parseInt(test[1]);
    	
    	Node node1 = list.get(n1-1);
    	Node node2 = list.get(n2-1);
    	node1.addNeighbors(node2);
    	node2.addNeighbors(node1);
    }

    public static ArrayList<Node> createNodes(int noNodes){
    	ArrayList<Node> nodeList = new ArrayList<Node>();
    	for(int i=0; i<noNodes; i++){
    		nodeList.add(new Node(-1));
    	}
    	//System.out.println("node list size " + nodeList.size());
    	return nodeList;
    }
}

class Node{
	public int distance;
	public ArrayList<Node> neighbors;

	Node(int dist){
		this.distance =dist;
		neighbors = new ArrayList<Node>();
	}

	public void addNeighbors(Node n){
		this.neighbors.add(n);
	}
}
