/*  Eloi Nshuti
 *  11/10/2022
 *  Exercise 17-3
 */

import java.io.*; 
 
public class Exercise17_3 {
  public static void main(String[] args) throws IOException {
	  java.io.File file = new java.io.File("Exercise17_03.dat");
	 
	  if(file.exists()) {
		  FileOutputStream fileOutput = new FileOutputStream("Exercise17_03.dat");
		  DataOutputStream dataOutput = new DataOutputStream(fileOutput);
		  
		  for(int i = 0; i < 100; i++) {
			  int j = (int)(Math.random() * 10);
			  dataOutput.writeInt(j);
			  }
		  dataOutput.close();
		  }
	  
	  if(file.exists() == false) {
		  try (
				  FileOutputStream fileOutput = new FileOutputStream(file);
				  DataOutputStream dataOutput = new DataOutputStream(fileOutput);
				  ) {
			  for(int i = 0; i < 100; i++) {
				  int j = (int)(Math.random() * 10);
				  dataOutput.writeInt(j);
				  }
			  }
		  }
	  
	  
	  try (
			  FileInputStream input = new FileInputStream("Exercise17_03.dat");
			  ) {
		  int value;
		  int sum = 0;
		  while ((value = input.read()) != -1) {
			  System.out.print(value + " ");
			  sum = value + sum;
			  }
		  System.out.print("\nSum: " + sum);
		  }
	  }
  }

