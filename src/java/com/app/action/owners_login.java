
package com.app.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.app.utility.DBConnectionn;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Puja
 */
public class owners_login extends HttpServlet {

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
        String name = request.getParameter("name");
        System.out.println("name"+name);
        String password = request.getParameter("upass");
        System.out.println("password"+password);
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String status = null;
        String accesskey = null;
        String email = null;
       
        try {
            con = DBConnectionn.getConnection();
            String sqlQuery = "Select status , accesskey , email  from ownerregister where name = ? and password = ?";
            ps = con.prepareStatement(sqlQuery);
            ps.setString(1, name);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()){
                status = rs.getString(1);
                accesskey = rs.getString(2);
               email = rs.getString(3);
               
            }else{
                //response.sendRedirect("dataownerlogin.jsp?msg=notexist");
            }
            if(status.equalsIgnoreCase("activated")){
                HttpSession session = request.getSession();
                session.setAttribute("accesskey", accesskey);
                session.setAttribute("name", name);
                 session.setAttribute("email", email);
                response.sendRedirect("ownerhome.jsp?msg=success");
            }else{
                response.sendRedirect("ownerlogin.jsp?msg=notactivated");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            response.sendRedirect("ownerlogin.jsp?msg=notexist");
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