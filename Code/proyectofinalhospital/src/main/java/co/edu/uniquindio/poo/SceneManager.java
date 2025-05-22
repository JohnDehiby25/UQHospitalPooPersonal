package co.edu.uniquindio.poo;

import java.io.IOException;

import co.edu.uniquindio.poo.controller.AdministradorController;
import co.edu.uniquindio.poo.controller.CrudMedicoController;
import co.edu.uniquindio.poo.controller.CrudPacienteController;
import co.edu.uniquindio.poo.controller.MenuPrincipalController;
import co.edu.uniquindio.poo.model.Administrador;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
    private static Stage stage;
    private static Administrador administrador;
    private static CrudPacienteController pacienteController;

    public static void setPacienteController(CrudPacienteController controller) {
        pacienteController = controller;
    }
    public static CrudPacienteController getPacienteController(){
        return pacienteController;
    }

    public static void setStage(Stage stage) {
        SceneManager.stage = stage;
    }
    
    public static void setAdministrador(Administrador admin) {
        administrador = admin;
    }

    public static void cambiarEscena(String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(rutaFXML));
            Parent root = loader.load();
            
            // Pasar el administrador al controlador
            Object controller = loader.getController();
            if (controller instanceof CrudMedicoController) {
                ((CrudMedicoController) controller).setAdministrador(administrador);
            } else if (controller instanceof MenuPrincipalController) {
                ((MenuPrincipalController) controller).setAdministrador(administrador);
            }else if(controller instanceof CrudPacienteController){
                ((CrudPacienteController) controller).setAdministrador(administrador);
            }else if(controller instanceof AdministradorController){
                ((AdministradorController) controller).setAdministrador(administrador);
            }
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            System.err.println("Error al cargar la escena: " + rutaFXML);
            e.printStackTrace();
        }
    }
}