/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.bar.validation;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author Tu
 */
public class DOM_RestaurantErrorHandler implements ErrorHandler{
    private boolean error=false;
    private String errorMessage="";

    public DOM_RestaurantErrorHandler() {
        this.error=false;
        this.errorMessage="";
    }
    

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isError() {
        return error;
    }

    public void warning(SAXParseException exception) throws SAXException {
        System.out.println("Warning: "+exception.getMessage());
    }

    public void error(SAXParseException exception) throws SAXException {
        error=true;
        this.errorMessage=exception.getMessage();
    }

    public void fatalError(SAXParseException exception) throws SAXException {
        error=true;
        this.errorMessage=exception.getMessage();
    }
    
    
}
