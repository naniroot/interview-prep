package hackerrank;

import java.util.Scanner;

public class AngryProfessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        for(int i=0; i<testCases; i++){
            String secondLine = scanner.nextLine();
            String[] splitLine = secondLine.split(" ");
            int n = Integer.parseInt(splitLine[0]);
            int k = Integer.parseInt(splitLine[1]);
            String inputLine = scanner.nextLine();
            String[] inputSplit = inputLine.split(" ");
            int inputArray[] = new int[n];
            for(int j=0; j<n; j++){
               inputArray[j] = Integer.parseInt(inputSplit[j]);
            }
            printCancelledOrNot(inputArray, n, k);
        }
        scanner.close();
    }

    public static void printCancelledOrNot(int inputArray[], int n, int k){
        int totalBefore =0;
        for(int i=0; i<n; i++){
           if(inputArray[i]<=0){
               totalBefore++;
           }
        }
        if(totalBefore<k){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }


    }

}
