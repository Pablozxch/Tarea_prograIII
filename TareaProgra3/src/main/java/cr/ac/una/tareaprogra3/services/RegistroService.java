/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.services;

import cr.ac.una.tareaprogra3.models.*;
import cr.ac.una.tareaprogra3.utils.*;
import java.util.*;

/**
 *
 * @author jp015
 */
public class RegistroService
{

    public Respuesta getAll()
    {
        try
        {
            List<RegistroClienteDto> registtroClienteDto = new ArrayList<>();
            SoapWS_Service service = new SoapWS_Service();
            SoapWS port = service.getSoapWSPort();
            List<RegistroDto> emp = port.regtodo();
            emp.forEach(empDto ->
            {

                registtroClienteDto.add(new RegistroClienteDto(empDto));
            });
            registtroClienteDto.forEach(t ->
            {
                System.out.println("Los valores del del cliente en sus registros on " + t.toString());
            });
            return new Respuesta(true , "" , "" , "Registro" , registtroClienteDto);
        }
        catch(Exception ex)
        {
            return new Respuesta(false , "Error gurdando el dato." , "getUser " + ex.getMessage());
        }
    }

    public Respuesta getRegistrobyid(Long id)
    {
        try
        {
            SoapWS_Service service = new SoapWS_Service();
            SoapWS port = service.getSoapWSPort();
            RegistroDto emp = port.getRegistro(id);
            return new Respuesta(true , "" , "" , "Registro" , new RegistroClienteDto(emp));
        }
        catch(Exception ex)
        {
            return new Respuesta(false , "Error gurdando el dato." , "getUser " + ex.getMessage());
        }
    }

    public Respuesta getRegistrosfindByFolio(String folioaBuscar)
    {
        try
        {
            List<RegistroClienteDto> registtroClienteDto = new ArrayList<>();
            SoapWS_Service service = new SoapWS_Service();
            SoapWS port = service.getSoapWSPort();
            List<RegistroDto> emp = port.registroFolio(folioaBuscar);
            emp.forEach(empDto ->
            {

                registtroClienteDto.add(new RegistroClienteDto(empDto));
            });
            return new Respuesta(true , "" , "" , "Registro" , registtroClienteDto);
        }
        catch(Exception ex)
        {
            return new Respuesta(false , "Error gurdando el dato." , "getUser " + ex.getMessage());
        }
    }

    public Respuesta saveRegistro(RegistroClienteDto registroClienteDto , EmpleadoClienteDto emp)
    {
        try
        {

            SoapWS_Service service = new SoapWS_Service();
            SoapWS port = service.getSoapWSPort();
            RegistroDto reg = registroClienteDto.getRegistroToService(emp);
            port.saveRegistro(reg);
            return new Respuesta(true , "" , "" , "user" , reg);
        }
        catch(Exception ex)
        {
            return new Respuesta(false , "Error gurdando el dato." , "getUser " + ex.getMessage());
        }
    }

    public Respuesta saveRegistrobyid(RegistroClienteDto registroClienteDto)
    {
        try
        {

            SoapWS_Service service = new SoapWS_Service();
            SoapWS port = service.getSoapWSPort();
            RegistroDto reg = new RegistroDto();
            reg = registroClienteDto.getRegistroToService();
            System.out.println("El valor a gurdar es " + reg.getEmpId());
            port.saveRegistro(reg);
            return new Respuesta(true , "" , "" , "user" , reg);
        }
        catch(Exception ex)
        {
            return new Respuesta(false , "Error gurdando el dato." , "getUser " + ex.getMessage());
        }
    }

    public Respuesta eliminarRegistro(RegistroClienteDto registroClienteDto)
    {

        try
        {
            SoapWS_Service service = new SoapWS_Service();
            SoapWS port = service.getSoapWSPort();
            port.deleteRegistro(registroClienteDto.getId());
            return new Respuesta(true , "" , "" , "user" , registroClienteDto);
        }
        catch(Exception ex)
        {
            return new Respuesta(false , "Error al eliminar registro" , "deleteReg " + ex.getMessage());
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
