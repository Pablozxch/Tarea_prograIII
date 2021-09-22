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
import javax.persistence.*;

/**
 *
 * @author jp015
 */
public class RegistroService
{

    public Respuesta getRegistro(Long id)
    {
        try
        {
            return null;

        }
        catch(NoResultException ex)
        {
            return new Respuesta(false , "No existe un empleado con el codigo ingresado." , "getRegistro NoResultException");

        }
        catch(NonUniqueResultException ex)
        {
            Logger.getLogger(RegistroService.class.getName()).log(Level.SEVERE , "Ocurrio un error al consultar el empleado" , ex);
            return new Respuesta(false , "Ocurrio un error al consultar el empleado." , "getRegistro  NonUniqueResultException ");

        }
        catch(Exception ex)
        {
            Logger.getLogger(RegistroService.class.getName()).log(Level.SEVERE , "Error obteniendo el empleado [" + id + "]" , ex);
            return new Respuesta(false , "Error obteniendo el deporte ." , "getRegistro " + ex.getMessage());
        }
    }

}
