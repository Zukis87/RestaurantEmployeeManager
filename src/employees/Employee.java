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

	public int getHoursWorked();

	public void addHoursWorked(int hoursWorked);

	public void acceptEmployeeVisitor(EmployeesVisitor visitor);

}