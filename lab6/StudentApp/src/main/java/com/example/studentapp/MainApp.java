package com.example.studentapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.example.studentapp.model.Person;
import com.example.studentapp.view.PersonOverviewController;
import javafx.stage.Modality;
import com.example.studentapp.view.PersonEditDialogController;


public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Person> personData = FXCollections.observableArrayList();

    public MainApp() {
        personData.add(new Person("Петро", "П'яточкін"));
        personData.add(new Person("Іван", "Зайців"));
        personData.add(new Person("Катерина", "Васильченка"));
        personData.add(new Person("Ольга", "Жук"));
        personData.add(new Person("Людміла", "Алексєєва"));
        personData.add(new Person("Даніл", "Кац"));
        personData.add(new Person("Євген", "Васнецов"));
        personData.add(new Person("Дмитро", "Жуликів"));
        personData.add(new Person("Мрат", "Алібов"));
        personData.add(new Person("Martin", "Mueller"));
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }


    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        this.primaryStage.setTitle("StudentGroupApp");
        initRootLayout();
        showPersonOverview();
    }


    public void initRootLayout() {
        FXMLLoader fxmlLoader = new FXMLLoader();

        fxmlLoader.setLocation(getClass().getResource("/com/example/studentapp/view/RootLayout.fxml"));
        try {
            rootLayout = (BorderPane) fxmlLoader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showPersonOverview() {
        FXMLLoader fxmlLoader = new FXMLLoader();

        fxmlLoader.setLocation(MainApp.class.getResource("/com/example/studentapp/view/PersonOverview.fxml"));
        try {
            AnchorPane personOverview = (AnchorPane) fxmlLoader.load();

            rootLayout.setCenter(personOverview);
            PersonOverviewController controller = fxmlLoader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch();
    }

    public boolean showPersonEditDialog(Person person) {
        try {

            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(MainApp.class.getResource("view/PersonEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            PersonEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            dialogStage.showAndWait();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
