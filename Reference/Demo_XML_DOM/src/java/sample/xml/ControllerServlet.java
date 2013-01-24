/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.xml;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import sample.sax.SAXHandlerParser;
import sample.utils.XMLUtils;

/**
 *
 * @author Tu
 */
public class ControllerServlet extends HttpServlet {

    private List studentList;
    private boolean isFound = false;
    private String fullname = "";
    private final String loginPage = "index.jsp";
    private final String homePage = "home.jsp";
    private final String invalidPage = "invalid.jsp";
    private final String registerPage = "register.jsp";

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
            String button = request.getParameter("btnAction");
            if (button.equals("Login")) {
                String username = request.getParameter("txtUsername");
                String password = request.getParameter("txtPassword");
                String url = invalidPage;
                if (username != null) {
                    String webPath = getServletContext().getRealPath("/");
                    String filePath = webPath + "WEB-INF/users.xml";
                    SAXParserFactory spf = SAXParserFactory.newInstance();
                    SAXParser parser = spf.newSAXParser();

                    SAXHandlerParser obj = new SAXHandlerParser(username, password);
                    parser.parse(new File(filePath), obj);
                    if (obj.getbUser() > 2) {
                        HttpSession session = request.getSession();
                        session.setAttribute("FULLNAME", obj.getLastname() + " " + obj.getName());
                        session.setAttribute("SID", username);
                        url = homePage;

                    }


//                    Document doc = XMLUtils.buildDOMTree(filePath);
//                    XPathFactory xpf=XPathFactory.newInstance();
//                    XPath xpath=xpf.newXPath();
//                    String exp="//student[@studentid='"+username+"' and normalize-space(password)='"+
//                            password+"' and normalize-space(status)!='dropout']";
//                    Boolean result=(Boolean) xpath.evaluate(exp,doc,XPathConstants.BOOLEAN);
//                    if(result.booleanValue()){
//                          HttpSession session = request.getSession();
//                        session.setAttribute("FULLNAME", fullname);
//                        session.setAttribute("SID", username);
//                        url = homePage;
//                    }


//                    isFound = false;
//                    fullname = "";
//                    checkLogin(doc, username, password);
//                    if (isFound) {
//                        HttpSession session = request.getSession();
//                        session.setAttribute("FULLNAME", fullname);
//                        session.setAttribute("SID", username);
//                        url = homePage;
//                    }
                }
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            } else if (button.equals("Search")) {
                String name = request.getParameter("txtName");
                String webPath = getServletContext().getRealPath("/");
                String filePath = webPath + "WEB-INF/users.xml";
                Document doc = XMLUtils.buildDOMTree(filePath);

                studentList = new ArrayList();
                searchLikeName(doc, name);
                request.setAttribute("INFO", studentList);
                request.getRequestDispatcher(homePage).forward(request, response);
            } else if (button.equals("delete")) {

                String id = request.getParameter("id");
                String searchValue = request.getParameter("searchValue");

                String webPath = getServletContext().getRealPath("/");
                String filePath = webPath + "WEB-INF/users.xml";
                Document doc = XMLUtils.buildDOMTree(filePath);

                isFound = false;
                deleteStudent(doc, id);
                XMLUtils.writeXML(doc, filePath);
                String url = "ControllerServlet?btnAction=Search&txtName=" + searchValue;
                response.sendRedirect(url);
            } else if (button.equals("Update")) {
                String username = request.getParameter("txtUsername");
                String status = request.getParameter("txtStatus");
                String searchValue = request.getParameter("searchValue");

                String webPath = getServletContext().getRealPath("/");
                String filePath = webPath + "WEB-INF/users.xml";
                Document doc = XMLUtils.buildDOMTree(filePath);

                isFound = false;
                updateStudentStatus(doc, username, status);
                XMLUtils.writeXML(doc, filePath);
                String url = "ControllerServlet?btnAction=Search&txtName=" + searchValue;
                response.sendRedirect(url);
            } else if (button.equals("RegisterLink")) {
                request.getRequestDispatcher(registerPage).forward(request, response);
            } else if (button.equals("Register")) {
                String id = request.getParameter("txtID");
                String lastname = request.getParameter("txtLastname");
                String firstname = request.getParameter("txtFirstName");
                String password = request.getParameter("txtPassword");

                String webPath = getServletContext().getRealPath("/");
                String filePath = webPath + "WEB-INF/users.xml";
                Document doc = XMLUtils.buildDOMTree(filePath);

                Element studentNode = doc.createElement("student");
                studentNode.setAttribute("studentid", id);

                Element lastnameNode = doc.createElement("lastname");
                lastnameNode.setTextContent(lastname);
                studentNode.appendChild(lastnameNode);

                Element nameNode = doc.createElement("name");
                nameNode.setTextContent(firstname);
                studentNode.appendChild(nameNode);

                Element passwordNode = doc.createElement("password");
                passwordNode.setTextContent(password);
                studentNode.appendChild(passwordNode);

                Element statusNode = doc.createElement("status");
                statusNode.setTextContent("studying");
                studentNode.appendChild(statusNode);

                Node root = doc.getFirstChild();
                root.appendChild(studentNode);

                XMLUtils.writeXML(doc, filePath);
                request.getRequestDispatcher(loginPage).forward(request, response);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    private void updateStudentStatus(Node node, String username, String status) {
        if (node == null || isFound) {
            return;
        }
        String nodeName = node.getNodeName();
        if (nodeName.equals("student")) {
            String user = node.getAttributes().getNamedItem("studentid").getNodeValue();
            if (user.equals(username)) {
                NodeList childs = node.getChildNodes();
                for (int i = 0; i < childs.getLength(); i++) {
                    Node tmp = childs.item(i);
                    if (tmp.getNodeName().equals("status")) {
                        tmp.setTextContent(status);
                        isFound = true;
                        return;
                    }
                }
            }
        }
        NodeList children = node.getChildNodes();
        int i = 0;
        while (i < children.getLength()) {
            updateStudentStatus(children.item(i++), username, status);
        }

    }

    private void deleteStudent(Node node, String id) {
        if (node == null || isFound) {
            return;
        }
        String nodeName = node.getNodeName();
        if (nodeName.equals("student")) {
            String user = node.getAttributes().getNamedItem("studentid").getNodeValue();
            if (user.equals(id)) {
                Node parent = node.getParentNode();
                parent.removeChild(node);
                isFound = true;
                return;
            }
        }
        NodeList children = node.getChildNodes();
        int i = 0;
        while (i < children.getLength()) {
            deleteStudent(children.item(i++), id);
        }
    }

    private void searchLikeName(Node node, String name) {
        if (node == null) {
            return;
        }
        String nodeName = node.getNodeName();
        if (nodeName.equals("student")) {
            String user = node.getAttributes().getNamedItem("studentid").getNodeValue();
            NodeList studentChildren = node.getChildNodes();
            for (int i = 0; i < studentChildren.getLength(); i++) {
                Node temp = studentChildren.item(i);
                String tempName = temp.getNodeName();
                if (tempName.equals("lastname")) {
                    fullname = temp.getTextContent().trim();
                } else if (tempName.equals("name")) {
                    String sName = temp.getTextContent().trim();
                    if (sName.indexOf(name) > -1) {
                        fullname += " " + sName;
                        Node siblings = temp.getNextSibling();
                        while (!siblings.getNodeName().equals("status")) {
                            siblings = siblings.getNextSibling();
                        }
                        String status = siblings.getTextContent().trim();
                        StudentDTO student = new StudentDTO(user, fullname, status);
                        studentList.add(student);
                    }

                }
            }
        }
        NodeList children = node.getChildNodes();
        int i = 0;
        while (i < children.getLength()) {
            searchLikeName(children.item(i++), name);
        }
    }

    private void checkLogin(Node node, String username, String password) {
        if (node == null || isFound) {
            return;
        }
        String nodeName = node.getNodeName();
        if (nodeName.equals("student")) {
            String user = node.getAttributes().getNamedItem("studentid").getNodeValue();
            if (user.equals(username)) {
                NodeList studentChildren = node.getChildNodes();
                for (int i = 0; i < studentChildren.getLength(); i++) {
                    Node temp = studentChildren.item(i);
                    String tempName = temp.getNodeName();
                    if (tempName.equals("lastname")) {
                        fullname = temp.getTextContent().trim();
                    } else if (tempName.equals("name")) {
                        fullname += " " + temp.getTextContent().trim();
                    } else if (tempName.equals("password")) {
                        String pass = temp.getTextContent().trim();
                        if (!pass.equals(password)) {
                            return;
                        }
                    } else if (tempName.equals("status")) {
                        String status = temp.getTextContent().trim();
                        if (!status.equals("dropout")) {
                            isFound = true;
                            return;
                        }
                    }
                }
            }
        }
        NodeList children = node.getChildNodes();
        int i = 0;
        while (i < children.getLength()) {
            checkLogin(children.item(i++), username, password);
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
