/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.controllers;

import java.net.URL;
import java.text.*;
import java.util.*;
import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author jp015
 */
public class MarcaEmpleadosController extends Controller implements Initializable
{

    int f = 10;
    @FXML
    private Label lbl_Date;
    public Thread tiempo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
        // TODO

        contarDaamge();
    }

    @Override
    public void initialize()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void contarDaamge()// este metodo se encarga de evaluar siempre la lista de mobs para ver si ya atacaron
    {

        Thread thread = new Thread(() ->
        {

            for(int i = 0; i < 2;)
            {
                f += 50;
                try
                {
                    final int contador = i;
                    Platform.runLater(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
                            hourFormat = new SimpleDateFormat("HH:mm:ss");
                            Date date = new Date();
                            lbl_Date.setText(hourFormat.format(date));
                        }
                    });

                    Thread.sleep(1000); // Vamos a actualizar el valor cada segundo
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

    }
}
