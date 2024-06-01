module com.example.codelab6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.codelab6 to javafx.fxml;
    exports com.example.codelab6;
}