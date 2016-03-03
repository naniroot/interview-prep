/* [WORKING] Given two strings S and T find the smallest substring of S which contains all the characters of T */
import java.util.*;

class MinimalSubstring{
	public static void main(String args[]){
		String s = "acbbaca";
		String t = "aba";

		System.out.println(String.format("s -> %s, t->%s", s, t));
		String k = findMinimumSubstring(s, t);
		System.out.println("The minimum substring is "+ k); 
		
	}

	public static String findMinimumSubstring(String s, String t){
		int slen = s.length();
		int tlen = t.length();
		int minLen = Integer.MAX_VALUE;
		int minWindowBeg = 0;
		int minWindowEnd = 0;
		int count = 0;

		Map<Character, Integer> foundMap = new HashMap<Character, Integer>();
		Map<Character, Integer> toFindMap = new HashMap<Character, Integer>();

		if(t.length()>s.length()){
			return null;
		}

		// initializing toFindMap
		for(int i=0; i<t.length(); i++){
			char c = t.charAt(i);
			if(toFindMap.containsKey(c)){
				int charCount = toFindMap.get(c);
				toFindMap.put(c, charCount+1);
			} else {
				toFindMap.put(c, 1);
			}
		}

		//printMap(toFindMap);

		int begin = 0;
		int end = 0;

		for(;end<slen; end++){
			char c = s.charAt(end);
			char begC = s.charAt(begin);

			if(!toFindMap.containsKey(c)){
				continue;
			} 

			//Add to foundMap map
			if(foundMap.containsKey(c)){
				int charCount = foundMap.get(c);
				foundMap.put(c, charCount+1);
			} else {
				foundMap.put(c, 1);
			}
			System.out.println("---------------------");
			printMap(foundMap);
			System.out.println(String.format("Begin %d, End %d", begin, end));

			//Increment count when you find an entry
			if(toFindMap.containsKey(c) && foundMap.containsKey(c)){
				if(foundMap.get(c) <= toFindMap.get(c)){
					count+=1;
				}
			}
			System.out.println("count " + count);

			//Constraint is reached toFind has all the characters required
			if(count == tlen){

				//Move the begin pointer only if it is not required or will simply repition stuff to foundMap
				while(!toFindMap.containsKey(begC) || foundMap.get(begC) > toFindMap.get(begC)){
					if(foundMap.containsKey(begC)){
						int tes = foundMap.get(begC);
						if(tes>1){
							foundMap.put(begC, tes-1);
						} else {
							foundMap.remove(begC);
						}
					}
					begin += 1;
					//System.out.println(String.format("Begin %d, End %d", begin, end));
					begC = s.charAt(begin);
				}

				// Check window length here
				int windowLen = end-begin+1;
				if(windowLen < minLen){
					minLen = windowLen;
					minWindowBeg = begin;
					minWindowEnd = end;
				}
			}
		}

		return s.substring(minWindowBeg, minWindowEnd+1);
	}


	public static void printMap(Map<Character, Integer> printMap){

		for(Map.Entry entry: printMap.entrySet()){
			System.out.println(String.format("[ %c ] -> %d", entry.getKey(), entry.getValue()));
		}
	}
}















