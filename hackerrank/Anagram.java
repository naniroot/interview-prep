package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int noTestCases = Integer.parseInt(scanner.nextLine());
		for(int i=0; i<noTestCases; i++){
			String word = scanner.nextLine();
			int k = printAnagram(word);
			System.out.println(k);
		}
		scanner.close();
	}
	public static int printAnagram(String word){
		int wlen = word.length();
		if(wlen%2!=0){
			return -1;
		}
		String firstHalf = word.substring(0, wlen/2);
		String secondHalf = word.substring((wlen/2), wlen);
		
		int firstArray[] = new int[26];
		int secondArray[] = new int[26];
		
		for(int i=0; i<firstHalf.length(); i++){
			int k = firstHalf.charAt(i) - 'a';
			firstArray[k]+=1;
			
			int j = secondHalf.charAt(i) - 'a';
			secondArray[j]+=1;
		}
		int count =0;
		for(int l=0; l<26; l++){
			count += Math.abs(firstArray[l]-secondArray[l]);
		}
		return count/2;
	}
}
