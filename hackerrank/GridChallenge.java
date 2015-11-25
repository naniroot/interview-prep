package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class GridChallenge {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int testCases = Integer.parseInt(scanner.nextLine());
		for(int indexes=0; indexes<testCases; indexes++){
			int rows = Integer.parseInt(scanner.nextLine());
			char[][] matrix = new char[rows][rows];
			//get matrix
			for(int jdexes=0; jdexes<rows;jdexes++){
				matrix[jdexes] = scanner.nextLine().toCharArray();
			}
			//printMatrix(matrix, rows);
			//System.out.println("");
			//sort matrix
			for(int jrocks=0; jrocks<rows; jrocks++){
				Arrays.sort(matrix[jrocks]);
			}
			//printMatrix(matrix, rows);
			verifyMatrix(matrix, rows);
		}
		scanner.close();
	}
	
	public static void printMatrix(char mat[][], int rows){
		for(int i=0; i<rows; i++){
			System.out.println("");
			for(int j=0; j<rows; j++){
				System.out.print(mat[i][j] + " ");
			}
		}
	}
	
	public static void verifyMatrix(char mat[][], int rows){
		for(int i=0; i<rows; i++){
			for(int j=0; j<rows-1; j++){
				if(mat[i][j] > mat[i][j+1]){
					System.out.println("NO");
					return;
				}
			}
		}
		
		for(int i=0; i<rows-1; i++){
			for(int j=0; j<rows; j++){
				if(mat[i][j] > mat[i+1][j]){
					System.out.println("NO");
					return;
				}
			}
		}
		System.out.println("YES");
	}
}
