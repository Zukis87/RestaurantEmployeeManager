package logic;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import employees.Employee;
import employees.ShiftManager;

public class Shift {
	private Date date;
	private Map<ShiftManager, Integer> managers;
	private Map<Employee, Integer> waiters;
	private Map<Employee, Integer> bartenders;
	private Map<Employee, Integer> cooks;
	private Map<Employee, Integer> hostesses;
	private Map<Employee, Integer> cleaners;

	public Shift(Date date) {
		this.setDate(date);
		managers = new HashMap<ShiftManager, Integer>();
		waiters = new HashMap<Employee, Integer>();
		bartenders = new HashMap<Employee, Integer>();
		cooks = new HashMap<Employee, Integer>();
		hostesses = new HashMap<Employee, Integer>();
		cleaners = new HashMap<Employee, Integer>();
	}

	public Shift(Shift other) {
		managers = new HashMap<ShiftManager, Integer>(other.getManagers());
		waiters = new HashMap<Employee, Integer>(other.getWaiters());
		bartenders = new HashMap<Employee, Integer>(other.getBartenders());
		cooks = new HashMap<Employee, Integer>(other.getCooks());
		hostesses = new HashMap<Employee, Integer>(other.getHostesses());
		cleaners = new HashMap<Employee, Integer>(other.getCleaners());
	}

	public void addEmployee(Employee employee, int hoursInShift) {
		switch (employee.getType()) {
		case BarManager:
		case HostessManager:
		case ShiftManager:
			managers.put((ShiftManager) employee, hoursInShift);
			break;
		case Bartender:
			bartenders.put(employee, hoursInShift);
			break;
		case Cook:
			cooks.put(employee, hoursInShift);
			break;
		case Hostess:
			hostesses.put(employee, hoursInShift);
			break;
		case Waiter:
			waiters.put(employee, hoursInShift);
			break;
		case Cleaner:
			cleaners.put(employee, hoursInShift);
			break;
		default:
			break;
		}
	}

	public Map<ShiftManager, Integer> getManagers() {
		return managers;
	}

	public Map<Employee, Integer> getWaiters() {
		return waiters;
	}

	public Map<Employee, Integer> getBartenders() {
		return bartenders;
	}

	public Map<Employee, Integer> getCooks() {
		return cooks;
	}

	public Map<Employee, Integer> getHostesses() {
		return hostesses;
	}

	public Map<Employee, Integer> getCleaners() {
		return cleaners;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Map<Employee, Integer> getAllEmployees() {
		Map<Employee, Integer> allEmployees = new HashMap<Employee, Integer>();
		allEmployees.putAll(managers);
		allEmployees.putAll(waiters);
		allEmployees.putAll(bartenders);
		allEmployees.putAll(cooks);
		allEmployees.putAll(hostesses);
		allEmployees.putAll(cleaners);
		return allEmployees;
	}
}