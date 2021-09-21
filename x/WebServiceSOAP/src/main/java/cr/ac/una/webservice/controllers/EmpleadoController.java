/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.webservice.controllers;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;

import javax.ws.rs.Path;

import javax.ws.rs.core.Response;
import cr.ac.una.webservice.models.*;

import cr.ac.una.webservice.utils.*;

import cr.ac.una.webservice.services.*;

/**
 *
 * @author Carlos
 */
public class EmpleadoController
{

    //TODO
    @EJB
    EmpleadoService empleadoService;

    //TODO
    public Response getUsuario(String folio)
    {
        try
        {
            Respuesta res = empleadoService.getEmpleadobyFolio(folio);
            EmpleadoDto empleadoDto = (EmpleadoDto) res.getResultado("Empleado");
            System.out.println("El valor es "+empleadoDto.toString());
        }
        catch(Exception ex)
        {
            Logger.getLogger(EmpleadoController.class.getName()).log(Level.SEVERE , null , ex);
            return null;//TODO
        }
        return null;
    }

}
