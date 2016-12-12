import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

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
				a.ssnTree = (SSNTree) in.readObject();
				a.studNumBST = (StudNumBST) in.readObject();
				a.ideaHeap = (IdeaHeap) in.readObject();
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
		System.out.println("A. Add a new Idea");
		System.out.println("B. Update student information");
		System.out.println("C. Find a student's email login");
		System.out.println("D. Look at the best idea");
		System.out.println("E. Look at a list of all students");
		System.out.println("F. Quit the program");
		String result1 = scan.nextLine();
		System.out.println();
		
		while(!result.equals("F")){
			
		if(result1.equals("A")){
			//Add new Idea
			Scanner scan1 = new Scanner(System.in);
			System.out.println("Please enter the last 4 digits of the SSN corresponding to the student who had the idea.");
			int studSSN = scan1.nextInt();
			StudentNode student = a.searchSSN(studSSN);

			if (student == null){
				Scanner scan2 = new Scanner(System.in);
				System.out.println("Student not found in database.");
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
				System.out.println(student.getName());
				System.out.println(student.getEmail());
				System.out.println(student.getSSN());
				System.out.println(student.getStudentNumber());
			}
			
			Scanner scan3 = new Scanner(System.in);
			System.out.println("Please enter the student's idea:");
			String strIdea = scan3.nextLine();
			System.out.println("Please enter the idea's rating:");
			int rating = scan3.nextInt();
			
			IdeaNode idea = new IdeaNode(strIdea, studSSN, rating);
			a.newIdea(idea);
			System.out.println("Student's new idea is added to the database");
		}

		
		
		
		else if (result1.equals("B")){
			Scanner scan4 = new Scanner(System.in);
			System.out.println("Please enter the last 4 digits of the SSN corresponding to the student you are searching for.");
			int studSSN = scan4.nextInt();
			StudentNode student = a.searchSSN(studSSN);
			
			if (student == null){
				Scanner scan5 = new Scanner(System.in);
				System.out.println("Student not found in database.");
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
				System.out.println(student.getName());
				System.out.println(student.getEmail());
				System.out.println(student.getSSN());
				System.out.println(student.getStudentNumber());
			}
			else{
				Scanner scan6 = new Scanner(System.in);
				System.out.println("Here is the information of this student:");
				System.out.println(student.getName());
				System.out.println(student.getEmail());
				System.out.println(student.getSSN());
				System.out.println(student.getStudentNumber());
				System.out.println();
				
				System.out.println("Please enter the letter of the option you want.");
				System.out.println("A. Change last name");
				System.out.println("B. Change email");
				System.out.println("C. Keep it the same");
				System.out.println("D. Delete all together");
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
				}
				System.out.println("Please enter the letter of the option you want.");
				System.out.println("A. Change last name");
				System.out.println("B. Change email");
				System.out.println("C. Keep it the same");
				System.out.println("D. Delete all together");
				result2 = scan.nextLine();
				System.out.println();
			}
		}
		}
		else if (result1.equals("C")){
			System.out.println("Please enter the last 4 digits of the student ID number to find the student's email login.");
			Scanner scan9 = new Scanner(System.in);
			int result3 = scan9.nextInt();
			if(a.getEmail(result3) == null){
				System.out.println("There is no student with that ID number.");
				System.out.println();
			}
			else{
				System.out.println(a.getEmail(result3));
				System.out.println();
			}
		}
		else if (result1.equals("D")){
			//Look at best idea
			if(a.getBestIdea() == null){
				System.out.println("There is no idea inside the database");
			}
			else{
				System.out.println("Here is the best idea:");
				System.out.println(a.getBestIdea());
	
				System.out.println("Do you want to sell the best idea? Enter \"Yes\" or \"No\".");
				Scanner scanYN = new Scanner(System.in);
				String answer = scanYN.nextLine();
				if (answer.equals("Yes")){
					a.sellBestIdea();
				}
			}
		}
		else if (result1.equals("E")){
			a.printStudents();
		}
		
		else if (result1.equals("F")){
			try {
			FileOutputStream fileOut = new FileOutputStream("output.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(a.ssnTree);
			out.writeObject(a.studNumBST);
			out.writeObject(a.ideaHeap);
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
		System.out.println("A. Add a new Idea");
		System.out.println("B. Search for student by SSN");
		System.out.println("C. Find a student's email login");
		System.out.println("D. Look at the best idea");
		System.out.println("E. Look at a list of all students");
		System.out.println("F. Quit the program");
		result1 = scan.nextLine();
		System.out.println();

	}
		 
	}
