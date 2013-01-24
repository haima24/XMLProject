/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.bar.validation;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.validation.ValidatorHandler;
import org.xml.sax.SAXException;

/**
 *
 * @author Tu
 */
public class XmlValidator {
    public static void validate(String xsdPath,Source src) throws SAXException, IOException{
        SchemaFactory sf=SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema=sf.newSchema(new File(xsdPath));
        Validator validator=schema.newValidator();
        validator.validate(src);
    }
    
}
