package employees;

public class EmployeeFactory {
	private static Chef chef = Chef.getInstance();
	private static int id = 2;
	private static EmployeeFactory factory = new EmployeeFactory();

	private EmployeeFactory() {
	}

	public static EmployeeFactory getInstance() {
		return factory;
	}

	public Employee createEmployee(String firstName, String lastName, String phone, String address, String birthday,
			EmployeeType type) {
		switch (type) {
		case Bartender:
		case Waiter:
		case Cook:
		case Hostess:
		case Cleaner:
			return new SimpleEmployee(id++, firstName, lastName, phone, address, birthday, type);
		case ShiftManager:
			return new ShiftManager(new SimpleEmployee(id++, firstName, lastName, phone, address, birthday, type));

		case HostessManager:
		case BarManager:
			return new EmployeeWithBonus(
					new ShiftManager(new SimpleEmployee(id++, firstName, lastName, phone, address, birthday, type)));
		case Chef:
			chef.setFirstName(firstName);
			chef.setLastName(lastName);
			chef.setPhone(phone);
			chef.setAddress(address);
			chef.setBirthday(birthday);
			return chef;
		default:
			return null;
		}
	}
	
	public Employee changeEmployeeType(Employee employee, EmployeeType newType) {
		switch (newType) {
		case Bartender:
		case Waiter:
		case Cook:
		case Hostess:
		case Cleaner:
			employee.setType(newType);
			if (employee instanceof SimpleEmployee) {
				return employee;
			} else {
				return new SimpleEmployee(employee);
			}
		case ShiftManager:
			employee.setType(newType);
			if (employee instanceof SimpleEmployee) {
				return new ShiftManager(employee);
			} else {
				return new ShiftManager(new SimpleEmployee(employee));
			}
		case HostessManager:
		case BarManager:
			employee.setType(newType);
			if (employee instanceof SimpleEmployee) {
				return new EmployeeWithBonus(new ShiftManager(employee));
			} else if (employee instanceof ShiftManager) {
				return new EmployeeWithBonus(employee);
			} else {
				return employee;
			}
		case Chef:
			chef.setFirstName(employee.getFirstName());
			chef.setLastName(employee.getLastName());
			chef.setPhone(employee.getPhone());
			chef.setAddress(employee.getAddress());
			chef.setBirthday(employee.getBirthday());
			return chef;
		default:
			return null;
		}
	}
}
