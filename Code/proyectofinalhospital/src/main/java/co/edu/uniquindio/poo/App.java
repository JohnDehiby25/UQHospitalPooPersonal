package co.edu.uniquindio.poo;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

import co.edu.uniquindio.poo.utils.Paths;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        SceneManager.setStage(stage);

        SceneManager.cambiarEscena(Paths.MENU_PRINCIPAL_VIEW);

    }

    public static void main(String[] args) {
        launch();
    }

}