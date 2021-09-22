/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.services;

import cr.ac.una.tareaprogra3.models.*;
import cr.ac.una.tareaprogra3.utils.*;
import java.util.logging.*;
import javax.persistence.*;

/**
 *
 * @author jp015
 */
public class EmpleadoService
{

    

    public String getEmpleado(Long id)
    {
        SoapWS soapWS = new SoapWS_Service().getSoapWSPort();
        System.out.println("ejecutando servicio listar personas ws");
        soapWS.empleadoFolio("EP");
        return "El valor del empleado en el service es ";

    }

    public Respuesta getEmpleadobyFolio(String folio)
    {
        try
        {
            return null;

        }
        catch(NoResultException ex)
        {
            return new Respuesta(false , "No existe un empleado con el codigo ingresado." , "getEmpleado NoResultException");

        }
        catch(NonUniqueResultException ex)
        {
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE , "Ocurrio un error al consultar el empleado" , ex);
            return new Respuesta(false , "Ocurrio un error al consultar el empleado." , "getEmpleado  NonUniqueResultException ");

        }
        catch(Exception ex)
        {
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE , "Error obteniendo el empleado [" + folio + "]" , ex);
            return new Respuesta(false , "Error obteniendo el deporte ." , "getEmpleado " + ex.getMessage());
        }
    }

    public Respuesta getEmpleadoAdmin(String folio , String pass , String rol)
    {

        try
        {
            return null;

        }
        catch(NoResultException ex)
        {
            return new Respuesta(false , "No existe un admin con el codigo ingresado." , "getEmpleadoAdmin NoResultException");

        }
        catch(NonUniqueResultException ex)
        {
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE , "Ocurrio un error al consultar el empleado" , ex);
            return new Respuesta(false , "Ocurrio un error al consultar el empleado." , "getEmpleado  NonUniqueResultException ");

        }
        catch(Exception ex)
        {
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE , "Error obteniendo el admin [" + folio + "]" , ex);
            return new Respuesta(false , "Error obteniendo el deporte ." , "getEmpleado " + ex.getMessage());
        }
    }

}
