package employees;
//the Factory design pattern
public class EmployeeFactory { 
	private static Chef chef = Chef.getInstance();
	private static int id = 2;
	private static EmployeeFactory factory = new EmployeeFactory();

	private EmployeeFactory() {
	}

	public static EmployeeFactory getInstance() {
		return factory;
	}
// can make a decorated object by the type of the requested employee.
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
			//an example to the creation of a decorated employee
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
}
