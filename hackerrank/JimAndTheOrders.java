/* Hacker Rank Jim and the Orders */
import java.util.*;

class JimAndTheOrders{
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int noOfLines = Integer.parseInt(scanner.nextLine());
		ArrayList<Node> list = new ArrayList<Node>();
		for(int i=0; i<noOfLines; i++){
			String case1 = scanner.nextLine();
			String []cases = case1.split(" ");
			list.add(new Node(Integer.parseInt(cases[0]), Integer.parseInt(cases[1]), i));
		}
		Collections.sort(list, new CustomComparator());
		for(int i=0; i<list.size(); i++){
			list.get(i).rank = i+1;
		}
		Collections.sort(list, new  PositionItCameInComparator());
		for(int i=0; i<list.size(); i++){
			System.out.print(list.get(i).rank + " ");
		}
		scanner.close();
	}
}
class Node{
	int pos;
	int time;
	int sum;
	int positionItCameIn;
	int rank;
	Node(int a, int b, int positionItCameIn){
		this.pos = a;
		this.time = b;
		this.sum = a+b;
		this.positionItCameIn = positionItCameIn;
	}
}

class CustomComparator implements Comparator<Node>{
	@Override
	public int compare(Node a, Node b){
		if(a.sum> b.sum){
			return 1;
		} else if(a.sum<b.sum) {
			return -1;
		}
		return 0;
	}
}

class PositionItCameInComparator implements Comparator<Node>{
	@Override
	public int compare(Node a, Node b){
		if(a.positionItCameIn> b.positionItCameIn){
			return 1;
		} else if(a.positionItCameIn<b.positionItCameIn) {
			return -1;
		}
		return 0;
	}
}