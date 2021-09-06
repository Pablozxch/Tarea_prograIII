/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.controllers;


import com.jfoenix.controls.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.stage.*;
import java.awt.image.*;
import javax.imageio.*;

/**
 * FXML Controller class
 *
 * @author jp015
 */
public class AgregarEmpleadoController extends Controller implements Initializable
{

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtCedula;
    @FXML
    private DatePicker dteFechaNacimiento;
    @FXML
    private JFXCheckBox ckbAdministrador;
    @FXML
    private JFXCheckBox ckbEmpleado;
    @FXML
    private JFXButton btnInsertarImagen;
    @FXML
    private JFXButton BtnTomarFoto;
    @FXML
    private JFXButton btnContinuar;
    @FXML
    private ImageView imgEmpleado;

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
        if(event.getSource()==btnInsertarImagen)
        {
            FileChooser file = new FileChooser();
            file.getExtensionFilters().addAll(
                      new FileChooser.ExtensionFilter("img" , "*.jpg") ,
                      new FileChooser.ExtensionFilter("img" , "*.png") ,
                      new FileChooser.ExtensionFilter("img2" , "*.gif")
            );
            
            File file2 = file.showOpenDialog(null);
            if(file2 != null)
            {
                Image imagen1 = new Image(file2.toURI().toString());
                imgEmpleado.setImage(imagen1);
            }
        }
        else if(event.getSource()==BtnTomarFoto)
        {
        
            
        }
        else if(event.getSource()==btnContinuar)
        {
            
        }
    }

    @Override
    public void initialize()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
