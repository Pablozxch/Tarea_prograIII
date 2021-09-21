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


    EmpleadoDto empleadoDto;
    RegistroDto registroDto;

    @WebMethod(operationName = "EmpleadoFolio")
    public EmpleadoDto getEmpleadoFolio(@WebParam(name = "folio") String fol)
    {
        Respuesta respuesta = empleadoService.getEmpleadobyFolio(fol);
        empleadoDto = (EmpleadoDto) respuesta.getResultado("EmpleadoFolio");
        return empleadoDto;
    }

    @WebMethod(operationName = "EmpleadoAdmin")
    public EmpleadoDto getEmpleadoAdmin(@WebParam(name = "folio") String fol , @WebParam(name = "pas") String pass)
    {
        Respuesta respuesta = empleadoService.getEmpleadoAdmin(fol , pass , "A");
        empleadoDto = (EmpleadoDto) respuesta.getResultado("Admin");
        return empleadoDto;
    }
}
