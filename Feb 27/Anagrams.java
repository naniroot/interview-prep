// LeetCode anagrams

import java.util.*;

class Anagrams{
	public static void main(String[] args){
		String[] input = {"taco", "rumba", "test", "coat", "sett", "aumbr"};
		ArrayList<ArrayList<String>> output = getAnagrams(input);
		for(ArrayList<String> e: output){
			for(int i=0; i<e.size(); i++){
				String s = e.get(i);
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}

	public static ArrayList<ArrayList<String>> getAnagrams(String[] input){
		ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
		if(input == null || input.length==0){
			return output;
		}
		Map<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

		for(int i=0; i<input.length; i++){
			String s = input[i];
			int hashCode = getHash(s);
			if(map.containsKey(hashCode)){
				ArrayList<String> tmp = map.get(hashCode);
				tmp.add(s);
				//PUt it back if this doesn't work
			} else {
				ArrayList<String> tmp = new ArrayList<String>();
				tmp.add(s);
				map.put(hashCode, tmp);
			}
		}

		for(Map.Entry<Integer, ArrayList<String>> e: map.entrySet()){
			output.add(e.getValue());
		}
		return output;
	}

	public static int getHash(String s){
		int sum =0;
		for(int i=0; i<s.length();i++){
			sum += (s.charAt(i)-'a');
		}
		return sum;
	}
}