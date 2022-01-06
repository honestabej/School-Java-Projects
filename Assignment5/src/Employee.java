
public abstract class Employee {
	protected String firstNameEmp;
	protected String lastNameEmp;
	protected String employeeIDEmp;
	protected double payAmountEmp;
	
	
	public Employee(String firstName, String lastName, String employeeID) {
		this.firstNameEmp = firstName;
		this.lastNameEmp = lastName;
		this.employeeIDEmp = employeeID;
		payAmountEmp = 0.0;
	}
	
	public String getEmployeeID() {
		return employeeIDEmp;
	}
	
	public abstract void computePayAmount();
		
	public String toString() {
		return String.format("\nFirst name:\t\t"+firstNameEmp+"\n"
							+ "Last name:\t\t"+lastNameEmp+"\n"
							+ "Employee ID:\t\t"+employeeIDEmp+"\n"
							+ "Pay Amount:\t\t"+payAmountEmp+"\n");
	}
	

}
