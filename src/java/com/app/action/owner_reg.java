
package com.app.action;

import com.app.utility.DBConnectionn;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Puja
 */
@MultipartConfig(maxFileSize = 161748002)
public class owner_reg extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        //response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String pincode = request.getParameter("pincode");
        String location = request.getParameter("location");
        //Part filepart=request.getPart("image");
        String status = "waiting";
        String accesskey = "waiting";
        //InputStream is = filepart.getInputStream();
        //String ImageName = filepart.getSubmittedFileName();
        //String accesskey = "notGenerated";
        //out.println("Print name"+name);
        Connection con = null;
        PreparedStatement ps = null;
        try  {
            con = DBConnectionn.getConnection();
            String sqlQuery = "insert into ownerregister(name,password,email,mobile,address,dob,gender,pincode,location,status,accesskey) values(?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sqlQuery);
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, mobile);
            ps.setString(5, address);
            ps.setString(6, dob);
            ps.setString(7, gender);
            ps.setString(8, pincode);
            ps.setString(9, location);
            //ps.setBinaryStream(10,is,is.available());
            ps.setString(10, status);
            ps.setString(11, accesskey);
            int no = ps.executeUpdate();
            if(no>0){
                response.sendRedirect("userreg.jsp?msg=success");
            }else{
                response.sendRedirect("userreg.jsp?msg=failed");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("userreg.jsp?msg=exist");
        }finally{
            try{
                ps.close();
                con.close();
            }catch (Exception e) {
        }
    }
    }

    }