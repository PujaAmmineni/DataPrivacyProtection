
<%@page import="com.app.utility.Attackerutility"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        int fileid = Integer.parseInt(request.getParameter("fileid"));
        String filename = request.getParameter("filename");
        String contents = request.getParameter("contents");
        Attackerutility au = new Attackerutility();
        au.getPlainDataandStoreInANotherTable(fileid, filename);
        au.updateFileStatus(fileid, contents);
        response.sendRedirect("Attacker.jsp?msg=attacked");
        
        %>
    </body>
</html>
