/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import cr.ac.una.tareaprogra3.models.*;
import cr.ac.una.tareaprogra3.services.*;
import cr.ac.una.tareaprogra3.utils.*;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.*;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.util.converter.LocalDateStringConverter;

/**
 * FXML Controller class
 *
 * @author Christopher
 */
public class EditarMarcaController extends Controller implements Initializable
{

    @FXML
    private DatePicker dtpFechaEntrada;
    @FXML
    private DatePicker dtpFechaSalida;
    @FXML
    private JFXButton btnAceptar;
    @FXML
    private JFXButton btnVolver;
    @FXML
    private JFXComboBox<String> comboHEntrada;
    @FXML
    private JFXComboBox<String> comboMEntrada;
    @FXML
    private JFXComboBox<String> comboHSalida;
    @FXML
    private JFXComboBox<String> comboMSalida;
    String fechaEn;
    String fechaSal;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    RegistroService registroService = new RegistroService();

    @Override
    public void initialize(URL url , ResourceBundle rb)
    {

        insertartodo();
        ajustarvalores();

//         System.out.println("WELLCOME");
    }

    public void ajustarvalores()
    {
        Respuesta res = registroService.getRegistrobyid(getReg().getId());
        setReg((RegistroClienteDto) res.getResultado("Registro"));
        /*
            Seleccionar entrada desde server
         */
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Instant instant = getReg().getFechaIngreso().toInstant();
        LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
        dtpFechaEntrada.setValue(localDate);
        /*
            Seleccionar salida desde server
         */
        Instant instant2 = getReg().getFechaSalida().toInstant();
        LocalDate localDate2 = instant2.atZone(defaultZoneId).toLocalDate();
        dtpFechaSalida.setValue(localDate2);
        int a = getReg().getFechaIngreso().getMinutes();//minutos fecha entrada
        int b = getReg().getFechaSalida().getMinutes();//minutos fecha salida
        comboHEntrada.valueProperty().set(String.valueOf(getReg().getFechaIngreso().getHours()));
        if(a < 10)
        {
            comboMEntrada.valueProperty().set(String.valueOf("0" + getReg().getFechaIngreso().getMinutes()));
        }
        else
        {
            comboMEntrada.valueProperty().set(String.valueOf(getReg().getFechaIngreso().getMinutes()));
        }
        comboHSalida.valueProperty().set(String.valueOf(getReg().getFechaSalida().getHours()));
        if(b < 10)
        {
            comboMSalida.valueProperty().set(String.valueOf("0" + getReg().getFechaSalida().getMinutes()));
        }
        else
        {
            comboMSalida.valueProperty().set(String.valueOf(getReg().getFechaSalida().getMinutes()));
        }
    }

    public void insertartodo()
    {
        dtpFechaEntrada.setEditable(false);
        dtpFechaSalida.setEditable(false);
        dtpFechaEntrada.setConverter(new LocalDateStringConverter(FormatStyle.LONG));
        dtpFechaSalida.setConverter(new LocalDateStringConverter(FormatStyle.LONG));
        int Horas = 00;
        for(int i = 0; i <= 24; i++)
        {
            if(Horas < 10)
            {
                comboHEntrada.getItems().add(String.valueOf(Horas));
                comboHSalida.getItems().add(String.valueOf(Horas));
            }
            else
            {
                comboHEntrada.getItems().add(String.valueOf(Horas));
                comboHSalida.getItems().add(String.valueOf(Horas));
            }
            Horas++;
        }
        int Minutos = 00;
        for(int j = 0; j <= 59; j++)
        {

            if(Minutos < 10)
            {
                comboMSalida.getItems().add("0" + String.valueOf(Minutos));
                comboMEntrada.getItems().add("0" + String.valueOf(Minutos));
            }
            else
            {
                comboMSalida.getItems().add(String.valueOf(Minutos));
                comboMEntrada.getItems().add(String.valueOf(Minutos));
            }
            Minutos++;

        }

    }

    @FXML
    private void onActionBtnAceptar(ActionEvent event)
    {

        LocalDate localDate = dtpFechaEntrada.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date dateFE = Date.from(instant);
        dateFE.setHours(Integer.parseInt(comboHEntrada.getValue()));
        dateFE.setMinutes(Integer.parseInt(comboMEntrada.getValue()));

        LocalDate localDate2 = dtpFechaSalida.getValue();
        Instant instant2 = Instant.from(localDate2.atStartOfDay(ZoneId.systemDefault()));
        Date dateFS = Date.from(instant2);
        dateFS.setHours(Integer.parseInt(comboHSalida.getValue()));
        dateFS.setMinutes(Integer.parseInt(comboMSalida.getValue()));
        getReg().setFechaIngreso(dateFE);
        getReg().setFechaSalida(dateFS);
        System.out.println("El valor de la fecha entrada final es " + getReg().getFechaIngreso());
        System.out.println("El valor de la fecha salida final es " + getReg().getFechaSalida());
        registroService.saveRegistrobyid(getReg());

    }

    @FXML
    private void onActionBtnVolver(ActionEvent event)
    {
        Stage s = (Stage) btnVolver.getScene().getWindow();
        s.close();
    }

    @Override
    public void initialize()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
