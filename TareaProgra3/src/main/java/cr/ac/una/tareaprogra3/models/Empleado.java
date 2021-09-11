/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.models;

import java.io.*;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author jp015
 */
@Entity
@Table(name = "CTRL_EMPLEADO" , catalog = "" , schema = "RELOJUNA")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Empleado.findAll" , query = "SELECT e FROM Empleado e") ,
    @NamedQuery(name = "Empleado.findByEmpId" , query = "SELECT e FROM Empleado e WHERE e.empId = :empId") ,
    @NamedQuery(name = "Empleado.findByEmNombre" , query = "SELECT e FROM Empleado e WHERE e.emNombre = :emNombre") ,
    @NamedQuery(name = "Empleado.findByEmpApellido" , query = "SELECT e FROM Empleado e WHERE e.empApellido = :empApellido") ,
    @NamedQuery(name = "Empleado.findByEmpCedula" , query = "SELECT e FROM Empleado e WHERE e.empCedula = :empCedula") ,
    @NamedQuery(name = "Empleado.findByEmpFolio" , query = "SELECT e FROM Empleado e WHERE e.empFolio = :empFolio") ,
    @NamedQuery(name = "Empleado.findByEmpNacimiento" , query = "SELECT e FROM Empleado e WHERE e.empNacimiento = :empNacimiento") ,
    @NamedQuery(name = "Empleado.findByEmpRol" , query = "SELECT e FROM Empleado e WHERE e.empRol = :empRol") ,
    @NamedQuery(name = "Empleado.findByEmpContra" , query = "SELECT e FROM Empleado e WHERE e.empContra = :empContra") ,
    @NamedQuery(name = "Empleado.loginAdmin" , query = "SELECT e FROM Empleado e WHERE e.empFolio = :empFolio and e.empContra = :empContra and e.empRol = :empRol")
})
public class Empleado implements Serializable
{

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
     @SequenceGenerator(name = "CTRL_EMPLEADO_EMP_ID_GENERATOR" , sequenceName = "relojuna.CTRL_EMPLEADO_SEQ01" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "CTRL_EMPLEADO_EMP_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "EMP_ID" , nullable = false , precision = 38 , scale = 0)
    private Long empId;
    @Basic(optional = false)
    @Column(name = "EM_NOMBRE" , nullable = false , length = 30)
    private String emNombre;
    @Basic(optional = false)
    @Column(name = "EMP_APELLIDO" , nullable = false , length = 30)
    private String empApellido;
    @Basic(optional = false)
    @Column(name = "EMP_CEDULA" , nullable = false , length = 30)
    private String empCedula;
    @Basic(optional = false)
    @Lob
    @Column(name = "EMP_FOTO" , nullable = false)
    private byte[] empFoto;
    @Basic(optional = false)
    @Column(name = "EMP_FOLIO" , nullable = false , length = 30)
    private String empFolio;
    @Basic(optional = false)
    @Column(name = "EMP_NACIMIENTO" , nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
    private Date empNacimiento;
    @Basic(optional = false)
    @Column(name = "EMP_ROL" , nullable = false , length = 1)
    private String empRol;
    @Column(name = "EMP_CONTRA" , length = 50)
    private String empContra;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "empId" , fetch = FetchType.LAZY)
    private List<Registro> registroList;

    public Empleado()
    {
    }

    public Empleado(Long empId)
    {
        this.empId = empId;
    }

    public Empleado(Long empId , String emNombre , String empApellido , String empCedula , byte[] empFoto , String empFolio , Date empNacimiento , String empRol)
    {
        this.empId = empId;
        this.emNombre = emNombre;
        this.empApellido = empApellido;
        this.empCedula = empCedula;
        this.empFoto = empFoto;
        this.empFolio = empFolio;
        this.empNacimiento = empNacimiento;
        this.empRol = empRol;
    }
    public Empleado(EmpleadoDto empleadoDto)
    {
        //para general un empleado nuevo , debe estar lo que no se deberia editar
        this.empId = empleadoDto.getId();
        //entra un dto sale una entidad---del otro lado en empleado dto pasa lo contrario
        actualizarEmpleado(empleadoDto);
    }
    public void actualizarEmpleado(EmpleadoDto empleadoDto)
    {
        this.emNombre= empleadoDto.getNombre();
        this.empApellido = empleadoDto.getApellido();
        this.empCedula = empleadoDto.getCedula();
        this.empFoto = empleadoDto.getFoto();
        this.empFolio = empleadoDto.getFolio();
        this.empNacimiento = empleadoDto.getNacimiento();
        this.empRol = empleadoDto.getRol();
    }
    public Long getEmpId()
    {
        return empId;
    }

    public void setEmpId(Long empId)
    {
        this.empId = empId;
    }

    public String getEmNombre()
    {
        return emNombre;
    }

    public void setEmNombre(String emNombre)
    {
        this.emNombre = emNombre;
    }

    public String getEmpApellido()
    {
        return empApellido;
    }

    public void setEmpApellido(String empApellido)
    {
        this.empApellido = empApellido;
    }

    public String getEmpCedula()
    {
        return empCedula;
    }

    public void setEmpCedula(String empCedula)
    {
        this.empCedula = empCedula;
    }

    public byte[] getEmpFoto()
    {
        return empFoto;
    }

    public void setEmpFoto(byte[] empFoto)
    {
        this.empFoto = empFoto;
    }

    public String getEmpFolio()
    {
        return empFolio;
    }

    public void setEmpFolio(String empFolio)
    {
        this.empFolio = empFolio;
    }

    public Date getEmpNacimiento()
    {
        return empNacimiento;
    }

    public void setEmpNacimiento(Date empNacimiento)
    {
        this.empNacimiento = empNacimiento;
    }

    public String getEmpRol()
    {
        return empRol;
    }

    public void setEmpRol(String empRol)
    {
        this.empRol = empRol;
    }

    public String getEmpContra()
    {
        return empContra;
    }

    public void setEmpContra(String empContra)
    {
        this.empContra = empContra;
    }

    @XmlTransient
    public List<Registro> getRegistroList()
    {
        return registroList;
    }

    public void setRegistroList(List<Registro> registroList)
    {
        this.registroList = registroList;
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
        if(!(object instanceof Empleado))
        {
            return false;
        }
        Empleado other = (Empleado) object;
        if((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "cr.ac.una.tareaprogra3.models.Empleado[ empId=" + empId + " ]";
    }
    
}
