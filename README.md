### Eloi Nshuti
### Southwest Technical College
### CSCI 1112 - Object Oriented Programming

## **Synopsis**
##### This is the final project for the Object Oriented Programming II (CSCI 1112) class. The project tests contains code that records and creates a report of grades input by the user.
##### This repository will also be used to save coursework from the class.

## **Motivation**
##### I built this program to help the users such as teachers and instructors to record grades and create a report which can also be optionally sorted
in order of performance.

## **Code Example**
##### This is a code snippet of how the program creates an unsorted and a sorted file.
```
		btTxt.setOnAction(e -> {
		java.io.File file = new java.io.File(fileName.getText() +".txt");
		try (
				java.io.PrintWriter output = new java.io.PrintWriter(file);
		         ) {
			for(int i = 0; i < firstNameList.size(); i++) {
			output.println("First name:  "+firstNameList.get(i));
			output.println("Middle name: "+middleNameList.get(i));
			output.println("Last name:   "+lastNameList.get(i));
			output.println("Score:       "+scoreList.get(i));
			output.println("Grade:       "+gradeList.get(i));
			output.println();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		});

		btSortedTxt.setOnAction(e -> {
		java.io.File file = new java.io.File(fileName.getText() +".txt");
		try (
				java.io.PrintWriter output = new java.io.PrintWriter(file);
		         ) {
			sort(scoreList,firstNameList,middleNameList,lastNameList,gradeList);
			for(int i = 0; i < firstNameList.size(); i++) {
			output.println("First name:  "+firstNameList.get(i));
			output.println("Middle name: "+middleNameList.get(i));
			output.println("Last name:   "+lastNameList.get(i));
			output.println("Score:       "+scoreList.get(i));
			output.println("Grade:       "+gradeList.get(i));
			output.println();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			}
		});
```
## **Implementing**
##### To run the program, the user has to enter the informantion and grade of the student and press the record button for each. When the recording is finished, the user will enter the name of the file to store the data and choose whether to sort it according to perfomance or leave it as recorded.

![image](https://user-images.githubusercontent.com/112521045/205109162-e4330f6f-0c86-4578-a711-049aa445d953.png)

## **Contributors**
##### Use this program using JUnit4.
