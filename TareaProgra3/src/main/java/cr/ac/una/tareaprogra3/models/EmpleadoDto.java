/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.models;

import javafx.beans.property.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author jp015
 */
public class EmpleadoDto
{

    @XmlTransient
    public SimpleStringProperty id;
    @XmlTransient
    public SimpleStringProperty nombre;
    @XmlTransient
    public SimpleStringProperty apellido;
    @XmlTransient
    public SimpleStringProperty cedula;

    @XmlTransient
    public SimpleStringProperty folio;
    @XmlTransient
    public SimpleStringProperty rol;

}
