module name {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires transitive java.sql;

    opens database to javafx.fxml;

    exports database;
}
