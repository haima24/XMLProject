/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.bar.Model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import xml.bar.binding.restaurants.RestaurantType;
import xml.bar.binding.restaurants.Restaurants;
import xml.bar.core.DbEntities;
import xml.bar.utils.DOMUtils;
import xml.bar.utils.KeyValuePair;
import xml.bar.utils.XmlUtils;
import xml.bar.validation.XmlValidator;

/**
 *
 * @author Tu
 */
public class RestaurantController extends HttpServlet {

    private final String listRestaurantPage = "Partials/Basic/Restaurant.jsp";

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String action = request.getParameter("action");
            if (action.equals("RESTAURANT_ADD")) {
                String name = request.getParameter("name");
                String latitute = request.getParameter("latitute");
                String longtitute = request.getParameter("longtitute");
                String address = request.getParameter("address");
                String description = request.getParameter("description");
                String phone = request.getParameter("phone");
                String webPath = getServletContext().getRealPath("/");

                List<KeyValuePair<String, Object>> properties = new ArrayList<KeyValuePair<String, Object>>();
                properties.add(new KeyValuePair<String, Object>("Name", name));
                properties.add(new KeyValuePair<String, Object>("Latitute", latitute));
                properties.add(new KeyValuePair<String, Object>("Longtitue", longtitute));
                properties.add(new KeyValuePair<String, Object>("Address", address));
                properties.add(new KeyValuePair<String, Object>("Description", description));
                properties.add(new KeyValuePair<String, Object>("PhoneNum", phone));
                properties.add(new KeyValuePair<String, Object>("MinimumOrder", 1));

                GregorianCalendar cldOpenHours = new GregorianCalendar();
                cldOpenHours.setTime(new Date());
                properties.add(new KeyValuePair<String, Object>("OpenHours", DatatypeFactory.newInstance().newXMLGregorianCalendar(cldOpenHours)));

                GregorianCalendar cldCloseHours = new GregorianCalendar();
                cldCloseHours.setTime(new Date());
                properties.add(new KeyValuePair<String, Object>("CloseHours", DatatypeFactory.newInstance().newXMLGregorianCalendar(cldCloseHours)));
                properties.add(new KeyValuePair<String, Object>("IsActive", true));

                //need to validate here
                Node doc = DOMUtils.buildRestaurantDOM(properties);
                XmlUtils.writeXML(doc, webPath+"XmlDoc/demo.xml");
                
                
                DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
                dbf.setNamespaceAware(true);
                DocumentBuilder db=dbf.newDocumentBuilder();
                Node doc2= db.parse(new File( webPath + "XmlDoc/demo.xml"));
                
                
                XmlValidator.validate(webPath + "WEB-INF/classes/xml/bar/schemas/restaurants.xsd", new DOMSource(doc2));
                XmlValidator.validate(webPath + "WEB-INF/classes/xml/bar/schemas/restaurants.xsd", new DOMSource(doc));


                RestaurantType resType = new RestaurantType();
                //resType.setId(BigInteger.ZERO);
                resType.setName(name);
                resType.setLatitute(BigDecimal.valueOf(Double.parseDouble(latitute)));
                resType.setLongtitue(BigDecimal.valueOf(Double.parseDouble(longtitute)));
                resType.setAddress(address);
                resType.setDescription(description);
                resType.setMinimumOrder(BigDecimal.ZERO);
                resType.setPhoneNum(phone);

                GregorianCalendar gOpenHours = new GregorianCalendar();
                gOpenHours.setTime(new Date());
                resType.setOpenHours(DatatypeFactory.newInstance().newXMLGregorianCalendar(gOpenHours));

                GregorianCalendar gCloseHours = new GregorianCalendar();
                gCloseHours.setTime(new Date());
                resType.setCloseHours(DatatypeFactory.newInstance().newXMLGregorianCalendar(gCloseHours));

                if (DbEntities.insertRestaurant(resType)) {
                    String filePath = webPath + "XmlDoc/Restaurants.xml";
                    Restaurants reslist = DbEntities.getRestaurants();
                    XmlUtils.marshalXml(reslist, filePath);

                    //respone obj->transform jaxb and xsl to string
                    String xslPath = webPath + "XslDoc/Restaurants.xsl";
                    String responseString = XmlUtils.TransformToString(xslPath, filePath);
                    out.write(responseString);
                }
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RestaurantController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantController.class.getName()).log(Level.SEVERE, null, ex);
        }catch (DatatypeConfigurationException ex) {
            Logger.getLogger(RestaurantController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(RestaurantController.class.getName()).log(Level.SEVERE, null, ex);
        }  finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
