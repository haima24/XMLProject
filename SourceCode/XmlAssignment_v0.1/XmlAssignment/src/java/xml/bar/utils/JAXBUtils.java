/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.bar.utils;

import com.sun.codemodel.JCodeModel;
import com.sun.tools.xjc.api.ErrorListener;
import com.sun.tools.xjc.api.S2JJAXBModel;
import com.sun.tools.xjc.api.SchemaCompiler;
import com.sun.tools.xjc.api.XJC;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;

/**
 *
 * @author Tu
 */
public class JAXBUtils {
    public static void main(String[] arg){
        //JAXBUtils.buildJaxbCode("src/java/xml/bar/schemas/dishcategories.xsd", "src/java","xml.bar.binding.dishcategories");
       JAXBUtils.buildJaxbCode("src/java/xml/bar/schemas/restaurants.xsd", "src/java","xml.bar.binding.restaurants");
        //JAXBUtils.buildJaxbCode("src/java/xml/bar/schemas/discounts.xsd", "src/java","xml.bar.binding.discounts");
        
    }
    public static void buildJaxbCode(String sourcePath,String outputPath,String packageName) {
        try {
            SchemaCompiler sc = XJC.createSchemaCompiler();
            sc.setErrorListener(new ErrorListener() {

                public void error(SAXParseException saxpe) {
                    System.out.println("error" + saxpe.getMessage());
                }

                public void fatalError(SAXParseException saxpe) {
                    System.out.println("fatal" + saxpe.getMessage());
                }

                public void warning(SAXParseException saxpe) {
                    System.out.println("warning" + saxpe.getMessage());
                }

                public void info(SAXParseException saxpe) {
                    System.out.println("info" + saxpe.getMessage());
                }
            });
            sc.forcePackageName(packageName);
            File schema = new File(sourcePath);
            InputSource is = new InputSource(schema.toURI().toString());
            sc.parseSchema(is);
            S2JJAXBModel model = sc.bind();
            JCodeModel code = model.generateCode(null, null);
            code.build(new File(outputPath));
            System.out.println("finished");
        } catch (IOException ex) {
            Logger.getLogger(JAXBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
