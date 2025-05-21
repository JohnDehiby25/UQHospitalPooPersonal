package co.edu.uniquindio.poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import co.edu.uniquindio.poo.utils.Paths;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(Paths.GESTIONAR_MEDICOS_VIEW));

        AnchorPane pane = loader.load();

        Scene scene = new Scene(pane);

        stage.setScene(scene);



        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}