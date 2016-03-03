// Inheritance in collections test

import java.util.*;

class InheritanceTest{
	public static void main(String[] args){
		List<SuperClass> list = new ArrayList<SuperClass>();
		SubA subA = new SubA();
		SubB subB = new SubB();
		SuperClass sup = new SuperClass();
		list.add(subA);
		list.add(subB);
		list.add(sup);
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
	}

	static class SuperClass{
		public String toString(){
			return "This is super";
		}
	}

	static class SubA extends SuperClass{
		public String toString(){
			return "This is SubA";
		}
	}

	static class SubB extends SuperClass{
		public String toString(){
			return "This is SubB";
		}
	}

}