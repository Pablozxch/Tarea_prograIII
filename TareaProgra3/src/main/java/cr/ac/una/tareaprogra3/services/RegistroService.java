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

    EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;  //se encarga del commit , rollback

    public Respuesta getRegistro(Long id)
    {
        try
        {
            Query gryRegistro = em.createNamedQuery("Registro.findByRegId" , Registro.class);
            gryRegistro.setParameter("regId" , id);

            return new Respuesta(true , "" , "" , "Registro" , new RegistroDto((Registro) gryRegistro.getSingleResult()));

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

    public List<RegistroDto> getRegistrosbyIdemp(Long Idemp)
    {

        try
        {
            Query qryRegistros = em.createNamedQuery("Registro.todo" , Registro.class);
            qryRegistros.setParameter("empId" , Idemp);
            List<Registro> registros = qryRegistros.getResultList();
            List<RegistroDto> registrosDto = new ArrayList<>();
            for(Registro Registros1 : registros)
            {
                registrosDto.add(new RegistroDto(Registros1));
            }
            return registrosDto;
            //return new Respuesta(true, Mensaje.CORRECTO, "", "", "Registros", RegistroDto);
        }
        catch(NoResultException ex)
        {
            return null;
            //return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existen Registros con los criterios ingresados.", "getRegistros NoResultException");
        }
        catch(Exception ex)
        {
            return null;
            //Logger.getLogger(RegistroService.class.getName()).log(Level.SEVERE , "Error obteniendo el empleado [" +  + "]" , ex);
            //return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el Registro.", "getRegistros " + ex.getMessage());
        }

    }

    public List<RegistroDto> getRegistrofindByFolio(String empFolio)
    {
        
        try
        {
            Query qryRegistros = em.createNamedQuery("Registro.findbyFolio" , Registro.class);
            qryRegistros.setParameter("empFolio" , empFolio);
            List<Registro> registros = qryRegistros.getResultList();
            List<RegistroDto> registrosDto = new ArrayList<>();
            for(Registro Registros1 : registros)
            {
                registrosDto.add(new RegistroDto(Registros1));
            }
            return registrosDto;
            //return new Respuesta(true, Mensaje.CORRECTO, "", "", "Registros", RegistroDto);
        }
        catch(NoResultException ex)
        {
            return null;
            //return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existen Registros con los criterios ingresados.", "getRegistros NoResultException");
        }
        catch(Exception ex)
        {
            return null;
            //Logger.getLogger(RegistroService.class.getName()).log(Level.SEVERE , "Error obteniendo el empleado [" +  + "]" , ex);
            //return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el Registro.", "getRegistros " + ex.getMessage());
        }
    }

}
