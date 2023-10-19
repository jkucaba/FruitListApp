module com.jakubku.borderpane.borderpane {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jakubku.borderpane.borderpane to javafx.fxml;
    exports com.jakubku.borderpane.borderpane;
}