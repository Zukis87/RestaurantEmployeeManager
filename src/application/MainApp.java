package application;

import java.io.IOException;

import employees.Employee;
import employees.EmployeeFactory;
import employees.EmployeeType;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<Employee> employeeData = FXCollections.observableArrayList();
	// private ObservableList<Shift> shiftData =
	// FXCollections.observableArrayList();
	private EmployeeFactory factory;

	public MainApp() {
		factory = EmployeeFactory.getInstance();
		employeeData.add(factory.createEmployee("Bill", "Foo", "0522443231", "SomeAddress 15 Herzliya", "03/01/1965",
				EmployeeType.Chef));
		employeeData.add(factory.createEmployee("Zuki", "Sarusi", "0523874254", "Arlozorov 33 Herzliya", "30/12/1987",
				EmployeeType.BarManager));
		employeeData.add(factory.createEmployee("Lolo", "Acid", "0522444454", "Arlozorov 1 Tel-Aviv", "03/02/1998",
				EmployeeType.ShiftManager));

	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("RestaurantManagerApp");

		initRootLayout();
		showemployeeOverview();
	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Shows the employee overview inside the root layout.
	 */
	public void showemployeeOverview() {
		try {
			// Load employee overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("ManagerOverview.fxml"));
			AnchorPane employeeOverview = (AnchorPane) loader.load();

			// Set employee overview into the center of root layout.
			rootLayout.setCenter(employeeOverview);

			// Give the controller access to the main app.
			ManagmantTabController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public ObservableList<Employee> getEmployeeData() {
		return employeeData;
	}

	public Employee showEmployeeEditDialog(boolean isNew, Employee employee) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("EmployeeEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			if (isNew) {
				dialogStage.setTitle("New Employee");
			} else {
				dialogStage.setTitle("Edit Employee");
			}
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the employee into the controller.
			EmployeeEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			if (isNew) {
				controller.newEmployee();
			} else {
				controller.setEmployee(employee);
			}
			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			if (controller.isOkClicked()) {
				return controller.getEmployee();
			}
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}