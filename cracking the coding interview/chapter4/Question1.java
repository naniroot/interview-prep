package chapter4;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import library.Graph;

public class Question1 {

	public static void main(String []args){
		Graph<Integer> graph = new Graph<Integer>();
		graph.insert(0); 
		graph.insert(1); 
		graph.insert(2); 
		graph.insert(3); 
		graph.insert(4); 
		graph.insert(5);
		graph.insert(6); 
		graph.connect(0, 4); 
		graph.connect(1, 2); 
		graph.connect(1, 4); 
		graph.connect(2, 1); 
		graph.connect(2, 3); 
		graph.connect(3, 1); 
		graph.connect(4, 6); 
		graph.connect(5, 4); 
		graph.connect(6, 4);
		
		System.out.println(graph);
		
		Question1Driver<Integer> driver = new Question1Driver<Integer>();
		boolean val = driver.findPath(0, 4,graph);
		if(val){
			System.out.println("There is a path!!!!");
		}
		else{
			System.out.println("There is no path!!");
		}
	}
}

class Question1Driver<T>{
	public boolean findPath(T a, T b, Graph<T> graph){
		Set<T> visitedSet = new HashSet<T>();
		Queue<T> queue = new LinkedList<T>();
		queue.add(a);
		visitedSet.add(a);
		while(!queue.isEmpty()){
			T ele = queue.remove();
			if(ele == b){
				return true;
			}
			else{
				Set<T>neighbors = graph.getNeighbors(ele);
				for(T nei: neighbors){
					if(!visitedSet.contains(nei)){
						queue.add(nei);
					}
				}
			}
		}
		return false;
	}
}