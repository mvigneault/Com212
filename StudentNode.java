//Student Node class - Mathieu Vigneault & Patrick Davis & Kendra Bolt
public class StudentNode {
	
	//Declare variables 
	private int SSN;
	private String email;
	private String name;
	private int studentNumber;
	private IdeaNode originalIdea;
	private IdeaQueueLL queue;
	private StudentNode Left;
	private StudentNode Right;
	private averageRating;
	
	//contructor that creates a node with a student name, SSN, email and studentNumber.
	public StudentNode (String name, int SSN, String email, int studentNumber){
		this.name = name; 
		this.SSN = SSN;
		this.email = email;
		this.studentNumber = studentNumber;
		
	}
	
	//contructor that creates a node with a name, SSN, as well as an original idea
	public StudentNode (String name, int SSN, String email, int studentNumber, IdeaNode originalIdea){
		this.name = name; 
		this.SSN = SSN;
		this.email = email;
		this.studentNumber = studentNumber;
		this.originalIdea = originalIdea;
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSSN() {
		return SSN;
	}

	public void setSSN(int sSN) {
		SSN = sSN;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	public StudentNode getRight() {
		return Right;
	}

	public void setRight(StudentNode Right) {
		this.Right = Right;
	}

	public StudentNode getLeft() {
		return Left;
	}

	public void setLeft(StudentNode Left) {
		this.Left = Left;
	}
	
	public void addIdea(IdeaNode idea) {
		queue.enqueue(idea);
	}
	
	public double averageRating(){
		IdeaNode temp = queue.front(); 
		double totalRating = 0;
		int numRatings = 0;
		double avgRating;
		while (temp!= null){
			totalRating = totalRating+temp.getRating();
			numRatings++;
		}
		avgRating = totalRating/ numRatings;
		return avgRating;
	}
	
}
