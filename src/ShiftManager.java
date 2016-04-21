import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShiftManager implements Employee {

	private int id;
	private String name;
	private double salary;

	public ShiftManager(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	List<Employee> employees = new ArrayList<Employee>();

	public void add(Employee employee) {
		employees.add(employee);
	}

	public Employee getChild(int i) {
		return employees.get(i);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public void print() {
		System.out.println("-------------");
		System.out.println("Name =" + getName());
		System.out.println("Salary =" + getSalary());
		System.out.println("-------------");

		Iterator<Employee> employeeIterator = employees.iterator();
		while (employeeIterator.hasNext()) {
			Employee employee = employeeIterator.next();
			employee.print();
		}
	}

	public void remove(Employee employee) {
		employees.remove(employee);
	}

}