
public class FullTimeEmployee extends Employee {
	private double salaryFullTime;
	private double bonusFullTime;
	
	public FullTimeEmployee(String firstName, String lastName, String employeeID, double salary, double bonus) {
		super(firstName, lastName, employeeID);
		salaryFullTime = salary;
		bonusFullTime = bonus;
		
	}
	
	public void computePayAmount() {
		payAmountEmp = salaryFullTime + bonusFullTime;
	}
	
	public String toString() {
		return String.format("\nFull Time Employee:\n"
							+ "First Name:\t\t"+firstNameEmp+"\n"
							+ "Last Name:\t\t"+lastNameEmp+"\n"
							+ "Employee ID:\t\t"+employeeIDEmp+"\n"
							+ "Pay Amount:\t\t"+payAmountEmp+"\n"
							+ "Salary:\t\t"+salaryFullTime+"\n"
							+ "Bonus:\t\t"+bonusFullTime);
	}

}
