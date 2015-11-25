package personalQuestions;

public class StringToInt {
	// Do String validation
	public static void main(String args[]){
		
		String input = "-000000012.3";
		double a = convertToString(input);
		System.out.println(a);
	}
	public static double convertToString(String input){
		int test = 1;
		double total = 0;
		for(int i =input.length()-1; i>=0; i--){
			if(input.charAt(i) == '-'){
				total = -1 * total;
				continue;
			}
			if(input.charAt(i) == '.'){
				total = total/(Math.pow(10, input.length()-i-1));
				test =1;
				continue;
			}
			int endChar = input.charAt(i) - '0';
			total = total + test*endChar;
			test *=10;
		}
		return total;
	}

}
