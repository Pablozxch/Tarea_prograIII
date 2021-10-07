
package cr.ac.una.tareaprogra3.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SaveRegistro complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SaveRegistro"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="reg2" type="{http://websoap.una.ac.cr/}registroDto" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SaveRegistro", propOrder = {
    "reg2"
})
public class SaveRegistro {

    protected RegistroDto reg2;

    /**
     * Obtiene el valor de la propiedad reg2.
     * 
     * @return
     *     possible object is
     *     {@link RegistroDto }
     *     
     */
    public RegistroDto getReg2() {
        return reg2;
    }

    /**
     * Define el valor de la propiedad reg2.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistroDto }
     *     
     */
    public void setReg2(RegistroDto value) {
        this.reg2 = value;
    }

}
