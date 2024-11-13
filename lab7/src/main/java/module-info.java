module lab7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens lab7 to javafx.fxml;
    exports lab7;
}