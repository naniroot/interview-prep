// Leetcode two sum

import java.util.*;

class TwoSum{
	public static void main(String[] args){
		int[] input = {2, 7, 11, 15, 2};
		int target = 4;
		int[] output = getTwoSum(input, target);
		String out = String.format("Index %d -> %d, Index %d -> %d", output[0], input[output[0]], output[1], input[output[1]]);
		System.out.println(out);
	}

	public static int[] getTwoSum(int[] arr, int target){
		//Map of number to list of indicies it is present at
		///Map<number, list<indicies>
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

		int[] output = new int[2];
		Arrays.fill(output, -1);
		for(int i=0; i<arr.length; i++){
			if(map.containsKey(arr[i])){
				ArrayList<Integer> indexList = map.get(arr[i]);
				indexList.add(i);
				map.put(arr[i], indexList);
			} else {
				ArrayList<Integer> indexList = new ArrayList<Integer>();
				indexList.add(i);
				map.put(arr[i], indexList);
			}

			int negSum = target - arr[i];
			if(map.containsKey(negSum)){
				List<Integer> hope = map.get(negSum);
				for(int j=0; j<hope.size(); j++){
					System.out.println(hope.get(j));
					if(i != hope.get(j)){
						//Not same indicies, we found a match
						output[0] = i;
						output[1] = hope.get(j);
						return output;
					}
				}
			}
		}

		return output;
	}
}