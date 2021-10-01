/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.websoap;

import cr.ac.una.websoap.models.*;
import cr.ac.una.websoap.services.*;
import cr.ac.una.websoap.utils.*;
import java.util.*;
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

    List<RegistroDto> registrolist = new ArrayList<RegistroDto>();
    EmpleadoDto empleadoDto;
    RegistroDto registroDto;

//    METODOS SOAP DEL EMPLEADO
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

//    guardarEmpleado(EmpleadoDto empleadoDto)
    @WebMethod(operationName = "SaveEmpleado")
    public void saveEmpleado(@WebParam(name = "emp") EmpleadoDto emp)
    {
        Respuesta respuesta = empleadoService.guardarEmpleado(emp);
    }
    //guardar registro
    @WebMethod(operationName = "SaveRegistro")
     public void saveRegistro(@WebParam(name = "reg") RegistroDto reg)
    {
        Respuesta respuesta = registroService.saveRegistro(reg);
    }

//    METODOS SOAP DEL EMPLEADO
    //    METODOS SOAP DEL REGISTRO
    @WebMethod(operationName = "RegistroFolio")//WORKEA
    public List<RegistroDto> getRegistroFolio(@WebParam(name = "folio") String fol)
    {
        Respuesta respuesta = registroService.getRegistrofindByFolio(fol);
        registrolist = (List<RegistroDto>) respuesta.getResultado("Registro");
        return registrolist;
    }

    @WebMethod(operationName = "RegistrosbyId")
    public List<RegistroDto> getRegistrosById(@WebParam(name = "id") Long id)
    {

        Respuesta respuesta = registroService.getRegistrosbyIdemp(id);

        registrolist = (List<RegistroDto>) respuesta.getResultado("Registro");
        return registrolist;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "regtodo")
    public List<RegistroDto> getregtodo()
    {

        Respuesta respuesta = registroService.getAll();

        registrolist = (List<RegistroDto>) respuesta.getResultado("Registro");
        return registrolist;
    }
}
