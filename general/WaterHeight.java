/* Question asked in qualtrics phone screen 
Array with heights of buildings, pour water on top, how much water can it store */

class WaterHeight{
	public static void main(String args[]){
		int arr[] = {1, 10, 3, 4, 11, 4, 8};
		int totalWater = getTotalWater(arr);
		System.out.println(totalWater);
	}

	public static int getTotalWater(int arr[]){
		int left = 0;
		int right = arr.length;
		int leftMaxArr[] = new int[arr.length];
		int rightMaxArr[] = new int[arr.length];
 		
 		printArray(arr);
 		int max = -1;
 		for(int i=0; i<arr.length; i++){
 			if(arr[i]>max){
 				max = arr[i];
 			}
 			leftMaxArr[i] = max;
 		}
 		printArray(leftMaxArr);
 		max = -1;
 		for(int i=arr.length-1; i>=0; i--){
 			if(arr[i]>max){
 				max = arr[i];
 			}
 			rightMaxArr[i] = max;
 		}
 		printArray(rightMaxArr);
 		int sum = 0;
 		for(int i=0; i<arr.length; i++){
 			int height = Math.min(leftMaxArr[i], rightMaxArr[i]) - arr[i];
 			if(height>0){
 				sum += height;
 			}
 		}
 		return sum;
	}

	public static void printArray(int arr[]){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] +  " ");
		}
		System.out.println("");
	}
}