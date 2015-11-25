package hackerrank;

import java.util.Scanner;

public class Candies {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noKids = Integer.parseInt(scanner.nextLine());
        int[] kids = new int[noKids];
        for(int i=0;i<noKids; i++){
            kids[i] = Integer.parseInt(scanner.nextLine());
        }
        int[] candyArr = new int[noKids]; 
        int total = 0;

        for(int i=0; i<noKids; i++){
        	candyArr[i] = 1;
        }
        for(int i=0; i<noKids-1; i++){
        	if(kids[i+1]>kids[i]){
        		if(candyArr[i+1]<=candyArr[i]){
        			candyArr[i+1] = candyArr[i]+1;
        		}
        	}
        	if(kids[i]>kids[i+1]){
        		if(candyArr[i]<=candyArr[i+1]){
        			candyArr[i] = candyArr[i+1]+1;
        			int temp = i-1;
        			while(temp>0 && kids[temp]>kids[temp+1]){
        				if(candyArr[temp]<=candyArr[temp+1]){
        					candyArr[temp]++;
        				}
        				temp--;
        			}
        		}
        	}
        }
        printArray(kids);
        printArray(candyArr);
        total = findTotal(candyArr);
        System.out.println(total);
        scanner.close();
    }

	public static int findTotal(int[] arr){
		int total =0;
		for(int i=0; i<arr.length; i++){
			total+=arr[i];
		}
		return total;
	}
	public static void printArray(int[] arr){
		StringBuilder builder = new StringBuilder();
		for(int i=0; i<arr.length; i++){
			builder.append('[');
			builder.append(arr[i]);
			builder.append(']');
		}
		System.out.println(builder.toString());
	}
}
