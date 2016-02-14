//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.19 at 10:45:20 PM EST 
//


package org.subsonic.restapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JukeboxStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JukeboxStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="currentIndex" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="playing" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="gain" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="position" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JukeboxStatus")
@XmlSeeAlso({
    JukeboxPlaylist.class
})
public class JukeboxStatus {

    @XmlAttribute(name = "currentIndex", required = true)
    protected int currentIndex;
    @XmlAttribute(name = "playing", required = true)
    protected boolean playing;
    @XmlAttribute(name = "gain", required = true)
    protected float gain;
    @XmlAttribute(name = "position")
    protected Integer position;

    /**
     * Gets the value of the currentIndex property.
     * 
     */
    public int getCurrentIndex() {
        return currentIndex;
    }

    /**
     * Sets the value of the currentIndex property.
     * 
     */
    public void setCurrentIndex(int value) {
        this.currentIndex = value;
    }

    /**
     * Gets the value of the playing property.
     * 
     */
    public boolean isPlaying() {
        return playing;
    }

    /**
     * Sets the value of the playing property.
     * 
     */
    public void setPlaying(boolean value) {
        this.playing = value;
    }

    /**
     * Gets the value of the gain property.
     * 
     */
    public float getGain() {
        return gain;
    }

    /**
     * Sets the value of the gain property.
     * 
     */
    public void setGain(float value) {
        this.gain = value;
    }

    /**
     * Gets the value of the position property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPosition(Integer value) {
        this.position = value;
    }

}