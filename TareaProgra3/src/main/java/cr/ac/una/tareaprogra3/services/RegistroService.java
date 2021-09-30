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

    public Respuesta getRegistrofindByFolio(String folioaBuscar)
    {
        try
        {
            List<RegistroClienteDto> registtroClienteDto=new ArrayList<>();
            SoapWS_Service service = new SoapWS_Service();
            SoapWS port = service.getSoapWSPort();
            List<RegistroDto> emp=port.registroFolio(folioaBuscar);
            emp.forEach(empDto->
            {
                
                registtroClienteDto.add(new RegistroClienteDto(empDto));
            });
            registtroClienteDto.forEach(t->
            {
                System.out.println("Los valores del cliente son "+t.toString());
            });
            return new Respuesta(true , "" , "" , "Registro" , registtroClienteDto);
        }
        catch(Exception ex)
        {
            return new Respuesta(false , "Error gurdando el dato." , "getUser " + ex.getMessage());
        }
    }

}
