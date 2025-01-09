<%@page import="com.app.utility.AccesskeyGeneration"%>
<%@page import="com.app.utility.DBConnectionn"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%
int id = Integer.parseInt(request.getParameter("id"));
Connection con = null;
PreparedStatement ps = null;
AccesskeyGeneration akg = new AccesskeyGeneration();
char spacerChar = 'D';
        String key = akg.randomUUID(15, 0, spacerChar);
try {
        con = DBConnectionn.getConnection();
        String sqlQuery = "update ownerregister set status = ?,accesskey=?  where id = ?";
        ps = con.prepareStatement(sqlQuery);
        ps.setString(1, "activated");
        ps.setString(2, key);
        ps.setInt(3, id);
        int no = ps.executeUpdate();
        response.sendRedirect("CloudActivateowners.jsp?msg=success");
    } catch (Exception e) {
        System.out.println("Error at "+e.getMessage());
    }finally{
try {
        ps.close();
        con.close();
    } catch (Exception e) {
    }
}
%>