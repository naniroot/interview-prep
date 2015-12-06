/* Hacker Rank Ice Cream parlor */
// [UNSOLVED]

import java.util.*;

public class IceCreamParlor{
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int testCases = Integer.parseInt(scanner.nextLine());
		System.out.println("testcases " + testCases);
		for(int i=0; i<testCases; i++){
			int m = Integer.parseInt(scanner.nextLine());
			int n = Integer.parseInt(scanner.nextLine());
			String []sarr = scanner.nextLine().split(" ");

			//Map of <val, index>
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int j=0; j<n; j++){
				int val = Integer.parseInt(sarr[j]);
				if(!map.containsKey(val)){
					map.put(val, j);
				}
			}
			printIndicies(m, map);
		}
		scanner.close();
	}

	public static void printIndicies(int m, Map<Integer, Integer> map){
		for(Map.Entry<Integer, Integer> e: map.entrySet()){
			int temp = m - e.getKey();
			if(map.containsKey(temp)){
				int index1 = e.getValue()+1;
				int index2 = map.get(temp)+1;
				if(index1>index2){
					System.out.println(index2 + " " + index1);
				} else {
					System.out.println(index1 + " " + index2);
				}
				return;
			}
		}
	}
}