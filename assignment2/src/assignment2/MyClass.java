package assignment2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;



public class MyClass {
	
	int grade;
	String teacherName;
	ArrayList<Students> studentsAL = new ArrayList<Students>();
	
	//constructor 
	public MyClass(int grade, String teacherName, ArrayList<Students> studentsAL) {
		super();
		this.grade = grade;
		this.teacherName = teacherName;
		this.studentsAL = studentsAL;
	}
// return details of student if found in the arraylist, if not found student is added
// to the arraylist
	public void getDetails(Students s)
	{
		if (studentsAL.isEmpty()) {
			
			studentsAL.add(s);
			System.out.println("new student was added to class !");
		}
		else if (studentsAL.contains(s))
		{
			s.toString();
			
		}
		else {
			studentsAL.add(s);
			System.out.println("new student was added to class !"); 
		}
	}
	
	
		
 // saves students details from arraylist into a given text file	
	public void putDetails(String fileName) {
		
		FileWrite data = new FileWrite(fileName);
		
		
		
		try {
			
			
		// loop through Students arraylist and and write information into textfile
		for(Students  s : studentsAL) {
			data.writer.write(s.name + " " + s.id + " " + s.average + " "
					+ s.department + "\n"); 
			System.out.println(s.name + " " + s.id + " " + s.average + " "
					+ s.department + " was recorded into the text file \n");
		
		
		} 
		
		data.writer.close();
		
		
	}
		catch(FileNotFoundException e) {}
		catch(IOException e) {}
		
	}
	
//getters setters 
	public int getGrade() {
		return grade;
	}


	public String getTeacherName() {
		return teacherName;
	}


	public ArrayList<Students> getStudentsAL() {
		return studentsAL;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}


	public void setStudentsAL(ArrayList<Students> studentsAL) {
		this.studentsAL = studentsAL;
	}

	
	
}
