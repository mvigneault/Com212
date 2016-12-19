Patrick, Matt V., and Kendra
# ℂ𝕠𝕞𝟚𝟙𝟚
# 𝕄𝕒𝕚𝕟.𝕛𝕒𝕧𝕒 ℝ𝕖𝕒𝕕𝕖𝕣'𝕤 𝕄𝕒𝕟𝕦𝕒𝕝
Question 1: "Do you want a new Database or an existing Database?"

A. Creates new database

B. Uploads previous database from file



Question 2: "What would you like to do? Please enter the letter corresponding to your choice."

A. Add a new Student to the database; last name, email, ssn, studNum.   

B. Add a new idea to the database; if student who created idea is not already in the database, he/she can be added.

C. Search a student by SSN (optional: change email/last name or delete student record); if not in database, prompted to create record.

D. Find a student's email login by searching with student number.

E. Look at the best idea in the database (optional: sell the best idea).

F. Look at a list of all students.

G. Quit the program




# 𝔻𝕒𝕥𝕒𝕓𝕒𝕤𝕖
	
	public Database()
		creates an instance of a database
	  
	  
	  public StudentNode searchSSN(int ssn)
		searches SSNtree to find StudentNode and sets student node found in tree to a variable studentRecord, then displays record information


	  public void changeLastName(String newLastName)
		changes the last name of the student node (studentRecord) saved from searchSSN

	  public void changeEmail(String newEmail)
		changes the email login of the student node (studentRecord) saved from searchSSN


	  public void deleteRecord()
		deletes the student node (studentRecord) saved from searchSSN


	  public void newStudent(StudentNode student)
		inserts a new student into the database


	  public void newIdea(IdeaNode idea)
		inserts a new idea into the database


	  public IdeaNode getBestIdea()
		returns the highest ranked idea in the database

	  public IdeaNode sellBestIdea()
		removes the highest ranked idea from the list of ideas, but not from a student’s record


	  public String getEmail (int num)
		searches StudentNumberTree to find StudentNode and displays student’s email login


	  public void printStudents()
		displays list of students and their information ordered by student ID number
