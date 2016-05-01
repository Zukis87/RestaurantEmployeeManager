package employees;

public class EmployeeWithBonus extends EmployeeDecorator {
	private double bonus;

	public EmployeeWithBonus(Employee employeeToBeDecorated) {
		super(employeeToBeDecorated);
		setBonus(employeeToBeDecorated.getType().getSalary());
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public void acceptEmployeeVisitor(EmployeesVisitor visitor) {
		visitor.visit(this);
	}
}
