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
            System.out.println("El valor del empleado en el service es " + empC.toString());
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
            System.out.println("El valor del empleado en el service es " + empC.toString());
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
            System.out.println("Los valores que vienen del empleado son " + empleadoClienteDto.toString());
            SoapWS_Service service = new SoapWS_Service();
            SoapWS port = service.getSoapWSPort();
            System.out.println("El valor es " + port);
            EmpleadoDto emp = empleadoClienteDto.getEmpleadoToService();
            System.out.println("El id es " + emp.getId());
            System.out.println("El nombre es " + emp.getNombre());
            System.out.println("El apellido es " + emp.getApellido());
            System.out.println("La foto es " + emp.getFoto());
            System.out.println("El folio es " + emp.getFolio());
            System.out.println("La foto es " + emp.getRol());

            port.saveEmpleado(emp);
            return new Respuesta(true , "" , "" , "user" , emp);
        }
        catch(Exception ex)
        {
            return new Respuesta(false , "Error gurdando el dato." , "getUser " + ex.getMessage());
        }
    }

//    public Respuesta eliminarEmpleado(String folio)
//    {
//        try
//        {
//             //return new Respuesta(true , "" , "" , "user" , EmpleadoClienteDto emp);
//        }
//        catch(Exception ex)
//        {
//            return new Respuesta(false , "Error gurdando el dato." , "getUser " + ex.getMessage());
//        }
//    }

}
