/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.controllers;

import com.jfoenix.controls.*;
import cr.ac.una.tareaprogra3.utils.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.layout.*;
import javafx.stage.*;
/**
 * FXML Controller class
 *
 * @author jp015
 */
public class MainController extends Controller implements Initializable
{

    @FXML
    private JFXButton btnAdmin;
    @FXML
    private JFXButton btnEmpleado;
    @FXML
    private AnchorPane mainFxmlClass;


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
         clickB();
        if(event.getSource()==btnAdmin)
        {
    
            FlowController.getInstance().goVistas("LoginAdmin");
            System.out.println("ADMINISTRADOR");
        }
        else if(event.getSource()==btnEmpleado)
        {
            
            System.out.println("Empleado");
             FlowController.getInstance().goVistas("LoginEmpleado");
        }
    }

    @Override
    public void initialize()
    {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
