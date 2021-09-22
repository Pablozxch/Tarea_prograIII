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
import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.logging.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.stage.*;
import javax.imageio.*;

/**
 * FXML Controller class
 *
 * @author jp015
 */
public class AdminControlController extends Controller implements Initializable
{

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtCedula;
    @FXML
    private ImageView imgEmpleado;
    @FXML
    private JFXButton btnInsertarImagen;
    @FXML
    private JFXButton BtnTomarFoto;
    @FXML
    private JFXButton btnContinuar;
    @FXML
    private DatePicker dteFechaNacimiento;
    @FXML
    private JFXButton btnRetroceder;
    @FXML
    private JFXCheckBox chckAdmin;
    @FXML
    private JFXButton btnBuscar;
    File x;
    EmpleadoClienteDto empleadoClienteDto;
    EmpleadoService service = new EmpleadoService();
    @FXML
    private TextField txtFolo;
    String rol = "E";

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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void click(ActionEvent event)
    {
        if(event.getSource() == chckAdmin)
        {
            rol = chckAdmin.isSelected() ? "A" : "E";
        }
        if(event.getSource() == btnBuscar)
        {
            Respuesta respuesta = service.getEmpleadobyFolio(txtFolo.getText());
            if(respuesta.getEstado())
            {
                empleadoClienteDto = (EmpleadoClienteDto) respuesta.getResultado("EmpleadoFolio");
                System.out.println(empleadoClienteDto.toString());
                Image img2 = new Image(new ByteArrayInputStream(empleadoClienteDto.getFoto()));//crea un objeto imagen, transforma el byte[] a un buffered imagen
                imgEmpleado.setImage(img2);
                txtNombre.setText(empleadoClienteDto.getNombre());
                txtApellido.setText(empleadoClienteDto.getApellido());
                txtCedula.setText(empleadoClienteDto.getCedula());

                ZoneId defaultZoneId = ZoneId.systemDefault();
                Instant instant = empleadoClienteDto.getfIngreso().toInstant();
                LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();

                //TOMA EL Date y lo va a psar a algo
                dteFechaNacimiento.setValue(localDate);
                if("A".equals(empleadoClienteDto.getRol()))
                {
                    System.out.println("El empleado es un admin");
                     rol = "A";
                    chckAdmin.setIndeterminate(true);
                }
                else
                {
                    rol = "E";
                    System.out.println("El empleado no un admin");
                    chckAdmin.setIndeterminate(false);
                }

            }
        }
        if(event.getSource() == btnInsertarImagen)
        {
            FileChooser file = new FileChooser();
            file.getExtensionFilters().addAll(
                      new FileChooser.ExtensionFilter("img" , "*.jpg") ,
                      new FileChooser.ExtensionFilter("png" , "*.png") ,
                      new FileChooser.ExtensionFilter("gif" , "*.gif")
            );

            File file2 = file.showOpenDialog(null);
            if(file2 != null)
            {
                Image imagen1 = new Image(file2.toURI().toString());
                x = file2;
                imgEmpleado.setImage(imagen1);
            }
        }
        if(event.getSource() == btnContinuar)
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
                if(empleadoClienteDto.getFoto() != null)
                {
                    empleadoClienteDto.setFoto(empleadoClienteDto.getFoto());
                }
                if (x!=null)
                {
                    BufferedImage bufferimage;
                    bufferimage = ImageIO.read(x);
                    ByteArrayOutputStream output = new ByteArrayOutputStream();
                    ImageIO.write(bufferimage , "jpg" , output);//POR EL MOMENTO SOLO SE PUEDE METE UN X TIPO DE FOTO
                    byte[] data = output.toByteArray();
                    empleadoClienteDto.setFoto(data);
                }

            }
            catch(IOException ex)
            {
                Logger.getLogger(AgregarEmpleadoController.class.getName()).log(Level.SEVERE , null , ex);
            }
           // service.guardarEmpleado(empleadoClienteDto);

            FlowController.getInstance().goVistas("MenuAdmin");
        }
        if(event.getSource() == btnRetroceder)
        {
            FlowController.getInstance().goVistas("MenuAdmin");
        }

    }

}
