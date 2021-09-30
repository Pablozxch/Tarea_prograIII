/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.websoap.services;

import cr.ac.una.websoap.models.*;
import cr.ac.una.websoap.utils.Respuesta;

import java.util.*;
import java.util.logging.*;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jp015
 */
@Stateless
@LocalBean
public class RegistroService
{

    private static final Logger LOG = Logger.getLogger(EmpleadoService.class.getName());

    @PersistenceContext(unitName = "WebServiceSoap")
    private EntityManager em;

    public Respuesta getRegistro(Long id)//UNICO REGRISTRO
    {
        try
        {
            Query gryRegistro = em.createNamedQuery("Registro.findByRegId" , Registro.class);
            gryRegistro.setParameter("regId" , id);

            return new Respuesta(true , "" , "" , "Registro" , new RegistroDto((Registro) gryRegistro.getSingleResult()));

        }
        catch(NoResultException ex)
        {
            return new Respuesta(false , "No existe un registro con las credenciales ingresadas." , "validarUsuario NoResultException");
        }
        catch(NonUniqueResultException ex)
        {
            LOG.log(Level.SEVERE , "Ocurrio un error al consultar el registro." , ex);
            return new Respuesta(false , "Ocurrio un error al consultar el registro." , "validarUsuario NonUniqueResultException");
        }
        catch(Exception ex)
        {
            LOG.log(Level.SEVERE , "Ocurrio un error al consultar el registro." , ex);
            return new Respuesta(false , "Ocurrio un error al consultar el registro." , "validarUsuario " + ex.getMessage());
        }
    }

    public Respuesta getRegistrosbyIdemp(Long Idemp)//LISTA DE REGRISTROS POR IDEMP 
    {

        try
        {
            Query qryRegistros = em.createNamedQuery("Registro.todo" , Registro.class);
            qryRegistros.setParameter("empId" , Idemp);
            List<Registro> registros = qryRegistros.getResultList();
            List<RegistroDto> registrosDto = new ArrayList<>();
            registros.forEach(Registros1 ->
            {
                registrosDto.add(new RegistroDto(Registros1));
            });
            return new Respuesta(true , "" , "" , "Registro" , registrosDto);

        }
        catch(NoResultException ex)
        {
            return new Respuesta(false , "No existen empleados con los criterios ingresados." , "getEmpleados NoResultException");
        }
        catch(Exception ex)
        {
            LOG.log(Level.SEVERE , "Ocurrio un error al consultar el empleado." , ex);
            return new Respuesta(false , "Ocurrio un error al consultar el empleado." , "getEmpleado " + ex.getMessage());
        }

    }

    public Respuesta getRegistrofindByFolio(String empFolio)//POR FOLIO
    {

        try
        {
            Query qryRegistros = em.createNamedQuery("Registro.findbyFolio" , Registro.class);
            qryRegistros.setParameter("empFolio" , empFolio);
            List<Registro> registros = qryRegistros.getResultList();
            List<RegistroDto> registrosDto = new ArrayList<>();
            registros.forEach(Registros1 ->
            {
                registrosDto.add(new RegistroDto(Registros1));
            });
            return new Respuesta(true , "" , "" , "Registro" , registrosDto);
        }
        catch(NoResultException ex)
        {
            return new Respuesta(false , "No existen empleados con los criterios ingresados." , "getEmpleados NoResultException");
        }
        catch(Exception ex)
        {
            LOG.log(Level.SEVERE , "Ocurrio un error al consultar el empleado." , ex);
            return new Respuesta(false , "Ocurrio un error al consultar el empleado." , "getEmpleado " + ex.getMessage());
        }
    }

}
