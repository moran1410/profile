package assignment2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//class for the registration document using 2 panels with text fields and and button and text area 
// at the bottom 
public class RegDocument extends JFrame implements ActionListener {
	//input fields 
	JTextField nameField = new JTextField(18);
	JTextField idField = new JTextField(18);
	JTextField avgField = new JTextField(18);
	Choice dptChoice = new Choice();
	
	// text area with scroll pane
	JTextArea textArea = new JTextArea(10,10);
	JScrollPane scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	
	
	//action buttons
	JButton subButton = new JButton("Submit");
	JButton saveButton = new JButton("SaveToFile");
	JButton showButton = new JButton("Show all");
	JButton newFileButton = new JButton("NewFile");
	JButton clearButton = new JButton("Clear");
	
	//MyClass and String used by this class to receive handle of the instance of MyClass and location 
	//of the file that we will read from and write to 
	MyClass class1;
	String txtFile;
	
	
	// constructor of the JFrame
	public RegDocument (MyClass myclass, String file)
	{
		super("Student registeration form");
		
		//handles for text file and myclass
		this.class1 = myclass;
		this.txtFile = file;
		
		dptChoice.add("...");		
		dptChoice.add("DEP1");		
		dptChoice.add("DEP2");		
		dptChoice.add("DEP3");		
		dptChoice.add("DEP4");

		// text fields panel
		JPanel panel1 = new JPanel(new GridLayout(0,2));
		panel1.add(new Label("Full name:"));
		panel1.add(nameField);
		panel1.add(new Label("ID:"));
		panel1.add(idField);
		panel1.add(new Label("Average:"));
		panel1.add(avgField);
		panel1.add(new Label("Department:"));
		panel1.add(dptChoice);
		
		// buttons panel with action listener method
		JPanel panel2 = new JPanel(new FlowLayout());
		panel2.add(subButton);
		subButton.addActionListener(this);
		
		panel2.add(saveButton);
		saveButton.addActionListener(this);
		
		panel2.add(showButton);
		showButton.addActionListener(this);
		
		panel2.add(newFileButton);
		newFileButton.addActionListener(this);
		
		panel2.add(clearButton);
		clearButton.addActionListener(this);
		
		//main window
		setLayout(new BorderLayout());
		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);
		add(scroll,BorderLayout.SOUTH);
		pack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	
	public void actionPerformed(ActionEvent ev)
	{
		String arg = ev.getActionCommand();
		
		//clear button to clear all fields
		if(arg.equals("Clear")) {
			nameField.setText("");
			idField.setText("");
			avgField.setText("");
			dptChoice.select("...");
			textArea.setText("");
		}
		
		//submit student information entered to instance of myclass
		else if (arg.equals("Submit"))
		{
			String name = nameField.getText();
			
			String idString = idField.getText();
			int id = Integer.parseInt(idString);
			
			String avgString = avgField.getText();
			double avg = Double.parseDouble(avgString);
			
			
			String dpt = dptChoice.getSelectedItem();
			
			Students s = new Students(name,id,avg,dpt);
			
			this.class1.getDetails(s);
			
			
		}
		
		//call putDetails method to save students in myclass to the text file
		else if (arg.equals("SaveToFile"))
		{
			
			
			this.class1.putDetails(this.txtFile);
			
			
		}
		
		//copy text from file to text area line by line
		else if (arg.equals("Show all"))
		{
			
			FileRead data = new FileRead(this.txtFile);
			String line = new String();
			
			
			
			try {
				
				// loop through text file reading it line by line 
				while((line = data.reader.readLine()) != null) {
					
				//append line to the text area
				textArea.append(line);
				textArea.append("\n");		
					 
				}
				data.reader.close();
				
				
			
			}
				catch(FileNotFoundException e) {}
				catch(IOException e) {}
			
		
		
					
			
		}
		
		//create new text file avg.txt, read students text file , iterate through tokens to the average and check if it's 
		// bigger than 80, if yes, copy line to the new text file avg.txt
		else if (arg.equals("NewFile")) 
		{
			 
			
			FileWrite dataWrite = new FileWrite("src/avg.txt");
			FileRead dataRead = new FileRead(this.txtFile);
			String line = new String();
			
			
			
			try {
				
				
				while((line = dataRead.reader.readLine()) != null) {
					
					//using tokens to split lines into tokens and then using nextToken twice to read
					//third token that's the average
					StringTokenizer token = new StringTokenizer(line);
					
					token.nextToken();
					
					token.nextToken();
					
					String avgString = token.nextToken();
					double avg = Double.parseDouble(avgString);
					
					if(avg>80.00) {
						
					dataWrite.writer.write(line);
					dataWrite.writer.write("\n");
					
					
					}
					
					
					
						
					 
				}
				dataRead.reader.close();
				dataWrite.writer.close();
				
				
			
			}
				catch(FileNotFoundException e) {}
				catch(IOException e) {}
			
		
		}
		
		
	}


		
	}
	

