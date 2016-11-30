public class StudentNode {

	private int SSN;
	private String email;
	private String name;
	private int studentNumber;
	private IdeaNode originalIdea;
	private Idea[];
	
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
}
