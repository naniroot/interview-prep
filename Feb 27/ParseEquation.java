// Parse and solve an equation with +, - and braces '(' and ')'

class ParseEquation{
	public static void main(String[] args){
		String input = "10+5(78-10)";
		double output = parseEquation(input);
		System.out.println(output);
	}

	public static double parseEquation(String input){
		int len = input.length();
		int integerCount = 0;
		while(integerCount<len){
			char c = input.charAt(integerCount);
			int k = c -'0';
			if(k<0 || k>9){
				break;
			}
			integerCount++;
		}

		String leftS = input.substring(0, integerCount);
		double left = Double.parseDouble(leftS);

		String right = input.substring(integerCount+1);

		System.out.println("left " + leftS + " right " + right);
		if(right.length() <= 1){
			return left;
		}
		char c = input.charAt(integerCount);

		Double rightD = parseEquation(right);

		if(c == '+'){
			return left + rightD;
		} else if(c == '-'){
			return left - rightD;
		} else if(c == '(' || c == ')'){
			return left * rightD;
		} else {
			return left;
		}
	}
}