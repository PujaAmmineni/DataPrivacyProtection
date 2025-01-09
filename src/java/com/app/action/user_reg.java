package com.app.action;

import com.app.utility.DBConnectionn;
import com.app.utility.PasswordUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class user_reg extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String password = PasswordUtil.hashPassword(request.getParameter("password")); // Hash password
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String pincode = request.getParameter("pincode");
        String location = request.getParameter("location");
        String status = "waiting";
        String accesskey = "waiting";

        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBConnectionn.getConnection();
            String sqlQuery = "INSERT INTO userregister(name, password, email, mobile, address, dob, gender, pincode, location, status, accesskey) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            ps.setString(10, status);
            ps.setString(11, accesskey);
            int no = ps.executeUpdate();
            if (no > 0) {
                response.sendRedirect("userreg.jsp?msg=success");
            } else {
                response.sendRedirect("userreg.jsp?msg=failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("userreg.jsp?msg=exist");
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
