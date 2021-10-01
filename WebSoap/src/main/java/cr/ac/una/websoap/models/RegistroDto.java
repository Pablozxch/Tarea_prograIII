/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.websoap.models;

import java.time.*;
import java.util.*;

/**
 *
 * @author jp015
 */
public class RegistroDto
{

    private Long id;
    private Date fechaIngreso;
    private Date fechaSalida;
    private String completado;
    private EmpleadoDto empId;

    //verificar si es necesario el empleado
    public RegistroDto()
    {

        this.fechaIngreso = new Date();
        this.fechaSalida = new Date();
    }

    public RegistroDto(Registro registro)
    {
        this();
        this.id = registro.getRegId();
        this.fechaIngreso = registro.getRegEntrada();
        this.fechaSalida = registro.getRegSalida();
        this.completado = registro.getRegCompletado();
        this.empId=new EmpleadoDto(registro.getEmpId());//aqui busca el objeto empleado y lo manda 
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public Date getFechaIngreso()
    {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso)
    {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida()
    {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida)
    {
        this.fechaSalida = fechaSalida;
    }

    public String getCompletado()
    {
        return completado;
    }

    public void setCompletado(String completado)
    {
        this.completado = completado;
    }

    public EmpleadoDto getEmpId()
    {
        return empId;
    }

    public void setEmpId(EmpleadoDto empId)
    {
        this.empId = empId;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("RegistroDto{id=").append(id);
        sb.append(", fechaIngreso=").append(fechaIngreso);
        sb.append(", fechaSalida=").append(fechaSalida);
        sb.append(", completado=").append(completado);
        sb.append(", empId").append(empId);
        sb.append('}');
        return sb.toString();
    }

}
