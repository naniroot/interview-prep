package zillow;

import java.util.Scanner;

public class ParseLong {
	public static void main(String args[]) throws Exception{
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		long test = parseLong(str);
		System.out.println(test);
		scanner.close();
	}
	
	   /*
     * Function first validates the input string using the helper function.
     * It parses the input string from the last character to the first
     * It creates start and end index based on whether the input is all numbers or has a '+' or '-' sign
     */
    static long parseLong(String str) throws Exception{
		try{
		  validateInput(str);
		} catch (Exception e){
            //Log exception here 
			throw e;
		}
		int startIndex = str.length()-1;
		int endIndex = 0;
        
        // Check for negative number with a '-' sign
		boolean negativeNumber = false;
		if(str.charAt(0) == '-'){
			negativeNumber = true;
			endIndex = 1;
		}
		if(str.charAt(0) == '+'){
			endIndex = 1;
		}
		long result = 0;
        long tenPower = 1;
        // Multiply by powers of ten for each position from the end and add to result
		for(int i=startIndex; i>=endIndex; i--){
			result += (str.charAt(i)-'0')*tenPower;
			tenPower *= 10;
		}
		
		if(negativeNumber){
			return -1*result;
		} else {
			return result;
		}
		
	}
	
	/*
    * Function to help validate the input string.
    * Creates start and end index based on if the first character is '-' or '+'
    * Subtracts all characters with base char of '0' then check if its in the range of 0 to 9
    * Works for ASCII input or encoding with contigous values from "0" to "9"
    */
	static void validateInput(String str) throws Exception{
		if(str.length() == 0 || str == null){
			String errorMessage = "Input string is null or empty";
			throw new Exception(errorMessage);
		}
		int startIndex = 0;
		int endIndex = str.length()-1;
		//Check if first character is among accepted strings
		char firstCharacter = str.charAt(0);
		if(firstCharacter == '-' || firstCharacter == '+'){
			startIndex = 1;
		}
        //For every character check if it's in the ASCII range of '0' to '9'
        final char baseChar = '0';
		for(int i=startIndex; i<=endIndex; i++){
			char testChar = str.charAt(i);
			if((testChar - baseChar > 9) || (testChar - baseChar <0)){
				String errorMessage = String.format("Input string contains invalid character %c at index %d\n", str.charAt(i), i);
				throw new Exception(errorMessage);
			}
		}
		
	}
}
