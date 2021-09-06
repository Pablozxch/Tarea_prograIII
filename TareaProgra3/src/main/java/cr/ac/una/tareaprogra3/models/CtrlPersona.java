/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.models;

import java.io.*;
import java.math.*;
import java.util.*;

/**
 *
 * @author jp015
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "CTRL_PERSONA" , catalog = "" , schema = "RELOJUNA")
@javax.persistence.NamedQueries(
{
    @javax.persistence.NamedQuery(name = "CtrlPersona.findAll" , query = "SELECT c FROM CtrlPersona c") ,
    @javax.persistence.NamedQuery(name = "CtrlPersona.findByPerId" , query = "SELECT c FROM CtrlPersona c WHERE c.perId = :perId") ,
    @javax.persistence.NamedQuery(name = "CtrlPersona.findByPerNombre" , query = "SELECT c FROM CtrlPersona c WHERE c.perNombre = :perNombre") ,
    @javax.persistence.NamedQuery(name = "CtrlPersona.findByPerApellido" , query = "SELECT c FROM CtrlPersona c WHERE c.perApellido = :perApellido") ,
    @javax.persistence.NamedQuery(name = "CtrlPersona.findByPerCedula" , query = "SELECT c FROM CtrlPersona c WHERE c.perCedula = :perCedula") ,
    @javax.persistence.NamedQuery(name = "CtrlPersona.findByPerNacimiento" , query = "SELECT c FROM CtrlPersona c WHERE c.perNacimiento = :perNacimiento")
})
public class CtrlPersona implements Serializable
{

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "PER_ID")
    private BigDecimal perId;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "PER_NOMBRE")
    private String perNombre;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "PER_APELLIDO")
    private String perApellido;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "PER_CEDULA")
    private String perCedula;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Lob
    @javax.persistence.Column(name = "PER_FOTO")
    private Serializable perFoto;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "PER_NACIMIENTO")
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date perNacimiento;
    @javax.persistence.OneToMany(mappedBy = "perId" , fetch = javax.persistence.FetchType.LAZY)
    private List<CtrlEmpleado> ctrlEmpleadoList;

    public CtrlPersona()
    {
    }

    public CtrlPersona(BigDecimal perId)
    {
        this.perId = perId;
    }

    public CtrlPersona(BigDecimal perId , String perNombre , String perApellido , String perCedula , Serializable perFoto , Date perNacimiento)
    {
        this.perId = perId;
        this.perNombre = perNombre;
        this.perApellido = perApellido;
        this.perCedula = perCedula;
        this.perFoto = perFoto;
        this.perNacimiento = perNacimiento;
    }

    public BigDecimal getPerId()
    {
        return perId;
    }

    public void setPerId(BigDecimal perId)
    {
        this.perId = perId;
    }

    public String getPerNombre()
    {
        return perNombre;
    }

    public void setPerNombre(String perNombre)
    {
        this.perNombre = perNombre;
    }

    public String getPerApellido()
    {
        return perApellido;
    }

    public void setPerApellido(String perApellido)
    {
        this.perApellido = perApellido;
    }

    public String getPerCedula()
    {
        return perCedula;
    }

    public void setPerCedula(String perCedula)
    {
        this.perCedula = perCedula;
    }

    public Serializable getPerFoto()
    {
        return perFoto;
    }

    public void setPerFoto(Serializable perFoto)
    {
        this.perFoto = perFoto;
    }

    public Date getPerNacimiento()
    {
        return perNacimiento;
    }

    public void setPerNacimiento(Date perNacimiento)
    {
        this.perNacimiento = perNacimiento;
    }

    public List<CtrlEmpleado> getCtrlEmpleadoList()
    {
        return ctrlEmpleadoList;
    }

    public void setCtrlEmpleadoList(List<CtrlEmpleado> ctrlEmpleadoList)
    {
        this.ctrlEmpleadoList = ctrlEmpleadoList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if(!(object instanceof CtrlPersona))
        {
            return false;
        }
        CtrlPersona other = (CtrlPersona) object;
        if((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "cr.ac.una.tareaprogra3.models.CtrlPersona[ perId=" + perId + " ]";
    }
    
}
