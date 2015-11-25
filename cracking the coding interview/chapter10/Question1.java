package chapter10;

public class Question1 {
	public static void main(String[] arg){
	
//	    int[] arrA= new int[10];
//	    int[] arrB = new int[4];
//	    arrA[0] = 1;
//	    arrA[1] =2;
//	    arrA[2] = 4;
//	    arrA[3] = 8;
//	    arrA[4] = 19;
//	    arrA[5] = 45;
//	    
//	    arrB[0] = 12;
//	    arrB[1] = 20;
//	    arrB[2] = 67;
//	    arrB[3] = 89;
		
		int[] arrA = {1,4,7,0,0,0};
		int arrB[] = {0,5,9};
	    
	    printArray(arrA);
	    printArray(arrB);
	    sortArrays(arrA, arrB);
	    printArray(arrA);

	}
    public static void sortArrays(int[] arrA, int[] arrB){
    	// to get length of arrA where elements end is by 
    	//subtracting the length of arrB from arrA
    	int p1 = arrA.length - arrB.length-1;
    	int p2 = arrB.length-1;

    	for(int i = arrA.length-1; i>=0; i--){
        	//System.out.println(p1);
        	//System.out.println(p2);
    		if(p1>=0 && p2 >= 0 && arrA[p1]> arrB[p2]){
    			arrA[i] = arrA[p1];
    			p1--;
    		} else if(p2>=0){
    			arrA[i] = arrB[p2];
    			p2--;
    		}
    	}
    }
    
    public static void printArray(int[] arrA){
	    System.out.print("[ ");
	    for(int i=0;i<arrA.length; i++){
	    	System.out.print(arrA[i]+ " ");
	    }
	    System.out.print("]\n");
    }
}
