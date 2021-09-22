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
import java.awt.image.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javax.imageio.*;

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
    EmpleadoClienteDto empleadoClienteDto;
    EmpleadoService service = new EmpleadoService();
    @FXML
    private ImageView img;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
        System.out.println("Bienvenidos");
        service.getEmpleado(1L);
    }

    @FXML
    private void click(ActionEvent event)
    {
        if(event.getSource() == btnContinuar)
        {
            if(!txtUser.getText().isEmpty())
            {
                String username = txtUser.getText();
                String pass = txtPass.getText();
                Respuesta respuesta = service.getEmpleadobyFolio(username);
                System.out.println("Hola");
                if(respuesta.getEstado())
                {
                    empleadoClienteDto = (EmpleadoClienteDto) respuesta.getResultado("EmpleadoFolio");
                    System.out.println(empleadoClienteDto.toString());
                    Image img2 = new Image(new ByteArrayInputStream(empleadoClienteDto.getFoto()));//crea un objeto imagen, transforma el byte[] a un buffered imagen
                    img.setImage(img2);

                }
                else
                {
                    txtPass.clear();
                }

            }
            if(!txtPass.getText().isEmpty() && !txtUser.getText().isEmpty())
            {
                String username = txtUser.getText();
                setNfolio(username);
                String pass = txtPass.getText();
                Respuesta respuesta = service.getEmpleadoAdmin(username , pass , "A");
                if(respuesta.getEstado())
                {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION , "Usuario " , getStage() , "Usuario encontrado");
                    empleadoClienteDto = (EmpleadoClienteDto) respuesta.getResultado("Admin");
                    System.out.println(empleadoClienteDto.toString());
                    FlowController.getInstance().goVistas("MenuAdmin");
                }
                else
                {
                    new Mensaje().showModal(Alert.AlertType.ERROR , "Usuario " , btnContinuar.getScene().getWindow() , "Datos incorrectos");
                    txtUser.clear();
                    txtPass.clear();
                }
            }
            if(txtPass.getText().isEmpty())
            {
                //new Mensaje().showModal(Alert.AlertType.WARNING , "Usuario " , btnContinuar.getScene().getWindow() , "Faltan Datos");
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
