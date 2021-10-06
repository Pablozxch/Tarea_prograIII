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
import java.text.*;
import java.util.*;
import java.util.logging.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.stage.*;

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
                asig();
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
                stage.initOwner((Stage)btnContinuar.getScene().getWindow());
                stage.setScene(scene);
                stage.showAndWait();

            }
            catch(IOException ex)
            {
                Logger.getLogger(MenuEmpleadoController.class.getName()).log(Level.SEVERE , null , ex);
            }

        }
    }

}
