/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.bar.Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import xml.bar.binding.restaurants.RestaurantType;
import xml.bar.binding.restaurants.Restaurants;
import xml.bar.core.DbEntities;
import xml.bar.utils.XmlUtils;

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

                RestaurantType resType = new RestaurantType();
                //resType.setId(BigInteger.ZERO);
                resType.setName(name);
                resType.setLatitute(BigDecimal.valueOf(Double.parseDouble(latitute)));
                resType.setLongtitue(BigDecimal.valueOf(Double.parseDouble(longtitute)));
                resType.setAddress(address);
                resType.setDescription(description);
                resType.setMinimumOrder(BigDecimal.ZERO);
                resType.setPhoneNum(phone);
                
                 GregorianCalendar cldOpenHours = new GregorianCalendar();
                cldOpenHours.setTime(new Date());
                resType.setOpenHours(DatatypeFactory.newInstance().newXMLGregorianCalendar(cldOpenHours));
                
                GregorianCalendar cldCloseHours = new GregorianCalendar();
                cldCloseHours.setTime(new Date());
                resType.setCloseHours(DatatypeFactory.newInstance().newXMLGregorianCalendar(cldCloseHours));

//                Restaurants reslist = (Restaurants) XmlUtils.unMarshalXml(webPath+"WEB-INF/classes/xml/bar/schemas/restaurants.xsd", webPath + "XmlDoc/Restaurants.xml", Restaurants.class);
//                reslist.getRestaurant().add(resType);
                if (DbEntities.insertRestaurant(resType)) {
                    String filePath = webPath + "XmlDoc/Restaurants.xml";
                    Restaurants reslist=DbEntities.getRestaurants();
                    XmlUtils.marshalXml(reslist, filePath);
                    
                    //respone obj
                    String respone=XmlUtils.marshalXml(resType);
                    out.write(respone);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(RestaurantController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(RestaurantController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
