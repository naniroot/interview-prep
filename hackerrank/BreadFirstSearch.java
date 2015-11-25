import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
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
    		dijkstra(start, nodeList);
    		printDistances(nodeList);
    	}
		scanner.close();
    }

    public static dijkstra(node start, ArrayList<Node> list){
    	System.out.println("TADA");

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
    	int distance = Integer.parseInt(test[2]);
    	
    	Node node1 = list.get(n1-1);
    	Node node2 = list.get(n2-1);
    	node1.addNeighbors(node2, distance);
    	node2.addNeighbors(node1, distance);
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
	public HashMap<Node, Integer> distanceMap;
	public Node prev;

	Node(int dist){
		this.distance =dist;
		neighbors = new ArrayList<Node>();
		distanceMap = new HashMap<Node, Integer>();
		prev = null;
	}

	public void addNeighbors(Node n, int distance){
		this.neighbors.add(n);
		HashMap.add(n, distance);
	}
}
