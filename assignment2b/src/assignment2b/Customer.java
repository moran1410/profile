package assignment2b;

public class Customer {
	String name = "";
	int customerID;
	
	
//constructor	
	public Customer(String name, int customerID) {
		super();
		this.name = name;
		this.customerID = customerID;
	}
//getters setters 
	public String getName() {
		return name;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	
	
	
}
