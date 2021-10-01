/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.models;

import cr.ac.una.tareaprogra3.services.*;
import java.time.*;
import java.util.*;
import java.util.logging.*;
import javafx.beans.property.*;
import javax.xml.datatype.*;
//import javax.xml.bind.annotation.*;

/**
 *
 * @author jp015
 */
public class RegistroClienteDto
{

//    @XmlTransient
    public SimpleStringProperty id;
//    @XmlTransient
    public ObjectProperty<Date> fechaIngreso;
//    @XmlTransient
    public ObjectProperty<Date> fechaSalida;
//    @XmlTransient
    public SimpleStringProperty completado;
    public ObjectProperty<EmpleadoClienteDto> empId;

    //verificar si es necesario el empleado
    public RegistroClienteDto()
    {
        this.id = new SimpleStringProperty();
        this.fechaIngreso = new SimpleObjectProperty();
        this.fechaSalida = new SimpleObjectProperty();
        this.completado = new SimpleStringProperty();
        this.empId = new SimpleObjectProperty();
    }

    public RegistroClienteDto(RegistroDto registro)
    {
        this();
        this.id.set(registro.getId().toString());
        Date fingreso = registro.getFechaIngreso().toGregorianCalendar().getTime();
        Date fsalida = registro.getFechaSalida().toGregorianCalendar().getTime();
        this.fechaIngreso.set(fingreso);
        this.fechaSalida.set(fsalida);
        this.completado.set(registro.getCompletado());
        this.empId.set(new EmpleadoClienteDto(registro.getEmpId()));
    }

    public void setId(Long id)
    {
        this.id.set(id.toString());
    }

    public Long getId()
    {
        if(id.get() != null && !id.get().isEmpty())
        {
            return Long.valueOf(id.get());
        }
        else
        {
            return null;
        }
    }

    public Date getFechaIngreso()
    {
        return fechaIngreso.getValue();
    }

    public void setFechaIngreso(Date fechaIngreso)
    {
        this.fechaIngreso.setValue(fechaIngreso);
    }

    public Date getFechaSalida()
    {
        return fechaSalida.getValue();
    }

    public void setFechaSalida(Date fechaSalida)
    {
        this.fechaSalida.setValue(fechaSalida);
    }

    public String getCompletado()
    {
        return completado.get();
    }

    public void setCompletado(String completado)
    {
        this.completado.set(completado);
    }

    public EmpleadoClienteDto getEmpId()
    {
        return this.empId.get();
    }

    public void setEmpId(EmpleadoClienteDto empId)
    {
        this.empId.set(empId);
    }

    public RegistroDto getRegistroToService(EmpleadoClienteDto emp)
    {
        RegistroDto reg = new RegistroDto();
        GregorianCalendar fechaEntrada = new GregorianCalendar();
        fechaEntrada.setTime(this.getFechaIngreso());
        XMLGregorianCalendar datefechaEntrada;
        try
        {
            datefechaEntrada = DatatypeFactory.newInstance().newXMLGregorianCalendar(fechaEntrada);
            reg.setFechaIngreso(datefechaEntrada);

        }
        catch(DatatypeConfigurationException ex)
        {
            Logger.getLogger(EmpleadoClienteDto.class.getName()).log(Level.SEVERE , null , ex);
        }
        GregorianCalendar fechaSalida = new GregorianCalendar();
        fechaSalida.setTime(this.getFechaSalida());
         XMLGregorianCalendar datefechaSalida;
        try
        {
            datefechaSalida = DatatypeFactory.newInstance().newXMLGregorianCalendar(fechaSalida);
            reg.setFechaIngreso(datefechaSalida);

        }
        catch(DatatypeConfigurationException ex)
        {
            Logger.getLogger(EmpleadoClienteDto.class.getName()).log(Level.SEVERE , null , ex);
        }
        EmpleadoDto emp2=emp.getEmpleadoToService();
        reg.setEmpId(emp2);
        return reg;

    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("RegistroDto{id=").append(id);
        sb.append(", fechaIngreso=").append(fechaIngreso);
        sb.append(", fechaSalida=").append(fechaSalida);
        sb.append(", completado=").append(completado);
        sb.append(", empleado").append(empId.toString());
        sb.append('}');
        return sb.toString();
    }

}
