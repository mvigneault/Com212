/* Binary Search Tree by Student Number*/

public class StudNumBST{
	//declare the root/ top of the tree
	private StudentNode top;
	//constructor
	public StudNumBST(){
		top = null;
		
	}
	//Check if the tree is empty
	public boolean isEmptyTree(){
		return top == null;
	}
	
	//delete a given node
	public void delete(StudentNode p){

		//if the node we want to delete is the root/ top of the tree
		if (p.getStudentNumber()== top.getStudentNumber()){
			StudentNode successor = getSuccessor(p);
			successor.setStudNumLeft(p.getStudNumLeft());
			successor.setStudNumRight(p.getStudNumRight());
			p.setStudNumLeft(null);
			p.setStudNumRight(null);
			top=successor;
		}
		//if the Node we want to delete is a leaf with no children
		else if (p.getStudNumLeft()== null && p.getStudNumRight()==null){
			//get the parent of the node we want to delete
			//must have this in every else statement because cant get the parent of top
			StudentNode parent = getParent(p);
			//if node to delete is to the right of the parent
			if (parent.getStudentNumber()<p.getStudentNumber()){
				parent.setStudNumRight(null);
			}
			//else if the node to delete is to the left of the parent
			else{
				parent.setStudNumLeft(null);
			}
		}
		//if the node to delete only has nodes coming off its left side
		else if(p.getStudNumRight()==null){
			StudentNode parent = getParent(p);
			//if node to delete is to the right of the parent
			if (parent.getStudentNumber()<p.getStudentNumber()){
				parent.setStudNumRight(p.getStudNumLeft());
				p.setStudNumLeft(null);
			}
			//else if the node to delete is to the left of the parent
			else{
				parent.setStudNumLeft(p.getStudNumLeft());
				p.setStudNumLeft(null);
			}
			
		}
		//if the node to delete only has nodes coming off its right side
		else if(p.getStudNumLeft()==null){
			StudentNode parent = getParent(p);
			if (parent.getStudentNumber()<p.getStudentNumber()){
				parent.setStudNumRight(p.getStudNumRight());
				p.setStudNumRight(null);
			}
			else{
				parent.setStudNumLeft(p.getStudNumRight());
				p.setStudNumRight(null);
			}
		}
		//if the node to delete has two children coming off of it
		else if (p.getStudNumLeft()!= null && p.getStudNumRight()!=null){
			//find the parent and the successor
			StudentNode parent = getParent(p);
			StudentNode successor = getSuccessor(p);
			//set the successors left and right to the left and right Node your deleting
			successor.setStudNumLeft(p.getStudNumLeft());
			successor.setStudNumRight(p.getStudNumRight());
			//remove the node completely from the tree
			p.setStudNumLeft(null);
			p.setStudNumRight(null);
			//know which side of the parent to set to the successor
			if (parent.getStudentNumber()<p.getStudentNumber()){
				parent.setStudNumRight(successor);
			}
			else{
				parent.setStudNumLeft(successor);
			}
		}
	}
	
	//get parent, call recurrsive parent
	public StudentNode getParent(StudentNode p){
		return reGetParent(top,p.getStudentNumber());
	}
	//recursive parent
	public StudentNode reGetParent(StudentNode temp, int studentNumber){
		//if the node your looking for if less than the parent check to the left
		if (studentNumber < temp.getStudentNumber()){
			if (temp.getStudNumLeft().getStudentNumber()==studentNumber){
				return temp;
			}
			else{
				return reGetParent(temp.getStudNumLeft(), studentNumber);
			}
		}
		//if the node your looking for is greater than the parent check to the right
		else {
			if (temp.getStudNumRight().getStudentNumber()==studentNumber){
				return temp;
			}
			else{
				return reGetParent(temp.getStudNumRight(), studentNumber);
			}
		}
	}
	//get successor
	public StudentNode getSuccessor(StudentNode p){
		//get to the left most node off of the right of p
		StudentNode temp = p.getStudNumRight();
		while (temp.getStudNumLeft() != null){
			temp = temp.getStudNumLeft();
		}
		//get parent and check if its bigger or less to remove the successor from the tree
		//could also call delete on it
		StudentNode parent = getParent(temp);
		if (parent.getStudentNumber()<temp.getStudentNumber()){
			parent.setStudNumRight(temp.getStudNumRight());
		}
		else{
			parent.setStudNumLeft(temp.getStudNumRight());
			temp.setStudNumRight(null);
		}
		
		return temp;
		
	}
	//insert a given element to the tree
	public void insert(StudentNode p){
		if (top==null){
			top = p;
		}
		else{
			reInsert(top,p);//recursive insert
		}
	}
	//recurrsive insert
	public void reInsert(StudentNode temp, StudentNode p){
		if (p.getStudentNumber()< temp.getStudentNumber()){
			if (temp.getStudNumLeft() ==null){
				temp.setStudNumLeft(p);
			}
			else{
				reInsert(temp.getStudNumLeft(),p);
			}
		}
		else{
			if(temp.getStudNumRight()==null){
				temp.setStudNumRight(p);
			}
			else{
				reInsert(temp.getStudNumRight(),p);
			}
		}
	}
	//search for a given element, calls recursive search
	public StudentNode search(int studentNumber){
		return compareNode(top,studentNumber);
	}
	//recursive search
	public StudentNode compareNode(StudentNode temp, int studentNumber){
		//if node null return null
		if (temp == null){
			return null;
		}
		//if node is the key we are looking for return a pointer to it
		else if (studentNumber == temp.getStudentNumber()){
			return temp;
		}
		//if the value is less than or bigger, move left or right in the tree
		else if (studentNumber < temp.getStudentNumber()){
			return compareNode(temp.getStudNumLeft(),studentNumber);
		}
		else {
			return compareNode(temp.getStudNumRight(),studentNumber);
		}
	}
	
	//traverse the tree going from left to the right
	public void traverse(){
		reTraverse(top);
		System.out.println();
	}
	public void reTraverse(StudentNode temp){
		// as long as its not null keep traversing
		if (temp != null){
			reTraverse(temp.getStudNumLeft());
			System.out.print(temp.getStudentNumber()+" ");
			reTraverse(temp.getStudNumRight());
		}
		
	}
	
	
	//print tree given by Parker
	public void printTree() {
		printTree2(top);
		System.out.println();
	}

	private void printTree2(StudentNode tree) {
		if (tree != null) {
			System.out.print(tree.getStudentNumber() + " ");
			if (tree.getStudNumLeft() != null)
				System.out.print("Left: " + tree.getStudNumLeft().getStudentNumber() + " ");
			else
				System.out.print("Left: null ");
			if (tree.getStudNumRight() != null)
				System.out.println("Right: " + tree.getStudNumRight().getStudentNumber() + " ");
			else
				System.out.println("Right: null ");
			printTree2(tree.getStudNumLeft());
			printTree2(tree.getStudNumRight());
		}
	}
}
