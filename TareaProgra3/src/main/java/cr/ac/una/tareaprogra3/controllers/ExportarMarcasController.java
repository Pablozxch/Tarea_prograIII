/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.controllers;

import com.jfoenix.controls.*;
import cr.ac.una.tareaprogra3.services.*;
import cr.ac.una.tareaprogra3.utils.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.*;

/**
 * FXML Controller class
 *
 * @author jp015
 */
public class ExportarMarcasController extends Controller implements Initializable
{

    RegistroService service = new RegistroService();
    EmpleadoService empS = new EmpleadoService();
    @FXML
    private JFXButton btnMarcas;
    @FXML
    private JFXTextField txtFolio;
    @FXML
    private JFXButton btnGuardar;
    @FXML
    private JFXButton btnEmpleados;
    @FXML
    private JFXButton btnSalir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url , ResourceBundle rb)
    {

    }

    @Override
    public void initialize()
    {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void onActionBtnMarcas(ActionEvent event)
    {
        clickB();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF" , "*.pdf"));
        fileChooser.setInitialFileName("*.pdf");
        File selectedFile = fileChooser.showSaveDialog(new Stage());

        if(selectedFile != null)
        {
            File file2 = new File(selectedFile.toPath().toString());
            Respuesta res = service.obtenerJAll();
            byte[] decoder = (byte[]) res.getResultado("Registro");
            try(FileOutputStream fos = new FileOutputStream(file2);)
            {
                fos.write(decoder);
                new Mensaje().show(Alert.AlertType.CONFIRMATION , "Guardado" , "Con exito");
            }
            catch(Exception e)
            {
            }
        }
    }

    @FXML
    private void onActionBtnGuardar(ActionEvent event) throws IOException
    {
        clickB();
        if(!txtFolio.getText().isEmpty())
        {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF" , "*.pdf"));
            fileChooser.setInitialFileName("*.pdf");
            File selectedFile = fileChooser.showSaveDialog(new Stage());

            if(selectedFile != null)
            {
                File file2 = new File(selectedFile.toPath().toString());
                Respuesta res = service.obtenerJEmpF(txtFolio.getText());
                byte[] decoder = (byte[]) res.getResultado("Registro");
                try(FileOutputStream fos = new FileOutputStream(file2);)
                {
                    fos.write(decoder);
                    new Mensaje().show(Alert.AlertType.CONFIRMATION , "Guardado" , "Con exito");
                }
                catch(Exception e)
                {
                }
            }
        }
        else
        {
            new Mensaje().show(Alert.AlertType.WARNING , "ERROR" , "Folio No ingresado");
        }

    }

    @FXML
    private void onActionBtnEmpleados(ActionEvent event)
    {
        clickB();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF" , "*.pdf"));
        fileChooser.setInitialFileName("*.pdf");
        File selectedFile = fileChooser.showSaveDialog(new Stage());

        if(selectedFile != null)
        {
            File file2 = new File(selectedFile.toPath().toString());
            Respuesta res = empS.obtenerJAllE();
            byte[] decoder = (byte[]) res.getResultado("Empleado");
            try(FileOutputStream fos = new FileOutputStream(file2);)
            {
                fos.write(decoder);
                new Mensaje().show(Alert.AlertType.CONFIRMATION , "Guardado" , "Con exito");
            }
            catch(Exception e)
            {
            }
        }
    }

    @FXML
    private void click(ActionEvent event)
    {
        clickB();
        if(event.getSource() == btnSalir)
        {
            FlowController.getInstance().goVistas("MenuAdmin");
        }
    }

}
