package employees;

public interface Employee {

	public int getId();

	public void setId(int id);

	public String getFirstName();

	public void setFirstName(String firstName);

	public String getLastName();

	public void setLastName(String lastName);

	public String getPhone();

	public void setPhone(String phone);

	public String getAddress();

	public void setAddress(String address);

	public String getBirthday();

	public void setBirthday(String birthday);

	public double getSalary();

	public void setSalary(double salary);

	public EmployeeType getType();

	public void setType(EmployeeType type);

	public String getFullName();

	public double getHoursWorked();
	
	public void setHoursWorked(double hoursWorked);
	
	public void addHoursWorked(double hoursWorked);
//method to implement the acceptance of the visitor:
	public void acceptEmployeeVisitor(EmployeesVisitor visitor);

}