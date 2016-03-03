//LeetCode 3-sum closest

import java.util.*;

class ThreeSumClosest{
	public static void main(String[] args){
		int[] input = {-1, 2, 1, -4, 5, -7, 3, -1};
		int target = -3;
		int[] output = findThreeClosest(input, target);
		printArray(output);
	}

	public static int[] findThreeClosest(int[] arr, int target){
		int[] out = new int[3];
		if(arr.length < 3 || arr == null){
			return out;
		}
		Arrays.sort(arr);
		int closest = Integer.MAX_VALUE/2;
		for(int i=0; i<arr.length-2;i++){
			int left = i+1;
			int right = arr.length-1;
			while(left<right){
				int sum = arr[i]+arr[left]+arr[right];
				int temLeft = left;
				int temRight = right;
				if(sum == target){
					int[] output = {arr[i], arr[left], arr[right]};
					return output;
				}else if(sum>target){
					right--;
				} else {
					left++;
				}
				if(Math.abs(sum-target) < Math.abs(closest-target)){
					closest = sum;
					out[0] = arr[i];
					out[1] = arr[temLeft];
					out[2] = arr[temRight];
				}
			}
		}
		System.out.println("closest "+ closest);
		return out;
	}

	public static void printArray(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}