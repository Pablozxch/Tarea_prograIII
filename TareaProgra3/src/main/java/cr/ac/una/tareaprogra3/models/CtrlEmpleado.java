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
@javax.persistence.Table(name = "CTRL_EMPLEADO" , catalog = "" , schema = "RELOJUNA")
@javax.persistence.NamedQueries(
{
    @javax.persistence.NamedQuery(name = "CtrlEmpleado.findAll" , query = "SELECT c FROM CtrlEmpleado c") ,
    @javax.persistence.NamedQuery(name = "CtrlEmpleado.findByEmpId" , query = "SELECT c FROM CtrlEmpleado c WHERE c.empId = :empId") ,
    @javax.persistence.NamedQuery(name = "CtrlEmpleado.findByEmpHorastrabajadas" , query = "SELECT c FROM CtrlEmpleado c WHERE c.empHorastrabajadas = :empHorastrabajadas")
})
public class CtrlEmpleado implements Serializable
{

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "EMP_ID")
    private BigDecimal empId;
    @javax.persistence.Column(name = "EMP_HORASTRABAJADAS")
    private BigInteger empHorastrabajadas;
    @javax.persistence.JoinColumn(name = "PER_ID" , referencedColumnName = "PER_ID")
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.LAZY)
    private CtrlPersona perId;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL , mappedBy = "empId" , fetch = javax.persistence.FetchType.LAZY)
    private List<CtrlRol> ctrlRolList;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL , mappedBy = "empId" , fetch = javax.persistence.FetchType.LAZY)
    private List<CtrlHistorial> ctrlHistorialList;

    public CtrlEmpleado()
    {
    }

    public CtrlEmpleado(BigDecimal empId)
    {
        this.empId = empId;
    }

    public BigDecimal getEmpId()
    {
        return empId;
    }

    public void setEmpId(BigDecimal empId)
    {
        this.empId = empId;
    }

    public BigInteger getEmpHorastrabajadas()
    {
        return empHorastrabajadas;
    }

    public void setEmpHorastrabajadas(BigInteger empHorastrabajadas)
    {
        this.empHorastrabajadas = empHorastrabajadas;
    }

    public CtrlPersona getPerId()
    {
        return perId;
    }

    public void setPerId(CtrlPersona perId)
    {
        this.perId = perId;
    }

    public List<CtrlRol> getCtrlRolList()
    {
        return ctrlRolList;
    }

    public void setCtrlRolList(List<CtrlRol> ctrlRolList)
    {
        this.ctrlRolList = ctrlRolList;
    }

    public List<CtrlHistorial> getCtrlHistorialList()
    {
        return ctrlHistorialList;
    }

    public void setCtrlHistorialList(List<CtrlHistorial> ctrlHistorialList)
    {
        this.ctrlHistorialList = ctrlHistorialList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if(!(object instanceof CtrlEmpleado))
        {
            return false;
        }
        CtrlEmpleado other = (CtrlEmpleado) object;
        if((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "cr.ac.una.tareaprogra3.models.CtrlEmpleado[ empId=" + empId + " ]";
    }
    
}
