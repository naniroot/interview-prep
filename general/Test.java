class Test{
	public static void main(String args[]){
		int[] a = {1, 0, 1};
		int[] b = new int[3];
		b = a;
		b[0] = 100;
		for(int i=0; i<a.length; i++){
			System.out.println(a[i]);
		}
		for(int i=0; i<a.length; i++){
			System.out.println(b[i]);
		}
	}
}