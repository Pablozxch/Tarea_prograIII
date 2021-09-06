/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.models;

import java.io.*;
import java.math.*;

/**
 *
 * @author jp015
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "CTRL_ROL" , catalog = "" , schema = "RELOJUNA")
@javax.persistence.NamedQueries(
{
    @javax.persistence.NamedQuery(name = "CtrlRol.findAll" , query = "SELECT c FROM CtrlRol c") ,
    @javax.persistence.NamedQuery(name = "CtrlRol.findByRolId" , query = "SELECT c FROM CtrlRol c WHERE c.rolId = :rolId") ,
    @javax.persistence.NamedQuery(name = "CtrlRol.findByRolContra" , query = "SELECT c FROM CtrlRol c WHERE c.rolContra = :rolContra")
})
public class CtrlRol implements Serializable
{

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "ROL_ID")
    private BigDecimal rolId;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "ROL_CONTRA")
    private String rolContra;
    @javax.persistence.JoinColumn(name = "EMP_ID" , referencedColumnName = "EMP_ID")
    @javax.persistence.ManyToOne(optional = false , fetch = javax.persistence.FetchType.LAZY)
    private CtrlEmpleado empId;

    public CtrlRol()
    {
    }

    public CtrlRol(BigDecimal rolId)
    {
        this.rolId = rolId;
    }

    public CtrlRol(BigDecimal rolId , String rolContra)
    {
        this.rolId = rolId;
        this.rolContra = rolContra;
    }

    public BigDecimal getRolId()
    {
        return rolId;
    }

    public void setRolId(BigDecimal rolId)
    {
        this.rolId = rolId;
    }

    public String getRolContra()
    {
        return rolContra;
    }

    public void setRolContra(String rolContra)
    {
        this.rolContra = rolContra;
    }

    public CtrlEmpleado getEmpId()
    {
        return empId;
    }

    public void setEmpId(CtrlEmpleado empId)
    {
        this.empId = empId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if(!(object instanceof CtrlRol))
        {
            return false;
        }
        CtrlRol other = (CtrlRol) object;
        if((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "cr.ac.una.tareaprogra3.models.CtrlRol[ rolId=" + rolId + " ]";
    }
    
}
