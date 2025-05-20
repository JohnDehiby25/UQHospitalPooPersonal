module co.edu.uniquindio.poo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires transitive javafx.graphics;

    opens co.edu.uniquindio.poo.controller to javafx.fxml;
    opens co.edu.uniquindio.poo to org.junit.platform.commons;
    
    exports co.edu.uniquindio.poo;
    
    exports co.edu.uniquindio.poo.controller;
}