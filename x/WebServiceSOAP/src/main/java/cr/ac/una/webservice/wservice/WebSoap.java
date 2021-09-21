/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.webservice.wservice;

import cr.ac.una.webservice.controllers.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author jp015
 */
@WebService(serviceName = "WebSoap")
public class WebSoap
{

    /**
     * This is a sample web service operation
     */
     @WebMethod(operationName = "EmpleadoFolio")
    public String getEmpleadoFolio(@WebParam(name = "folio") String fol)
    {
        EmpleadoController emp = new EmpleadoController();
        emp.getUsuario(fol);
        System.out.println("El valor es " );
        return "hola ";
    }
}
