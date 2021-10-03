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
import static java.lang.Boolean.TRUE;
import java.net.URL;
import java.text.*;
import java.util.*;
import javafx.application.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

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

    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
        // TODO
        DateFormat daymyear = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        lblFecha.setText(daymyear.format(date));
        timecount();
        String name = getEmp().getNombre();

        System.out.println("El nombre es " + name);
        lblnombreEmpleado.setText(name);

    }

    @Override
    public void initialize()
    {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                System.out.println("La fecha de entrada es " + fS);
                System.out.println("EL empleado en esta sesion es " + getEmp());
                Respuesta r = service.saveRegistro(reg , getEmp());
                new Mensaje().showModal(Alert.AlertType.INFORMATION , "Empleado" + reg.empId.getName() , getStage() , "Saliendo del sistema");
                FlowController.getInstance().goVistas("LoginEmpleado");

            }
        }
    }

    public void timecount()// este metodo se encarga de evaluar siempre la lista de mobs para ver si ya atacaron
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
