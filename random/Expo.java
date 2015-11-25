class Expo{
	public static void main(String args[]){
		int a = 3;
		int b = 2;
		System.out.println("THe number is ");
		System.out.println(expo(a, b));
	}
	public static int successor(int a){
		return a+1;
	}

	public static int expo(int a , int b){
		return expoHelper(a, b, 1, 0);
	}

	public static int expoHelper(int a, int b, int total, int helper){
		if(helper == b){
		    return total;
		}else{
			return expoHelper(a, b, multHelper(a, total, 0, 0), successor(helper));
		}
	}

	public static int multHelper(int a, int b, int total, int helper){
	    if(helper == b){
	         return total;
	    }else{
	        return multHelper(a, b, addHelper(a, total, 0), successor(helper));
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