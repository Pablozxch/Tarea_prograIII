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
@javax.persistence.Table(name = "CTRL_REGISTRO" , catalog = "" , schema = "RELOJUNA")
@javax.persistence.NamedQueries(
{
    @javax.persistence.NamedQuery(name = "CtrlRegistro.findAll" , query = "SELECT c FROM CtrlRegistro c") ,
    @javax.persistence.NamedQuery(name = "CtrlRegistro.findByRegId" , query = "SELECT c FROM CtrlRegistro c WHERE c.regId = :regId") ,
    @javax.persistence.NamedQuery(name = "CtrlRegistro.findByRegEntrada" , query = "SELECT c FROM CtrlRegistro c WHERE c.regEntrada = :regEntrada") ,
    @javax.persistence.NamedQuery(name = "CtrlRegistro.findByRegSalida" , query = "SELECT c FROM CtrlRegistro c WHERE c.regSalida = :regSalida") ,
    @javax.persistence.NamedQuery(name = "CtrlRegistro.findByRegCompletado" , query = "SELECT c FROM CtrlRegistro c WHERE c.regCompletado = :regCompletado")
})
public class CtrlRegistro implements Serializable
{

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "REG_ID")
    private BigDecimal regId;
    @javax.persistence.Column(name = "REG_ENTRADA")
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date regEntrada;
    @javax.persistence.Column(name = "REG_SALIDA")
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date regSalida;
    @javax.persistence.Column(name = "REG_COMPLETADO")
    private String regCompletado;
    @javax.persistence.JoinColumn(name = "HIS_ID" , referencedColumnName = "HIS_ID")
    @javax.persistence.ManyToOne(optional = false , fetch = javax.persistence.FetchType.LAZY)
    private CtrlHistorial hisId;

    public CtrlRegistro()
    {
    }

    public CtrlRegistro(BigDecimal regId)
    {
        this.regId = regId;
    }

    public BigDecimal getRegId()
    {
        return regId;
    }

    public void setRegId(BigDecimal regId)
    {
        this.regId = regId;
    }

    public Date getRegEntrada()
    {
        return regEntrada;
    }

    public void setRegEntrada(Date regEntrada)
    {
        this.regEntrada = regEntrada;
    }

    public Date getRegSalida()
    {
        return regSalida;
    }

    public void setRegSalida(Date regSalida)
    {
        this.regSalida = regSalida;
    }

    public String getRegCompletado()
    {
        return regCompletado;
    }

    public void setRegCompletado(String regCompletado)
    {
        this.regCompletado = regCompletado;
    }

    public CtrlHistorial getHisId()
    {
        return hisId;
    }

    public void setHisId(CtrlHistorial hisId)
    {
        this.hisId = hisId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (regId != null ? regId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if(!(object instanceof CtrlRegistro))
        {
            return false;
        }
        CtrlRegistro other = (CtrlRegistro) object;
        if((this.regId == null && other.regId != null) || (this.regId != null && !this.regId.equals(other.regId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "cr.ac.una.tareaprogra3.models.CtrlRegistro[ regId=" + regId + " ]";
    }
    
}
