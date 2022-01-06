
public class PartTimeEmployee extends Employee{
	private double hourlyRatePartTime;
	private int hoursPartTime;
	
	public PartTimeEmployee(String firstName, String lastName, String employeeID, double hourlyRate, int hours) {
		super(firstName, lastName, employeeID);
		hourlyRatePartTime = hourlyRate;
		hoursPartTime = hours;
	}
	
	public void computePayAmount() {
		payAmountEmp = hourlyRatePartTime * hoursPartTime;
	}
	
	public String toString() {
		return String.format("\nPart Time Employee:\n"
							+ "First Name:\t\t"+firstNameEmp+"\n"
							+ "Last Name:\t\t"+lastNameEmp+"\n"
							+ "Employee ID:\t\t"+employeeIDEmp+"\n"
							+ "Pay Amount:\t\t"+payAmountEmp+"\n"
							+ "Hourly Rate:\t\t"+hourlyRatePartTime+"\n"
							+ "Hours:\t\t"+hoursPartTime);
	}	

}
