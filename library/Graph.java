package library;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class Graph<T> {
   public HashMap<T, Node> graph;
   public Graph(){
	   graph = new HashMap<T, Node>();
   }
   public void insert(T val){
	   if(graph.get(val)!=null){
		   System.out.println("Node already inserted");
	   }
	   else {
		   Node node = new Node(val);
		   graph.put(val, node);
		   //System.out.println("inserting node");
	   }
   }
   public void connect(T from, T to){
	   if(graph.get(from) == null){
		   System.out.println("Please insert the node first");
	   }
	   else{
		   Node node = graph.get(from);
		   node.neighbors.add(to);
	   }
   }
   public Set<T> getNeighbors(T proto){
	   if(graph.get(proto) == null){
		   System.out.println("The node is not present in the graph");
	   }
	   return graph.get(proto).getNeigbors();
	   
   }
   public String toString(){
	   StringBuilder builder = new StringBuilder();
	   
	   for(Entry<T, Node> entry: graph.entrySet()){
		   builder.append(entry.getKey());
		   builder.append(" | ");
		  // System.out.println(builder.toString());
		   String str = buildNeighborString(entry.getValue().getNeigbors());
		   builder.append(str);
		   //System.out.println(builder);
		   
	   }
	   return builder.toString();
   }
   public String buildNeighborString(Set<T> set){
	   StringBuilder strBuilder = new StringBuilder();
	   if(set.size() == 0){
		   return "\n";
	   }
	   for(T t : set){
		   strBuilder.append(t);
		   strBuilder.append(" | ");
	   }
	   strBuilder.append("\n");
	   return strBuilder.toString();
   }
   class Node{
		 T data;
		 Set<T> neighbors;
		
		Node(T data){
			this.data = data;
			neighbors = new HashSet<T>();
		}
		Set<T> getNeigbors(){
			return this.neighbors;
		}
	}
}

