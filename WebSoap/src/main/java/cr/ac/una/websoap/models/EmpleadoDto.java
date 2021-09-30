/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.websoap.models;

import cr.ac.una.websoap.models.Empleado;
import java.util.*;

/**
 *
 * @author jp015
 */
public class EmpleadoDto
{

    private Long id;
    private String nombre;
    private String apellido;
    private String cedula;
    private Date nacimiento;
    private byte[] foto;
    private String folio;
    private String rol;

    public EmpleadoDto()
    {
       this.nacimiento=new Date();
    }

    public EmpleadoDto(Empleado empleado)
    {
        this();
        this.id = empleado.getEmpId();
        this.nombre= empleado.getEmNombre();
        this.apellido=empleado.getEmpApellido();
        this.cedula=empleado.getEmpCedula();
        this.nacimiento=empleado.getEmpNacimiento();
        this.foto=empleado.getEmpFoto();
        this.folio=empleado.getEmpFolio();
        this.rol=empleado.getEmpRol();
    }

    public void setId(Long id)
    {
        this.id= id;
    }

    public Long getId()
    {
        return this.id;
    }

    public void setNombre(String nombre)//Set de los nombres
    {
        this.nombre=nombre;
    }

    public String getNombre()//Get del nombre
    {
        return nombre;
    }

    public void setApellido(String apellido)//Set del apellido
    {
        this.apellido=apellido;
    }

    public String getApellido()//Get del apellido
    {
        return apellido;
    }

    public void setCedula(String cedula)//Set de la cedula
    {
        this.cedula=cedula;
    }

    public String getCedula()//Get de la cedula
    {
        return cedula;
    }

    public Date getfIngreso()
    {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento)
    {
        this.nacimiento=nacimiento;
    }

    public Date getNacimiento()
    {
        return nacimiento;
    }

    public void setFoto(byte[] foto)//!Ver bien como hacer un simplebyte
    {
        this.foto = foto;
    }

    public byte[] getFoto()
    {
        return foto; //!Ver bien como hacer un simplebyte
    }

    public void setFolio(String folio)
    {
        this.folio=folio;
    }

    public String getFolio()
    {
        return folio;
    }

    public void setRol(String rol)
    {
        this.rol=rol;
    }

    public String getRol()
    {
        return rol;
    }

    @Override
    public String toString()
    {
        return "EmpleadoDto{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", nacimiento=" + nacimiento + ", foto=" + foto + ", folio=" + folio + ", rol=" + rol + '}';
    }



}
