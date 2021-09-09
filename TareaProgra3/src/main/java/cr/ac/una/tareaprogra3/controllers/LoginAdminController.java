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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author jp015
 */
public class LoginAdminController extends Controller implements Initializable
{

    @FXML
    private JFXButton btnContinuar;
    @FXML
    private JFXButton BtnRegresar;
    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtPass;
    EmpleadoDto empleadoDto ;
    EmpleadoService service = new EmpleadoService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void click(ActionEvent event)
    {
        if(event.getSource()==btnContinuar)
        {

            if(txtPass.getText().isEmpty() || txtUser.getText().isEmpty())
            {
                new Mensaje().showModal(Alert.AlertType.WARNING , "Usuario " , btnContinuar.getScene().getWindow() , "Faltan Datos");
            }
            else
            {
                String username=txtUser.getText();
                String pass=txtPass.getText();
                Respuesta respuesta = service.getEmpleadoAdmin("E1" , "chupapi", "A");
                if(respuesta.getEstado())
                {
                   // new Mensaje().showModal(Alert.AlertType.INFORMATION , "Usuario " , getStage() , "Usuario encontrado");
                    empleadoDto = (EmpleadoDto) respuesta.getResultado("Admin");
                    System.out.println(empleadoDto.toString());
                    FlowController.getInstance().goVistas("MenuAdmin");
                }
                else
                {
                    new Mensaje().showModal(Alert.AlertType.ERROR , "Usuario " , btnContinuar.getScene().getWindow() , "Datos incorrectos");
                    txtUser.clear();
                    txtPass.clear();
                }

            }
        }
        else
        {
            System.out.println("Regresando");
            FlowController.getInstance().goMain();
        }
    }
   
    @Override
    public void initialize()
    {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
