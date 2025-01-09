 <%  if(request.getParameter("cname").equals("cloud") && request.getParameter("cpass").equals("cloud@2020"))
{
    response.sendRedirect("CloudHome.jsp?msg=success");
}
else{
    response.sendRedirect("cloudlogin.jsp?msg=failed");
}
%>