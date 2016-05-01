package application;

import employees.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import logic.Shift;

public class ShiftsTabController {
	@FXML
	private TableView<Shift> shiftTable;
	@FXML
	private TableColumn<Shift, Employee> managersColumn;
	@FXML
	private TableColumn<Shift, Employee> waitersColumn;
	@FXML
	private TableColumn<Shift, Employee> bartendersColumn;
	@FXML
	private TableColumn<Shift, Employee> HostessesColumn;
	@FXML
	private TableColumn<Shift, Employee> cooksColumn;
	@FXML
	private TableColumn<Shift, Employee> cleanersColumn;
	@SuppressWarnings("unused")
	private MainApp mainApp;

	public ShiftsTabController() {
	}
	@FXML
	private void initialize() {
//		// Initialize the employee table with the two columns.
//		managersColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<Employee>());
//		typeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType().name()));
//		// Clear employee details.
//		showEmployeeDetails(null);
//
//		// Listen for selection changes and show the employee details when
//		// changed.
//		employeeTable.getSelectionModel().selectedItemProperty()
//				.addListener((observable, oldValue, newValue) -> showEmployeeDetails(newValue));
	}
}
