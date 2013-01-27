
package xml.bar.binding.restaurants;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for restaurantType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="restaurantType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Latitute" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Longtitue" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PhoneNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MinimumOrder" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="OpenHours" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CloseHours" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="IsActive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "restaurantType", propOrder = {
    "id",
    "name",
    "latitute",
    "longtitue",
    "address",
    "description",
    "phoneNum",
    "minimumOrder",
    "openHours",
    "closeHours",
    "isActive"
})
public class RestaurantType {

    @XmlElement(name = "Id")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger id;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Latitute", required = true)
    protected BigDecimal latitute;
    @XmlElement(name = "Longtitue", required = true)
    protected BigDecimal longtitue;
    @XmlElement(name = "Address", required = true)
    protected String address;
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "PhoneNum", required = true)
    protected String phoneNum;
    @XmlElement(name = "MinimumOrder", required = true)
    protected BigDecimal minimumOrder;
    @XmlElement(name = "OpenHours", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar openHours;
    @XmlElement(name = "CloseHours", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar closeHours;
    @XmlElement(name = "IsActive")
    protected boolean isActive;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the latitute property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLatitute() {
        return latitute;
    }

    /**
     * Sets the value of the latitute property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLatitute(BigDecimal value) {
        this.latitute = value;
    }

    /**
     * Gets the value of the longtitue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLongtitue() {
        return longtitue;
    }

    /**
     * Sets the value of the longtitue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLongtitue(BigDecimal value) {
        this.longtitue = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the phoneNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * Sets the value of the phoneNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNum(String value) {
        this.phoneNum = value;
    }

    /**
     * Gets the value of the minimumOrder property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMinimumOrder() {
        return minimumOrder;
    }

    /**
     * Sets the value of the minimumOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMinimumOrder(BigDecimal value) {
        this.minimumOrder = value;
    }

    /**
     * Gets the value of the openHours property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOpenHours() {
        return openHours;
    }

    /**
     * Sets the value of the openHours property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOpenHours(XMLGregorianCalendar value) {
        this.openHours = value;
    }

    /**
     * Gets the value of the closeHours property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCloseHours() {
        return closeHours;
    }

    /**
     * Sets the value of the closeHours property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCloseHours(XMLGregorianCalendar value) {
        this.closeHours = value;
    }

    /**
     * Gets the value of the isActive property.
     * 
     */
    public boolean isIsActive() {
        return isActive;
    }

    /**
     * Sets the value of the isActive property.
     * 
     */
    public void setIsActive(boolean value) {
        this.isActive = value;
    }

}
