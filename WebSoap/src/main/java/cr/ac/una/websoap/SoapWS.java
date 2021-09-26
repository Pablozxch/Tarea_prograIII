/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.websoap;

import cr.ac.una.websoap.models.*;
import cr.ac.una.websoap.services.*;
import cr.ac.una.websoap.utils.*;
import javax.ejb.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author jp015
 */
@WebService(serviceName = "SoapWS")
public class SoapWS
{

    @EJB
    EmpleadoService empleadoService;

    @EJB
    RegistroService registroService;

    EmpleadoDto empleadoDto;
    RegistroDto registroDto;

//    METODOS SOAP DEL EMPLEADO
    @WebMethod(operationName = "EmpleadoFolio")
    public EmpleadoDto getEmpleadoFolio(@WebParam(name = "folio") String fol)
    {
        Respuesta respuesta = empleadoService.getEmpleadobyFolio(fol);
        empleadoDto = (EmpleadoDto) respuesta.getResultado("EmpleadoFolio");
        System.out.println("El valor es "+empleadoDto.toString());
        return empleadoDto;
    }

    @WebMethod(operationName = "EmpleadoAdmin")
    public EmpleadoDto getEmpleadoAdmin(@WebParam(name = "folio") String fol , @WebParam(name = "pas") String pass)
    {
        Respuesta respuesta = empleadoService.getEmpleadoAdmin(fol , pass , "A");
        empleadoDto = (EmpleadoDto) respuesta.getResultado("Admin");
        return empleadoDto;
    }

//    guardarEmpleado(EmpleadoDto empleadoDto)
    @WebMethod(operationName = "SaveEmpleado")
    public String saveEmpleado(@WebParam(name = "employee") EmpleadoDto empDto)
    {
        Respuesta respuesta = empleadoService.guardarEmpleado(empDto);
        String s;
        if(respuesta.getEstado())
        {
            s = "Empleado guardado correctamente";
        }
        else
        {
            s = "Error al  guardado el empleado";
        }
        return s;
    }
//    METODOS SOAP DEL EMPLEADO

    
    
    //    METODOS SOAP DEL REGISTRO
}
