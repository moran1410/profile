package assignment2;


import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;



//seperate class to write into files
public class FileWrite {
	
	String fileName;
	BufferedWriter writer;
	
	public FileWrite(String file) {
		super();
		this.fileName = file;
	
	try {
			
			//open a bufferedWriter
			writer = new BufferedWriter( new FileWriter(fileName));
		}
		
	
		catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
	
	}

	
	
	
	

	
}
