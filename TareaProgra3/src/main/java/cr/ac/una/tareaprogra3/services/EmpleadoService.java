/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.services;

/**
 *
 * @author jp015
 */
public class EmpleadoService
{

    public String getEmpleado(Long id)
    {
        System.out.println("ejecutando servicio listar personas ws");
        SoapWS_Service service = new SoapWS_Service();
        SoapWS port=service.getSoapWSPort();
        port.empleadoFolio("EP");
        String a="El valor del empleado en el service es ";
        return a;

    }

}
