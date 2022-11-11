/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rmazorow
 */
import java.io.*;

public class Exercise17_07 {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        
        try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        } 
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }
        outputData();
    }
    
    public static void outputData() throws IOException, ClassNotFoundException {
    	
    	try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise17_07.dat"))
    			) {
    		System.out.println("Total Loan Amount: ");
    		
    		while (true) {
    			System.out.println("\t " + ((Loan) input.readObject()).getTotalPayment());
    			}
    		}
    	
    	catch (EOFException ex) {
    		System.out.println("\nAll data was read.");
    		}
    	}
    }
