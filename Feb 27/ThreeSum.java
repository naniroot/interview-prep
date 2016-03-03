// Leet code 3 sum problem, find all triplets (a, b, c) such that a+b+c = 0
import java.util.*;

class ThreeSum{
	public static void main(String[] args){

		int[] arr = {1, 4, 1, -2, 5, 2, 0, -7};
		List<Tuple> list = getThreeSum(arr);
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}

	}

	public static List<Tuple> getThreeSum(int[] arr){
		Arrays.sort(arr);
		List<Tuple> out = new ArrayList<Tuple>();
		if(arr == null || arr.length < 3){
			return out;
		}

		for(int i=0; i<arr.length-2; i++){
			int left = i+1;
			int right = arr.length-1;
			while(left<right){
				int sum = arr[i] + arr[left] + arr[right];
				if(sum == 0){
					out.add(new Tuple(arr[i], arr[left], arr[right]));
					left++;
					right--;
				} else if(sum>0){
					right--;
				} else {
					left ++;
				}		
			}
		}
		return out;
	}

	static class Tuple{
		private int a;
		private int b;
		private int c;
		public Tuple(int a, int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}

		public String toString(){
			return String.format(" %d, %d, %d", a, b, c);
		}

	}
}