// Ivan google prefix equation solver

class SolveEquationPrefix{
	public static void main(String[] args){
		String input = "( + ( + 1 2 4 ) 5 2 4 ( + 1 2 3 ) )";
		Tuple output = parseEquation(input.split(" "), 0);
		System.out.println(output.result);
	}
	public static Tuple parseEquation(String[] s, int head){
		char c = s[head].charAt(0);

		if(isNum(c)){
			return new Tuple(Double.parseDouble(s[head]), head+1);
		} else if(c == '+'){
			double acc = 0;
			head += 1;

			while(true){

				if(s[head].charAt(0) == ')' && head < s.length -1){
					head ++;
				}

				Tuple one = parseEquation(s, head);

				head = one.newHead;
				acc += one.result;
				
				if(one.newHead >= s.length -1){
					break;
				}

			}
			return new Tuple(acc, head);
		} else if(s[head].charAt(0) == '('){
			return parseEquation(s, head+1);
		} else if(c == ')'){
			return new Tuple(0.0f, head+1);
	    } else {
			throw new IllegalStateException("This cannot happen, illegal char: " + c);
		}
	}

	public static boolean isNum(char c){
		int k = c-'0';
		if(k>=0 && k<=9){
			return true;
		} else {
			return false;
		}
	}
}

class Tuple{
	double result;
	int newHead;
	Tuple(double res, int newH){
		this.result = res;
		this.newHead = newH;
	}
}