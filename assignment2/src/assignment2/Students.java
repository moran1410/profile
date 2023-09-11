package assignment2;

public class Students {

	String name;
	int id;
	double average;
	String department;
	
	//constructor
	public Students(String name, int id, double average, String department) {
		super();
		this.name = name;
		this.id = id;
		this.average = average;
		this.department = department;
	}

	
	//getters setters
	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public double getAverage() {
		return average;
	}

	public String getDepartment() {
		return department;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
