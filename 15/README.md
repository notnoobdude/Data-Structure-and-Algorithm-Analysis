DEADLINE: March 13, 2017 (NEW) GIVEN Feb. 20, 2017

    (DOUBLY LINKED LIST Assignment) 
    Write a Java program that will be used by the University's Admission office to record and evaluate all its freshman(First year College) applicants. 
    The program use a doubly linked list(DLL) to represent the database of First Year applicants. Each node in the DLL represents 1 applicant record.
    Please see below the template of the Java class FreshmanApplicant. Each Applicant record consists of 16 fields, 6 of which are inputs from user 
    for each applicant. The 6 static fields values have to be entered only once because they are the same values for all applicants(instances).
    After creating a new Applicant record, compute the 4 grades: science, math, english and overall grade using the formulas given below. 
    Add 2 pointer fields (left and right) to the class FreshmanApplicant. Write another Java class having the main method that 
    creates/builds the database of applicants records arranged in ascending order on the applicantNo and allows the user to perform any of the 
    following tasks. Before doing any of the following tasks below, user has to input common values for the 6 static fields. The 3 percent fields must
    total to 100.

    Tasks user can do: 
      	a) Add a new Freshman Applicant record. Input the new applicant's first 6 data fields.
           These will be added to the database as a new record (new node of the doubly linked list).
           The records must be in ascending order on the applicantNo. Find the right place for the new record and insert it there. 
	b) Delete an applicant record. Enter the applicantNo of the applicant record to be deleted. Find and delete the record. 
    	c) Display all freshman applicants records in ascending order on the applicantNo. Display all fields per record.
	d) Display the freshman applicant record (all data fields) of the one with the highest overall grade.
	e) Display the freshman applicant record (all data fields) of the one with the lowest overall grade.
        f) Display the freshman applicant record (all data fields) of the one with the highest science grade. (Best in Science)
	g) Display the freshman applicant record (all data fields) of the one with the highest math grade. (Best in Math)
        h) Display the freshman applicant record (all data fields) of the one with the highest english grade. (Best in English)
