/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.controllers;

import com.jfoenix.controls.*;
import cr.ac.una.tareaprogra3.services.*;
import cr.ac.una.tareaprogra3.models.*;
import cr.ac.una.tareaprogra3.utils.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.stage.*;
import java.awt.image.*;
import java.time.*;
import java.util.*;
import java.util.logging.*;
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
    private ImageView imgEmpleado;
    @FXML
    private JFXButton btnInsertarImagen;
    @FXML
    private JFXButton BtnTomarFoto;
    @FXML
    private JFXButton btnContinuar;
    @FXML
    private JFXButton btnRetroceder;
    @FXML
    private JFXCheckBox chckAdmin;
    /**
     * Initializes the controller class.
     */
    EmpleadoClienteDto empleadoClienteDto = new EmpleadoClienteDto();
    EmpleadoService service = new EmpleadoService();
    File x;

    String rol = "E";

    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
        // TODO
    }

    @FXML
    private void click(ActionEvent event)
    {
        if(event.getSource() == chckAdmin)
        {
            String rol = chckAdmin.isSelected() ? "A" : "E";
        }
        if(event.getSource() == btnInsertarImagen)
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
                x = file2;
                imgEmpleado.setImage(imagen1);
            }
        }
        else if(event.getSource() == BtnTomarFoto)
        {

        }
        else if(event.getSource() == btnContinuar)
        {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String cedula = txtCedula.getText();
            empleadoClienteDto.setNombre(nombre);
            empleadoClienteDto.setApellido(apellido);
            empleadoClienteDto.setCedula(cedula);
            //TOMA EL DATEPICKER Y LO TRANSFORMA EN UN DATE
            LocalDate localDate = dteFechaNacimiento.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date date = Date.from(instant);
            //TOMA EL DATEPICKER Y LO TRANSFORMA EN UN DATE
            empleadoClienteDto.setNacimiento(date);
            char folio = apellido.charAt(0);
            char folio2 = nombre.charAt(0);
            String FolioV = String.valueOf(folio) + String.valueOf(folio2);
            empleadoClienteDto.setFolio(FolioV);
            empleadoClienteDto.setRol(rol);
            try
            {
                BufferedImage bufferimage;
                bufferimage = ImageIO.read(x);
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                ImageIO.write(bufferimage , "jpg" , output);
                byte[] data = output.toByteArray();
                empleadoClienteDto.setFoto(data);
            }
            catch(IOException ex)
            {
                Logger.getLogger(AgregarEmpleadoController.class.getName()).log(Level.SEVERE , null , ex);
            }
            service.guardarEmpleado(empleadoClienteDto);
            FlowController.getInstance().goVistas("MenuAdmin");

        }
        if(event.getSource() == btnRetroceder)
        {
            FlowController.getInstance().goVistas("MenuAdmin");
        }
    }

    @Override
    public void initialize()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
