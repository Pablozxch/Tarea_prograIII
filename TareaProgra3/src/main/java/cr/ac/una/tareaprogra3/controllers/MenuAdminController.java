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
import java.time.*;
import java.time.format.*;
import java.util.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.image.*;

/**
 * FXML Controller class
 *
 * @author jp015
 */
public class MenuAdminController extends Controller implements Initializable
{

    @FXML
    private JFXButton btnVerHistoriales;
    private JFXButton btnAgregarE;
    @FXML
    private JFXButton btnAgregarEmpleado;
    @FXML
    private JFXButton btnMantenimiento;
    @FXML
    private JFXButton btnBuscarHistorial;
    @FXML
    private JFXButton btnExportarMarcas;
    @FXML
    private JFXButton btnSalir;
    @FXML
    private ImageView imgFotoAdmin;
//    EmpleadoDto empleadoClienteDto ;
    List<RegistroClienteDto> registroClienteDto = new ArrayList<RegistroClienteDto>();
    RegistroService service = new RegistroService();
    EmpleadoService service2 = new EmpleadoService();

    EmpleadoClienteDto empleadoClienteDto = new EmpleadoClienteDto();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
        llenarCentro();
    }

    @Override
    public void initialize()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void click(ActionEvent event)
    {
        clickB();
        if(event.getSource() == btnAgregarEmpleado)
        {
            FlowController.getInstance().goVistas("AgregarEmpleado");
        }
        if(event.getSource() == btnSalir)
        {
            FlowController.getInstance().goVistas("LoginAdmin");
        }
        if(event.getSource() == btnMantenimiento)
        {
            FlowController.getInstance().goVistas("AdminControl");
        }
        if(event.getSource() == btnBuscarHistorial)
        {
            FlowController.getInstance().goVistas("BuscarHistorial");
        }
        if(event.getSource() == btnVerHistoriales)
        {
            FlowController.getInstance().goVistas("ViewHistoriales");
        }
        if(event.getSource() == btnExportarMarcas)
        {
            FlowController.getInstance().goVistas("ExportarMarcas");
        }
    }

    public void llenarCentro()
    {
        Respuesta respuesta = service2.getEmpleadobyFolio(Nfolio);
        if(respuesta.getEstado())
        {
            empleadoClienteDto = (EmpleadoClienteDto) respuesta.getResultado("Empleado");
            Image img2 = new Image(new ByteArrayInputStream(empleadoClienteDto.getFoto()));//crea un objeto imagen, transforma el byte[] a un buffered imagen
            imgFotoAdmin.setImage(img2);

        }
    }

}
