//Student Node class - Mathieu Vigneault & Patrick Davis & Kendra Bolt
public class StudentNode {

	private int SSN;
	private String email;
	private String name;
	private int studentNumber;
	private IdeaNode originalIdea;
	private IdeaQueueLL queue;
	private StudentNode SSNLeft; 
	private StudentNode SSNRight;
	private StudentNode StudNumLeft; 
	private StudentNode StudNumRight;
	
	
	//contructor that creates a node with a name, SSN
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
		this.setOriginalIdea(originalIdea);
		
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
	
	public void addIdea(IdeaNode idea) {
				queue.enqueue(idea);
			
	}
	
	public double getAverageRating(){
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
	
	public void printIdeaQueue(){
		queue.printQueue();
	}

	public IdeaNode getOriginalIdea() {
		return originalIdea;
	}

	public void setOriginalIdea(IdeaNode originalIdea) {
		this.originalIdea = originalIdea;
	}

	public StudentNode getSSNLeft() {
		return SSNLeft;
	}

	public void setSSNLeft(StudentNode sSNLeft) {
		SSNLeft = sSNLeft;
	}

	public StudentNode getSSNRight() {
		return SSNRight;
	}

	public void setSSNRight(StudentNode sSNRight) {
		SSNRight = sSNRight;
	}

	public StudentNode getStudNumLeft() {
		return StudNumLeft;
	}

	public void setStudNumLeft(StudentNode studNumLeft) {
		StudNumLeft = studNumLeft;
	}

	public StudentNode getStudNumRight() {
		return StudNumRight;
	}

	public void setStudNumRight(StudentNode studNumRight) {
		StudNumRight = studNumRight;
	}
	
}
