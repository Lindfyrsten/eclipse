package guifx;

import application.service.Service;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() {
        Service.init();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Sønderhøj Netcafé reservation");
        BorderPane pane = new BorderPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

        Tab tabCompanies = new Tab("Reservationer");
        tabPane.getTabs().add(tabCompanies);

// CompanyPane companyPane = new CompanyPane();
// tabCompanies.setContent(companyPane);
// tabCompanies.setOnSelectionChanged(event -> companyPane.updateControls());

        Tab tabEmployees = new Tab("Employees");
        tabPane.getTabs().add(tabEmployees);

// EmployeePane employeePane = new EmployeePane();
// tabEmployees.setContent(employeePane);
// tabEmployees.setOnSelectionChanged(event -> employeePane.updateControls());

        Tab tabCustomer = new Tab("Medlemmer");
        tabPane.getTabs().add(tabCustomer);

        CustomerPane customerPane = new CustomerPane();
        tabCustomer.setContent(customerPane);
        tabCustomer.setOnSelectionChanged(event -> customerPane.updateControls());

    }

}
