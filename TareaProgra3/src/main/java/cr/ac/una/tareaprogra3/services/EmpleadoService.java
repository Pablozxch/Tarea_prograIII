/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.services;

import cr.ac.una.tareaprogra3.models.*;
import cr.ac.una.tareaprogra3.utils.*;
import java.util.logging.*;

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
            System.out.println("ejecutando servicio listar personas ws");
            cr.ac.una.tareaprogra3.services.SoapWS_Service service = new cr.ac.una.tareaprogra3.services.SoapWS_Service();
            cr.ac.una.tareaprogra3.services.SoapWS port = service.getSoapWSPort();
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
}
