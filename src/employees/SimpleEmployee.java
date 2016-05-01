package employees;

public class SimpleEmployee implements Employee {

	private int id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	private String birthday;
	private double salary;
	private EmployeeType type;
	private double totalHoursWorked;

	public SimpleEmployee(int id, String firstName, String lastName, String phone, String address, String birthday,
			EmployeeType type) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
		this.type = type;
		this.addHoursWorked(0);
		this.setSalary(type.getSalary());
	}

	public SimpleEmployee(Employee other) {
		this.id = other.getId();
		this.firstName = other.getFirstName();
		this.lastName = other.getLastName();
		this.phone = other.getPhone();
		this.address = other.getAddress();
		this.birthday = other.getBirthday();
		this.setSalary(other.getType().getSalary());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public EmployeeType getType() {
		return type;
	}

	public void setType(EmployeeType type) {
		this.type = type;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public void acceptEmployeeVisitor(EmployeesVisitor visitor) {
		visitor.visit(this);
	}

	public double getHoursWorked() {
		return totalHoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		this.totalHoursWorked = hoursWorked;
	}

	public void addHoursWorked(double hoursWorked) {
		this.totalHoursWorked += hoursWorked;
	}

}