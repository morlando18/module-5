import java.util.Scanner;
public class CreditCardValidation {
	

	/** Return true if the card number is valid */
	public static boolean isValid(long number){
		boolean valid;
		int sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace( number);
		if(sum % 10 == 0 && prefixMatched(number, 1))
			valid = true;			
		else 
			valid = false;
		return valid;
	}
	
	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(long number){
		int sum = 0, counter;
		if(getSize(number) % 2 == 0) counter = 2;
		else counter = 3;
		for(int i = getSize(number); i>=1; i--){
			//getting left digit, one by one
			int digitNumber = (int) (number / Math.pow(10, i-1));
			// checks digit if in odd location
			if(counter % 2 == 0){		
				sum += getDigit(digitNumber);				
			}
			counter++;
			//removing left digit
			number -=  (digitNumber * Math.pow(10, i-1));
		}
		return sum;
	}
	
	/** Return this number if it is a single digit, otherwise,
	* return the sum of the two digits */
	public static int getDigit(int number){
		long doubled = number * 2;
		long sum;
		// adds two numbers if not a single digit
		if(doubled >= 10){
			sum = doubled %10 + doubled /10;
		}else{ 
			sum = doubled;
		}
		return (int) sum;
	}
	
	/** Return sum of odd-place digits in number */
	public static int sumOfOddPlace(long number){
		int sum = 0, counter;
		if(getSize(number) % 2 == 0) counter = 2;
		else counter = 3;
		for(int i = getSize(number); i>=1; i--){
			//getting left digit, one by one
			long digitNumber = (long) (number / Math.pow(10, i-1));
			// checks digit if in odd location
			if(counter % 2 != 0){				
				sum+=digitNumber;				
			}
			counter++;
			//removing left digit
			number -=  (digitNumber * Math.pow(10, i-1));
		}
		return sum;
	}
	
	/** Return true if the digit d is a prefix for number */
	public static boolean prefixMatched(long number, int d){
		String name;
		boolean match;
		int preFix = (int) getPrefix(number, d);
		if(getPrefix(number, 2) == 37) preFix = 37;
		switch(preFix){
			case 4: name = "Visa cards"; match = true; break;
			case 5: name = "Master cards"; match = true; break;
			case 37: name = "American Express cards"; match = true; break;
			case 6: name = "Discover cards"; match = true; break;
			default: match = false;
		}
		return match;
	}
	
	public static int getSize(long d){
		int count = 0;
		while(d > 0){
			count++;
			d /= 10;
		}
		return count;
	}
	
	public static long getPrefix(long number, int k){
		long digitNumber = 0;		
		if(getSize(number) < k){
			digitNumber = number;
		}else {
			digitNumber = (long) (number / Math.pow(10, getSize(number)-k));
		}
		return digitNumber;
	} 
		
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);		
		System.out.print("Enter a credit card number as a long integer: ");
		long number = input.nextLong();
		//long number = 4388576018410707L;
		
		if(isValid(number))
			System.out.println(number + " is valid");
		else
			System.out.println(number + " is invalid");
	}
}
