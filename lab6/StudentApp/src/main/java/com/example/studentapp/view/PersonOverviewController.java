package com.example.studentapp.view;

import com.example.studentapp.MainApp;
import com.example.studentapp.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.example.studentapp.util.DateUtil;
import javafx.scene.control.Alert.AlertType;


public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;

    @FXML
    private TableColumn<Person, String> firstNameColumn;

    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label groupCodeLabel;

    @FXML
    private Label birthdayLabel;

    @FXML
    private Label emalLabel;

    @FXML
    private Label studentIdLabel;

    @FXML
    private Label averageGradeLabel;

    private MainApp mainApp;

    public PersonOverviewController() {
    }

    @FXML
    private void initialize() {
        firstNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().lastNameProperty());

        showPersonDetails(null);


        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        personTable.setItems(mainApp.getPersonData());
    }

    private void showPersonDetails(Person person) {
        if (person != null) {

            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            groupCodeLabel.setText(String.valueOf(person.getGroupCode()));
            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
            emalLabel.setText(String.valueOf(person.getEmail()));
            studentIdLabel.setText(String.valueOf(person.getStudentId()));
            averageGradeLabel.setText(String.valueOf(person.getAverageGrade()));
        } else {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            groupCodeLabel.setText("");
            birthdayLabel.setText("");
            emalLabel.setText("");
            studentIdLabel.setText("");
            averageGradeLabel.setText("");
        }
    }


    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Confirm Deletion");
            alert.setHeaderText("Are you sure you want to delete this person?");
            alert.setContentText("This action cannot be undone");

            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    personTable.getItems().remove(selectedIndex);
                }
            });
        } else {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleNewPerson() {
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }
    }

    @FXML
    private void handleEditPerson() {
        Person
                selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }
        } else {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            alert.showAndWait();
        }
    }

}


