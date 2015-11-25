package chapter5;

public class Question1 {

	public static void main(String[] args){
		int N = 1024;
		int M = 19;
		int i = 2;
		int j = 6;
		int mask = (1<<(j-i+1))-1;
		mask = ~(mask<<i);
		N = N&mask;
		M = M<<i;
		N = N|M;
		System.out.println(N);
	}
}
