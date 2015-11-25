package hackerrank;

import java.util.Scanner;

public class StockMaximize {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int testCases = Integer.parseInt(scanner.nextLine());
		for(int i=0; i<testCases; i++){
			int countNum = Integer.parseInt(scanner.nextLine());
			String testNum = scanner.nextLine();
			String testNumArr[] = testNum.split(" ");
			int intArr[] = new int[countNum];
			for(int j=0; j<countNum; j++){
				intArr[j] = Integer.parseInt(testNumArr[j]);
			}
			int total = findMax(intArr, countNum);
			System.out.println(total);
		}
		scanner.close();
	}

	public static int findMax(int[] intArr, int count){
		int total =0;
		//BUY = 1
		//SELLALL = 2
		//DONOTHING = 0
		
		return total;
	}
}
