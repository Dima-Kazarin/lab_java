package com.example.studentapp.view;

import com.example.studentapp.model.Person;
import com.example.studentapp.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonEditDialogController {
    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField groupCodeField;

    @FXML
    private TextField birthdayField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField studentIdField;

    @FXML
    private TextField averageGradeField;

    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setPerson(Person person) {
        this.person = person;
        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        groupCodeField.setText(String.valueOf(person.getGroupCode()));
        birthdayField.setText(DateUtil.format(person.getBirthday()));
        birthdayField.setPromptText("dd.mm.yyyy");
        emailField.setText(String.valueOf(person.getEmail()));
        studentIdField.setText(String.valueOf(person.getStudentId()));
        averageGradeField.setText(String.valueOf(person.getAverageGrade()));
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setFirstName(firstNameField.getText());
            person.setLastName(lastNameField.getText());
            person.setGroupCode(Integer.parseInt(groupCodeField.getText()));
            person.setBirthday(DateUtil.parse(birthdayField.getText()));
            person.setEmail(emailField.getText());
            person.setStudentId(Integer.parseInt(studentIdField.getText()));
            person.setAverageGrade(Double.parseDouble(averageGradeField.getText()));
            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (firstNameField.getText() == null || firstNameField.getText().isEmpty()) {
            errorMessage += "No valid first name!\n";
        }

        if (lastNameField.getText() == null || lastNameField.getText().isEmpty()) {
            errorMessage += "No valid last name!\n";
        }

        if (groupCodeField.getText() == null || groupCodeField.getText().isEmpty()) {
            errorMessage += "No valid postal code!\n";
        } else {
            try {
                Integer.parseInt(groupCodeField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid group code (must be an integer)!\n";
            }
        }

        if (birthdayField.getText() == null || birthdayField.getText().isEmpty()) {
            errorMessage += "No valid birthday!\n";
        } else {
            if (!DateUtil.validDate(birthdayField.getText())) {
                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
            }
        }

        if (emailField.getText() == null || emailField.getText().isEmpty()) {
            errorMessage += "No valid email!\n";
        } else {
            String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            if (!emailField.getText().matches(emailPattern)) {
                errorMessage += "Invalid email format!\n";
            }
        }

        if (studentIdField.getText() == null || studentIdField.getText().isEmpty()) {
            errorMessage += "No valid student id!\n";
        } else {
            try {
                Integer.parseInt(studentIdField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid student id (must be an integer)!\n";
            }
        }

        if (averageGradeField.getText() == null || averageGradeField.getText().isEmpty()) {
            errorMessage += "No valid average grade\n";
        } else {
            try {
                double a = Double.parseDouble(averageGradeField.getText());
                if (a > 5.0) {
                    errorMessage += "No valid average grade (must be less than 5.0)";
                }
            } catch (NumberFormatException e) {
                errorMessage += "No valid average grade (must be an double)!\n";
            }
        }

        if (errorMessage.isEmpty()) {
            return true;
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }
}