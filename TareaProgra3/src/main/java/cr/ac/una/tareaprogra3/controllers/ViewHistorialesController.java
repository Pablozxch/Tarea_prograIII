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
import java.util.*;
import java.util.logging.*;
import java.util.stream.*;
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
public class ViewHistorialesController extends Controller implements Initializable
{

    @FXML
    private TableView tblHistorial;
    List<RegistroClienteDto> registroDto = new ArrayList<>();
    RegistroService service = new RegistroService();
    private Object resultado;
    @FXML
    private JFXButton btnEditar;
    @FXML
    private JFXButton btnSalir;
    @FXML
    private JFXButton btnEliminar;
    @FXML
    private DatePicker dtpEntrdadaR;
    @FXML
    private DatePicker dtpSalidaR;
    @FXML
    private JFXButton btnFilter;
    @FXML
    private JFXCheckBox chkES;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
        chkES.setSelected(true);
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
        actualizarDatosInicales();

    }

    public Date rangoEntrada()
    {
        LocalDate localDate = dtpEntrdadaR.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date dateFE = Date.from(instant);
        return dateFE;
    }

    public Date rangoSalida()
    {
        LocalDate localDate = dtpSalidaR.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date dateFE = Date.from(instant);
        return dateFE;
    }

    public void actualizarDatosInicales()
    {
        Respuesta respuesta = service.getAll();

        registroDto = (List<RegistroClienteDto>) respuesta.getResultado("Registro");

        ObservableList<RegistroClienteDto> empleados = FXCollections.observableList(registroDto);

        tblHistorial.setItems(empleados);
        tblHistorial.refresh();
    }

    public void actualizarDatosSoloEntradaDespues()//solo tienen el primero con datos
    {
        Date FRE = rangoEntrada();
        List<RegistroClienteDto> customersWithMoreThan100Points = registroDto
                  .stream().filter(t -> t.getFechaIngreso().after(FRE))
                  .collect(Collectors.toList());
        System.out.println("La lista tiene estos valores");
        customersWithMoreThan100Points.forEach(t ->
        {
            System.out.println("Los valores del filtro son" + t);
        });
        ObservableList<RegistroClienteDto> empleados = FXCollections.observableList(customersWithMoreThan100Points);
        tblHistorial.setItems(empleados);
        tblHistorial.refresh();
    }

    public void actualizarDatosSoloEntradaAntes()//solo tiene el segundo con datos
    {
        Date FRE = rangoSalida();
        List<RegistroClienteDto> customersWithMoreThan100Points = registroDto
                  .stream().filter(t -> t.getFechaIngreso().before(FRE))
                  .collect(Collectors.toList());
        System.out.println("La lista tiene estos valores");
        customersWithMoreThan100Points.forEach(t ->
        {
            System.out.println("Los valores del filtro son" + t);
        });
        ObservableList<RegistroClienteDto> empleados = FXCollections.observableList(customersWithMoreThan100Points);
        tblHistorial.setItems(empleados);
        tblHistorial.refresh();
    }

    public void actualizarDatosFiltroEntrada()//los dos dptpicker tienen datos
    {

        Date FRE = rangoEntrada();
        Date FRS = rangoSalida();
        List<RegistroClienteDto> customersWithMoreThan100Points = registroDto
                  .stream().filter(t -> t.getFechaIngreso().after(FRE) && t.getFechaIngreso().before(FRS))
                  .collect(Collectors.toList());
        System.out.println("La lista tiene estos valores");
        customersWithMoreThan100Points.forEach(t ->
        {
            System.out.println("Los valores del filtro son" + t);
        });
        ObservableList<RegistroClienteDto> empleados = FXCollections.observableList(customersWithMoreThan100Points);
        tblHistorial.setItems(empleados);
        tblHistorial.refresh();
    }

    public void actualizarDatosFiltroSalida()//Metodo para filtrar las varas completas de Salida
    {
        Date FRE = rangoEntrada();
        Date FRS = rangoSalida();
        List<RegistroClienteDto> customersWithMoreThan100Points = registroDto
                  .stream().filter(t -> t.getFechaSalida().after(FRE) && t.getFechaSalida().before(FRS))
                  .collect(Collectors.toList());
        System.out.println("La lista tiene estos valores");
        customersWithMoreThan100Points.forEach(t ->
        {
            System.out.println("Los valores del filtro son" + t);
        });
        ObservableList<RegistroClienteDto> empleados = FXCollections.observableList(customersWithMoreThan100Points);
        tblHistorial.setItems(empleados);
        tblHistorial.refresh();
    }

    public void actualizarDatosSoloSalidaDespues()
    {
        Date FRE = rangoEntrada();
        List<RegistroClienteDto> customersWithMoreThan100Points = registroDto
                  .stream().filter(t -> t.getFechaSalida().after(FRE))
                  .collect(Collectors.toList());
        ObservableList<RegistroClienteDto> empleados = FXCollections.observableList(customersWithMoreThan100Points);
        tblHistorial.setItems(empleados);
        tblHistorial.refresh();
    }

    public void actualizarDatosSoloSalidaAntes()
    {
        Date FRE = rangoSalida();
        List<RegistroClienteDto> customersWithMoreThan100Points = registroDto
                  .stream().filter(t -> t.getFechaSalida().before(FRE))
                  .collect(Collectors.toList());
        ObservableList<RegistroClienteDto> empleados = FXCollections.observableList(customersWithMoreThan100Points);
        tblHistorial.setItems(empleados);
        tblHistorial.refresh();
    }

    @Override
    public void initialize()
    {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void changename(ActionEvent event)
    {
        if(chkES.isSelected())
        {
            chkES.setText("Entrada");
        }
        else
        {
            chkES.setText("Salida");
        }

    }

    @FXML
    private void click(ActionEvent event)
    {
        if(event.getSource() == btnFilter)
        {
            if(chkES.isSelected() == true)
            {

                if(dtpEntrdadaR.getValue() == null && dtpSalidaR.getValue() == null)
                {
                    actualizarDatosInicales();
                }
                else if(dtpEntrdadaR.getValue() != null && dtpSalidaR.getValue() != null)
                {
                    actualizarDatosFiltroEntrada();
                }
                else if(dtpEntrdadaR.getValue() != null && dtpSalidaR.getValue() == null)
                {
                    actualizarDatosSoloEntradaDespues();
                }
                else if(dtpEntrdadaR.getValue() == null && dtpSalidaR.getValue() != null)
                {
                    actualizarDatosSoloEntradaAntes();
                }
            }
            else
            {

                if(dtpEntrdadaR.getValue() == null && dtpSalidaR.getValue() == null)
                {
                    actualizarDatosInicales();
                }
                else if(dtpEntrdadaR.getValue() != null && dtpSalidaR.getValue() != null)
                {
                    actualizarDatosFiltroSalida();
                }
                else if(dtpEntrdadaR.getValue() != null && dtpSalidaR.getValue() == null)
                {
                    actualizarDatosSoloSalidaDespues();
                }
                else if(dtpEntrdadaR.getValue() == null && dtpSalidaR.getValue() != null)
                {
                    actualizarDatosSoloSalidaAntes();
                }
            }
            dtpEntrdadaR.setValue(null);
            dtpSalidaR.setValue(null);
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
                    actualizarDatosInicales();
                }
                catch(IOException ex)
                {
                    Logger.getLogger(ViewHistorialesController.class.getName()).log(Level.SEVERE , null , ex);
                }

            }
            else
            {
                System.out.println("No selecciono nada, no sea idiota");
            }

        }
        if(event.getSource() == btnEliminar)
        {
            if(tblHistorial.getSelectionModel().getSelectedItem() != null)
            {

            }
            else
            {
                System.out.println("No hay nada seleccionado para elimianr");
            }
        }
        if(event.getSource() == btnSalir)
        {
            FlowController.getInstance().goVistas("MenuAdmin");
        }
    }

}
