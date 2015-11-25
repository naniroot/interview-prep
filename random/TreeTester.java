package personalQuestions;

import library.NTree;

public class TreeTester {

	public static NTree<Integer> ntree = new NTree<Integer>();
	public static void main(String[] args){
		ntree.insert(5);
		ntree.insert(3);
		ntree.insert(7);
		ntree.insert(1);
		ntree.insert(4);
		ntree.insert(6);
		ntree.insert(8);
		
		//ntree.printInOrder();
		//ntree.printLevel(2);
		ntree.printLevelDFS(2);
	}

}
