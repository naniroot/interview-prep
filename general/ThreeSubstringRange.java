/* find the smallest window which has all the three given substrings */

class ThreeSubstringRange{
	public static void main(String args[]){
		// String givenString = "tleyabkkcjlsdababyctleyabbyctley";
		// String one = "ab";
		// String two = "byc";
		// String three = "tley";

		String givenString = "00as00deas00ef0de0";
		String one = "as";
		String two = "de";
		String three = "ef";

		int resultArr[] = getSubStringResultArray(givenString, one, two, three);
		printArray(resultArr);
	}
	public static void printArray(int arr[]){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}

	public static int[] getSubStringResultArray(String given, String one, String two, String three){
		int onePosArr[] = getPosArr(given, one);
		int twoPosArr[] = getPosArr(given, two);
		int threePosArr[] = getPosArr(given, three);

		//printArray(onePosArr);
		//printArray(twoPosArr);
		//printArray(threePosArr);

		int slidingWindow[] = {-1, -1, -1};
		//resultArr = {start, end, length}
		int resultArr[] = {-1, -1, -1};

		for(int i=0; i<given.length(); i++){

			if(onePosArr[i] != 0){
				slidingWindow[0] = i;
			}
			if(twoPosArr[i] != 0){
				slidingWindow[1] = i;
			}
			if(threePosArr[i] != 0){
				slidingWindow[2] = i;
			}

			if(slidingWindow[0] != -1 && slidingWindow[1] != -1 && slidingWindow[2] != -1){

				int start = Math.min(Math.min(slidingWindow[0], slidingWindow[1]), slidingWindow[2]);
				int end = Math.max(Math.max(slidingWindow[0] + one.length()-1, slidingWindow[1] + two.length()-1), slidingWindow[2] + three.length()-1);
				int len = end-start;
				if(resultArr[2] == -1 || resultArr[2] > len){
					resultArr[0] = start;
					resultArr[1] = end;
					resultArr[2] = len;
				}
			}
		}
		return resultArr;
	}
	public static int[] getPosArr(String given, String candidate){
		int[] posArr = new int[given.length()];

		for(int i=0; i<given.length(); i++){
			if(given.charAt(i) == candidate.charAt(0)){

				for(int j=0; j<candidate.length(); j++){
					if(given.charAt(i+j) != candidate.charAt(j)){
						break;
					} else if (j == candidate.length()-1){
						posArr[i] = 1;
					}
				}
			}
		}

		return posArr;
	}
}