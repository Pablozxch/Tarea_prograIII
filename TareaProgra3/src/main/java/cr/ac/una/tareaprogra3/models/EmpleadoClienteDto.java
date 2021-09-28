/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.models;

import cr.ac.una.tareaprogra3.services.*;
import java.util.*;
import javafx.beans.property.*;


/**
 *
 * @author jp015
 */
public class EmpleadoClienteDto
{

//    @XmlTransient
    public SimpleStringProperty id;
//    @XmlTransient
    private SimpleStringProperty nombre;
//    @XmlTransient
    private SimpleStringProperty apellido;
//    @XmlTransient
    private SimpleStringProperty cedula;
//    @XmlTransient
    private ObjectProperty<Date> nacimiento;
//    @XmlTransient
    private ObjectProperty<byte[]> foto;
//    @XmlTransient
    public SimpleStringProperty folio;
//    @XmlTransient
    private SimpleStringProperty rol;

    public EmpleadoClienteDto()
    {
        this.id = new SimpleStringProperty();
        this.nombre = new SimpleStringProperty();
        this.apellido = new SimpleStringProperty();
        this.cedula = new SimpleStringProperty();
        this.nacimiento= new SimpleObjectProperty();
        this.foto = new SimpleObjectProperty();
        this.folio = new SimpleStringProperty();
        this.rol = new SimpleStringProperty();
    }
    public EmpleadoClienteDto(EmpleadoDto empleado)
    {
        this();
        this.id.set(empleado.getId().toString());
        this.nombre.set(empleado.getNombre());
        this.apellido.set(empleado.getApellido());
        this.cedula.set(empleado.getCedula());
        //this.nacimiento.set(empleado.getNacimiento().);
        this.foto.set(empleado.getFoto());
        this.folio.set(empleado.getFolio());
        this.rol.set(empleado.getRol());
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

    public void setNombre(String nombre)//Set de los nombres
    {
        this.nombre.set(nombre);
    }

    public String getNombre()//Get del nombre
    {
        return nombre.get();
    }

    public void setApellido(String apellido)//Set del apellido
    {
        this.apellido.set(apellido);
    }

    public String getApellido()//Get del apellido
    {
        return apellido.get();
    }

    public void setCedula(String cedula)//Set de la cedula
    {
        this.cedula.set(cedula);
    }

    public String getCedula()//Get de la cedula
    {
        return cedula.get();
    }

    public Date getfIngreso()
    {
        return nacimiento.getValue();
    }

    public void setNacimiento(Date nacimiento)
    {
        this.nacimiento.setValue(nacimiento);
    }

    public Date getNacimiento()
    {
        return nacimiento.getValue();
    }

    public void setFoto(byte[] foto)//!Ver bien como hacer un simplebyte
    {
        this.foto.set(foto);
    }

    public byte[] getFoto()
    {
        return foto.getValue(); //!Ver bien como hacer un simplebyte
    }

    public void setFolio(String folio)
    {
        this.folio.set(folio);
    }

    public String getFolio()
    {
        return folio.get();
    }

    public void setRol(String rol)
    {
        this.rol.set(rol);
    }

    public String getRol()
    {
        return rol.get();
    }

    @Override
    public String toString()
    {
        return "EmpleadoClienteDto{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", nacimiento=" + nacimiento + ", foto=" + foto + ", folio=" + folio + ", rol=" + rol + '}';
    }



}
