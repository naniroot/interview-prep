// Print all permutations of a string

class Permute{
	public static void main(String[] args){
		String s = "hello";
		printPermutations(s, "");
	}

	public static void printPermutations(String s, String prefix){
		if(s.length() == 0){
			System.out.println(prefix);
		}
		for(int i=0; i<s.length(); i++){
			String rem = s.substring(0, i) + s.substring(i+1);
			printPermutations(rem, prefix+s.charAt(i));
		}
	}
}