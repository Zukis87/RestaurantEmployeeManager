package employees;

public class SalaryCalculatorVisitor implements EmployeesVisitor {
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
		total += employeeWithBonus.getHoursWorked() * employeeWithBonus.getSalary() + employeeWithBonus.getBonus();
	}

	@Override
	public void visit(Chef chef) {
		total += chef.getSalary();
	}
	public int getTotalEmployeesSalary(){
		return this.total;
	}
}
