<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Project</title>
  <meta name="keywords" content="Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod.">
  <meta name="description" content="Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod.">

  <link rel="stylesheet" href="assets/fonts/flat-icon/flaticon.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<%
       HttpSession ses=request.getSession();
       ses.invalidate();
       response.sendRedirect("index.jsp");
       %>
</body>
</html>  