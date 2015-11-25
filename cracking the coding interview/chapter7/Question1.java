package chapter7;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Question1 {
	public static Map<Integer,Integer> memoisedList = new HashMap<Integer,Integer>();
	public static void main(String[] args){
		int N = 5;
		System.out.println(findSteps(N));
		System.out.println(findIterativeSteps(N));
	}
	//THIS WILL NOT WORKS IF N==0 AS IT WILL RETURN 1
	public static int findSteps(int N){
		if(memoisedList.containsKey(N)){
		    return memoisedList.get(N);
		}
		else if(N<0){
			return 0;
		}
		else if(N==0){
			return 1;
		}
		else{
			int total = findSteps(N-1) + findSteps(N-2) + findSteps(N-3);
			memoisedList.put(N, total);
			return total;
		}
	}
	
	public static int findIterativeSteps(int N){
		Stack<Integer> stack = new Stack<Integer>();
		if(N ==0){
			return 0;
		}
		stack.add(N);
		int total = 0;
		while(!stack.isEmpty()){
			int k = stack.pop();
				if(k-1 >0){
				 stack.push(k-1);
				}else if (k -1 == 0){
					total ++;
				}
				if(k-2 > 0){
				  stack.push(k-2);
				}else if (k -2 == 0){
					total ++;
				}
				if(k-3 > 0){
				  stack.push(k-3);
				}else if (k -3 == 0){
					total ++;
				}
		}
		return total;
	}
}
