package assignment2;
/*
 * Moran Abuelhija 302608666
 * Assignment 2 Part a
 * 
 */

import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	// create 3 students 	
	Students s1 = new Students("Mike",123,77.7,"ADM");
	Students s2 = new Students("Matt",321,97.2,"AAS");
	Students s3 = new Students("Miko",333,87.7,"SSA");
	
	//create an instance of MyClass
	MyClass class1 = new MyClass(10, "Chocho", new ArrayList<Students>());
	
	//running getdetails methods for an instance of the class 
	class1.getDetails(s3);
	class1.getDetails(s2);
	class1.getDetails(s1);
	
	// running putdetails for an instance of the class 
	// note this will appear as duplicate above students details will be 
	// copied again when pressing SaveToFile in the document 
	class1.putDetails("src/students.txt");
	
	
// call for RegDocument class that construct the form 	
RegDocument document = new RegDocument(class1,"src/students.txt");	
	
document.setVisible(true);	
	
	
	}

}
