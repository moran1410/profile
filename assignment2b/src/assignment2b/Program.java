package assignment2b;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Program {
	
	//method to check if the input contains numbers and $ symbol only	
	public static boolean inputCorrect(String s) {
		//split accepted input into characters
		String acceptedInput="0123456789$";
		char[] charArr = acceptedInput.toCharArray();
		 
		List<Character> charAL = new ArrayList<Character>();
		
		//store all accepted characters in a new arraylist
		//to use method contains()
		for(char c1: charArr )
		{
			charAL.add(c1);
		}
		
		//check if every character from the user input
		// is either numeric or $
		for(char c2: s.toCharArray())
		{
			if(!charAL.contains(c2))
				return false;
			else
				continue;
		}
	return true;
	}
	
	//method to check if user input string is numeric

	public static boolean isNumeric(String s)
	{
		if (s == null || s.length() == 0) {
		      return false;
		    } else {
		      for (char c : s.toCharArray()) {
		        if (!Character.isDigit(c)) {
		          return false;
		        }
		      }
		    }
		    return true;
	}
			
	

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

	DocumentFrame mainMenu = new DocumentFrame();
	Socket socket = null;
	
	DataInputStream dis;
	PrintStream ps;
	String userInput = "";
	
	try 
	{
		//  listen to port 7000 continuously until a user connects 
		// when connected print out message to console
		ServerSocket server1 = new ServerSocket(7000);
		socket = server1.accept();
		System.out.println("New user connected.." + 
		socket.getInetAddress() + " " + socket.getPort());
	
	
	//initialize output and input streams
		dis = new DataInputStream(socket.getInputStream());
		ps = new PrintStream(socket.getOutputStream());
	
	//send message to user 
		ps.println("Connected successfully to " + socket.getLocalAddress());
	
	//loop until user decides to end connection by sending "x"
		while(!userInput.equals("x"))
		{
			
			//read line from user input and store it in a string
			userInput=dis.readLine();
			System.out.println("from user - " + socket.getInetAddress()+": "+
			userInput);
			
			//check if string consists of integers and $ by splitting it 
			String[] splitInput = userInput.split(Pattern.quote("$"));
			System.out.println(splitInput.length);
			System.out.println(splitInput[1]);
			for(String s9: splitInput) {
				System.out.println(s9);	
					
			}
			
			//after split userINput is stored in an array of strings
			//we check that its length is 3 as we are expecting
			// (123,&,123,&,123) and then check if it is  
			// the characters used are only numbers and "$"
			if(splitInput.length==3&&inputCorrect(userInput))
			{
				//retrieve the information required form the input
				String drugID = splitInput[1];
				String strAmount = splitInput[2];
				int amount = Integer.parseInt(strAmount);
				double totalPrice;
				
				//initiate connection to database 
				Connection con;
				try {
					con = ConnectionWAMP.getConn();
					Statement statement;
					ResultSet resultSet;
					String sqlQuery;
					
					
					//run SQL query and store the result in resultset
					
						sqlQuery = "SELECT `price` FROM `drug` WHERE `drugID`="+drugID;
						statement = con.createStatement();
						resultSet = statement.executeQuery(sqlQuery);
						
						//as we are expecting a double to be returned we use getDouble at column 1
						//the we multiply it with the amount received from user input 
						resultSet.next();
						totalPrice = amount*resultSet.getDouble(1);
						
						//send stream to user with total price
						ps.println("The price for amount: " + strAmount + " of drug ID: "
								+ drugID + " is: " + totalPrice);
					
					
					
					
					
					
					con.close();
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
			
				
				
			}
			else
			{
				ps.println("input format incorrect !");
			}
		}
	server1.close();
	socket.close();
	}
	
	
	catch(Exception e)
	{
		System.err.println(e);
	}
	
	
	
	
	}

}
