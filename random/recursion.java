class Expo{
	public static void main(String args[]){
		int a = 5;
		int b = 3;
		System.out.println("THe number is ");
		System.out.println(expo(a, b));
	}
	public static int successor(int a){
		return a+1;
	}

	public static int expo(int a , int b){
		return expoHelper(a, b, 0);
	}

	public static int expoHelper(int a, int b, int helper){
		if(helper == b){
		    return a;
		}else{
			return expoHelper(multHelper(a, b, 0), b, successor(helper));
		}
	}

	public static int multHelper(int a, int b, int helper){
	    if(helper == b){
	         return a;
	    }else{
	         return addHelper(addHelper(a, b, 0), b, successor(helper));
	    }
	}
	public static int addHelper(int a, int b, int helper){
	    if(helper == b){
	    	return a;
	    }else{
	    	return addHelper(successor(a), b, successor(helper));
	    }
	}
}