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
  <script>
            function validateForm() {
                var x = document.forms["myForm"]["email"].value;
                var atpos = x.indexOf("@");
                var dotpos = x.lastIndexOf(".");
                if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length) {
                    alert("Not a valid e-mail address");
                    return false;
                }
            }
        </script>

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
            <li><a href="user.jsp">Owner</a></li>
            <li><a href="userlogin.jsp">User</a></li> 
            <li><a href="#">PORTFOLIO</a></li> 
            <li><a href="#">TEAM</a></li> 
            <li><a href="#">BLOG</a></li> 
            <li><a href="#">CONTACT</a></li> 
          </ul>
        </div>
      </nav>
      <div class="header__content text-center">
          <span class="header__content__block">User Registration</span><center>
          <form action="owner_reg" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
                                    <table>
                                        <tr><td style="color: white">Data User:</td><td><input type="text" required name="name" pattern="[A-Za-z]+" title="Name should not contain integer value"/></tb></tr>
                                        <tr><td style="color: white">Password:</td><td><input type="password" required name="password" pattern="(?=.*\d)(?=.*[a-z]).{8,}" title="Must contain at least one number and lowercase letter, and at least 8 or more characters"/></td></tr>
                                        <tr><td style="color: white">Email Address:</td><td><input type="text"  required  title="Email Must In Email Format" name="email"/></td></tr>
                                        <tr><td style="color: white">Mobile Number:</td><td><input type="text" required name="mobile" pattern="[6789][0-9]{9}" title="Mobile Number Must 10 Digits"/></td></tr>
                                        <tr><td style="color: white">Your Address:</td><td><input type="text" required name="address"/></td></tr>
                                        <tr><td style="color: white">Date of Birth:</td><td><input type="text" required name="dob" title="Date of Birth Required"/></td></tr>
                                        <tr><td style="color: white">Gender:</td><td><input type="text" required name="gender" pattern="[A-Za-z]+"/></td></tr>
                                        <tr><td style="color: white">Enter pincode:</td><td><input type="text" required name="pincode" /></td></tr>
                                        <tr><td style="color: white">Enter Location:</td><td><input type="text" required name="location" pattern="[A-Za-z]+"/></td></tr>
                                        <!--<tr><td style="color: white">Select profile:</td><td><input type="file"   required name="image"/><br><br></td></tr>-->
                                        <tr><td></td><td><input type="submit" value="Register" style="color: blue"/></td></tr>
                                    </table>
          </form></center>
      </div>
      
    </div>
  </header>

  

  <footer class="footer footer--bg">
    <div class="container text-center">
      <h1 class="footer__title">contact</h1>
      <ul class="footer__contact-information">
        <li><a href="tel:5555555555"><i class="material-icons">phone</i>9062314645</a></li>
        <li><a href="mailto:sshariar458@gmail.com"><i class="material-icons">email</i>pujaammineni817@gmail.com</a></li>
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