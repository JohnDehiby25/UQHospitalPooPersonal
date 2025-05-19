module co.edu.uniquindio.poo {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;

    opens co.edu.uniquindio.poo to javafx.fxml;
    exports co.edu.uniquindio.poo;
}
