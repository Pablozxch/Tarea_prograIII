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
import net.sf.jasperreports.engine.util.*;

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
    public void saveRegistro(@WebParam(name = "reg2") RegistroDto reg)
    {
        System.out.println("El valor de es " + reg.toString());
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
     *
     * @param id
     * @return
     */
    @WebMethod(operationName = "getRegistro")
    public RegistroDto getRegistro(@WebParam(name = "id") Long id)
    {
        Respuesta respuesta = registroService.getRegistro(id);
        registroDto = (RegistroDto) respuesta.getResultado("Registro");
        return registroDto;
    }

    @WebMethod(operationName = "regtodo")
    public List<RegistroDto> getregtodo()
    {

        Respuesta respuesta = registroService.getAll();

        registrolist = (List<RegistroDto>) respuesta.getResultado("Registro");
        return registrolist;
    }

    @WebMethod(operationName = "deleteRegistro")
    public void deleteRegistro(@WebParam(name = "id") Long id)
    {
        registroService.eliminarRegistro(id);
    }

    @WebMethod(operationName = "deleteEmpleado")
    public void deleteEmpleado(@WebParam(name = "id") Long id)
    {
        empleadoService.eliminarEmpleado(id);
    }

    @WebMethod(operationName = "jasP")
    public byte[] jaspertodo()
    {
        Respuesta res = registroService.reporteALl();
        byte[] a = (byte[]) res.getResultado("Registro");
        return a;

    }

    @WebMethod(operationName = "jasPEmp")
    public byte[] jaspertodoEmp()
    {
        Respuesta res = empleadoService.reporteALlE();
        byte[] a = (byte[]) res.getResultado("Empleado");
        return a;

    }

    @WebMethod(operationName = "jasPFolio")
    public byte[] reporteByFolio(@WebParam(name = "EmpFolio") String EmpFolio)
    {
        Respuesta res = registroService.reporteByFolio(EmpFolio);
        byte[] a = (byte[]) res.getResultado("Registro");
        return a;
    }

}
