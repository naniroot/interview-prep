package hackerrank;

import java.util.Scanner;

public class SherlockAndTheBeast {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int testCases = Integer.parseInt(scanner.nextLine());
	        for(int i=0; i<testCases; i++){
	            int n = Integer.parseInt(scanner.nextLine());
	            printDecent(n);
	        }
	        scanner.close();
	    }
	    public static void printDecent(int n){
	        if(0==n%3){
	            StringBuffer buffer = new StringBuffer();
	            for(int tada=0; tada<n; tada++){
	                buffer.append("5");
	            }
	            System.out.println(buffer);
	            return;
	        }
	        if(0==(n-5)%3 && n-5 >0){
	            StringBuffer buffer = new StringBuffer();
	            for(int tada=0; tada<n-5; tada++){
	                buffer.append("5");
	            }
	            for(int t=0; t<5; t++){
	               buffer.append("3");
	            }
	            System.out.println(buffer);
	            return;
	        }
	        if(0==(n-10)%3 && n-10 >0){
	            StringBuffer buffer = new StringBuffer();
	            for(int tada=0; tada<n-10; tada++){
	                buffer.append("5");
	            }
	            for(int t=0; t<10; t++){
	               buffer.append("3");
	            }
	            System.out.println(buffer);
	            return;
	        }
	
	        if(0==n%5){
	            StringBuffer buffer = new StringBuffer();
	            for(int tada=0; tada<n; tada++){
	                buffer.append("3");
	            } 
	            System.out.println(buffer);
	            return; 
	        }
	        System.out.println("-1");
	    }
}
