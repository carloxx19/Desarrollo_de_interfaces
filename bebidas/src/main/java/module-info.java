module com.mycompany.mavenproject7 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;

    opens com.mycompany.mavenproject7 to javafx.fxml;
    exports com.mycompany.mavenproject7;
}
