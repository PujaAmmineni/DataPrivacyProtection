
package com.app.action;

import ECC.ECC;
import com.app.clouds.StoreFileInCloud;
import com.app.algorithms.AESImple;
import com.app.algorithms.MyKeyGenerations;
import com.app.utility.DBConnectionn;
import com.app.utility.Helpers;
import com.app.utility.KeyPair;
import com.app.utility.Point;
import com.app.utility.PrivateKey;
import com.app.utility.PublicKey;
import com.app.wrapper.ECCEncoder;

import com.app.wrapper.TestMyECC;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Ramu Maloth
 */
@MultipartConfig
public class DataownerUploadAction extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        Part part = request.getPart("file");
        InputStream is = part.getInputStream();
        HttpSession hs = request.getSession();
        InputStreamReader isReader = new InputStreamReader(is);
        //Creating a BufferedReader object
        BufferedReader reader = new BufferedReader(isReader);
        StringBuffer sb = new StringBuffer();
        String str;
        String data = null;
        while ((str = reader.readLine()) != null) {
            sb.append(str);
        }
        data = sb.toString();
        //out.println(data);
        String key = MyKeyGenerations.getAlphaNumericString(16);
        String initVector = MyKeyGenerations.getAlphaNumericString(16);
        System.out.println("Encryption Key ="+key);
        System.out.println("Encryption InitVector "+initVector);
        String cipher = AESImple.encrypt(data, key, initVector);
        //System.out.println(cipher);

       // TestMyECC test = new TestMyECC();
        //KeyPair keys = test.getKeys();
        //PublicKey pub = keys.getPublicKey();
        //PrivateKey privkey = keys.getPrivateKey();
        System.out.println("My Key is " + key);
        String[] args = {"A", "b", "c", "D"};
       // ECC.main(args);

        String ecc_Secret_key = ECCEncoder.convertStringToBinary(key);
        String ecc_vector_key = ECCEncoder.convertStringToBinary(initVector);
        int data_length = data.length();
        String email = hs.getAttribute("email").toString();
        String ownername = hs.getAttribute("name").toString();
        String fileName = part.getSubmittedFileName();
        PreparedStatement ps = null;
        try(Connection con = DBConnectionn.getConnection()) {
            Date cdate = new Date(new java.util.Date().getTime());
            String sqlQuery = "insert into datafiles(ownername,email,privatekey,publickey,filename,cipherdata,datalength,cdate) values(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sqlQuery);
            ps.setString(1, ownername);
            ps.setString(2, email);
            ps.setString(3, ecc_Secret_key);
            ps.setString(4, ecc_vector_key);
            ps.setString(5, fileName);
            ps.setString(6, cipher);
            ps.setInt(7, data_length);
            ps.setDate(8, cdate);
            int no = ps.executeUpdate();
            if(no>0){
                 //Storing File In Cloud
            //StoreFileInCloud.storeInCloud(cipher, key);
            response.sendRedirect("DataOwnerUploadFile.jsp?msg=success");
            }else{
            response.sendRedirect("DataOwnerUploadFile.jsp?msg=failed");
            }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("DataOwnerUploadFile.jsp?msg=failed");
        }
       
        
        
        System.out.println("ENcode " + ecc_Secret_key);
        String sskey = ECCEncoder.binaryToText(ecc_Secret_key);
        System.out.println("SSkey " + sskey);
        System.out.println("Result=" + key.equals(sskey));

        /*int[] cipher_key = test.doEncryptMessage(key.toLowerCase(),  pub);
         StringBuilder sbkey = new StringBuilder();
         for(int i = 0;i<cipher_key.length;i++){
         sbkey.append(i);
         }
         String cipherkey = sbkey.toString();
         System.out.println("Key ="+key);
         System.out.println("InitVector "+initVector);
         System.out.println("Cipher Key is "+cipherkey);
         */
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
