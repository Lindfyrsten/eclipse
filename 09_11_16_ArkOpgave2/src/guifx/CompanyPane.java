package guifx;

import java.util.Optional;

import application.model.Company;
import application.model.Costumer;
import application.model.Employee;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class CompanyPane extends GridPane {
    private TextField txfName, txfHours;
    private TextArea txaEmps, txaCostumers;
    private ListView<Company> lvwCompanies;

    public CompanyPane() {
        setPadding(new Insets(20));
        setHgap(20);
        setVgap(10);
//        setGridLinesVisible(true);

        Label lblComp = new Label("Companies");
        this.add(lblComp, 0, 0);
        
        lvwCompanies = new ListView<>();
        this.add(lvwCompanies, 0, 1, 1, 4);
        lvwCompanies.setPrefWidth(200);
        lvwCompanies.setPrefHeight(200);
        lvwCompanies.getItems().setAll(Service.getCompanies());
        
        ChangeListener<Company> companyListener = (ov, oldCompny, newCompany) -> selectionChanged();
        lvwCompanies.getSelectionModel().selectedItemProperty().addListener(companyListener);
        
        Label lblName = new Label("Name:");
        this.add(lblName, 1, 1);

        txfName = new TextField();
        this.add(txfName, 2, 1);
        txfName.setEditable(false);

        Label lblHours = new Label("Weekly Hours:");
        this.add(lblHours, 1, 2);

        txfHours = new TextField();
        this.add(txfHours, 2, 2);
        txfHours.setEditable(false);

        Label lblEmps = new Label("Employees:");
        this.add(lblEmps, 1, 3);
        GridPane.setValignment(lblEmps, VPos.BASELINE);
        lblEmps.setPadding(new Insets(4, 0, 4, 0));

        txaEmps = new TextArea();
        this.add(txaEmps, 2, 3);
        txaEmps.setPrefWidth(200);
        txaEmps.setPrefHeight(100);
        txaEmps.setEditable(false);

        Label lblCost = new Label("Costumers:");
        this.add(lblCost, 1, 4);
        GridPane.setValignment(lblCost, VPos.BASELINE);
        lblCost.setPadding(new Insets(4, 0, 4, 0));
        txaCostumers = new TextArea();
        this.add(txaCostumers, 2, 4);
        txaCostumers.setEditable(false);
        txaCostumers.setPrefWidth(200);
        txaCostumers.setPrefHeight(100);
        
        HBox hbxButtons = new HBox(40);
        this.add(hbxButtons, 0, 5, 3, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreate = new Button("Create company");
        hbxButtons.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> createCompany());

        Button btnUpdate = new Button("Update");
        hbxButtons.getChildren().add(btnUpdate);
        btnUpdate.setOnAction(event -> updateAction());

        Button btnDelete = new Button("Delete");
        hbxButtons.getChildren().add(btnDelete);
        btnDelete.setOnAction(event -> deleteAction());

        Button btnCostumer = new Button("Create costumer");
        hbxButtons.getChildren().add(btnCostumer);
        btnCostumer.setOnAction(event -> addCostumer());
        
        if (lvwCompanies.getItems().size() > 0) {
            lvwCompanies.getSelectionModel().select(0);
        }
        
    }

    // -------------------------------------------------------------------------

    private void createCompany() {
        CompanyWindow dia = new CompanyWindow("Create Company");
        dia.showAndWait();

        // Wait for the modal dialog to close

        lvwCompanies.getItems().setAll(Service.getCompanies());
        int index = lvwCompanies.getItems().size() - 1;
        lvwCompanies.getSelectionModel().select(index);
    }

    private void addCostumer() {
        
        CostumerWindow cos =
            new CostumerWindow("Add costumer", lvwCompanies.getSelectionModel().getSelectedItem());
        cos.showAndWait();
        
        updateControls();
    }
    
    private void updateAction() {
        Company company = lvwCompanies.getSelectionModel().getSelectedItem();
        if (company == null) {
            return;
        }

        CompanyWindow dia = new CompanyWindow("Update Company", company);
        dia.showAndWait();

        // Wait for the modal dialog to close

        int selectIndex = lvwCompanies.getSelectionModel().getSelectedIndex();
        lvwCompanies.getItems().setAll(Service.getCompanies());
        lvwCompanies.getSelectionModel().select(selectIndex);
    }

    private void deleteAction() {
        
        Company company = lvwCompanies.getSelectionModel().getSelectedItem();
        
        if (company == null) {
            return;
        }
        
        if (company.employeesCount() == 0) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Delete Company");
            // alert.setContentText("Are you sure?");
            alert.setHeaderText("Are you sure?");
            Optional<ButtonType> result = alert.showAndWait();
            if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
                Service.deleteCompany(company);
                lvwCompanies.getItems().setAll(Service.getCompanies());
                updateControls();
            }
            
        }
        else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Delete Company");
            alert.setHeaderText("Can't delete a company that has emlpoyees");
            // wait for the modal dialog to close
            alert.show();
        }
    }
    
    // -------------------------------------------------------------------------

    private void selectionChanged() {
        updateControls();
    }

    public void updateControls() {
        Company company = lvwCompanies.getSelectionModel().getSelectedItem();
        if (company != null) {
            txfName.setText(company.getName());
            txfHours.setText("" + company.getHours());

            StringBuilder sb = new StringBuilder();
            for (Employee emp : company.getEmployees()) {
                sb.append(emp + "\n");
            }
            StringBuilder sb1 = new StringBuilder();
            for (Costumer cos : company.getCostumers()) {
                sb1.append(cos + "\n");
            }
            txaEmps.setText(sb.toString());
            txaCostumers.setText(sb1.toString());

        }
        else {
            txfName.clear();
            txfHours.clear();
            txaEmps.clear();
            txaCostumers.clear();
        }
    }

}
