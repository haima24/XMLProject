/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.bar.validation;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.ValidationEventLocator;

/**
 *
 * @author Tu
 */
public class JAXB_RestaurantEventHandler implements ValidationEventHandler{
    private boolean error=false;
    private String errorMessage="";
    private String detailError="";

    public JAXB_RestaurantEventHandler() {
        this.error=false;
        this.errorMessage="";
        this.detailError="";
    }
    
    public boolean handleEvent(ValidationEvent event) {
        if(event.getSeverity()==ValidationEvent.FATAL_ERROR||event.getSeverity()==ValidationEvent.ERROR){
            ValidationEventLocator locator=event.getLocator();
            this.errorMessage="BAR: Error "+event.getMessage();
            this.detailError="BAR: Error In document "+locator.getURL()+" at column "+locator.getColumnNumber()+", line "+locator.getLineNumber();
        }
        return false;
    }

    public String getDetailError() {
        return detailError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isError() {
        return error;
    }
    
    
}
