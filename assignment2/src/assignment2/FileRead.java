package assignment2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


//seperate class to read files 
public class FileRead {
	
	String fileName;
	BufferedReader reader;
	
	
	public FileRead(String file) {
		super();
		this.fileName = file;
	
	try {
			
			reader = new BufferedReader(new FileReader(fileName));
			
		}
		
	
		catch(FileNotFoundException e) {e.printStackTrace();}
		
	
	}

	
	
	
	

	
}



