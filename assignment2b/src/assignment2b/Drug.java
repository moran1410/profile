package assignment2b;

public class Drug {
 
	
 String name;
 int drugID;
 double price;
 
//constructor 
public Drug(String name, int drugID, double price) {
	super();
	this.name = name;
	this.drugID = drugID;
	this.price = price;
}

// getters setters
public String getName() {
	return name;
}


public int getDrugID() {
	return drugID;
}


public double getPrice() {
	return price;
}


public void setName(String name) {
	this.name = name;
}


public void setDrugID(int drugID) {
	this.drugID = drugID;
}


public void setPrice(double price) {
	this.price = price;
}
 
 
 
}
