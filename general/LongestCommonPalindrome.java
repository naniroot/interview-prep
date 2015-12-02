/* Longest Palidromic substring in any given string */

class LongestCommonPalindrome{
	public static void main(String args[]){
		String s = "tacocat";
		String res = findLongestPalindromicSubstring(s);
		System.out.println("The longest palindromic substring is " + res);
	}
	public static String findLongestPalindromicSubstring(String s){
		s = s.replaceAll("\\s+", "");
		if(s.isEmpty()){
			return null;
		}
		if(s.length() == 1){
			return s;
		}
		String longest = s.substring(0,1);
		for(int i=0; i<s.length(); i++){

			//Longest palindromic substring with center i
			String tmp = strHelper(s, i, i);
			if(tmp.length()>longest.length()){
				longest = tmp;
			}

			//Longest palindromic substring with center i, i+1
			tmp = strHelper(s, i, i+1);
			if(tmp.length()>longest.length()){
				longest = tmp;
			}
		}
		return longest;
	}

	public static String strHelper(String s, int begin, int end){
		while(begin>=0 && end<s.length() && s.charAt(begin) == s.charAt(end)){
			begin--;
			end++;
		}
		return s.substring(begin+1, end);
	}
}