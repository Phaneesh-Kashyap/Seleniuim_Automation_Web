package Programs;

import java.util.Scanner;

public class Program_To_Convert_From_Num_To_Text {

	 private static final String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	    private static final String[] teens = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	    private static final String[] tens = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a number: ");
	        int number = scanner.nextInt();
	        System.out.println("Output: " + convertNumberToWord(number));
	        scanner.close();
	    }

	    public static String convertNumberToWord(int number) {
	        if (number == 0) {
	            return "zero";
	        }

	        if (number < 0) {
	            return "minus " + convertNumberToWord(-number);
	        }

	        String word = "";

	        if ((number / 1000000) > 0) {
	            word += convertNumberToWord(number / 1000000) + " million ";
	            number %= 1000000;
	        }

	        if ((number / 1000) > 0) {
	            word += convertNumberToWord(number / 1000) + " thousand ";
	            number %= 1000;
	        }

	        if ((number / 100) > 0) {
	            word += convertNumberToWord(number / 100) + " hundred ";
	            number %= 100;
	        }

	        if (number > 0) {
	            if (number < 10) {
	                word += units[number];
	            } else if (number < 20) {
	                word += teens[number - 10];
	            } else {
	                word += tens[number / 10] + " " + units[number % 10];
	            }
	        }

	        return word.trim();
	    }
	
	
}
