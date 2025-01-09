<%@page import="com.app.utility.DBConnectionn"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>

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
            <li><a href="CloudHome.jsp">HOME</a></li>
            <li><a href="CloudActivateowners.jsp">View Owners</a></li>
            <li><a href="CloudActivateusers.jsp">View Users</a></li> 
            <li><a href="Viewfiles.jsp">View Files</a></li>
            <li><a href="logout.jsp">Logout</a></li> 
            
          </ul>
        </div>
      </nav>
      <div class="header__content text-center">
        <span class="header__content__block">View Owner Files</span>
       <table border="2px" class="table table-hover table-dark">
                                <thead>
                                    <tr class="table-danger">
                                        <th scope="col">S.No</th>
                                        <th scope="col">Owner Name</th>
                                        <th scope="col">Email ID</th>
                                                                               
                                        <th scope="col">Filename</th>
                                        <th scope="col">Data Length</th>
                                        <th scope="col">Date</th>
                                        <th scope="col">Cipher Data</th>                                        
                                        
                                        
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        PreparedStatement ps = null;
                                        ResultSet rs = null;
                                        int count = 0;
                                        //String ownername = session.getAttribute("name").toString();
                                    try(Connection con = DBConnectionn.getConnection()){
                                        String sqlQuery = "select *from datafiles ";
                                        ps = con.prepareStatement(sqlQuery);
                                        //ps.setString(1, ownername);                                       
                                        rs = ps.executeQuery();
                                        while(rs.next()){
                                        count++;
                                        int id = rs.getInt("id");
                                       
                                        %>
                                     <tr scope="row" style="color: BLUE; background-color:#FFFCBB">
                                        <td><%=count%></td>
                                        <td><%=rs.getString("ownername")%></td>
                                        <td><%=rs.getString("email")%></td>
                                         
                                        <td><%=rs.getString("filename")%></td>
                                        <td><%=rs.getString("datalength")%> bytes</td>
                                        <td><%=rs.getString("cdate")%></td>
                                        <td><textarea readonly=""><%=rs.getString("cipherdata")%></textarea></td>  
                                        

                                        
                                    </tr>

                                    <%
                                        
                                        }
                                        
                                        
                                    
                                    }catch(Exception ex){
                                    System.out.println("Error at Activating users "+ex.getMessage());
                                    }
                                    %>
                                    
                                                                      


                                </tbody>
                            </table>

      </div>
      
    </div>
  </header>

  

  <footer class="footer footer--bg">
    <div class="container text-center">
      <h1 class="footer__title">contact</h1>
      <ul class="footer__contact-information">
        <li><a href="tel:5555555555"><i class="material-icons">phone</i>9062314645</a></li>
        <li><a href="mailto:sshariar458@gmail.com"><i class="material-icons">email</i> pujaammineni817@gmail.com</a></li>
        <li><a href="#"><i class="material-icons">location_on</i> Michigan Technological University</a></li>
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