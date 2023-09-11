package assignment2b;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CustFrame extends JFrame implements ActionListener  {

	public DocumentFrame df;
	 
			//input fields 
			JTextField name = new JTextField(18);
			JTextField custID = new JTextField(18);
			
			
			//action buttons
			JButton mainMenu = new JButton("Main menu");
			JButton add = new JButton("Add");
			JButton clear = new JButton("Clear");
			
			
			
			
			
			// constructor of the JFrame
		public CustFrame(DocumentFrame df)
			{
				super("Add customer form");
				this.df = df;
				df.setVisible(false);
				// text fields panel
				JPanel panel1 = new JPanel(new GridLayout(0,2));
				panel1.add(new Label("Name:"));
				panel1.add(name);
				panel1.add(new Label("Customer ID:"));
				panel1.add(custID);
				
				// buttons panel with action listener method
				JPanel panel2 = new JPanel(new FlowLayout());
				panel2.add(mainMenu);
				mainMenu.addActionListener(this);
				
				panel2.add(add);
				add.addActionListener(this);
				
				panel2.add(clear);
				clear.addActionListener(this);
				
				
				//main window
				setLayout(new BorderLayout());
				add(panel1,BorderLayout.NORTH);
				add(panel2,BorderLayout.SOUTH);
				pack();
				this.setVisible(true);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setSize(700,350);
			}

	
	
	
	
	public void actionPerformed(ActionEvent e) {
		
	
		String arg = e.getActionCommand();
		
		if(arg.equals("Main menu")) 
		{
			this.setVisible(false);
			this.df.setVisible(true);
		}
		
		if(arg.equals("Add")) 
		{
			String custName = name.getText();
			String stringCustID = custID.getText();
			int intCustID = Integer.parseInt(stringCustID);
			
		
			Connection con;
			try {
			//using WAMP connection class to start connection with database
				con = ConnectionWAMP.getConn();
				Statement statement;
				
				String sqlQuery;
				
				
				//sql query to be sent to the sql database 
					sqlQuery = "INSERT INTO `assignment2b`.`customer` (`custID`, `name` ) "
							+ "VALUES ('"+ intCustID + "', '" + custName+" '); ";
					statement = con.createStatement();
					statement.execute(sqlQuery);
					
				
				
				
				
				
				
				con.close();
			}
			catch(Exception ex) {
				System.out.println(ex);
			}
		
		
		
		}
		
		if(arg.equals("Clear")) 
		{
			name.setText("");
			custID.setText("");
			
		}
		
	}

}
