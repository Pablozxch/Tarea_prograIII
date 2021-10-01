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
import java.util.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;

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
    RegistroService service= new RegistroService();
    RegistroClienteDto reg=new RegistroClienteDto();
    @FXML
    private JFXButton btn_startstop;
    @FXML
    private Label lbl_nombreEmpleado;
    boolean flag = true;

    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
        // TODO
        String name=getEmp().getNombre();
        System.out.println("El nombre es "+name );
        lbl_nombreEmpleado.setText(name);
        

    }

    @Override
    public void initialize()
    {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void click(ActionEvent event)
    {
        if(event.getSource() == btn_startstop)
        {
           if(flag==true)
           {
               flag=false;
               Date fE=new Date();
               reg.setFechaIngreso(fE);
               System.out.println("La fecha de entrada es "+fE);
               btn_startstop.setText("Terminar Jornada");
           }
           else
           {
                flag=true;
               Date fS=new Date();
          
               reg.setFechaSalida(fS);
               System.out.println("La fecha de entrada es "+fS);
               System.out.println("EL empleado en esta sesion es "+getEmp());
                Respuesta r= service.saveRegistro(reg , getEmp());
                if(!r.getEstado())
                {
                    System.out.println("No guardo ni picha");
                }
           }       
        }
    }

}
