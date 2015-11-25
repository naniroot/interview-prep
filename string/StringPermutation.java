class StringPermutation{
	public static void main(String args[]){
		String s = "catas";
		printPermutations("", s);
	}

	public static void printPermutations(String prefix, String s){
		int n = s.length();
		if(n == 0){
			System.out.println(prefix);
		} else {
			for(int i=0; i < n; i++){
				printPermutations(prefix+s.charAt(i), s.substring(0,i) + s.substring(i+1, n));
			}
		}
	}
}