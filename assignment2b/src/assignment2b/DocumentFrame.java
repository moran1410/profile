package assignment2b;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class DocumentFrame extends JFrame implements ActionListener {

	
	
		//input fields 
		JTextField custID = new JTextField(18);
		JTextField drugID = new JTextField(18);
		JTextField amount = new JTextField(18);
		
		
		
		
		
		//action buttons
		JButton addDrug = new JButton("Add drug type");
		JButton addCust = new JButton("Add customer");
		JButton sendOrder = new JButton("Send order");
		JButton clearButton = new JButton("Clear");
		
		
		
		
		
		// constructor of the JFrame
		public DocumentFrame ()
		{
			super("Order form");
			
			
			// text fields panel
			JPanel panel1 = new JPanel(new GridLayout(0,2));
			panel1.add(new Label("Customer ID:"));
			panel1.add(custID);
			panel1.add(new Label("Drug ID:"));
			panel1.add(drugID);
			panel1.add(new Label("Amount:"));
			panel1.add(amount);
			
			// buttons panel with action listener method
			JPanel panel2 = new JPanel(new FlowLayout());
			panel2.add(addDrug);
			addDrug.addActionListener(this);
			
			panel2.add(addCust);
			addCust.addActionListener(this);
			
			panel2.add(sendOrder);
			sendOrder.addActionListener(this);
			
			panel2.add(clearButton);
			clearButton.addActionListener(this);
			
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
			
			if(arg.equals("Add drug type")) 
			{
				this.setVisible(false);
				new DrugFrame(this);
				
				
			
				
			}
			if(arg.equals("Add customer")) 
			{
				this.setVisible(false);
				new CustFrame(this);
				
				
			
				
			}
		}

}
