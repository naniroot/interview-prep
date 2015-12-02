import java.util.*;

class WordInMatrix{
	public static void main(String arg[]){
		char[][] matrix = {
			{'c', 'a', 't', 'e'},
			{'b', 't', 'r', 'c'},
			{'l', 'e', 'a', 'w'},
			{'z', 'f', 'e', 'l'}
		};
		String searchWord = "fawrabl";
		boolean res = isWordInMatrix(matrix, searchWord);
		if(res){
			System.out.println("Yes!, the word is in matrix");
		} else {
			System.out.println("No!, the word is not in the matrix");
		}
	}

	public static boolean isWordInMatrix(char[][] matrix, String searchWord){
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				//System.out.print(matrix[i][j] + " ");
				boolean test = wimHelper(matrix, i, j, searchWord);
				if(test){
					return true;
				}
			}
			//System.out.println("");
		}
		return false;
	}

	public static boolean wimHelper(char[][] matrix, int row, int col, String searchWord){
		if(matrix[row][col] != searchWord.charAt(0)){
			return false;
		}
		int[][] visitedMatrix = new int[matrix.length][matrix[0].length];
		visitedMatrix[row][col] = 1;
		Node root = new Node(row, col, searchWord, visitedMatrix);

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node n = q.remove();
			if(matrix[n.row][n.col]  == n.searchWordSubString.charAt(0) && n.searchWordSubString.length() == 1){
				return true;
			}
			ArrayList<Node> validNeighbors = getValidNeighbors(n.row, n.col, matrix, n.visitedMatrix, n.searchWordSubString.substring(1, n.searchWordSubString.length()));
			for(Node n1: validNeighbors){
				q.add(n1);
			}
		}
		return false;	
	}

	public static ArrayList<Node> getValidNeighbors(int row, int col, char[][] matrix, int[][] visitedMatrix, String partWord){
		ArrayList<Node> neighborList = new ArrayList<Node>();
		int maxRow = matrix.length;
		int maxCol = matrix[0].length;
		int rowVals[] = {-1, 0, 1};
		for(int i=0; i<rowVals.length; i++){
			for(int j=0; j<rowVals.length; j++){
				int x = row + rowVals[i];
				int y = col + rowVals[j];

				if(x>=maxRow || y >= maxCol) continue;
				if(x<0 || y<0) continue;
				if(x == 0 && y==0) continue;
				if(visitedMatrix[x][y] == 1) continue;
				if(matrix[x][y] != partWord.charAt(0)) continue;
				int[][] newVistedMatrix = copyVisitedMatrix(visitedMatrix);
				newVistedMatrix[x][y] = 1;
				Node n = new Node(x, y, partWord, newVistedMatrix);
				neighborList.add(n);
			}
		}
		return neighborList;
	}
	public static int[][] copyVisitedMatrix(int[][] visitedMatrix){
		int[][] newMatrix = new int[visitedMatrix.length][visitedMatrix[0].length];
		for(int i=0; i<visitedMatrix.length; i++){
			for(int j=0; j<visitedMatrix[0].length; j++){
				newMatrix[i][j] = visitedMatrix[i][j];
			}
		}
		return newMatrix;
	}
}

class Node{
	public int row;
	public int col;
	public String searchWordSubString; //Stores what location you are trying to match
	public int[][] visitedMatrix;
	Node(int row, int col, String searchWordSubString, int[][] visitedMatrix){
		this.row = row;
		this.col = col;
		this.searchWordSubString = searchWordSubString;
		this.visitedMatrix = visitedMatrix;
	}
}