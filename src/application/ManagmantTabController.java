package application;

import employees.Employee;
import employees.EmployeeType;
import employees.SalaryCalculatorVisitor;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ManagmantTabController {
	@FXML
	private TableView<Employee> employeeTable;
	@FXML
	private TableColumn<Employee, String> nameColumn;
	@FXML
	private TableColumn<Employee, String> typeColumn;

	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label addressLabel;
	@FXML
	private Label phoneLabel;
	@FXML
	private Label birthdayLabel;
	@FXML
	private Label idLabel;
	@FXML
	private Label typeLabel;
	@FXML
	private Label currentEmployeeLable;
	@FXML
	private Label employeeByTypeLable;
	@FXML
	private Label allEmployeesLable;
	@FXML
	private Label totalHoursLable;
	@FXML
	private TextField hoursField;
	@FXML
	private ComboBox<EmployeeType> employeeTypeComboBox;

	// Reference to the main application.
	private MainApp mainApp;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public ManagmantTabController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Initialize the employee table with the two columns.
		employeeTypeComboBox.setItems(FXCollections.observableArrayList(EmployeeType.values()));
		allEmployeesLable.setText("");
		employeeByTypeLable.setText("");
		nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFullName()));
		typeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType().name()));
		// Clear employee details.
		showEmployeeDetails(null);
		// Listen for selection changes and show the employee details when
		// changed.
		employeeTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showEmployeeDetails(newValue));
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	private void showEmployeeDetails(Employee employee) {
		if (employee != null) {
			// Fill the labels with info from the employee object.
			firstNameLabel.setText(employee.getFirstName());
			lastNameLabel.setText(employee.getLastName());
			addressLabel.setText(employee.getAddress());
			phoneLabel.setText(employee.getPhone());
			birthdayLabel.setText(employee.getBirthday());
			idLabel.setText(Integer.toString(employee.getId()));
			typeLabel.setText(employee.getType().name());
			totalHoursLable.setText(Double.toString(employee.getHoursWorked()));
			currentEmployeeLable.setText(Integer.toString(getCurrentEmployeeSalary()));
			employeeTypeComboBox.setValue(employee.getType());

			// TODO: We need a way to convert the birthday into a String!
			// birthdayLabel.setText(...);
		} else {
			// employee is null, remove all the text.
			firstNameLabel.setText("");
			lastNameLabel.setText("");
			addressLabel.setText("");
			phoneLabel.setText("");
			birthdayLabel.setText("");
			idLabel.setText("");
			typeLabel.setText("");
			currentEmployeeLable.setText("");
			totalHoursLable.setText("");
			employeeTypeComboBox.setValue(EmployeeType.Waiter);
		}
	}

	@FXML
	private void handleRemoveEmployee() {
		int selectedIndex = employeeTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			if (employeeTable.getSelectionModel().getSelectedItem().getType().equals(EmployeeType.Chef)) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.initOwner(mainApp.getPrimaryStage());
				alert.setTitle("Can't Remove Chef");
				alert.setHeaderText("The restaurant can't run without a Chef.");
				alert.setContentText("Please select Edit to replace the Chef.");
				alert.showAndWait();
			} else {
				employeeTable.getItems().remove(selectedIndex);
			}
		} else {
			alertNoSelection();
		}
	}

	private void alertNoSelection() {
		// Nothing selected.
		Alert alert = new Alert(AlertType.WARNING);
		alert.initOwner(mainApp.getPrimaryStage());
		alert.setTitle("No Selection");
		alert.setHeaderText("No Employee Selected");
		alert.setContentText("Please select a employee in the table.");
		alert.showAndWait();
	}

	@FXML
	private void handleNewEmployee() {
		Employee returndEmployee = mainApp.showEmployeeEditDialog(true, null);
		if (returndEmployee != null) {
			mainApp.getEmployeeData().add(returndEmployee);
		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected employee.
	 */
	@FXML
	private void handleEditEmployee() {
		Employee selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();
		if (selectedEmployee != null) {
			Employee returndEmployee = mainApp.showEmployeeEditDialog(false, selectedEmployee);
			if (returndEmployee != null) {
				showEmployeeDetails(selectedEmployee);
				employeeTable.refresh();
			}

		} else {
			alertNoSelection();
		}
	}
	//the usage of the SalaryCalculatorVisitor:
	public int getAllEmployeesSalary() { 
		SalaryCalculatorVisitor visitor = new SalaryCalculatorVisitor();
		if (mainApp.getEmployeeData() != null) {
			for (Employee employee : mainApp.getEmployeeData()) {
				employee.acceptEmployeeVisitor(visitor);
			}
		}
		return visitor.getTotalEmployeesSalary();
	}

	public int getEmployeesSalaryByType(EmployeeType type) {
		SalaryCalculatorVisitor visitor = new SalaryCalculatorVisitor();
		if (mainApp.getEmployeeData() != null) {
			for (Employee employee : mainApp.getEmployeeData()) {
				if (employee.getType().equals(type)) {
					employee.acceptEmployeeVisitor(visitor);
				}
			}
		}
		return visitor.getTotalEmployeesSalary();
	}

	public int getCurrentEmployeeSalary() {
		SalaryCalculatorVisitor visitor = new SalaryCalculatorVisitor();
		Employee selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();
		selectedEmployee.acceptEmployeeVisitor(visitor);
		return visitor.getTotalEmployeesSalary();
	}

	@FXML
	private void handleCalculateSalaries() {
		allEmployeesLable.setText(Integer.toString(getAllEmployeesSalary()));
		employeeByTypeLable.setText(Integer.toString(getEmployeesSalaryByType(employeeTypeComboBox.getValue())));
	}

	@FXML
	private void handleAddHours() {
		Employee selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();
		if (selectedEmployee != null) {
			selectedEmployee.addHoursWorked(Double.parseDouble(hoursField.getText()));
			hoursField.setText("");
			showEmployeeDetails(selectedEmployee);
			employeeTable.refresh();
		} else {
			alertNoSelection();
		}
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		// Add observable list data to the table
		employeeTable.setItems(mainApp.getEmployeeData());
	}

}
