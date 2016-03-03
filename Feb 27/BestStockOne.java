// LeetCode Best time to buy stock 1

class BestStockOne{
	public static void main(String[] args){
		int[] input = {5, 10, 15, 10, 5, 15};
		int output = maxProfit(input);
		System.out.println("The max profit is "+ output);
	}

	public static int maxProfit(int[] arr){
		int[] maxArray = getMaxEleToRightArray(arr);
		int buyCount = 0;
		int[] buySell = new int[arr.length];
		int cost = 0;
		int revenue = 0;
		// 1 buy
		// 0 sell
		// -1 do nothing
		for(int i=0; i<arr.length; i++){
			if(maxArray[i]>buyCount){
				buySell[i] = 1;
				buyCount++;
				cost += arr[i];
			} else if(buyCount>0 && (maxArray[i] <= buyCount)){
				buySell[i] = 0;
				buyCount--;
				revenue += arr[i];
			} else {
				buySell[i] = -1;
			}
		}

		printArray(arr);
		printArray(maxArray);
		printArray(buySell);
		return revenue-cost;
	}

	public static int[] getMaxEleToRightArray(int[] arr){
		int len = arr.length;
		int[] maxArray = new int[len];
		for(int i=len-1; i>=0; i--){
			maxArray[i] = getMaxEleHelper(arr, i);
		}
		return maxArray;
	}

	public static int getMaxEleHelper(int[] arr, int i){
		int val = arr[i];
		int count = 0;
		int len = arr.length;
		if(i == len-1){
			return count;
		}
		for(int k=i+1; k<len; k++){
			if(arr[k]>val){
				count++;
			}
		}
		return count;
	}

	public static void printArray(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}