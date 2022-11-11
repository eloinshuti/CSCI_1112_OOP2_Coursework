/* Eloi Nshuti
 * Exercise 17-1
 * 11/08/2022
 */

import java.io.PrintWriter;
import java.util.Scanner;

public class Exercise17_1 {
	public static void main(String[] args) throws Exception{
		java.io.File file = new java.io.File("Exercise17_01.txt");

		if(file.exists()) {
			PrintWriter output = new PrintWriter("Exercise17_01.txt");
			
			for(int i = 0; i < 100; i++) {
				int j = (int)(Math.random() * 100);
				output.print(j + " ");
				}
				output.close();
			}
		
		if(file.exists() == false) {
		try (
					java.io.PrintWriter output = new java.io.PrintWriter(file);
			         ) {
			for(int i = 0; i < 100; i++) {
				int j = (int)(Math.random() * 100);
				output.print(j + " ");
				}
			}
		}
		}
	}
