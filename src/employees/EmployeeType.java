package employees;

public enum EmployeeType {
	Cleaner(20), Waiter(25), Bartender(40), Hostess(35), Cook(35), ShiftManager(50), HostessManager(3000), BarManager(
			4000), Chef(20000);

	private final double salary;

	EmployeeType(double salary) {
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}
}
