/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.controllers;

import com.jfoenix.controls.*;
import cr.ac.una.tareaprogra3.models.*;
import cr.ac.una.tareaprogra3.services.*;
import cr.ac.una.tareaprogra3.utils.*;
import java.io.*;
import static java.lang.Boolean.TRUE;
import java.net.URL;
import java.text.*;
import java.util.*;
import java.util.logging.*;
import javafx.application.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 * FXML Controller class
 *
 * @author jp015
 */
public class MenuEmpleadoController extends Controller implements Initializable
{

    /**
     * Initializes the controller class.
     */
    RegistroService service = new RegistroService();
    RegistroClienteDto reg = new RegistroClienteDto();
    boolean flag = true;
    @FXML
    private Label lblFecha;
    int f = 0;
    @FXML
    private JFXButton btnstartstop;
    @FXML
    private ImageView imvSS;
    @FXML
    private Label lblnombreEmpleado;
    @FXML
    private Label lblDate;
    @FXML
    private JFXButton btnSalir;
    Thread thread;

    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
        // TODO
        DateFormat daymyear = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        lblFecha.setText(daymyear.format(date));
        timecount();
        String name = getEmp().getNombre();
        lblnombreEmpleado.setText(name);
        asig();

    }

    @Override
    public void initialize()
    {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void asig()
    {
        Date date = new Date();
        SimpleDateFormat dateemp = new SimpleDateFormat("dd/MM/YYYY");

        String dateCumple = dateemp.format(getEmp().getNacimiento());
        String dateactual = dateemp.format(date);
        System.out.println(dateCumple);
        System.out.println(dateactual);
        if(dateCumple.equals(dateactual))
        {
            try
            {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/tareaprogra3/views/FelizBird.fxml"));
                stage.setOpacity(1);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.resizableProperty().set(false);
                stage.initModality(Modality.WINDOW_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

            }
            catch(IOException ex)
            {
                Logger.getLogger(MenuEmpleadoController.class.getName()).log(Level.SEVERE , null , ex);
            }

        }
    }

    @FXML
    private void click(ActionEvent event)
    {
        if(event.getSource() == btnstartstop)
        {
            if(flag == true)
            {
                imvSS.setImage(new Image("cr/ac/una/tareaprogra3/resources/Stop.png"));
                flag = false;
                Date fE = new Date();
                reg.setFechaIngreso(fE);
                System.out.println("La fecha de entrada es " + fE);
                btnstartstop.setText("Terminar Jornada");
            }
            else
            {
                flag = true;
                Date fS = new Date();
                reg.setFechaSalida(fS);
                asignarcompletado();
                System.out.println(reg);
                Respuesta r = service.saveRegistro(reg , getEmp());
                new Mensaje().showModal(Alert.AlertType.INFORMATION , "Empleado" + reg.empId.getName() , getStage() , "Saliendo del sistema");
                thread.stop();
                FlowController.getInstance().goVistas("LoginEmpleado");

            }
        }
        if(event.getSource() == btnSalir)
        {

            if(new Mensaje().showConfirmation("Saliendo del sistema" , getStage() , "¿Esta seguro que desea salir del sistema?"))
            {
                if(reg.getFechaIngreso() == null)
                {
                    thread.stop();
                    FlowController.getInstance().goVistas("LoginEmpleado");
                }
                else
                {
                    Date fS = new Date();
                    reg.setFechaSalida(fS);
                    asignarcompletado();
                    Respuesta r = service.saveRegistro(reg , getEmp());
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Empleado" + reg.empId.getName() , getStage() , "Saliendo del sistema");
                    thread.stop();
                    FlowController.getInstance().goVistas("LoginEmpleado");
                }

            }

        }
    }

    public void asignarcompletado()
    {
        if(reg.getFechaSalida().getTime() - reg.getFechaIngreso().getTime() > 28800000L)//comparacion de tiempo para poder colocar el completado e incompleto obteniendo los milisegundos desde 1 enero del 70
        {
            reg.setCompletado("C");
        }
        else
        {
            reg.setCompletado("I");

        }
    }

    public void timecount()// este metodo se encarga de evaluar siempre la lista de mobs para ver si ya atacaron
    {

        thread = new Thread(() ->
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

                            Date date = new Date();
                            lblDate.setText(hourFormat.format(date));
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
