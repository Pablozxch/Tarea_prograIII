/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.controllers;

import cr.ac.una.tareaprogra3.models.*;
import javafx.scene.control.Control;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.media.*;

/**
 *
 * @author jp0151
 */
public abstract class Controller
{

    private Stage stage;
    private String accion;
    public static String Nfolio = new String();//Para obtener la imagen del admin es la parte del menu admin
    public static EmpleadoClienteDto emp = new EmpleadoClienteDto();
    private static RegistroClienteDto reg = new RegistroClienteDto();
    public MediaPlayer musica;

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

    public EmpleadoClienteDto getEmp()
    {
        return emp;
    }

    public void setEmp(EmpleadoClienteDto emp)
    {
        this.emp = emp;
    }

    public RegistroClienteDto getReg()
    {
        return reg;
    }

    public void setReg(RegistroClienteDto aReg)
    {
        this.reg = aReg;
    }

    public void clickB()
    {
        Media audio = new Media(this.getClass().getResource("/cr/ac/una/tareaprogra3/resources/clickBtton.mp3").toString());
        musica = new MediaPlayer(audio);
        musica.setCycleCount(1);
        musica.setVolume(0.04);
        musica.play();
    }

    public void happyB()
    {
        Media audio = new Media(this.getClass().getResource("/cr/ac/una/defender/resources/HB.mp3").toString());
        musica = new MediaPlayer(audio);
        musica.setCycleCount(1);
        musica.setVolume(0.04);
        musica.play();
    }
}
