// Zig zag conversion - easy problem in leetcode

class ZigZag{
	public static void main(String[] args){
		String input = "PAYPALISHIRING";
		String output = getZigZag(input);
		System.out.println(output);
	}

	public static String getZigZag(String s){
		StringBuilder builder = new StringBuilder();
		for(int i=0; i<s.length();i+=4){
			builder.append(s.charAt(i));
		}
		for(int i=1;i<s.length();i+=2){
			builder.append(s.charAt(i));
		}
		for(int i=2;i<s.length();i+=4){
			builder.append(s.charAt(i));
		}
		return builder.toString();
	}
}