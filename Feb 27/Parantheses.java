//LeetCode paranthese
import java.util.*;

class Parantheses{
	public static void main(String[] args){
		String input = "{[()()({)}]}";
		if(isValid(input)){
			System.out.println("This is valid");
		} else {
			System.out.println("This is invalid");
		}
	}

	public static boolean isValid(String s){
		Map<Character, Character> braces = new HashMap<Character, Character>();
		braces.put('(', ')');
		braces.put('{', '}');
		braces.put('[', ']');

		Set<Character> openBraces = braces.keySet();
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<s.length(); i++){
			char a = s.charAt(i);
			if(openBraces.contains(a)){
				stack.push(a);
			} else {
				if(!stack.isEmpty() && validate(stack.peek(), a)){
					stack.pop();
				} else {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	public static boolean validate(char c1, char c2){
		if((c1 == '(' && c2 ==')') || (c1 == '{' && c2 =='}') || (c1 == '[' && c2 ==']') ){
			return true;
		} else {
			return false;
		}
	}
}