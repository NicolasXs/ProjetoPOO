module com.example.dashboardcompany {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.desktop;
    requires java.sql;
    requires mysql.connector.java;

    opens com.example.dashboardcompany to javafx.fxml;
    exports com.example.dashboardcompany;
}