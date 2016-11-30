//Node for Ideas — Kendra Bolt

class IdeaNode{
	private int ideaNum;
	public int ideaSSN;
	public String text;
	public int rating;
	private Node right;
	private Node left;

	public Idea( String x, int ssn, int y){
		ideaSSN = ssn;
		text = x;
		rating = y;
	}

	public void setIdeaNum(int num){
		ideaNum = num;
	}

	public int getRating(){
		return rating;
	}

	public String getIdea(){
		return text;
	}

	public int getSSN(){
		return ideaSSN;
	}

	public void setRight(Node x){
		right = x;
	}

	public Node getRight(){
		return right;
	}
	
	public void setLeft(Node x){
		left = x;
	}
	
	public Node getLeft(){
		return left;
	}
}
