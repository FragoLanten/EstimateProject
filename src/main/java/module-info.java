module entry.newsmetaproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens entry to javafx.fxml;
    exports entry;
}