/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.services;

import cr.ac.una.tareaprogra3.models.*;
import cr.ac.una.tareaprogra3.utils.*;
import java.util.*;
import java.util.logging.*;
import javax.xml.datatype.*;

/**
 *
 * @author jp015
 */
public class EmpleadoService
{

    public Respuesta getEmpleadobyFolio(String folio)
    {
        try
        {
            SoapWS_Service service = new SoapWS_Service();
            SoapWS port = service.getSoapWSPort();
            EmpleadoDto emp = (EmpleadoDto) port.empleadoFolio(folio);
            EmpleadoClienteDto empC = new EmpleadoClienteDto(emp);
            // System.out.println("El valor del empleado en el service es " + empC.toString());
            return new Respuesta(true , "" , "" , "Empleado" , empC);
        }
        catch(Exception ex)
        {
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE , "Error obteniendo el deporte [" + folio + "]" , ex);
            return new Respuesta(false , "Error obteniendo el deporte ." , "getUser " + ex.getMessage());
        }

    }

    public Respuesta getEmpleadoAdmin(String username , String pass , String a)
    {
        try
        {
            SoapWS_Service service = new SoapWS_Service();
            SoapWS port = service.getSoapWSPort();
            EmpleadoDto emp = (EmpleadoDto) port.empleadoAdmin(username , pass);
            EmpleadoClienteDto empC = new EmpleadoClienteDto(emp);
            return new Respuesta(true , "" , "" , "Empleado" , empC);
        }
        catch(Exception ex)
        {
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE , "Error obteniendo el deporte [" + "admin" + "]" , ex);
            return new Respuesta(false , "Error obteniendo el deporte ." , "getUser " + ex.getMessage());
        }
    }

    public Respuesta guardarEmpleado(EmpleadoClienteDto empleadoClienteDto)
    {
        try
        {
            SoapWS_Service service = new SoapWS_Service();
            SoapWS port = service.getSoapWSPort();
            EmpleadoDto emp = empleadoClienteDto.getEmpleadoToService();
            port.saveEmpleado(emp);
            return new Respuesta(true , "" , "" , "user" , emp);
        }
        catch(Exception ex)
        {
            return new Respuesta(false , "Error gurdando el dato." , "getUser " + ex.getMessage());
        }
    }

    public Respuesta eliminarEmpleado(EmpleadoClienteDto emp)
    {
        try
        {
            SoapWS_Service service = new SoapWS_Service();
            SoapWS port = service.getSoapWSPort();
            port.deleteEmpleado(emp.getId());
            return new Respuesta(true , "" , "" , "User" , emp);
        }
        catch(Exception ex)
        {
            return new Respuesta(false , "Error al eliminar " , "Empleado " + ex.getMessage());
        }
    }

    public Respuesta obtenerJAllE()
    {
        try
        {
            SoapWS_Service service = new SoapWS_Service();
            SoapWS port = service.getSoapWSPort();
            byte[] pdfJ = port.jasPEmp();
            return new Respuesta(true , "" , "" , "Empleado" , pdfJ);
        }
        catch(Exception ex)
        {
            return new Respuesta(false , "Error al obtener registro" , "Registro obteniendo " + ex.getMessage());
        }
    }
}
