/*This is the Database Class. 
 * It is a class that helps regroup all the methods to make it easy to call them. 
 * This class was done by Kendra.
 * It was revised by Patrick and Mathieu.
*/

import java.io.*;

public class Database implements java.io.Serializable{
	public StudentNode studentRecord;
	private int uniqueIdeaNumber = 0;
	public SSNTree ssnTree;
	public StudNumBST studNumBST;
	public IdeaHeap ideaHeap;
  
	public Database() {
		ssnTree = new SSNTree();
		studNumBST = new StudNumBST();
		ideaHeap = new IdeaHeap();
	}
  
	public StudentNode searchSSN(int ssn){
		studentRecord = ssnTree.search(ssn); 
		return studentRecord;
	}

	public void changeLastName(String newLastName){
		studentRecord.setName(newLastName);
	}

	public void changeEmail(String newEmail){
		studentRecord.setEmail(newEmail); 
	}

	public void deleteRecord(){
    //Remove studentRecord from SSNtree and StudentIDtree
		ssnTree.delete(studentRecord);
		studNumBST.delete(studentRecord);
	}

	public void newStudent(StudentNode student){
	//add student to SSNtree and StudentID tree
		ssnTree.insert(student);
		studNumBST.insert(student);
	}

	public void newIdea(IdeaNode idea){
		idea.setIdeaNum(uniqueIdeaNumber);
		//add new idea to IdeaHeap and use ideaSSN to add idea to the correct student
		int ssn = idea.getSSN();
		ideaHeap.insert(idea);
		uniqueIdeaNumber++;
		studentRecord = ssnTree.search(ssn);
		studentRecord.addIdea(idea);
	}

	public IdeaNode getBestIdea(){
		return ideaHeap.findMax();
	}

	public IdeaNode sellBestIdea(){
		IdeaNode bestIdea = ideaHeap.findMax();
		ideaHeap.deleteMax();
		return bestIdea;
	}

	public String getEmail (int num){  //num is student ID number. 
	//search student number tree for student
		studentRecord = studNumBST.search(num);
		if(studentRecord == null){
			return null;
	    }
		else{//display email login
			return studentRecord.getEmail();
		}
	}

	public void printStudents(){
		//print student ID tree
		//students printed must also display student number, name, SSN, average score
		studNumBST.printTree();
	}
}
