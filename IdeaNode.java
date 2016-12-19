/*Node for Ideas.
 * This class was made by Kendra Bolt.
 * Revised by Mathieu & Patrick.
*/

import java.io.*;

public class IdeaNode implements java.io.Serializable{
	
	private int ideaNum;
	public int ideaSSN;
	public String text;
	public int rating;
	private IdeaNode right;
	private IdeaNode left;
	private IdeaNode next;
	
	public IdeaNode( String x, int ssn, int y){
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

	public void setRight(IdeaNode x){
		right = x;
	}

	public IdeaNode getRight(){
		return right;
	}
	
	public void setLeft(IdeaNode x){
		left = x;
	}
	
	public IdeaNode getLeft(){
		return left;
	}

	public IdeaNode getNext() {
		return next;
	}

	public void setNext(IdeaNode next) {
		this.next = next;
	}
}
