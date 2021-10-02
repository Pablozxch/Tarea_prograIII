/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.controllers;

import com.jfoenix.controls.*;
import static cr.ac.una.tareaprogra3.controllers.Controller.Nfolio;
import cr.ac.una.tareaprogra3.models.*;
import cr.ac.una.tareaprogra3.services.*;
import cr.ac.una.tareaprogra3.utils.*;
import java.net.URL;
import java.util.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.*;

/**
 * FXML Controller class
 *
 * @author jp015
 */
public class BuscarHistorialController implements Initializable
{

    @FXML
    private TableView tblHistorial;
    @FXML
    private TextField lblFolio;
    @FXML
    private JFXButton btnBuscar;
    List<RegistroClienteDto> registroDto = new ArrayList<>();
    RegistroService service = new RegistroService();
    private Object resultado;
    @FXML
    private JFXButton btnRegresar;
    @FXML
    private JFXButton btnEditar;
    @FXML
    private JFXButton btnAgregar;
    @FXML
    private JFXButton btnEliminar;

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

    }

    @FXML
    private void click(ActionEvent event)
    {
        if(event.getSource() == btnBuscar)
        {
            String folioaBuscar = lblFolio.getText();
            Respuesta respuesta = service.getRegistrosfindByFolio(folioaBuscar);

            registroDto = (List<RegistroClienteDto>) respuesta.getResultado("Registro");
            ObservableList<RegistroClienteDto> empleados = FXCollections.observableList(registroDto);

            tblHistorial.setItems(empleados);
            tblHistorial.refresh();
        }
        else if(event.getSource() == btnRegresar)
        {
            Stage s= (Stage)btnAgregar.getScene().getWindow();
            s.close();
        }

    }

}
