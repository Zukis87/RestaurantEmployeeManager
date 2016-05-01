package employees;

public class ShiftManager extends EmployeeDecorator {

	public ShiftManager(Employee employeeToBeDecorated) {
		super(employeeToBeDecorated);
		setSalary(EmployeeType.ShiftManager.getSalary());
	}

	public void acceptEmployeeVisitor(EmployeesVisitor visitor) {
		visitor.visit(this);
	}
}