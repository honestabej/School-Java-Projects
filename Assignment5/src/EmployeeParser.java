public class EmployeeParser {

	public static Employee parseStringToEmployee(String lineToParse) {

		String[] employeeData = lineToParse.split(":");

		if(employeeData[0].equalsIgnoreCase("FullTimeEmployee")) {
			return new FullTimeEmployee(employeeData[1],employeeData[2],employeeData[3],Double.parseDouble(employeeData[4]),Double.parseDouble(employeeData[5]));
		} else if(employeeData[0].equalsIgnoreCase("PartTimeEmployee")) {
			return new PartTimeEmployee(employeeData[1],employeeData[2],employeeData[3],Double.parseDouble(employeeData[4]),Integer.parseInt(employeeData[5]));
		} else return null;

		
	}

}
