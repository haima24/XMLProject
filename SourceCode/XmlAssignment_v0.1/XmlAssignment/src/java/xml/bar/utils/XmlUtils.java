/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.bar.utils;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import xml.bar.binding.restaurants.Restaurants;

/**
 *
 * @author Tu
 */
public class XmlUtils {
public static void writeXML(Node node,String filePath){
        try {
            TransformerFactory tff = TransformerFactory.newInstance();
            Transformer trans = tff.newTransformer();
            Source src=new DOMSource(node);
            File file=new File(filePath);
            Result result=new StreamResult(file);
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.transform(src, result);
        }catch (TransformerConfigurationException ex) {
            Logger.getLogger(XmlUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XmlUtils.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public static String TransformToString(String xslPath,String xmlPath){
        String result="";
        try {
            StreamSource xslStream=new StreamSource(xslPath);
            StreamSource xmlStream=new StreamSource(xmlPath);
            TransformerFactory tff=TransformerFactory.newInstance();
            Transformer tf= tff.newTransformer(xslStream);
            StringWriter sw=new StringWriter();
            StreamResult rs=new StreamResult(sw);
            tf.transform(xmlStream, rs);
            result=sw.toString();
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(XmlUtils.class.getName()).log(Level.SEVERE, null, ex);
        }catch (TransformerException ex) {
            Logger.getLogger(XmlUtils.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return result;
    }
    
    public static void marshalXml(Object obj, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            File file = new File(filePath);
            mar.marshal(obj, file);
        } catch (JAXBException ex) {
            Logger.getLogger(XmlUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public static String marshalXml(Object obj) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw=new StringWriter();
            mar.marshal(obj, sw);
            return sw.toString();
        } catch (JAXBException ex) {
            Logger.getLogger(XmlUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public static Object unMarshalXml(String xsdPath, String xmlPath, Class boundClass) {
        try {
            JAXBContext jc = JAXBContext.newInstance(boundClass);
            Unmarshaller u = jc.createUnmarshaller();

            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema sm = sf.newSchema(new File(xsdPath));
            u.setSchema(sm);


            File f = new File(xmlPath);
            Restaurants res = (Restaurants) u.unmarshal(f);
            return res;
        } catch (UnmarshalException ex) {
            Logger.getLogger(XmlUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XmlUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(XmlUtils.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception ex){
            Logger.getLogger(XmlUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
