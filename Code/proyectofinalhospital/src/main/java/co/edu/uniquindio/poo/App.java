package co.edu.uniquindio.poo;

import javafx.application.Application;
import javafx.stage.Stage;
import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.utils.Paths;

public class App extends Application {
    private static Stage primaryStage;
    private static Administrador administrador;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        administrador = new Administrador("admin", "123", "Admin", "admin@hospital.com", 30);
        
        // Configurar SceneManager
        SceneManager.setStage(primaryStage);
        SceneManager.setAdministrador(administrador);
        
        // Cargar escena inicial
        SceneManager.cambiarEscena(Paths.MENU_PRINCIPAL_VIEW);
        
        primaryStage.setTitle("Hospital Management System");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}