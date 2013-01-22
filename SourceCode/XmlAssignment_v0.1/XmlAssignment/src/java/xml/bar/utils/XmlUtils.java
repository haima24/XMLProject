/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.bar.utils;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Tu
 */
public class XmlUtils {
 public static void marshalXml(Object obj,String filePath){
        try {
            JAXBContext context=JAXBContext.newInstance(obj.getClass());
            Marshaller mar=context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            File file=new File(filePath);
            mar.marshal(obj, file);
        }  catch (JAXBException ex) {
            Logger.getLogger(XmlUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
