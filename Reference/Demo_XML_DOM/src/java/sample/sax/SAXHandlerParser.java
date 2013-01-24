/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Tu
 */
public class SAXHandlerParser extends DefaultHandler {

    private String username;
    private String password;
    private int bUser;
    private String currentTagName;
    private String lastname;
    private String name;

    public SAXHandlerParser() {
        this.username = "";
        this.password = "";
        this.bUser = 0;
        this.currentTagName = "";
        this.lastname = "";
        this.name = "";
    }

    public SAXHandlerParser(String username, String password) {
        this.username = username;
        this.password = password;
        this.bUser = 0;
        this.currentTagName = "";
        this.lastname = "";
        this.name = "";
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //super.startElement(uri, localName, qName, attributes);
        if (qName.equals("student")) {
            String sid = attributes.getValue("studentid");
            if (sid.equals(this.username)) {
                this.bUser = 1;
            }
        }
        this.currentTagName = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //System.out.println("URL "+uri);
        this.currentTagName = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bUser < 3) {
            //super.characters(ch, start, length);
            if (currentTagName.equals("lastname")) {
                String str = new String(ch, start, length);
                lastname = str.trim();
            } else if (currentTagName.equals("name")) {
                String str = new String(ch, start, length);
                name = str.trim();
            } else if (currentTagName.equals("password")) {
                if (bUser > 0) {
                    String str = new String(ch, start, length);
                    if (str.trim().equals(password)) {
                        bUser = 2;
                    } else {
                        bUser = 0;
                    }
                }

            } else if (this.currentTagName.equals("status")) {
                if (bUser > 1) {
                    String str = new String(ch, start, length);
                    if (str.trim().equals("dropout")) {
                        bUser = 0;
                    } else {
                        bUser = 3;
                    }
                }
            }
        }
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastname() {
        return lastname;
    }

    public String getName() {
        return name;
    }

    public int getbUser() {
        return bUser;
    }
    
}
