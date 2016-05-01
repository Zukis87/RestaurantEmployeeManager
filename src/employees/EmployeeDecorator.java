package employees;

public abstract class EmployeeDecorator implements Employee{
	protected Employee employeeToBeDecorated;

	public EmployeeDecorator(Employee employeeToBeDecorated){
		this.employeeToBeDecorated = employeeToBeDecorated;
	}
	public int getId() {
		return employeeToBeDecorated.getId();
	}

	public void setId(int id) {
		employeeToBeDecorated.setId(id);
	}

	public String getFirstName() {
		return employeeToBeDecorated.getFirstName();
	}

	public void setFirstName(String firstName) {
		employeeToBeDecorated.setFirstName(firstName);
	}

	public String getLastName() {
		return employeeToBeDecorated.getLastName();
	}

	public void setLastName(String lastName) {
		employeeToBeDecorated.setLastName(lastName);
	}

	public String getPhone() {
		return employeeToBeDecorated.getPhone();
	}

	public void setPhone(String phone) {
		employeeToBeDecorated.setPhone(phone);
	}

	public String getAddress() {
		return employeeToBeDecorated.getAddress();
	}

	public void setAddress(String address) {
		employeeToBeDecorated.setAddress(address);
	}

	public String getBirthday() {
		return employeeToBeDecorated.getBirthday();
	}

	public void setBirthday(String birthday) {
		employeeToBeDecorated.setBirthday(birthday);
	}

	public double getSalary() {
		return employeeToBeDecorated.getSalary();
	}

	public void setSalary(double salary) {
		employeeToBeDecorated.setSalary(salary);
	}

	public EmployeeType getType() {
		return employeeToBeDecorated.getType();
	}

	public void setType(EmployeeType type) {
		employeeToBeDecorated.setType(type);
	}
	public String getFullName(){
		return employeeToBeDecorated.getFullName();
	}
	public double getHoursWorked() {
		return employeeToBeDecorated.getHoursWorked();
	}

	public void addHoursWorked(double hoursWorked) {
		employeeToBeDecorated.addHoursWorked(hoursWorked);
	}
	public void setHoursWorked(double hoursWorked) {
		employeeToBeDecorated.setHoursWorked(hoursWorked);
	}
}
