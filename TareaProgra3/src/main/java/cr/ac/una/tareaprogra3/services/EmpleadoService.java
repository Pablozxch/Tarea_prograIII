/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.services;

import cr.ac.una.tareaprogra3.models.*;
import cr.ac.una.tareaprogra3.utils.*;

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
            EmpleadoDto emp = (EmpleadoDto) port.empleadoFolio("folio");
            return new Respuesta(true , "" , "" , "User" , new EmpleadoClienteDto((emp)));

        }
        catch(Exception ex)
        {
            return new Respuesta(false , "Error obteniendo el deporte ." , "getUser " + ex.getMessage());
        }

    }

}
