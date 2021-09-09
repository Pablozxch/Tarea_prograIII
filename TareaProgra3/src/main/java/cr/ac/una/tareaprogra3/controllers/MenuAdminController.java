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
import javafx.event.*;
import javafx.fxml.*;

/**
 * FXML Controller class
 *
 * @author jp015
 */
public class MenuAdminController extends Controller implements Initializable
{

    @FXML
    private JFXButton btnVerHistoriales;
    @FXML
    private JFXButton btnAgregarE;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
        // TODO
    }    

    @Override
    public void initialize()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void click(ActionEvent event)
    {
        if(event.getSource()==btnAgregarE)
        {
            FlowController.getInstance().goVistas("AgregarEmpleado");
        }
    }
    
}
