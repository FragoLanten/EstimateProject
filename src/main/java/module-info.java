module entry.newsmetaproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;


    opens entry to javafx.fxml;
    exports entry;
}