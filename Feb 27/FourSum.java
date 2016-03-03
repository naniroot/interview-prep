// LeetCode 4 sum problem, find a, b, c, d in an array such a+b+c+d=target, given target

import java.util.*;

class FourSum{
	public static void main(String[] args){
		
		int[] arr = {1, 4, 1, -2, 5, 2, 0, -7};
		int target = 5;
		List<Tuple> listo = getFourSum(arr, target);
		for(int i=0; i<listo.size(); i++){
			System.out.println(listo.get(i));
		}
	}

	public static List<Tuple> getFourSum(int[] arr, int target){
		List<Tuple> output = new ArrayList<Tuple>();
		if(arr.length < 4 || arr == null){
			return output;
		}
		Arrays.sort(arr);
		// for(int i=0; i<arr.length; i++){
		// 	System.out.print(arr[i] + " ");
		// }
		// System.out.println();

		for(int i=0; i<arr.length-3; i++){
			for(int j=i+1; j<arr.length-2; j++){
				int left = j+1;
				int right = arr.length-1;
				while(left<right){
					int sum = arr[i] + arr[j] + arr[left] + arr[right];
					//System.out.println(sum);
					if(sum < target){
						left++;
					} else if (sum > target){
						right--;
					} else {
						//System.out.println("index "+ i + " " + j + " " + left + " " + right);
						//System.out.println("answer "+ arr[i] + " " + arr[j] + " " + arr[left] + " " + arr[right]);
						Tuple tup = new Tuple(arr[i], arr[j], arr[left], arr[right]);
						output.add(tup);
						left++;
						right--;
					}
				}
			}
		}
		return output;
	}

	static class Tuple{
		private int a;
		private int b;
		private int c;
		private int d;

		public Tuple(int a, int b, int c, int d){
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}

		public String toString(){
			return String.format(" %d, %d, %d, %d", this.a, this.b, this.c, this.d);
		}

	}
}