package hackerrank;

import java.util.Scanner;

public class TwoStrings {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        for(int i=0; i<testCases; i++){
            String line1 = scanner.nextLine();
            String line2 = scanner.nextLine();
            printSubString(line1, line2);
        }
        scanner.close();
    }

    public static void printSubString(String line1, String line2){
        int k = prepare(line1);
        compareAndPrint(k, line2);
    }
    public static int prepare(String line1){
        int n = 0;
        line1 = line1.toLowerCase();
        for(int i=0;i<line1.length();i++){
            n = n|(1<<(line1.charAt(i)-'a'));
        }
        return n;
    }
    public static void compareAndPrint(int k, String line2){
        line2 = line2.toLowerCase();
        for(int i=0; i<line2.length();i++){
            int pos = 1<<(line2.charAt(i)-'a');
            if((pos & k) >0){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
