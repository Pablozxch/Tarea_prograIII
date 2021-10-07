
package cr.ac.una.tareaprogra3.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jasPFolio complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="jasPFolio"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EmpFolio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jasPFolio", propOrder = {
    "empFolio"
})
public class JasPFolio {

    @XmlElement(name = "EmpFolio")
    protected String empFolio;

    /**
     * Obtiene el valor de la propiedad empFolio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpFolio() {
        return empFolio;
    }

    /**
     * Define el valor de la propiedad empFolio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpFolio(String value) {
        this.empFolio = value;
    }

}
