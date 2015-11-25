package personalQuestions;

import library.NLinkedList;

public class LinkedListTester {
	public static void main(String[] args){
		NLinkedList<Integer> list = new NLinkedList<Integer>();
		
		list.insert(5);
		list.insert(4);
		list.insert(7);
		list.insert(6);
		System.out.println(list);
		
	}
}
