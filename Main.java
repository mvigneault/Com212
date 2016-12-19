/*This is the Main Class. 
 * This class was done by Mathieu & Patrick.
 * It was revised by Kendra.
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.NumberFormatException;


public class Main {
	public static void main(String[] args){
		//Question 1
		System.out.println("Do you want a new Database or an existing Database?");
		Scanner scan = new Scanner(System.in);
		System.out.println("A: New Database");
		System.out.println("B: Existing Database");
		String result = scan.nextLine();
		Database a = new Database();
		System.out.println();
		
		while(!result.equals("A") && !result.equals("B")){
			System.out.println("Do you want a new Database or an existing Database?");
			System.out.println("A: New Database");
			System.out.println("B: Existing Database");
			result = scan.nextLine();
			System.out.println();
		}
		if(result.equals("A")){
			System.out.println("New Database");
			System.out.println();
		}
		else if (result.equals("B")){
			//restore old database
			try {
				FileInputStream fileIn = new FileInputStream("output.txt");
				ObjectInputStream in = new ObjectInputStream(fileIn);
				a.studNumBST = (StudNumBST) in.readObject();
				a.ssnTree = (SSNTree) in.readObject();
				a.ideaHeap = (IdeaHeap) in.readObject();
				a = (Database) in.readObject();
				in.close();
				fileIn.close();
			}
			catch(IOException i) {
				i.printStackTrace();
			}
			catch(ClassNotFoundException j) {
				j.printStackTrace();
			}
			System.out.println("Database Restored");
			System.out.println();
		}


		//Question 2
		
		System.out.println("What would you like to do? Please enter the letter corresponding to your choice.");
		System.out.println("A. Add a New Student");
		System.out.println("B. Add a New Idea");
		System.out.println("C. Update student information");
		System.out.println("D. Find a student's email login");
		System.out.println("E. Look at the best idea");
		System.out.println("F. Look at a list of all students");
		System.out.println("G. Quit the program");
		String result1 = scan.nextLine();
		System.out.println();
		
		while(!result.equals("G")){
		
		if(result1.equals("A")){
			try{
			Scanner scan30 = new Scanner(System.in);
			System.out.println("Please enter student's last name: ");
			String name = scan30.nextLine();
			System.out.println("Please enter student's email login: ");
			String email = scan30.nextLine();
			System.out.println("Please enter student's Student Number: ");
			int studNum = scan30.nextInt();
			System.out.println("Please enter student's SSN: ");
			int studSSN = scan30.nextInt();
			
			StudentNode student = new StudentNode(name, studSSN, email, studNum);
			a.newStudent(student);
			System.out.println("A new student is created:");
			System.out.println();
			System.out.println("Student Last Name: " + student.getName());
			System.out.println("Student Email: " + student.getEmail());
			System.out.println("SSN: " + student.getSSN());
			System.out.println("Student Number: " + student.getStudentNumber());
			System.out.println();
			}
			catch(InputMismatchException e){
				System.out.println("The last entry was not a number.");
				System.out.println();
			}
		}
		if(result1.equals("B")){
			//Add new Idea
			try{
			System.out.println("Please enter the last 4 digits of the SSN corresponding to the student who had the idea.");
			Scanner scan1 = new Scanner(System.in);
			int studSSN = scan1.nextInt();
			StudentNode student = a.searchSSN(studSSN);
			
			while(studSSN < 0 || studSSN > 9999){
				System.out.println("Something Wrong Was Typed.");
				System.out.println("Please enter the last 4 digits of the SSN corresponding to the student who had the idea.");
				studSSN = scan1.nextInt();
				System.out.println();
			}
			
			if (student == null){
				Scanner scan2 = new Scanner(System.in);
				System.out.println("Student not found in database.");
				System.out.println();
				System.out.println("Would you like to add a new student with this SSN? Enter \"Yes\" or \"No\".");
				Scanner scanYN1 = new Scanner(System.in);
				String answer1 = scanYN1.nextLine();
				System.out.println();
				while(!answer1.equals("Yes") && !answer1.equals("No")){
					System.out.println("Would you like to add a new student with this SSN? Enter \"Yes\" or \"No\".");
					answer1 = scanYN1.nextLine();
					System.out.println();
				}
				if(answer1.equals("Yes")){
					System.out.println("Please enter student's last name: ");
					String name = scan2.nextLine();
					System.out.println("Please enter student's email login: ");
					String email = scan2.nextLine();
					System.out.println("Please enter student's Student Number: ");
					int studNum = scan2.nextInt();
					
					student = new StudentNode(name, studSSN, email, studNum);
					a.newStudent(student);
					System.out.println("A new student is created:");
					System.out.println();
					System.out.println("Student Last Name: " + student.getName());
					System.out.println("Student Email: " + student.getEmail());
					System.out.println("SSN: " + student.getSSN());
					System.out.println("Student Number: " + student.getStudentNumber());
					System.out.println();
					
					try{
					Scanner scan12 = new Scanner(System.in);
					System.out.println("Please enter the student's idea:");
					String strIdea = scan12.nextLine();
					System.out.println("Please enter the idea's rating:");
					int rating = scan12.nextInt();
					
					IdeaNode idea = new IdeaNode(strIdea, studSSN, rating);
					a.newIdea(idea);
					System.out.println("Student's new idea is added to the database");
					System.out.println();
					}
					catch(NumberFormatException e) {
					    System.out.println("One of the input is not a number " + e);
					}
					catch(InputMismatchException e){
						 System.out.println("The program is being haulted.");
						 System.out.println("The last entry was not a number.");
						 System.out.println();
					}
					
				}
				else if(answer1.equals("No")){}
			}
			
			else{
				try{
				Scanner scan3 = new Scanner(System.in);
				System.out.println("Please enter the student's idea:");
				String strIdea = scan3.nextLine();
				System.out.println("Please enter the idea's rating:");
				int rating = scan3.nextInt();
				
				IdeaNode idea = new IdeaNode(strIdea, studSSN, rating);
				a.newIdea(idea);
				System.out.println("Student's new idea is added to the database");
				System.out.println();
				}
				catch(NumberFormatException e) {
				    System.out.println("One of the input is not a number " + e);
				}
				catch(InputMismatchException e){
					 System.out.println("The program is being haulted.");
					 System.out.println("The last entry was not a number.");
					 System.out.println();
				}
			}
		}
		catch(InputMismatchException e){
			 System.out.println("The last entry was not a number.");
			 System.out.println();
		}
		}
		
		else if (result1.equals("C")){
			try{
			Scanner scan4 = new Scanner(System.in);
			System.out.println("Please enter the last 4 digits of the SSN corresponding to the student you are searching for.");
			int studSSN = scan4.nextInt();
			StudentNode student = a.searchSSN(studSSN);
			
			if (student == null){
				Scanner scan5 = new Scanner(System.in);
				System.out.println("Student not found in database.");
				System.out.println();
				System.out.println("Would you like to add a new student with this SSN? Enter \"Yes\" or \"No\".");
				Scanner scanYN2 = new Scanner(System.in);
				String answer2 = scanYN2.nextLine();
				System.out.println();
				while(!answer2.equals("Yes") && !answer2.equals("No")){
					System.out.println("Would you like to add a new student with this SSN? Enter \"Yes\" or \"No\".");
					answer2 = scanYN2.nextLine();
					System.out.println();
				}
				if(answer2.equals("Yes")){
					System.out.println("Please enter student's last name: ");
					String name = scan5.nextLine();
					System.out.println("Please enter student's email login: ");
					String email = scan5.nextLine();
					System.out.println("Please enter student's Student Number: ");
					int studNum = scan5.nextInt();
					
					student = new StudentNode(name, studSSN, email, studNum);
					a.newStudent(student);
					System.out.println("A new student is created:");
					System.out.println();
					System.out.println("Student Last Name: " + student.getName());
					System.out.println("Student Email: " + student.getEmail());
					System.out.println("SSN: " + student.getSSN());
					System.out.println("Student Number: " + student.getStudentNumber());
					System.out.println();
				}
				else if(answer2.equals("No")){}
				
			}
			else{
				Scanner scan6 = new Scanner(System.in);
				System.out.println("Here is the information of this student:");
				System.out.println("Student Last Name: " + student.getName());
				System.out.println("Student Email: " + student.getEmail());
				System.out.println("SSN: " + student.getSSN());
				System.out.println("Student Number: " + student.getStudentNumber());
				System.out.println("Student Average Rating For Last 10 Ideas: " + student.getAverageRating());
				System.out.println();
				
				System.out.println("Please enter the letter of the option you want.");
				System.out.println("A. Change last name");
				System.out.println("B. Change email");
				System.out.println("C. Keep it the same");
				System.out.println("D. Delete all together");
				System.out.println("E. Display last 10 Ideas");
				String result2 = scan.nextLine();
				System.out.println();
				
				while(!result2.equals("C")){
				if(result2.equals("A")){
					Scanner scan7 = new Scanner(System.in);
					System.out.println("Please enter the desired last name of the student.");
					String name = scan7.nextLine();
					student.setName(name);
				}
				if(result2.equals("B")){
					Scanner scan8 = new Scanner(System.in);
					System.out.println("Please enter the desired email of the student.");
					String email = scan8.nextLine();
					student.setEmail(email);
				}
				if(result2.equals("D")){
					System.out.println("The student is deleted");
					a.ssnTree.delete(student);
					a.studNumBST.delete(student);
					break;
				}
				if(result2.equals("E")){
					System.out.println("Here are the student's last 10 ideas: ");
					student.printIdeaQueue();
					System.out.println();
				}
				System.out.println("Please enter the letter of the option you want.");
				System.out.println("A. Change last name");
				System.out.println("B. Change email");
				System.out.println("C. Keep it the same");
				System.out.println("D. Delete all together");
				System.out.println("E. Display last 10 Ideas");
				result2 = scan.nextLine();
				System.out.println();
			}
		}
		}
		catch(InputMismatchException e){
			System.out.println("The last entry was not a number.");
			System.out.println();
		}
		}
		else if (result1.equals("D")){
			try{
			System.out.println("Please enter the last 4 digits of the student ID number to find the student's email login.");
			Scanner scan9 = new Scanner(System.in);
			int studNum = scan9.nextInt();
			
			if(a.getEmail(studNum) == null){
				Scanner scan13 = new Scanner(System.in);
				System.out.println("There is no student with that ID number.");
				System.out.println();
				System.out.println("Would you like to add a new student with this SSN? Enter \"Yes\" or \"No\".");
				Scanner scanYN3 = new Scanner(System.in);
				String answer3 = scanYN3.nextLine();
				System.out.println();
				while(!answer3.equals("Yes") && !answer3.equals("No")){
				System.out.println("Would you like to add a new student with this SSN? Enter \"Yes\" or \"No\".");
				answer3 = scanYN3.nextLine();
				System.out.println();
				}
				if(answer3.equals("Yes")){
					System.out.println("Please enter student's last name: ");
					String name = scan13.nextLine();
					System.out.println("Please enter student's email login: ");
					String email = scan13.nextLine();
					System.out.println("Please enter student's SSN: ");
					int studSSN = scan13.nextInt();
					
					StudentNode student = new StudentNode(name, studSSN, email, studNum);
					a.newStudent(student);
					System.out.println("A new student is created:");
					System.out.println();
					System.out.println("Student Last Name: " + student.getName());
					System.out.println("Student Email: " + student.getEmail());
					System.out.println("SSN: " + student.getSSN());
					System.out.println("Student Number: " + student.getStudentNumber());
					System.out.println();
				}
				else if(answer3.equals("No"));{}
			}
			else{
				System.out.println(a.getEmail(studNum));
				System.out.println();
			}
		}
		catch(InputMismatchException e){
			System.out.println("The last entry was not a number.");
			System.out.println();
		}
		}
		else if (result1.equals("E")){
			//Look at best idea
			if(a.getBestIdea() == null){
				System.out.println("There is no idea inside the database");
			}
			else{
				System.out.println("Here is the best idea:");
				System.out.println(a.getBestIdea().getIdea());
				System.out.println(a.getBestIdea().getRating());
				
				System.out.println("Do you want to sell the best idea? Enter \"Yes\" or \"No\".");
				Scanner scanYN = new Scanner(System.in);
				String answer = scanYN.nextLine();
				while(!answer.equals("Yes") && !answer.equals("No")){
					System.out.println("Would you like to add a new student with this SSN? Enter \"Yes\" or \"No\".");
					answer = scanYN.nextLine();
					System.out.println();
				}
				if (answer.equals("Yes")){
					a.sellBestIdea();
					System.out.println("The best Idea is sold.");
				}
				else if(answer.equals("No")){}
			}
		}
		else if (result1.equals("F")){
			if(a.studNumBST.isEmptyTree()){
				System.out.println("There is no student in the system.");
			}
			a.printStudents();
		}
		
		else if (result1.equals("G")){
			try {
			FileOutputStream fileOut = new FileOutputStream("output.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(a.studNumBST);
			out.writeObject(a.ssnTree);
			out.writeObject(a.ideaHeap);
			out.writeObject(a);
			out.close();
			fileOut.close();
			System.out.println("Serialized object successfully in output.txt");
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		break;
		}
		System.out.println("What would you like to do? Please enter the letter corresponding to your choice.");
		System.out.println("A. Add a New Student");
		System.out.println("B. Add a New Idea");
		System.out.println("C. Search for student by SSN");
		System.out.println("D. Find a student's email login");
		System.out.println("E. Look at the best idea");
		System.out.println("F. Look at a list of all students");
		System.out.println("G. Quit the program");
		result1 = scan.nextLine();
		System.out.println();

	}
		 
	}
}
