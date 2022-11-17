/*  Eloi Nshuti
 *  11/17/2022
 *  Programming 18-9
 */

import java.util.Scanner;

public class Programming18_9 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a string to reverse: ");
		String inputString = input.nextLine();
		System.out.print("Reverse: ");
		reverseDisplay(inputString);
		
		}
	
	public static void reverseDisplay(String value) {
		
		if (value.length() == 1) //Stop the method.
			System.out.print(value); 

		else {
			System.out.print(value.charAt(value.length() - 1)); //Print letter by letter.
			reverseDisplay(value.substring(0, value.length() - 1));
			}
		}
	}