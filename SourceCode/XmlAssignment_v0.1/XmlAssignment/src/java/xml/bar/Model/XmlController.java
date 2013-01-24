/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.bar.Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import xml.bar.binding.discounts.Discounts;
import xml.bar.binding.dishcategories.DishCategories;
import xml.bar.binding.restaurants.Restaurants;
import xml.bar.core.DbEntities;
import xml.bar.utils.XmlUtils;

/**
 *
 * @author Tu
 */
public class XmlController extends HttpServlet {

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
            if (action.equals("MARSHAL_RESTAURANTS")) {
                Restaurants resList = DbEntities.getRestaurants();
                String webPath = getServletContext().getRealPath("/");
                String filePath = webPath + "XmlDoc/Restaurants.xml";
                XmlUtils.marshalXml(resList, filePath);
            } else if (action.equals("MARSHAL_DISHCATEGORY")) {
                DishCategories dishes = DbEntities.getDishCategories();
                String webPath = getServletContext().getRealPath("/");
                String filePath = webPath + "XmlDoc/DishCategory.xml";
                XmlUtils.marshalXml(dishes, filePath);
            }else if(action.equals("MARSHAL_DISCOUNT")){
                Discounts discounts = DbEntities.getDiscounts();
                String webPath = getServletContext().getRealPath("/");
                String filePath = webPath + "XmlDoc/Discounts.xml";
                XmlUtils.marshalXml(discounts, filePath);
            }

        } catch (SQLException ex) {
            Logger.getLogger(XmlController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(XmlController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            ex.printStackTrace();
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
