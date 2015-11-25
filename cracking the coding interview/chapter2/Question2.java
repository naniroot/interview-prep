package chapter2;

import library.NLinkedList;

//TODO: implement the answer to the question
//Currently its just testing the generic linked list you have created.
public class Question2 {
	public static void main(String[] args){
		NLinkedList<Integer> list = new NLinkedList<Integer>();
		
		list.insert(5);
		list.insert(4);
		list.insert(7);
		list.insert(6);
		System.out.println(list);
		
	}
}
