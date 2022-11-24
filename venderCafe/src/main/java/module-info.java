/* doesn't work with source level 1.8:
module com.mycompany.vendercafe {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.vendercafe to javafx.fxml;
    exports com.mycompany.vendercafe;
}
*/
