package chapter1;

public class Question3 {

	public static void main(String[] args){
		String a = "c at  ";
		String result = urlify(a, a.length());
		System.out.println(result);
	}
	public static String urlify(String a, int len){
		char[] aArr = a.toCharArray();
		int arrayLength = aArr.length-1;
		int firstCharIndex = -1;
		for(int i=arrayLength;i>=0;i--){
			if(aArr[i] != ' '){
				firstCharIndex = i;
				break;
			}
		}
		System.out.println(firstCharIndex);
		if(firstCharIndex == -1){
			System.out.println("Invalid string  ");
			System.exit(-1);
		}
		while(arrayLength>0){
			if(aArr[firstCharIndex] == ' '){
				aArr[arrayLength] = '0';
				arrayLength--;
				aArr[arrayLength] = '2';
				arrayLength--;
				aArr[arrayLength] = '%';
				arrayLength--;
				firstCharIndex--;
			}else{
				aArr[arrayLength] = aArr[firstCharIndex];
				firstCharIndex--;
				arrayLength--;
			}
		}
		return new String(aArr);
	}
}
