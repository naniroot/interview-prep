//Leetcode add binary

class AddBinary{
	public static void main(String[] args){
		String a = "1111";
		String b = "1111";

		String out = addBinary(a, b);
		System.out.println(out);
	}

	public static String addBinary(String a, String b){
		if(a.length() < b.length()){
			String tmp = a;
			a = b;
			b = tmp;
		}
		int pa = a.length() -1;
		int pb = b.length() -1;
		int carry = 0;

		StringBuilder builder = new StringBuilder();

		while(pb>=0){
			int sum = (int)(a.charAt(pa)-'0') + (b.charAt(pb)-'0')+ carry;
			carry = sum/2;
			builder.append(sum%2);
			pa--;
			pb--;
		}

		while(pa>=0){
			int sum = (int)(a.charAt(pa)-'0')+carry;
			carry = sum/2;
			builder.append(sum%2);
			pa--;
		}

		if(carry == 1){
			builder.append(1);
		}
		return builder.reverse().toString();
	}
}