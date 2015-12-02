/* Sorted array find median of sub array greater than a threshold */

import java.util.Scanner;

class Median{
	public static void main(String args[]){
		int arr[] = {2, 3, 6, 9, 12, 34, 45, 56, 67, 92, 123, 456, 678, 956};
		Scanner scanner = new Scanner(System.in);
		int threshold = Integer.parseInt(scanner.nextLine());
		findMedian(arr, threshold);
		scanner.close();
	}

	public static void findMedian(int arr[], int threshold){
		int thresholdIndex = binarySearchModified(arr, 0, arr.length, threshold);
		System.out.println(String.format("Index: %d -> Value %d", thresholdIndex, arr[thresholdIndex]));
		int medianIndex = (thresholdIndex + arr.length)/2;
		System.out.println(String.format("Median -> [%d]", arr[medianIndex]));	
	}

	public static int binarySearchModified(int arr[], int low, int high, int threshold){
		if(high<low){
			return low;
		}
		int mid = (high + low)/2;
		if(arr[mid]>threshold){
			return binarySearchModified(arr, low, mid-1, threshold);
		} else {
			return binarySearchModified(arr, mid+1, high, threshold);
		}

	}

}