/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.websoap.services;

import cr.ac.una.websoap.*;
import cr.ac.una.websoap.models.*;
import cr.ac.una.websoap.utils.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.ejb.*;
import javax.naming.*;
import javax.persistence.*;
import javax.sql.*;
import net.sf.jasperreports.engine.*;

/**
 *
 * @author jp015
 */
@Stateless
@LocalBean
public class EmpleadoService
{

    private static final Logger LOG = Logger.getLogger(EmpleadoService.class.getName());

    @PersistenceContext(unitName = "WebServiceSoap")
    private EntityManager em;

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
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE , "Error obteniendo el empleado [" + folio + "]" , ex);
            return new Respuesta(false , "Error obteniendo el deporte ." , "getEmpleado " + ex.getMessage());
        }
    }

    public Respuesta getEmpleadoAdmin(String folio , String pass , String rol)
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
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE , "Error obteniendo el admin [" + folio + "]" , ex);
            return new Respuesta(false , "Error obteniendo el deporte ." , "getEmpleado " + ex.getMessage());
        }
    }

    public Respuesta guardarEmpleado(EmpleadoDto empleadoDto)
    {
        try
        {
            Empleado empleado;
            if(empleadoDto.getId() != null && empleadoDto.getId() > 0)
            {
                empleado = em.find(Empleado.class , empleadoDto.getId());
                if(empleado == null)
                {
                    return new Respuesta(false , "No se encrontró el empleado a modificar." , "guardarEmpleado NoResultException");
                }
                empleado.actualizarEmpleado(empleadoDto);
                empleado = em.merge(empleado);
            }
            else
            {
                empleado = new Empleado(empleadoDto);
                em.persist(empleado);
            }
            em.flush();
            return new Respuesta(true , "" , "" , "Empleado" , new EmpleadoDto(empleado));
        }
        catch(Exception ex)
        {
            LOG.log(Level.SEVERE , "Ocurrio un error al guardar el empleado." , ex);
            return new Respuesta(false , "Ocurrio un error al guardar el empleado." , "guardarEmpleado " + ex.getMessage());
        }
    }

    public Respuesta eliminarEmpleado(Long id)
    {
        try
        {
            Empleado empleado;
            if(id != null && id > 0)
            {
                empleado = em.find(Empleado.class , id);
                if(empleado == null)
                {
                    return new Respuesta(false , "No se encrontró el empleado a modificar." , "Eliminar NoResultException");
                }
                em.remove(empleado);
            }
            else
            {
                return new Respuesta(false , "Error idk" , "Empleado");
            }
            em.flush();
            return new Respuesta(true , "Completado" , "Empleado");
        }
        catch(Exception ex)
        {
            LOG.log(Level.SEVERE , "Ocurrio un error al guardar el empleado." , ex);
            return new Respuesta(false , "Ocurrio un error al guardar el empleado." , "guardarEmpleado " + ex.getMessage());
        }
    }

    public Respuesta reporteALlE()
    {

        try
        {
            InputStream x = SoapWS.class.getClassLoader().getResourceAsStream("/cr/ac/una/websoap/reportes/ReportAllE.jrxml");
            JasperReport jasper = JasperCompileManager.compileReport(x);
            InitialContext initialContext = new InitialContext();
            DataSource dataSource = (DataSource) initialContext.lookup("jdbc/Reloj");
            Connection connection = dataSource.getConnection();

            HashMap<String , Object> map = new HashMap<>();
            JasperPrint print = JasperFillManager.fillReport(jasper , map , connection);
            String a = JasperExportManager.exportReportToXml(print);
            System.out.println(a);
            byte[] s = JasperExportManager.exportReportToPdf(print);
            return new Respuesta(true , "" , "" , "Empleado" , s);

        }
        catch(Exception ex)
        {
            LOG.log(Level.SEVERE , "Ocurrio un error al guardar el registro." , ex);
            return new Respuesta(false , "Ocurrio un error al guardar el registro." , "guardarRegistro " + ex.getMessage());
        }

    }

}
