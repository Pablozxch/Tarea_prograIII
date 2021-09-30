/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.websoap.models;

import cr.ac.una.websoap.models.Empleado;
import java.io.*;
import java.math.*;
import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author jp015
 */
@Entity
@Table(name = "CTRL_REGISTRO" , catalog = "" , schema = "RELOJUNA")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Registro.findAll" , query = "SELECT r FROM Registro r") ,
    @NamedQuery(name = "Registro.findByRegId" , query = "SELECT r FROM Registro r WHERE r.regId = :regId") ,
    @NamedQuery(name = "Registro.findByRegEntrada" , query = "SELECT r FROM Registro r WHERE r.regEntrada = :regEntrada") ,
    @NamedQuery(name = "Registro.findByRegSalida" , query = "SELECT r FROM Registro r WHERE r.regSalida = :regSalida") ,
    @NamedQuery(name = "Registro.findByRegCompletado" , query = "SELECT r FROM Registro r WHERE r.regCompletado = :regCompletado"),
    @NamedQuery(name="Registro.todo",query = "SELECT r FROM Registro r JOIN r.empId e WHERE e.empId = :empId"),
    @NamedQuery(name="Registro.findbyFolio",query = "SELECT r FROM Registro r JOIN r.empId e WHERE e.empFolio = :empFolio"),//consulto otra tabla viajando por el id pero sin hacer uso de el
  //"SELECT t FROM TipoPlanilla t Join t.empleados e WHERE UPPER(t.codigo) like :codigo and  UPPER(e.cedula) like :cedula and UPPER(e.id) like :idemp"),
          //    select t Join t.empleados WHERE t.codigo=:codigo
          //, hints = @QueryHint(name = "eclipselink.refresh", value = "true"

})
@XmlAccessorType(XmlAccessType.FIELD)
public class Registro implements Serializable
{

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "CTRL_REGISTRO_REG_ID_GENERATOR" , sequenceName = "relojuna.CTRL_REGISTRO_SEQ01" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "CTRL_REGISTRO_REG_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "REG_ID" , nullable = false , precision = 38 , scale = 0)
    private Long regId;
    @Column(name = "REG_ENTRADA")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date regEntrada;
    @Column(name = "REG_SALIDA")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date regSalida;
    @Column(name = "REG_COMPLETADO" , length = 1)
    private String regCompletado;
     @XmlTransient
    @JoinColumn(name = "EMP_ID" , referencedColumnName = "EMP_ID" , nullable = false)
    @ManyToOne(optional = false , fetch = FetchType.LAZY)
    private Empleado empId;

    public Registro()
    {
    }

    public Registro(Long regId)
    {
        this.regId = regId;
    }
    public Registro(RegistroDto registroDto)
    {
        //para general un empleado nuevo , debe estar lo que no se deberia editar
        this.regId = registroDto.getId();
        //entra un dto sale una entidad---del otro lado en empleado dto pasa lo contrario
        actualizarRegistro(registroDto);
    }
    public void actualizarRegistro(RegistroDto registroDto)
    {
        this.regId= registroDto.getId();
        this.regEntrada = registroDto.getFechaIngreso();
        this.regSalida = registroDto.getFechaSalida();
        this.regCompletado = registroDto.getCompletado();
        this.empId=new Empleado(registroDto.getEmpId());
    }
    
    
    public Long getRegId()
    {
        return regId;
    }

    public void setRegId(Long regId)
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

    public Empleado getEmpId()
    {
        return empId;
    }

    public void setEmpId(Empleado empId)
    {
        this.empId = empId;
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
        if(!(object instanceof Registro))
        {
            return false;
        }
        Registro other = (Registro) object;
        if((this.regId == null && other.regId != null) || (this.regId != null && !this.regId.equals(other.regId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Registro{regId=").append(regId);
        sb.append(", regEntrada=").append(regEntrada);
        sb.append(", regSalida=").append(regSalida);
        sb.append(", regCompletado=").append(regCompletado);
        sb.append(", empId=").append(empId);
        sb.append('}');
        return sb.toString();
    }


    
}
