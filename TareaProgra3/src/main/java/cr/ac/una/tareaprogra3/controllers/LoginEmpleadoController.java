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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;

/**
 * FXML Controller class
 *
 * @author jp015
 */
public class LoginEmpleadoController extends Controller implements Initializable
{

    @FXML
    private TextField txtUser;
    @FXML
    private JFXButton btnContinuar;

    /**
     * Initializes the controller class.
     */
    EmpleadoClienteDto emp;
    EmpleadoService service = new EmpleadoService();
    @FXML
    private JFXButton btnRegresar;

    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
        // TODO
    }

    @FXML
    private void click(ActionEvent event)
    {
        if(event.getSource() == btnContinuar)
        {
            String username = txtUser.getText();
            Respuesta respuesta = service.getEmpleadobyFolio(username);
            if(respuesta.getEstado())
            {
                emp = (EmpleadoClienteDto) respuesta.getResultado("Empleado");
                setEmp(emp);
                FlowController.getInstance().goVistas("MenuEmpleado");

            }
        }
        if(event.getSource()==btnRegresar)
        {
            FlowController.getInstance().goMain();
        }
    }

    @Override
    public void initialize()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
