/*Main Function: Mathieu Vigneault & Patrick Davis & Kendra Bolt
12/5/16 Kendra Main outline and rough coding*/

public class Database{
  public StudentNode studentRecord;
  private int uniqueIdeaNumber = 0;
  public SSNTree ssnTree;
  public StudNumBST studNumBST;
  public IdeaHeap ideaHeap;
  
  public Database(){
    ssnTree = SSNTree();
    studNumBST = StudNumBST();
    ideaHeap = IdeaHeap();
  }
  
  public StudentNode searchSSN(String ssn){
    //searches SSNtree to return StudentNode
    //studentRecord = student node from search (for manipulation)
    studentRecord = ssnTree.search(ssn);

    //displays last name, email login, ssn, avg score ideas, ideaqueue
    System.out.println(studentRecord.getName());
    System.out.println(studentRecord.getEmail());
    System.out.println(studentRecord.getSSN());
    System.out.println(Student.getAverageRating());
    System.out.println();
    student.printIdeaQueue();
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
    studentRecord = SSNTree.search(ssn);
    studentRecord.addIdea(idea);
  }

  public IdeaNode getBestIdea(){
    return ideaHeap.findMin();
  }

  public IdeaNode sellBestIdea(){
    return ideaHeap.deleteMin();
  }

  public StudentNode searchIDnum(int num){
    //search student number tree for student
    studentRecord = studNumBST.search(num);
    //display email login
    System.out.println(studentRecord.getEmail());
  }

  public void printStudents(){
    //print student ID tree
    //students printed must also display student number, name, SSN, average score
    studNumBST.printTree();
  }

  //Save and Load functions

  //Your program should store the contents of the database to a file when it is shut down and retrieve the data when started back up again.
  //You only need a single text file for this, but can use more if you prefer.

    
    
    
}
