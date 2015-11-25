class BaseConverter{
	public static void main(String args[]){
		int test = 63;
		convertToBaseTwo(test);
	}
	public static void convertToBaseTwo(int test){
		int n = test;
		StringBuffer buffer = new StringBuffer();
		while(n > 1){
			buffer.append(n%2);
			n = n/2;
		}
		buffer.append(n);
		System.out.println(buffer.reverse());
	}
}