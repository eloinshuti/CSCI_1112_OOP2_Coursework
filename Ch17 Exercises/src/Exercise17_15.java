/* Eloi Nshuti
 * 11/11/2022
 * Exercise 17-15
 */

import java.io.*; 
import java.util.Scanner;

public class Exercise17_15 {
  public static void main(String[] args) throws IOException {
	  Scanner input = new Scanner(System.in);
	    
	  // Input file.
	  System.out.print("Enter the name of the file to be decrypted: ");
	  String inputFileStr = input.nextLine();
	  BufferedInputStream inputFile = new BufferedInputStream(new FileInputStream(
			  inputFileStr));
	  
	  // Output file.
	  System.out.print("Enter the name of the file to save decrypted version: ");
	  String outputFileStr = input.nextLine();
	  BufferedOutputStream outputFile = new BufferedOutputStream(new FileOutputStream(
			  outputFileStr));
	  
	  // Decryption code.
	  int value;
	  while ((value = inputFile.read()) != -1) {
		  outputFile.write(value - 5);
		  }
	  inputFile.close();
	  outputFile.close();
	  
	  }
  }