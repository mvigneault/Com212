/*Main Function: Mathieu Vigneault & Patrick Davis & Kendra Bolt
12/5/16 Kendra Main outline and rough coding*/

public class Database{
  public StudentNode studentRecord;
  private int uniqueIdeaNumber = 0;
  public SSNTree ssnTree;
  public StudNumBST studNumBST;
  public IdeaHeap ideaHeap;
  
  public Database{
    ssnTree = SSNTree();
    studNumBST = StudNumBST();
    ideaHeap = IdeaHeap();
  }
  
    public StudentNode searchSSN(String ssn){
      //searches SSNtree to return StudentNode
      StudentNode student = ssnTree.search(ssn);
      //displays last name, email login, ssn, avg score ideas, ideaqueue
      System.out.println(student.getName());
      System.out.println(student.getEmail());
      System.out.println(student.getSSN());
      System.out.println();
      System.out.println(Student.)
      //studentRecord = student node from search (for manipulation)
    }
    
    public void changeLastName(String newLastName){
      //studentRecord.setName(newLastName);
    }
    
    public void changeEmail(String newEmail){
      //studentRecord.setEmail(newEmail); 
    }
    
    public void deleteRecord(){
      //Remove studentRecord from SSNtree and StudentIDtree
    }
    
    public void newStudent(StudentNode student){
      //add student to SSNtree and StudentID tree
    }
    
    public void newIdea(IdeaNode idea){
      idea.setIdeaNum(uniqueIdeaNumber);
      //add new idea to IdeaHeap and use ideaSSN to add idea to the correct student
      uniqueIdeaNumber++;
    }
    
    public IdeaNode getBestIdea(){
      return Ideaheap.findMin();
    }
    
    public IdeaNode sellBestIdea(){
      return Ideaheap.deleteMin();
    }
    
    public StudentNode searchIDnum(int num){
      //search student number tree for student
      //display email login
    }
    
    public void printStudents(){
      //print student ID tree
      //students printed must also display student number, name, SSN, average score
    }
    
    //Save and Load functions
    
    //Your program should store the contents of the database to a file when it is shut down and retrieve the data when started back up again.
    //You only need a single text file for this, but can use more if you prefer.
    
    
    
    
}
