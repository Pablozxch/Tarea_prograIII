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
import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.logging.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

/**
 * FXML Controller class
 *
 * @author jp015
 */
public class BuscarHistorialController extends Controller implements Initializable
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

    public void search()
    {
        String folioaBuscar = lblFolio.getText();
        Respuesta respuesta = service.getRegistrosfindByFolio(folioaBuscar);

        registroDto = (List<RegistroClienteDto>) respuesta.getResultado("Registro");
        ObservableList<RegistroClienteDto> empleados = FXCollections.observableList(registroDto);

        tblHistorial.setItems(empleados);
        tblHistorial.refresh();
    }

    @FXML
    private void click(ActionEvent event)
    {
        if(event.getSource() == btnBuscar)
        {
            search();
        }
        if(event.getSource() == btnRegresar)
        {
            FlowController.getInstance().goVistas("MenuAdmin");
        }
        if(event.getSource() == btnEditar)
        {
            if(tblHistorial.getSelectionModel().getSelectedItem() != null)
            {

                try
                {
                    setReg((RegistroClienteDto) tblHistorial.getSelectionModel().getSelectedItem());
                    RegistroClienteDto reg = (RegistroClienteDto) tblHistorial.getSelectionModel().getSelectedItem();
                    System.out.println("El valor seleccionado es " + reg.toString());
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cr/ac/una/tareaprogra3/views/EditarMarca.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setOpacity(1);
                    Scene scene = new Scene(root , 647 , 474);
                    stage.setScene(scene);
                    stage.resizableProperty().set(false);
                    stage.initModality(Modality.WINDOW_MODAL);
                    stage.initOwner(btnEditar.getScene().getWindow());
                    stage.centerOnScreen();
                    stage.showAndWait();
                    search();
                }
                catch(IOException ex)
                {
                    Logger.getLogger(BuscarHistorialController.class.getName()).log(Level.SEVERE , null , ex);
                }

            }
        }
        if(event.getSource() == btnEliminar)
        {
            Respuesta res = service.eliminarRegistro((RegistroClienteDto) tblHistorial.getSelectionModel().getSelectedItem());
            if(res.getEstado())
            {
                new Mensaje().show(Alert.AlertType.CONFIRMATION , "Registro Eliminado" , "Correctamente");
                search();
            }
            else
            {
                new Mensaje().show(Alert.AlertType.ERROR , "Registro Eliminado" , "Incorrectamente");
            }
        }

    }

    @Override
    public void initialize()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
