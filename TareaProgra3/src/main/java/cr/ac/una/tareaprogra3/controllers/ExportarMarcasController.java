/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.controllers;

import cr.ac.una.tareaprogra3.services.*;
import cr.ac.una.tareaprogra3.utils.*;
import java.io.*;
import java.net.URL;
import java.nio.charset.*;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author jp015
 */
public class ExportarMarcasController extends Controller implements Initializable
{

    RegistroService service = new RegistroService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
        // TODO
        Respuesta res = service.obtenerJAll();
        byte[] decoder = (byte[]) res.getResultado("Registro");

        File file = new File("./test.pdf");

        try(FileOutputStream fos = new FileOutputStream(file);)
        {
            fos.write(decoder);
            System.out.println("PDF File Saved");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        Respuesta res2 = service.obtenerJEmpF("EP");
        byte[] decoder2 = (byte[]) res2.getResultado("Registro");

        File file2 = new File("./test2.pdf");

        try(FileOutputStream fos = new FileOutputStream(file2);)
        {
            fos.write(decoder2);
            System.out.println("PDF File2 Saved");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize()
    {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
