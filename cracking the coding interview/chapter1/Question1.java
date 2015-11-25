package chapter1;

import java.util.Arrays;
import java.util.BitSet;

public class Question1 {

	public static void main(String[] args){

		String test1 = "narayana";
		String test2 = "ivan";
		//Should return false
		System.out.println(isUnique(test1));
		System.out.println(isUniqueBitVector(test1));
		//Shoulr return true
		System.out.println(isUnique(test2));
		System.out.println(isUniqueBitVector(test2));
	}
	
	public static boolean isUnique(String word){
		char[] charArray = word.toLowerCase().toCharArray();
		Arrays.sort(charArray);
		for(int i=0; i<charArray.length-1; i++){
			if(charArray[i] == charArray[i+1]){
				return false;
			}
		}
		return true;
	}

	public static boolean isUniqueBitVector(String word){
		BitSet bitSet = new BitSet();
		for(int i=0; i<word.length(); i++){
			char a = word.charAt(i);
			if(bitSet.get(a)){
				return false;
			}
			bitSet.set(a);
		}
		return true;
	}
}