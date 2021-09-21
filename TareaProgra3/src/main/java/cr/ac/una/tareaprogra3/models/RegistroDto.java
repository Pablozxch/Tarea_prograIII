/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.models;

import java.time.*;
import java.util.*;
import javafx.beans.property.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author jp015
 */
public class RegistroDto
{

    @XmlTransient
    public SimpleStringProperty id;
    @XmlTransient
    public ObjectProperty<Date> fechaIngreso;
    @XmlTransient
    public ObjectProperty<Date> fechaSalida;
    @XmlTransient
    public SimpleStringProperty completado;

    //verificar si es necesario el empleado
    public RegistroDto()
    {
        this.id = new SimpleStringProperty();
        this.fechaIngreso = new SimpleObjectProperty();
        this.fechaSalida = new SimpleObjectProperty();
        this.completado = new SimpleStringProperty();
    }

    public RegistroDto(Registro registro)
    {
        this();
        this.id.set(registro.getRegId().toString());
        this.fechaIngreso.set(registro.getRegEntrada());
        this.fechaSalida.set(registro.getRegSalida());
        this.completado.set(registro.getRegCompletado());
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

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("RegistroDto{id=").append(id);
        sb.append(", fechaIngreso=").append(fechaIngreso);
        sb.append(", fechaSalida=").append(fechaSalida);
        sb.append(", completado=").append(completado);
        sb.append('}');
        return sb.toString();
    }

}
