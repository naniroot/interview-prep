package hackerrank;

import java.util.Scanner;

public class AlternatingCharacters {
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int testCases = Integer.parseInt(scanner.nextLine());
		for(int i=0; i<testCases; i++){
			String tCase = scanner.nextLine();
			int out = getCount(tCase);
			System.out.println(out);
		}
		scanner.close();
	}
	public static int getCount(String tCase){
		char charA = 'A';
		char charB = 'B';
		
		char nextChar = tCase.charAt(0);
		int goodCount = 0;
		
		/* Check for starting with A */
		for(int i=0; i<tCase.length(); i++){
			if(tCase.charAt(i) == nextChar){
				goodCount ++;
				nextChar = (nextChar == charA) ? charB: charA;
			}
		}
		return tCase.length()-goodCount;
	}
}
