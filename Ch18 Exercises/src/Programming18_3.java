/*  Eloi Nshuti
 *  11/15/2022
 *  Programming 18-3
 */

import java.util.Scanner;

public class Programming18_3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter two integers to calculate the greatest common divisor.");
		
		System.out.print("First Integer = ");
		int m = input.nextInt();
		
		System.out.print("Second Integer = ");
		int n = input.nextInt();
		
		System.out.println("The GCD is " + gcd(m,n));
		}
	
	public static int gcd(int m, int n) {
		
		if (m%n == 0)
			return n;
		
		else
			return  gcd(n, m%n);
		}
}
