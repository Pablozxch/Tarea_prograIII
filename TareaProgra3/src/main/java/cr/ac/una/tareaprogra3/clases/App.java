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
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("ss");
        //System.out.println("Segundos: " + dateFormat.format(date));
        System.out.println("Segundos "+ dateFormat.format(date));
//        for(int i = 0; i < 10;)
//        {
//
////Caso 1: obtener la hora y salida por pantalla con formato:
//            DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
//            System.out.println("Hora: " + hourFormat.format(date));
//////Caso 2: obtener la fecha y salida por pantalla con formato:
//
//////Caso 3: obtenerhora y fecha y salida por pantalla con formato:
        //DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
////        System.out.println("Hora y fecha: " + hourdateFormat.format(date));
//        }

        launch();
    }
}
