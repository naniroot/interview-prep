package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class SherlockAndValid {
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		printValid(str);
		scanner.close();
	}
//	public static void printValid(String str){
//		Map<Character, Integer> map = new HashMap<Character, Integer>();
//		for(int i=0; i<str.length(); i++){
//			char c = str.charAt(i);
//			if(map.containsKey(c)){
//				int val = map.get(c);
//				val++;
//				map.put(c, val);
//			} else {
//				map.put(c, 1);
//			}
//		}
//		int val = -1;
//		boolean firstViolation = true;
//		for(Entry<Character, Integer> etr: map.entrySet()){
//			if(val == -1){
//				val = etr.getValue();
//			} else if ( val- etr.getValue() > 1 ){
//				System.out.println("NO");
//				return;
//			} else if(val -etr.getValue() == 1){
//				if(firstViolation){
//					firstViolation = false;
//				} else {
//					System.out.println("NO");
//					return;
//				}
//			}
//		}
//		System.out.println("YES");
//	}
	public static void printValid(String str){
		int charArr[] = new int[26];
		for(int i=0; i<str.length(); i++){
			charArr[str.charAt(i)-'a']++;
		}
		//printCharArr(charArr);
		//int mode = findMode(charArr);
		//System.out.println(mode);
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<charArr.length; i++){
			if(charArr[i]!=0){
				if(map.containsKey(charArr[i])){
					map.put(charArr[i], map.get(charArr[i])+1);
				} else {
					map.put(charArr[i], 1);
				}
			}
		}
		if(map.entrySet().size()>2){
			System.out.println("NO");
			return;
		}
		if(map.entrySet().size() ==1){
			System.out.println("YES");
			return;
		}
		if(map.containsKey(1)){
			if(map.get(1) == str.length()){
				System.out.println("YES");
				return;
			}
		}
		int a = -1;
		int b = -1;
		for(Entry<Integer, Integer> etr: map.entrySet()){
			System.out.println(etr.getKey() + " "+ etr.getValue());
			if(a ==-1){
				a = etr.getKey();
				b = etr.getValue();
			} else {
				if(b !=1 || etr.getValue() != 1){
					System.out.println("NO");
					return;
				} else {
					System.out.println("YES");
					return;
				}
			}
		}
	}
	
//	public static int findMode(int arr[]){
//		Map<Integer, Integer> modeMap = new HashMap<Integer, Integer>();
//		for(int i=0; i<arr.length; i++){
//			if(modeMap.containsKey(arr[i])){
//				int val = modeMap.get(arr[i]);
//				modeMap.put(arr[i], val+1);
//			} else {
//				modeMap.put(arr[i], 1);
//			}
//		}
//		int max = -1;
//		int mode = -1;
//		for(Entry<Integer, Integer> etr: modeMap.entrySet()){
//			if(etr.getKey() !=0 && etr.getValue() >= max){
//				//System.out.println("entry value: " + etr.getKey());
//				max = etr.getValue();
//				mode = etr.getKey();
//			}
//			//System.out.println(etr.getKey() + " "+ etr.getValue());
//		}
//		return mode;
//	}
//	public static void printCharArr(int arr[]){
//		for(int i=0; i<arr.length; i++){
//			if(arr[i]!=0){
//				System.out.print(arr[i]+ " ");
//			}
//		}
//		System.out.println("");
//	}
}
