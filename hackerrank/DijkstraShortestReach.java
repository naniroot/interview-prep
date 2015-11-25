package hackerrank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraShortestReach {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int testCases = Integer.parseInt(scanner.nextLine());
	for(int i=0; i<testCases; i++){
		String firstLine = scanner.nextLine();
		String test[] = firstLine.split(" ");
		int noNode1s = Integer.parseInt(test[0]);
		int noEdges = Integer.parseInt(test[1]);
		//System.out.println("no Node1s " + noNode1s + "no edges " + noEdges);
		ArrayList<Node1> Node1List = createNode1s(noNode1s);
		for(int j=0;j<noEdges; j++){
			String edge = scanner.nextLine();
			addEdge(edge, Node1List);
		}
		int start = Integer.parseInt(scanner.nextLine());
		dijkstra(start, Node1List);
		printDistances(Node1List);
	}
	scanner.close();
}

public static void dijkstra(int start, ArrayList<Node1> list){
	//System.out.println("TADA");

	
	PriorityQueue<Node1> pq = new PriorityQueue<Node1>(100, new PqueueComaparator());
	for(Node1 n: list){
		n.distance = Integer.MAX_VALUE / 2;
		pq.add(n);
	}
	
	Node1 startNode = list.get(start-1);
	startNode.distance = 0;
	pq.remove(startNode);
	pq.add(startNode);
	
	//System.out.println(String.format("This is the startNode [%s]", startNode));
	
	while(!pq.isEmpty()){
		Node1 u = pq.poll();
		
		//System.out.println(String.format("Polling the node with minimum distance [%s]", u));
		for(Node1 nieg: u.neighbors){
			int altDistance = u.distance + u.distanceMap.get(nieg);
			//System.out.println(String.format("\tThe neighbor distance is [%d] and altDistance is [%d]", u.distanceMap.get(nieg), altDistance));
			//System.out.println("U distance " + u.distance);
			if(altDistance < nieg.distance){
				//System.out.println("Alt distnace "+ altDistance);
				nieg.distance = altDistance;
				pq.remove(nieg);
				pq.add(nieg);
			}
		}
	}
}

public static void printDistances(ArrayList<Node1> list){
	//System.out.println("tada\n");
	for(int i =0; i<list.size(); i++){
		Node1 t = list.get(i);
		if(t.distance == 1073741823){
			System.out.print(-1);
			System.out.print(" ");
		}else if(t.distance!=0){
			System.out.print(t.distance);
			System.out.print(" ");
		}
	}
	System.out.println("");
}

public static void addEdge(String edge, ArrayList<Node1> list){
	String test[] = edge.split(" ");
	int n1 = Integer.parseInt(test[0]);
	int n2 = Integer.parseInt(test[1]);
	int distance = Integer.parseInt(test[2]);
	
	Node1 Node11 = list.get(n1-1);
	Node1 Node12 = list.get(n2-1);
	Node11.addNeighbors(Node12, distance);
	Node12.addNeighbors(Node11, distance);
}

public static ArrayList<Node1> createNode1s(int noNode1s){
	ArrayList<Node1> Node1List = new ArrayList<Node1>();
	for(int i=0; i<noNode1s; i++){
		Node1List.add(new Node1(Integer.MAX_VALUE/2));
	}
	//System.out.println("Node1 list size " + Node1List.size());
	return Node1List;
}
}

class Node1{
public int distance;
public ArrayList<Node1> neighbors;
public HashMap<Node1, Integer> distanceMap;

Node1(int dist){
	this.distance =dist;
	neighbors = new ArrayList<Node1>();
	distanceMap = new HashMap<Node1, Integer>();
}

public void addNeighbors(Node1 n, int distance){
	this.neighbors.add(n);
	distanceMap.put(n, distance);
}

public String toString(){
	return "Distance : " + distance + " Num Neighbors : " + neighbors.size();
}

}


class PqueueComaparator implements Comparator<Node1>{
	@Override
	public int compare(Node1 n1, Node1 n2){
		if(n1.distance < n2.distance){
			return -1;
		}
		if(n1.distance > n2.distance){
			return 1;
		}
		return 0;
	}
}