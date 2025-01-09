
<%@page import="com.app.utility.DBConnectionn"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        int fileId = Integer.parseInt(request.getParameter("fileid"));
        String fileName = request.getParameter("filename");
        String ownername = request.getParameter("ownername");
        
       Connection con = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       
      try {
              con = DBConnectionn.getConnection();
              String sql = "select *from datafiles where id=? and filename = ? and ownername = ?";
              ps = con.prepareStatement(sql);
              ps.setInt(1, fileId);
              ps.setString(2, fileName);
              ps.setString(3, ownername);
              rs = ps.executeQuery();
              if(rs.next()){
                  String data = rs.getString("cipherdata");
              %>
              
              <pre>
                    <h3>Attack the Data</h3>
              <form action="AttackingOnData.jsp" method="POST">
                  File Name :<input type="text" name="filename" value="<%=fileName%>" readonly="">
                  <input type="hidden" name="fileid" value="<%=fileId%>" readonly="">
                        Data:<textarea name="cipherdata" rows="25" cols="80" value="<%=data%>"><%=data%></textarea>  
                        <br/><br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="Submit" name="SUBMIT" value="Attack"><br/>
                  </form>
              </pre>
        <%
              }else{
              response.sendRedirect("Attacker.jsp?msg=nofile");
              }
          } catch (Exception e) {
              System.out.println("Error at Retreive "+e.getMessage());
              response.sendRedirect("Attacker.jsp?msg=nofile");
          }finally{
      try {
              rs.close();
              ps.close();
              con.close();              
          } catch (Exception e) {
          }
      }

        
        %>
    </body>
</html>
