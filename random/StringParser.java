/* Parse a string expression and evaluate it 

"3+14" should return 17
"-4+9-4" should return 1
"(4+2)-1" should return 5

*/

import java.util.*;

class StringParser{
	
	public static void main(String[] args){

		String s = "4+14-2*5";
		double val = processString(s);
		System.out.println("The output is " + val);
	}

	public static double processString(String s){
		return processStringHelper(s, 0);
	}

	public static double processStringHelper(String s, double left){
		int operatorIndex = findFirstOperator(s);

		if(operatorIndex == -1){
			return Double.parseDouble(s);
		}

		if(s.char(operatorIndex) == '('){
			String lHalf = s.substring(operatorIndex+1, s.length());
			
		}
		else if(s.charAt(operatorIndex) == '+'){
			double newLeft = Double.parseDouble(s.substring(0, operatorIndex));
			return newLeft + processStringHelper(s.substring(operatorIndex+1, s.length()), newLeft);
		} else if(s.charAt(operatorIndex) == '-'){
		 	double newLeft = Double.parseDouble(s.substring(0, operatorIndex));
		 	return newLeft - processStringHelper(s.substring(operatorIndex+1, s.length()), newLeft);
		} else if(s.charAt(operatorIndex) == '*'){
		 	double newLeft = Double.parseDouble(s.substring(0, operatorIndex));
		 	return newLeft * processStringHelper(s.substring(operatorIndex+1, s.length()), newLeft);
		} else if(s.charAt(operatorIndex) == '/'){
		 	double newLeft = Double.parseDouble(s.substring(0, operatorIndex));
		 	return newLeft / processStringHelper(s.substring(operatorIndex+1, s.length()), newLeft);
		}else {
			return left;
		}
	}

	public static int findFirstOperator(String s){

		for(int i=0; i<s.length(); i++){
			int val = s.charAt(i)-'0'; 
			if(val < 0 || val > 9){
				System.out.println(i + " " + s.charAt(i));
				return i;
			}
		}
		return -1;
	}
}