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
<div id="content-wrapper">
  <header class="header header--bg">
    <div class="container">
      <nav class="navbar">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span> 
          </button>
          <a class="navbar-brand" href="#">Data Privacy Protection Technology</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
          <ul class="nav navbar-nav">
            <li><a href="index.jsp">HOME</a></li>
            <li><a href="ownerlogin.jsp">Owner</a></li>
            <li><a href="userlogin.jsp">User</a></li> 
            <li><a href="cloudlogin.jsp">Cloud</a></li> 
            <li><a href="#">TEAM</a></li> 
            <li><a href="#">BLOG</a></li> 
            <li><a href="#">CONTACT</a></li> 
          </ul>
        </div>
      </nav>
      <div class="header__content text-center">
        <span class="header__content__block">Cloud login</span>
       <form action="CloudHome.jsp" method="post">
                                    <h5 style="color:white">UserName:&nbsp;&nbsp;<input type="text" required name="cname"/></h5><br>
                                    <h5 style="color:white">Password:&nbsp;&nbsp;<input type="password" required name="cpass"/></h5><br>
                                    <h5><input type="reset" value="Reset" style="color: blue"/>&nbsp;&nbsp;
                                        <input type="submit" value="Login" style="color: blue"/><br><br></h5>
                                </form>
        <%
                                    String msg = request.getParameter("msg");
                                    if (msg != null && msg.equalsIgnoreCase("success")) {
                                        out.println("<font color='green'><b>Login Success</b></font>");
                                    }
                                    if (msg != null && msg.equalsIgnoreCase("waiting")) {
                                        out.println("<font color='Red'><b>You are not Yet Activated,you should be activated by KGC</b></font>");
                                    }
                                    if (msg != null && msg.equalsIgnoreCase("failed")) {
                                        out.println("<font color='Red'><b>Login Failed,please provide correct details..</b></font>");
                                    }
                                    if (msg != null && msg.equalsIgnoreCase("wrongpassword")) {
                                        out.println("<font color='Red'><b>Please Enter Valid Password</b></font>");
                                    }
                                    if (msg != null && msg.equalsIgnoreCase("regsuccess")) {
                                        out.println("<font color='green'><b>Successfully Registered</b></font>");
                                    }


                                %>
                               

      </div>
      
    </div>
  </header>

  

  <footer class="footer footer--bg">
    <div class="container text-center">
      <h1 class="footer__title">contact</h1>
      <ul class="footer__contact-information">
        <li><a href="tel:5555555555"><i class="material-icons">phone</i> 9062314645</a></li>
        <li><a href="mailto:sshariar458@gmail.com"><i class="material-icons">email</i> pujaammineni817@gmail.com</a></li>
        <li><a href="#"><i class="material-icons">location_on</i>Michigan Technological University</a></li>
      </ul>
    </div>
    <hr style="border: 0;border-top: 1px solid #525B60;display:block;margin-top: 40px;">
    <div class="container text-center">
      <div class="social-icon">
        <ul>
          <li><a href="#"><i class="flaticon-facebook-letter-logo"></i></a></li>
          <li><a href="#"><i class="flaticon-twitter-logo"></i></a></li>
          <li><a href="#"><i class="flaticon-behance-logo"></i></a></li>
          <li><a href="#"><i class="flaticon-dribbble-logo"></i></a></li>
        </ul>
      </div>
      <p class="footer__paragraph">Copyright &copy; 2020 , All Rights Reserved.</p>
    </div>
  </footer>
</div>
  <script src="assets/jquery/jquery-3.2.1.min.js"></script>
  <script src="assets/bootstrap/js/bootstrap.min.js"></script>
  <!-- <script src="js/mixitup.js"></script>

  <script>
    $('a').click(function(e)
      {
        e.preventDefault();
      });

    // calling mixitup
    var mixer = mixitup(".portfolio");
  </script> -->
</body>
</html>  