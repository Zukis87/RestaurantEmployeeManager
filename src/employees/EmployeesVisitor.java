package employees;

public interface EmployeesVisitor {

	public void visit(SimpleEmployee simpleEmployee);

	public void visit(ShiftManager shiftManager);

	public void visit(EmployeeWithBonus employeeWithBonus);

	public void visit(Chef chef);
}
