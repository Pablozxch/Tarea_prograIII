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

    EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;  //se encarga del commit , rollback

    public Respuesta getEmpleado(Long id)
    {
        try
        {
            Query gryEmpleado = em.createNamedQuery("Empleado.findByEmpId" , Empleado.class);
            gryEmpleado.setParameter("empId" , id);

            return new Respuesta(true , "" , "" , "Empleado" , new EmpleadoDto((Empleado) gryEmpleado.getSingleResult()));

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
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE , "Error obteniendo el empleado [" + id + "]" , ex);
            return new Respuesta(false , "Error obteniendo el deporte ." , "getEmpleado " + ex.getMessage());
        }
    }
    public Respuesta getEmpleadobyFolio(String folio)
    {
        try
        {
            Query gryEmpleado = em.createNamedQuery("Empleado.findByEmpFolio" , Empleado.class);
            gryEmpleado.setParameter("empFolio" , folio);

            return new Respuesta(true , "" , "" , "EmpleadoFolio" , new EmpleadoDto((Empleado) gryEmpleado.getSingleResult()));

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
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE , "Error obteniendo el empleado [" + folio+ "]" , ex);
            return new Respuesta(false , "Error obteniendo el deporte ." , "getEmpleado " + ex.getMessage());
        }
    }
     public Respuesta getEmpleadoAdmin(String folio, String pass,String rol)
     {
         
           try
        {
            Query gryEmpleado = em.createNamedQuery("Empleado.loginAdmin" , Empleado.class);
            gryEmpleado.setParameter("empFolio" , folio);
            gryEmpleado.setParameter("empContra" , pass);
            gryEmpleado.setParameter("empRol" , rol);
            return new Respuesta(true , "" , "" , "Admin" , new EmpleadoDto((Empleado) gryEmpleado.getSingleResult()));

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
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE , "Error obteniendo el admin [" + folio+ "]" , ex);
            return new Respuesta(false , "Error obteniendo el deporte ." , "getEmpleado " + ex.getMessage());
        }      
     }
    
     
     
     
     
     
     public Respuesta guardarEmpleado(EmpleadoDto empleadoDto)
    {
        try
        {
            et = em.getTransaction();
            et.begin();
            Empleado empleado;

            if(empleadoDto.getId() != null && empleadoDto.getId() > 0)
            {
                empleado = em.find(Empleado.class , empleadoDto.getId());
                if(empleado == null)
                {
                    et.rollback();
                    return new Respuesta(false , "No se encontro el empleado a modificar" , "guardarEmpleado NoResultExteption");
                }
                empleado.actualizarEmpleado(empleadoDto);
                empleado = em.merge(empleado);
            }
            else
            {

                empleado = new Empleado(empleadoDto);
                em.persist(empleado);
            }
            et.commit();
            return new Respuesta(true , "" , "" , "Empleado" , new EmpleadoDto(empleado));
        }
        catch(Exception ex)
        {
            et.rollback();
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE , "Error guardando el empleado." , ex);
            return new Respuesta(false , "Error guardando el empleado." , "guardarEmpleado " + ex.getMessage());
        }
    }
     
}
