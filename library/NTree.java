package library;

import java.util.LinkedList;
import java.util.Queue;

public class NTree <T extends Comparable<T>>{
	private Node root;
	
	public void insert(T data){
		if(this.root == null){
			this.root = new Node(data);
			return;
		}
		insertHelper(root, data);
	}
	private void insertHelper(Node cur, T data){
		if(cur.value.compareTo(data)>0){
			if(cur.left == null){
				cur.left = new Node(data);
			}else{
				insertHelper(cur.left, data);
			}
		}else{
			if(cur.right == null){
				cur.right = new Node(data);
			}else{
				insertHelper(cur.right, data);
			}
		}
	}
	public void printInOrder(){
		printInOrderHelper(root);
	}
	private void printInOrderHelper(Node cur){
		if(cur == null){
			return;
		}
		printInOrderHelper(cur.left);
		System.out.println(cur.value);
		printInOrderHelper(cur.right);
	}
	public void printLevel(int level){
		if(root == null){
			System.out.println("Tree empty!!");
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		int toPop = 1;
		while(!q.isEmpty()){
			if(level == 0){
				while(!q.isEmpty()){
					System.out.println(q.poll().value);
				}
				break;
			}
			int tempToPop = 0;
		   for(int i=0; i<toPop; i++){
				Node n = q.poll();
				
				if(n.left != null){
					q.add(n.left);
					tempToPop ++;
				}
				if(n.right!=null){
					q.add(n.right);
					tempToPop ++;
				}
		   }
		   toPop = tempToPop;
			level--;
			
		}
	}
	public void printLevelDFS(int reqLevel){
		int rootLevel =0;
		printLevelDFSHelper(this.root,rootLevel, reqLevel );
	}
	private void printLevelDFSHelper(Node curNode, int curLevel, int reqLevel){
		if(curNode == null){
			return;
		}
		if(curLevel == reqLevel){
			System.out.println(curNode.value);
		}
		printLevelDFSHelper(curNode.left, curLevel+1,reqLevel );
		printLevelDFSHelper(curNode.right, curLevel+1, reqLevel);
		
	}
	private class Node{
		Node left;
		Node right;
		T value;
		Node(T value){
			this.value = value;
		}
	}

}
