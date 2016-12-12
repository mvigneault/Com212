import java.util.Scanner;

public class Main {
	 public static void main(String[] args){
		System.out.println("Do you want a new Database or an existing Database?");
		Scanner scan = new Scanner(System.in);
		System.out.println("A: New Database");
		System.out.println("B: Existing Database");
		int result = scan.nextInt();
		System.out.println(result);
		if(result.equals("A")){
			Database a = new Database();
			System.out.println(result);
		}
		else if (result.equals("B")){
			//restore old database 
			System.out.println(result);
		}
		//else{
			//System.out.println("Not an option");
			//scan.nextLine();
		//}
		//Database a = new Database();
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
		StudentNode xNode = new StudentNode ("Mathieu", 229935437, "mvigneau@conncoll.edu", 3390);
		StudentNode yNode = new StudentNode ("Patrick", 435872959, "pdavis@conncoll.edu", 4601);
		StudentNode zNode = new StudentNode ("Kendra", 753710983, "kbolt@conncoll.edu", 3219);
		a.newStudent(yNode);
		a.newStudent(xNode);
		a.newStudent(zNode);
		System.out.println(a.searchSSN(229935437));
		System.out.println(yNode.getEmail());
		System.out.println(yNode.getStudentNumber());
	/*	Node yNode = new Node ("Joe", 934567890);
		Node zNode = new Node ("Jack", 223452234);
		Node kNode = new Node("Jill", 934567856);
		Node aNode = new Node("Abe", 123456788);
		Node bNode = new Node("Beth", 934567898);
		Node cNode = new Node("Chuck", 223452238);
		Node dNode = new Node("Dot", 934567858);
		Node mNode = new Node("Mike", 723452237);
		Node nNode = new Node("Nick", 734567857);
		Node oNode = new Node("Otis", 734562222);
		System.out.println("Insert Key: 6789");
		System.out.println();
		a.insert(xNode);
		a.printHash();
		System.out.println();
		System.out.println("Insert Key: 7890");
		System.out.println();
		a.insert(yNode);
		a.printHash();
		System.out.println();
		System.out.println("Insert Key: 2234");
		System.out.println();
		a.insert(zNode);
		a.printHash();
		System.out.println();
		System.out.println("Insert Key: 7856");
		System.out.println();
		a.insert(kNode);
		a.printHash();
		System.out.println();
		System.out.println("Element in the array:");
		a.printHash();
		System.out.println();
		System.out.println("isEmptyHash = " + a.isEmpty());
		System.out.println();
		System.out.println("lookup index of 6789: " + a.lookup(xNode.getKey()));
		System.out.println();
		System.out.println("Insert Key: 2237");
		System.out.println();
		a.insert(mNode);
		a.printHash();
		System.out.println();
		System.out.println("Insert Key: 7857");
		System.out.println();
		a.insert(nNode);
		a.printHash();
		System.out.println();
		System.out.println("Element in the array:");
		a.printHash();
		System.out.println();
		System.out.println("Delete Key: 6789");
		System.out.println();
		a.delete(xNode);
		a.printHash();
		System.out.println();
		System.out.println("Delete Key: 2237");
		System.out.println();
		a.delete(mNode);
		a.printHash();
		System.out.println();
		System.out.println("lookup index of 7857: " + a.lookup(nNode.getKey()));
		System.out.println();
		System.out.println("Delete Key: 7857");
		System.out.println();
		a.delete(nNode);
		a.printHash();
		System.out.println();
		System.out.println("Element in the array:");
		a.printHash();
		System.out.println();
		System.out.println("Insert Key: 6788");
		System.out.println();
		a.insert(aNode);
		a.printHash();
		System.out.println();
		System.out.println("Insert Key: 2222");
		System.out.println();
		a.insert(oNode);
		a.printHash();
		System.out.println();
		System.out.println("lookup index of 7856: " + a.lookup(kNode.getKey()));
		System.out.println();
		System.out.println("isEmptyHash = " + a.isEmpty());
		*/ 
		//Serialize Code
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
	 }
}

