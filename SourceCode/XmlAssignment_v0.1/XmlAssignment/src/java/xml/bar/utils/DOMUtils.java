/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.bar.utils;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author Tu
 */
public class DOMUtils {

    public static Node buildRestaurantDOM(List<KeyValuePair<String,Object>> properties) {
        try {
            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            //factory.setValidating(true);

            DocumentBuilder loader = factory.newDocumentBuilder();
            Document document = loader.newDocument();

            // here is our vendor URL used in namepace-related functions:
            String docNS = "http://xml.netbeans.org/schema/restaurants";

            // create document element:
            Element root = document.createElementNS(docNS, "Restaurants");
            document.appendChild(root);
            Element res = document.createElement("Restaurant");
            for (KeyValuePair<String,Object> obj : properties) {
                Element ele = document.createElement(obj.getKey());
                ele.setTextContent(obj.getObj().toString());
                res.appendChild(ele);
            }
            root.appendChild(res);
            
            /////////////////
            //Output the XML

            //set up a transformer
            TransformerFactory transfac = TransformerFactory.newInstance();
            Transformer trans = transfac.newTransformer();
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");

            //create string from xml tree
            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);
            DOMSource source = new DOMSource(document);
            trans.transform(source, result);
            String xmlString = sw.toString();

            //print xml
            System.out.println("Here's the xml:\n\n" + xmlString);
            
            return document;
        }catch (TransformerConfigurationException ex) {
            Logger.getLogger(DOMUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DOMUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DOMUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
