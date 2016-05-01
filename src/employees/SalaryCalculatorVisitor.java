package employees;

public class SalaryCalculatorVisitor implements EmployeesVisitor {
	private final int HOURS_IN_WORK_DAY = 8;
	private final int DAYS_IN_WORK_MONTH = 22;
	private int total = 0;

	@Override
	public void visit(SimpleEmployee simpleEmployee) {
		total += simpleEmployee.getHoursWorked() * simpleEmployee.getSalary();
	}

	@Override
	public void visit(ShiftManager shiftManager) {
		total += shiftManager.getHoursWorked() * shiftManager.getSalary();
	}

	@Override
	public void visit(EmployeeWithBonus employeeWithBonus) {
		total += employeeWithBonus.getHoursWorked() * employeeWithBonus.getSalary()
				+ (employeeWithBonus.getBonus() * hoursToMonthes(employeeWithBonus.getHoursWorked()));
	}

	@Override
	public void visit(Chef chef) {
		total += chef.getSalary() * hoursToMonthes(chef.getHoursWorked());
	}

	public int getTotalEmployeesSalary() {
		return this.total;
	}

	public int hoursToMonthes(double hours) {
		return (int) (hours / HOURS_IN_WORK_DAY / DAYS_IN_WORK_MONTH);
	}
}
