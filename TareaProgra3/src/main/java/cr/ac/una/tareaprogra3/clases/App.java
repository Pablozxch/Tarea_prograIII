package cr.ac.una.tareaprogra3.clases;

import cr.ac.una.tareaprogra3.utils.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.*;
import java.util.*;
import javafx.animation.*;
import javafx.scene.image.*;

/**
 * JavaFX App
 */
public class App extends Application
{

    private static Scene scene;
    Calendar calendario = new GregorianCalendar();

    @Override
    public void start(Stage stage) throws IOException
    {
        FlowController.getInstance().InitializeFlow(stage , null);
        //stage.getIcons().add(new Image("/cr/ac/una/defender/resources/Logo.png"));
        stage.setTitle("Administrador de Empleados");
        stage.setResizable(false);
        FlowController.getInstance().goMain();
        //FlowController.getInstance().goVistas("EditarMarca");
        //FlowController.getInstance().goVistas("ViewHistoriales");
    }

    static void setRoot(String fxml) throws IOException
    {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args)
    {

        launch();
    }
}
