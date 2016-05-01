package employees;

public class Chef implements Employee {
	private static Chef chef = new Chef();
	private int id = 1;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	private String birthday;
	private double totalHoursWorked;
	private EmployeeType type = EmployeeType.Chef;
	private double salary = type.getSalary();

	private Chef() {
	}

	public static Chef getInstance() {
		return chef;
	}

	public static Chef getChef() {
		return chef;
	}

	public static void setChef(Chef chef) {
		Chef.chef = chef;
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

	public void acceptEmployeeVisitor(EmployeesVisitor visitor) {
		visitor.visit(this);
	}

	public String getFullName() {
		return firstName + " " + lastName;
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
