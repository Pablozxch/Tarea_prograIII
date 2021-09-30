/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.controllers;

import javafx.scene.control.Control;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author jp0151
 */
public abstract class Controller
{

    private Stage stage;
    private String accion;
    public static String Nfolio=new String();//Para obtener la imagen del admin es la parte del menu admin
    
    public String getAccion()
    {
        return accion;
    }
    public String getNfolio()
    {
        return Nfolio;
    }

    public void setNfolio(String Nfolio)
    {
        this.Nfolio = Nfolio;
    }

    public void setAccion(String accion)
    {
        this.accion = accion;
    }

    public void setStage(Stage stage)
    {
        this.stage = stage;
    }

    public Stage getStage()
    {
        return stage;
    }

    public void sendTabEvent(KeyEvent event)
    {
        event.consume();
        KeyEvent keyEvent = new KeyEvent(KeyEvent.KEY_PRESSED , null , null , KeyCode.TAB , false , false , false , false);
        ((Control) event.getSource()).fireEvent(keyEvent);
    }

    public boolean validaListaAyuda(KeyEvent event)
    {
        if(event.getCode() == KeyCode.F9)
        {
            try
            {
                TextInputControl control = (TextInputControl) event.getSource();
                return control.isEditable() && !control.isDisable();
            }
            catch(Exception ex)
            {
                try
                {
                    Control control = (Control) event.getSource();
                    return !control.isDisable();
                }
                catch(Exception exc)
                {
                    return false;
                }
            }
        }
        return false;
    }

    public abstract void initialize();

}
