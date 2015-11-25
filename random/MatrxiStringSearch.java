package personalQuestions;

public class MatrxiStringSearch {

	public static void main(String v[]){

	}
	
	public void checkMatrix(int test[][], String target){
		int row = test.length;
		int col = test[0].length;
	   	int visited[][] = new int[row][col];
	   	
	   	for(int i=0; i<row; i++){
	   		for(int j=0; j<col; j++){
	   			boolean val = checkLocation(test[][], i, j, visited[][], 0, String target)
	   			if(val){
	   				return true;
	   			}
	   			visited = new int[row][col];
	   		}
	   	}
	   	return false;
	}
	
	public void checkLocation(int test[][], int i, int j, int visited[][], int positionInStr, String target){
		if(positionInStr == target.length()){
			
		}
	}
}
