package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import employees.Employee;
import employees.EmployeeFactory;
import employees.EmployeeType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EmployeeEditDialogController {

	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField addressField;
	@FXML
	private TextField phoneField;
	@FXML
	private ComboBox<EmployeeType> typeCB;
	@FXML
	private TextField birthdayField;
	// private DatePicker birthdayDatePicker;

	private Stage dialogStage;
	private Employee employee;
	private boolean okClicked = false;
	private boolean isNew = false;
	private EmployeeFactory factory = EmployeeFactory.getInstance();

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
	}

	/**
	 * Sets the stage of this dialog.
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Sets the employee to be edited in the dialog.
	 * 
	 * @param employee
	 */
	public void newEmployee() {
		isNew = true;
		firstNameField.setText("");
		lastNameField.setText("");
		addressField.setText("");
		phoneField.setText("");
		birthdayField.setText("");
		List<EmployeeType> types = new ArrayList<>(Arrays.asList(EmployeeType.values()));
		types.remove(EmployeeType.Chef);
		typeCB.setItems(FXCollections.observableArrayList(types));
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
		firstNameField.setText(employee.getFirstName());
		lastNameField.setText(employee.getLastName());
		addressField.setText(employee.getAddress());
		phoneField.setText(employee.getPhone());
		birthdayField.setText(employee.getBirthday());
		List<EmployeeType> types = new ArrayList<>(Arrays.asList(EmployeeType.values()));
		types.remove(EmployeeType.Chef);
		typeCB.setItems(FXCollections.observableArrayList(types));
		if(employee.getType().equals(EmployeeType.Chef)){
			typeCB.setDisable(true);
		}
		typeCB.setValue(employee.getType());
		
		// birthdayDatePicker = new DatePicker(LocalDate.now());
	}

	/**
	 * Returns true if the user clicked OK, false otherwise.
	 * 
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Called when the user clicks ok.
	 */
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			if (isNew) {
				employee = factory.createEmployee(firstNameField.getText(), lastNameField.getText(), phoneField.getText(),
						addressField.getText(), birthdayField.getText(), typeCB.getValue());
			} else {
				employee.setFirstName(firstNameField.getText());
				employee.setLastName(lastNameField.getText());
				employee.setAddress(addressField.getText());
				employee.setPhone(phoneField.getText());
				employee.setBirthday(birthdayField.getText());
				employee = factory.changeEmployeeType(employee, typeCB.getValue());
			}
			okClicked = true;
			dialogStage.close();
		}
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	/**
	 * Validates the user input in the text fields.
	 * 
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (isEmptyText(firstNameField)) {
			errorMessage += "No valid first name!\n";
		}
		if (isEmptyText(lastNameField)) {
			errorMessage += "No valid last name!\n";
		}
		if (isEmptyText(addressField)) {
			errorMessage += "No valid Address!\n";
		}

		if (isEmptyText(phoneField)) {
			errorMessage += "No valid Phone Number!\n";
		}
		if (isEmptyText(birthdayField)) {
			errorMessage += "No valid birthday!\n";
		}
		if (typeCB.getValue() == null) {
			errorMessage += "No type Selected!\n";
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
			return false;
		}
	}

	private boolean isEmptyText(TextField tf) {
		return tf.getText() == null || tf.getText().length() == 0;
	}
	public Employee getEmployee(){
		return this.employee;
	}
}
