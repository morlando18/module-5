import java.util.Scanner;
public class SortThree {
	
	public static void displaySortedNumbers(double num1, double num2, double num3){
		double first, second, third;
		
		if(num1 > num2 && num2 > num3){
			first = num1; second = num2; third = num3;
		}else if(num1 > num2 && num2 < num3){
			first = num1; second = num3; third = num2;
		}else if (num3 > num2 && num2 > num1){
			first = num3; second = num2; third = num1;
		}else if (num3 > num2 && num2 < num1){
			first = num3; second = num1; third = num2;
		}else if(num2 > num3 && num3 > num1){
			first = num2; second = num3; third = num1;
		}else {
			first = num2; second = num1; third = num3;
		}

		System.out.println(third + " " + second + " " + first);
		System.out.println(first + " " + second + " " + third);	
	}
	
	public static void main(String[] args){
		double num1, num2, num3;
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter three number: ");
		num1 = input.nextDouble();
		num2 = input.nextDouble();
		num3 = input.nextDouble();
		

		displaySortedNumbers(num1, num2, num3);
	}

}
