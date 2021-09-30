/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.controllers;

import cr.ac.una.tareaprogra3.models.*;
import cr.ac.una.tareaprogra3.services.*;
import cr.ac.una.tareaprogra3.utils.*;
import java.net.URL;
import java.util.*;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author jp015
 */
public class ViewHistorialesController extends Controller implements Initializable
{

    @FXML
    private TableView tblHistorial;
    List<RegistroClienteDto> registroDto = new ArrayList<>();
    RegistroService service = new RegistroService();
    private Object resultado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
        TableColumn<RegistroClienteDto , String> idEmp = new TableColumn<>("Folio");
        idEmp.setPrefWidth(50);
        idEmp.setCellValueFactory(cd -> cd.getValue().empId.get().folio);
        idEmp.setResizable(false);

        TableColumn<RegistroClienteDto , Date> fechaEntrada = new TableColumn<>("Fecha Entrada");
        fechaEntrada.setPrefWidth(200);
        fechaEntrada.setCellValueFactory(cd -> cd.getValue().fechaIngreso);
        fechaEntrada.setResizable(false);

        TableColumn<RegistroClienteDto , Date> fechaSalida = new TableColumn<>("Fecha Salida");
        fechaSalida.setPrefWidth(200);
        fechaSalida.setCellValueFactory(cd -> cd.getValue().fechaSalida);
        fechaSalida.setResizable(false);

        TableColumn<RegistroClienteDto , String> diaci = new TableColumn<>("Dia Completado");
        diaci.setPrefWidth(138);
        diaci.setCellValueFactory(cd -> cd.getValue().completado);
        diaci.setResizable(false);

        tblHistorial.getColumns().add(idEmp);
        tblHistorial.getColumns().add(fechaEntrada);
        tblHistorial.getColumns().add(fechaSalida);
        tblHistorial.getColumns().add(diaci);
        tblHistorial.refresh();
        x();
    }

    public void x()
    {
        Respuesta respuesta = service.getAll();

        registroDto = (List<RegistroClienteDto>) respuesta.getResultado("Registro");
        ObservableList<RegistroClienteDto> empleados = FXCollections.observableList(registroDto);

        tblHistorial.setItems(empleados);
        tblHistorial.refresh();
    }

    @Override
    public void initialize()
    {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
