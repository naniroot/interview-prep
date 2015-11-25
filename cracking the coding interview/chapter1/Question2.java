package chapter1;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map.Entry;

/*
 *  1. case sensitive
 *  2. check whitespace
 *  3. null cannot be compared with a primitive type
 *  4. always use containsKey before checking in the hashTable value
 */
public class Question2 {

	public static void main(String[] args){

        tester("test", "sett");
        tester("apple", "applg");
        tester("test", "testzz");
        tester("watch", "tawhc");
	}
	
	public static boolean checkPermutationSorting(String a , String b){
		if(a.length() != b.length()){
			return false;
		}
		a = a.toLowerCase();
		b = b.toLowerCase();
		char[] aArr = a.toCharArray();
		char[] bArr = b.toCharArray();
		Arrays.sort(aArr);
		Arrays.sort(bArr);

		for(int i=0; i<aArr.length; i++){
			if(aArr[i]!= bArr[i]){
				return false;
			}
		}
		return true;
	}
    public static void tester(String one, String two){
        System.out.println("The strings are : (" + one + ") and (" + two + ")");
        System.out.println("Hashmap solution returning: " + checkPermutationHashTable(one, two));
        System.out.println("Sorting solution returning: " + checkPermutationSorting(one, two));
    }
	public static boolean checkPermutationHashTable(String a, String b){
		if(a.length() != b.length()){
			return false;
		}
		Hashtable<Character, Integer> aHash = new Hashtable<Character,Integer>();
		Hashtable<Character, Integer> bHash = new Hashtable<Character,Integer>();
		
		for(int i=0; i<a.length(); i++){
			if(aHash.get(a.charAt(i))==null){
				aHash.put(a.charAt(i), 1);
			}else{
				int val = aHash.get(a.charAt(i));
				val +=1;
				aHash.put(a.charAt(i), val);
			}
			if(bHash.get(b.charAt(i))==null){
				bHash.put(b.charAt(i), 1);
			}else{
				int val = bHash.get(b.charAt(i));
				val +=1;
				bHash.put(b.charAt(i), val);
			}		
		}
		for(Entry<Character, Integer> t: aHash.entrySet()){
			int value = t.getValue();
			char key = t.getKey();
//			System.out.println(value +" "+ bHash.get(key));
			
			if(!bHash.containsKey(key)){
				return false;
			}
			if(bHash.get(key)!= value){
				return false;
			}
		}
		return true;
	}
}
