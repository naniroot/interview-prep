/* Ivan's uber question
* if a=1, b=2,....l=12,...z=26
* how many ways can you parse 123?
* answer = 3
* abc, aw and lc
*/

import java.util.*;

class OneStepTwoStep{
	public static void main(String[] args){
		String input = "123";
		int out = getCount(input);
		System.out.println(out);
	}

	public static void test(int n){
		List<Integer> givenList = new ArrayList<Integer>();
		givenList.add(5);
		givenList.add(7);

		Map<Integer> sortingMap = new HashMap<Integer>();
		sortingMap.put(7);

		sortingMap.containsKey("5");
		
	}
}