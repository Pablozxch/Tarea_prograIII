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
@javax.persistence.Table(name = "CTRL_HISTORIAL" , catalog = "" , schema = "RELOJUNA")
@javax.persistence.NamedQueries(
{
    @javax.persistence.NamedQuery(name = "CtrlHistorial.findAll" , query = "SELECT c FROM CtrlHistorial c") ,
    @javax.persistence.NamedQuery(name = "CtrlHistorial.findByHisId" , query = "SELECT c FROM CtrlHistorial c WHERE c.hisId = :hisId")
})
public class CtrlHistorial implements Serializable
{

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "HIS_ID")
    private BigDecimal hisId;
    @javax.persistence.JoinColumn(name = "EMP_ID" , referencedColumnName = "EMP_ID")
    @javax.persistence.ManyToOne(optional = false , fetch = javax.persistence.FetchType.LAZY)
    private CtrlEmpleado empId;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL , mappedBy = "hisId" , fetch = javax.persistence.FetchType.LAZY)
    private List<CtrlRegistro> ctrlRegistroList;

    public CtrlHistorial()
    {
    }

    public CtrlHistorial(BigDecimal hisId)
    {
        this.hisId = hisId;
    }

    public BigDecimal getHisId()
    {
        return hisId;
    }

    public void setHisId(BigDecimal hisId)
    {
        this.hisId = hisId;
    }

    public CtrlEmpleado getEmpId()
    {
        return empId;
    }

    public void setEmpId(CtrlEmpleado empId)
    {
        this.empId = empId;
    }

    public List<CtrlRegistro> getCtrlRegistroList()
    {
        return ctrlRegistroList;
    }

    public void setCtrlRegistroList(List<CtrlRegistro> ctrlRegistroList)
    {
        this.ctrlRegistroList = ctrlRegistroList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (hisId != null ? hisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if(!(object instanceof CtrlHistorial))
        {
            return false;
        }
        CtrlHistorial other = (CtrlHistorial) object;
        if((this.hisId == null && other.hisId != null) || (this.hisId != null && !this.hisId.equals(other.hisId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "cr.ac.una.tareaprogra3.models.CtrlHistorial[ hisId=" + hisId + " ]";
    }
    
}
