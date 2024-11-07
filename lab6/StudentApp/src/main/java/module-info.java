module com.example.studentapp {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example.studentapp to javafx.graphics, javafx.fxml;  // Export the root package
    exports com.example.studentapp.view to javafx.fxml;  // Export the view package
    opens com.example.studentapp.view to javafx.fxml;
}