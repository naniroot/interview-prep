/* 3Sum, triplets a, b, c such that a+b+c = 0 in a given array */
import java.util.ArrayList;

class ThreeSum{
	public static void main(String args[]){
		int arr[] = {-5, -1, 0, 1, 3, 4, 6};
		ArrayList<ArrayList<Integer>> listOfLists = getTriplets(arr);
		for(ArrayList<Integer> list: listOfLists){
			System.out.print("[");
			for(int ele: list){
				System.out.print(" " + ele);
			}
			System.out.println("]");
		}
	}

	public static ArrayList<ArrayList<Integer>> getTriplets(int arr[]){
		ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<arr.length-2; i++){
			int left = i+1;
			int right = arr.length-1;
			while(left<right){
				int sum = arr[i] + arr[left] + arr[right];
				if(sum == 0){
					System.out.println("TADA");
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(arr[i]);
					tmp.add(arr[left]);
					tmp.add(arr[right]);
					listOfLists.add(tmp);
					left++;
					right--;
				} else if( sum > 0){
					right --;
				} else {
					left++;
				}
			}
		}
		return listOfLists;
	}
}