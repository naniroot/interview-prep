/* Iterative Fibonacci */
import java.util.Scanner;

class Fibonacci{
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		int fib = getFibonnaci(n);
		System.out.println(fib);
	}

	public static int getFibonnaci(int n){
		int first = 1;
		int second = 1;
		if(n == 1 || n == 2){
			return first;
		}
		int third = 0;
		for(int i=n; i>2; i--){
			third = first+second;
			first = second;
			second = third;
		}
		return third;
	}
}