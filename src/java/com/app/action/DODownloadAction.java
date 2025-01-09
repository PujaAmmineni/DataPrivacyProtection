
package com.app.action;

import com.app.algorithms.AESImple;
import com.app.utility.DBConnectionn;
import com.app.wrapper.ECCEncoder;
import com.app.wrapper.GetKeysFromServer;
import com.app.wrapper.StoreDownloadHistory;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Puja
 */
public class DODownloadAction extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        GetKeysFromServer gkfs = new GetKeysFromServer();
        String privKey = gkfs.getPrivateKey(id);
        String pubkey = gkfs.getPublicKey(id);
        String key = ECCEncoder.binaryToText(privKey);
        String initVector = ECCEncoder.binaryToText(pubkey);
        System.out.println("Decryption Key "+key);
        System.out.println("InitVector Key "+initVector);
        String fileName = null;
        String fileData = null;
        String plainData = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
         HttpSession hs = request.getSession();
        try(Connection con = DBConnectionn.getConnection()) {
            String sqlQuery = "select cipherdata,filename from datafiles where id =?";
            ps = con.prepareStatement(sqlQuery);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
            fileName = rs.getString("filename");
            fileData = rs.getString("cipherdata");
            plainData = AESImple.decrypt(fileData, key, initVector);
               
            String ownername = hs.getAttribute("username").toString();
                StoreDownloadHistory.storeDownloads(id,ownername,fileName,key,initVector);
            }
        } catch (Exception e) {
        }
           ServletContext context = getServletContext();
           
            int BUFFER_SIZE = 4096;
                // sets MIME type for the file download
                String mimeType = context.getMimeType(fileName);
                if (mimeType == null) {        
                    mimeType = "application/octet-stream";
                }              
                 
                // set content properties and header attributes for the response
                response.setContentType(mimeType);
                response.setContentLength(plainData.length());
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; filename=\"%s\"", fileName);
                response.setHeader(headerKey, headerValue); 
                // writes the file to the client
                OutputStream outStream = response.getOutputStream();                 
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = -1;               
               
                    outStream.write(plainData.getBytes());
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
